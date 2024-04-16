<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 광고 이미지 -->
<c:if test="${advertisementStatus != 'F' }">
	<div class="text-center" style="margin-top: 1%; margin-bottom: 2%">
		<a href="${advertisementData.advertisementUrl }" target="_blank"> <img src="/resources/upload/${advertisementData.advertisementImg }" alt="광고 이미지" class="img-fluid" style="max-width: 100%; height: 20%;">
		</a>
	</div>
</c:if>
