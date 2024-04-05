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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminExcelDownloadController {

    @Autowired
    private TotalService totalService;

    @GetMapping("/download")
    public void download(HttpServletResponse res, TotalDTO totalDTO) throws IOException {
        // Excel 워크북 및 시트 생성
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Balance Game 2024 Data");//년도의 따른 이름 생성 가능

        // 헤더 스타일 설정
        CellStyle headerStyle = createHeaderStyle(workbook);

        // 본문 스타일 설정
        CellStyle bodyStyle = createBodyStyle(workbook);

        // 헤더 생성
        createHeaderRow(sheet.createRow(0), headerStyle);

        // 데이터 입력
        int rowCount = 1;
        for (int day = 1; day <= 31; day++) {
            totalDTO.setSearchCondition("day");
            totalDTO.setYear("2024");//년도를 받아온다면 그 년도도 받아볼 수 있음
            totalDTO.setDay(day);
            List<TotalDTO> datas = totalService.selectAll(totalDTO);
            createDataRow(sheet.createRow(rowCount++), day, datas, bodyStyle);
        }

        // 월별 총계 계산
        calculateMonthlyTotal(sheet, rowCount, bodyStyle);

        // 다운로드 설정
        res.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        res.setHeader("Content-Disposition", "attachment;filename=BalanceGameData.xlsx");

        // Excel 파일 출력
        ServletOutputStream outputStream = res.getOutputStream();
        workbook.write(outputStream);
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
    private void createDataRow(Row row,int day, List<TotalDTO> datas, CellStyle style) {
    	int total=0;;
        Cell cell = row.createCell(0);
        cell.setCellValue(day+"일"); // 일/월 데이터 입력
        cell.setCellStyle(style);
        
        for (TotalDTO data : datas) {
        	cell = row.createCell(data.getMonth());
            cell.setCellValue(data.getTotalAmount()); // 월별 데이터 입력
            total+=data.getTotalAmount();
            cell.setCellStyle(style);
	    }
        


        cell = row.createCell(13);
        cell.setCellValue(total); // 년 총계 데이터 입력
        cell.setCellStyle(style);
    }
    
    // 월별 총계 계산 메서드
    private void calculateMonthlyTotal(Sheet sheet, int rowCount, CellStyle style) {
    	Cell cell = null;
        Row row = sheet.createRow(rowCount);
        cell=row.createCell(0);
        cell.setCellValue("월 총계");
        cell.setCellStyle(style);
        int yearTotal=0;
        for (int month = 1; month <= 12; month++) {
            int total = 0;
            for (int i = 1; i < rowCount; i++) {
                Row currentRow = sheet.getRow(i);
                cell = currentRow.getCell(month);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    total += (int) cell.getNumericCellValue();
                }
            }
            
            yearTotal+=total;
            cell=row.createCell(month);
            cell.setCellValue(total);
            cell.setCellStyle(style);
        }
        cell = row.createCell(13);
        cell.setCellValue(yearTotal); // 년 총계 데이터 입력
        cell.setCellStyle(style);
    }
}