package com.jarvis.BalanceGame.controller.admin.action;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.jarvis.BalanceGame.model.dto.TotalDTO;
import com.jarvis.BalanceGame.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminExcelDownloadController {

	private static final int MONTHLY_TOTAL_CELL_INDEX = 13;
	private static final int MAX_MONTH = 12;
	
    @Autowired
    private TotalService totalService;

    @GetMapping("/download")
    public void download(HttpServletResponse res, TotalDTO totalDTO) throws IOException {
    	int startDay = 1;//월 시작 날짜
    	int endDay = 31;// 월 마지막 날짜
    	int rowCount = 0;//시트 행 번호
    	// Excel 워크북 및 시트 생성
    	//Apache POI 라이브러리를 사용하여 시트 생성
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Balance Game 2024 Data");//년도의 따른 이름 생성 가능

        // 헤더 스타일 설정
        CellStyle headerStyle = createHeaderStyle(workbook);

        // 본문 스타일 설정
        CellStyle bodyStyle = createBodyStyle(workbook);

        // 헤더 생성
        createHeaderRow(sheet.createRow(rowCount++), headerStyle);

        // 데이터 입력
        //날짜 별로 데이터를 가져옴
        for (int day = startDay; day <= endDay; day++) {
            totalDTO.setSearchCondition("day");
            totalDTO.setYear("2024");//년도를 받아온다면 그 년도도 받아볼 수 있음
            totalDTO.setDay(day);
            //해당 년도와 날짜의 월 금액을 가져옴 
            List<TotalDTO> datas = totalService.selectAll(totalDTO);
            //가져온 데이터로 시트를 채움
            createDataRow(sheet.createRow(rowCount++), day, datas, bodyStyle);
        }

        // 월별 총계 계산
        calculateMonthlyTotal(sheet, rowCount++, bodyStyle);

        // 다운로드 설정
        // 엑셀 파일 타입 설정
        res.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        // Content-Disposition 헤더를 설정하여 파일 다운로드 지시 
        // attachment 웹페이지의 일부가 아니라 다운로드 할 것이라고 알려줌
        res.setHeader("Content-Disposition", "attachment;filename=BalanceGameData.xlsx");

        // Excel 파일 출력
        //생성한 데이터를 클라이언트에게 전송
        ServletOutputStream outputStream = res.getOutputStream();
        //엑셀 파일의 출력 작성
        workbook.write(outputStream);
        //메모리 누수 방지
        workbook.close();
        outputStream.flush();
        outputStream.close();
    }

    // 헤더 스타일 생성
    private CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);

        return style;
    }

    // 본문 스타일 생성
    private CellStyle createBodyStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        return style;
    }

    // 헤더 행 생성
    private void createHeaderRow(Row row, CellStyle style) {
        String[] headers = {"일/월", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월", "년 총계"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
        }
    }

 // 데이터 행 생성
    private void createDataRow(Row row, int day, List<TotalDTO> datas, CellStyle style) {
        int total = 0;
        Cell cell = row.createCell(0);
        cell.setCellValue(day + "일"); // 일/월 데이터 입력
        cell.setCellStyle(style);

        for (TotalDTO data : datas) {
            cell = row.createCell(data.getMonth());
            // data.getTotalAmount()에 콤마 추가
            cell.setCellValue(String.format("%,d", data.getTotalAmount())); // 월별 데이터 입력
            total += data.getTotalAmount();
            cell.setCellStyle(style);
        }

        cell = row.createCell(MONTHLY_TOTAL_CELL_INDEX);
        // total에 콤마 추가
        cell.setCellValue(String.format("%,d", total)); // 년 총계 데이터 입력
        cell.setCellStyle(style);
    }

    // 월별 총계 계산 메서드
    private void calculateMonthlyTotal(Sheet sheet, int rowCount, CellStyle style) {
        Cell cell = null;
        Row row = sheet.createRow(rowCount);
        cell = row.createCell(0);
        cell.setCellValue("월 총계");
        cell.setCellStyle(style);
        int yearTotal = 0;
        DataFormatter formatter = new DataFormatter();
        for (int month = 1; month <= MAX_MONTH; month++) {
            int total = 0;
            for (int i = 1; i < rowCount; i++) {
                Row currentRow = sheet.getRow(i);
                cell = currentRow.getCell(month);
                //System.out.println("cell 데이터 : "+cell);
                String cellValue = formatter.formatCellValue(cell);
                try {
                    total += Integer.parseInt(cellValue.replaceAll(",", ""));
                } catch (NumberFormatException e) {
                    // 셀 값이 숫자로 변환할 수 없음
                	total+=0;
                    // 예외 처리 필요
                }
            }

            yearTotal += total;
            cell = row.createCell(month);
            // total에 콤마 추가
            cell.setCellValue(String.format("%,d", total));
            cell.setCellStyle(style);
        }
        // yearTotal에 콤마 추가
        cell = row.createCell(MONTHLY_TOTAL_CELL_INDEX);
        cell.setCellValue(String.format("%,d", yearTotal)); // 년 총계 데이터 입력
        cell.setCellStyle(style);
    }
}