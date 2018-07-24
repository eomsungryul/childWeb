<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${ requestScope['javax.servlet.forward.servlet_path'] }" var="requestUri" />
<%
  String contextPath = (String)request.getContextPath();
%>

<c:if test="${fn:length(resultList)!=0}">
	<c:forEach var="result" items="${ resultList }" varStatus="status">
<%-- 		<tr onclick="fnRegist(${result.classId },'U')"> --%>
<%-- 		<td>${ pni.totalRecordCount - (((pni.pageIndex - 1) * pni.recordCountPerPage) + (status.index)) }</td> --%>
<%-- 		<td>${result.classNm }</td> --%>
<%-- 		<td>${result.teacherUserNm }</td> --%>
<!-- 		</tr> -->
		<div class="group">
		    <h3>${result.destinyNm }</h3>
		    <div class="eventList">
		    <input type="hidden" name="classDailyEventId" value="${result.classDailyEventId }">
		    <input type="hidden" name="flag" value="U">
		    	승차 시간 <input type="text" class="form-control ct" name="classNm" placeholder="승차시간" required="" maxlength="50">
		    </div>			
		</div>
	</c:forEach>
</c:if>
<c:if test="${fn:length(resultList)==0}">
		<div class="group">
		    <h3>이벤트가 존재하지 않습니다.</h3>
		    <div class="eventList">
		    
		    </div>			
		</div>
</c:if>
	