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
		<div class="group">
		    <h3>목적지는 <input type="text" class="form-control ht" id="destinyNm${status.count}" name="destinyNm${status.count}" value="${result.destinyNm }" required="" maxlength="50"  data-parsley-errors-messages-disabled> 입니다. <button type="submit" class="btn btn-primary float-right" onclick="DeleteAccordion(this); return false;">삭제</button></h3>
		    <div class="eventList">
		    <input type="hidden" name="classDailyEventId${status.count}" value="${result.classDailyEventId }">
		    <fmt:formatDate var="newFormattedDateString" value="${result.eventDate}" pattern="yyyy/MM/dd"/>​
		    <input type="hidden" name="eventDate${status.count}" value="${newFormattedDateString }">
		    <input type="hidden" name="eventOrder${status.count}" value="${result.eventOrder }">
		    <input type="hidden" name="classId${status.count}" value="${result.classId }">
		    <input type="hidden" name="flag${status.count}" value="U">
		    	<div class="form-group row">
				    <div class="col-sm-12">출발한지 <input type="text" class="form-control ct" name="eventAlarmStartT${status.count}" value="${result.eventAlarmStartT}" placeholder="분" required="" maxlength="4" data-parsley-type="number"	 data-parsley-errors-messages-disabled> 분이 지났는데도 도착하지 않았다면 긴급알람이 옵니다.
				    </div>
				 </div>
<!-- 				 <div class="form-group row"> -->
<%-- 				    <div class="col-sm-12">도착한지 <input type="text" class="form-control ct" name="eventAlarmEndT${status.count}" value="${result.eventAlarmEndT}" placeholder="분" required="" maxlength="4" data-parsley-type="number"	 data-parsley-errors-messages-disabled> 분이 지나면 긴급알람이 옵니다. --%>
<!-- 				    </div> -->
<!-- 				 </div> -->
		    	 <div class="form-group row">
				    <label for="" class="col-sm-4 col-form-label">차량 이용 여부 </label>
				    <div class="col-sm-8">
					  <input class="" type="radio" name="eventCarNeedYn${status.count}" id="eventCarNeedYn_Y${status.count}" value="Y" <c:if test="${result.eventCarNeedYn=='Y' }">checked="checked"</c:if> data-parsley-required>
					  <label class="" for="">Y</label>
					  <input class="" type="radio" name="eventCarNeedYn${status.count}" id="eventCarNeedYn_Y${status.count}"  value="N" <c:if test="${result.eventCarNeedYn=='N' }">checked="checked"</c:if>>
					  <label class="" for="">N</label>
				    </div>
				 </div>
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
	