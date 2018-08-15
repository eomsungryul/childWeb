<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${ requestScope['javax.servlet.forward.servlet_path'] }" var="requestUri" />
<head>
<%
  String contextPath = (String)request.getContextPath();
%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>클래스 이벤트 관리</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=contextPath%>/resources/bootstrap-4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<%=contextPath%>/resources/bootstrap-4.1.1/dashboard.css" rel="stylesheet">
  	<link href="<%=contextPath%>/resources/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">

  	<link href="<%=contextPath%>/resources/jquery-ui/jquery-ui.min.css" rel="stylesheet">
    <link href="<%=contextPath%>/resources/bootstrap-4.1.1/parsley.css" rel="stylesheet">
    
    
</head>
  
	<style>
	table tr.active {background: #ccc;}
	.ct{    display: inline; width:15%  }
	.ht{    display: inline; width:25%  }
	</style>
  <body>
  	
	<c:import charEncoding="utf-8" url="/inc/incHeader">
		<c:param name="path" value="${requestUri}" />
	</c:import>

    <div class="container-fluid">
      <div class="row">
      
        <!-- aside start -->
 		<c:import charEncoding="utf-8" url="/inc/incLeft">
 			<c:param name="path" value="${requestUri}" />
 		</c:import>
		<!-- aside end -->	    
		
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
         <h2 class="mt-3">어린이집 활동 관리 </h2>
      		<div class="col-md-8">
	      	<div class="row">
	      	<div class="col-md-12">
	          	<div class="float-right mt-3 mb-3">
					<div class="form-inline">
	                   	<form:form modelAttribute="searchVO" action="${ contextPath }/admin/code/list" name="searchFrm">
			           
			           <input type="text" id="searchKeyword" class="form-control">
			            <button type="button" onclick="fnSearch()" class="btn btn-secondary" >검색</button>
	<!-- 		            <div> -->
	<%-- 		                <input type="text" class="form-control search" id="searchKeyword" name="searchKeyword" placeholder="검색어"  value="${pni.searchKeyword}"/> --%>
	<!-- 		                <button type="button" onclick="fnSearch()" class="btn btn-secondary" >검색</button> -->
	<!-- 		            </div> -->
			            </form:form>
			        </div>
	          	</div>
	          	</div>
	         </div>
	         
	      		<div class="row">
	      		
	          	<div class="col-md-12">
	          	<div class="float-right mt-3 mb-3">
		         <a class="btn icon-btn btn-success" href="javascript:AddAccordion();">
					목적지 추가
				</a>
				</div>
				</div>
	      		
	          	<div class="col-md-4" style="overflow-y: auto;height: 350px;">
		          	<table class="table">
		              <thead>
		                <tr  style="cursor: pointer;" onclick="fnClick(this,'CENTER_${ centerInfo.centerId }' );return false;">
		                  <th>${centerInfo.centerNm}</th>
		                </tr>
		              </thead>
		              <tbody id="class">
		              	<c:if test="${fn:length(resultList)!=0}">
		                 	<c:forEach var="result" items="${ resultList }" varStatus="status">
				                <tr style="cursor: pointer;" onclick="fnClick(this,${ result.classId } );return false;">
				                  <td>ㄴ${result.classNm }</td>
				                </tr>
		                 	</c:forEach>
		              	</c:if>
		              	<c:if test="${fn:length(resultList)==0}">
			                <tr>
			                  <td colspan="5" class="text-center">클래스가 존재하지 않습니다.</td>
			                </tr>
		              	</c:if>
		              </tbody>
		            </table>
	          	</div>
	          	<div class="col-md-8">
	          	
                   	<form:form modelAttribute="classList" action="${ contextPath }/director/classEvent/list" name="registFrm" id="registFrm" >
	          		<div id="accordion">
					  <div class="group">
						    <h3>반을 선택해 주세요</h3>
						    <div class="eventList">
						    
						    </div>			
						</div>
	
					</div>	
					</form:form>
	          	</div>
	          	
	          	
	      		
	          	<div class="col-md-12">
	          	<div class="float-right mt-3 mb-3">
				<button type="button" class="btn btn-primary" onclick="fnInsert();">변경 사항 저장</button>
				</div>
				</div>
	          	
	          	</div>
          </div>
          
        </main>
      </div>
    </div>
    
    <script src="<%=contextPath%>/resources/js/jquery-3.1.0.js"></script>
    <script src="<%=contextPath%>/resources/js/moment.js"></script>
    <script src="<%=contextPath%>/resources/js/jquery.twbsPagination.min.js"></script>
    <script src="<%=contextPath%>/resources/bootstrap-4.1.1/js/bootstrap.min.js"></script>
    <script src="<%=contextPath%>/resources/js/Parsley.js-2.8.1/parsley.js"></script>
    <script src="<%=contextPath%>/resources/js/ESR23Common_debug.js"></script>
    
  	<script type="text/javascript" src="<%=contextPath%>/resources/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
  	<script type="text/javascript" src="<%=contextPath%>/resources/bootstrap-datepicker/locales/bootstrap-datepicker.kr.min.js"></script>
  	<script type="text/javascript" src="<%=contextPath%>/resources/jquery-ui/jquery-ui.min.js"></script>
  
	<script type="text/javascript">
	
	var contextPath = "${ pageContext.request.contextPath }";
	var classVal;
	var delList = [];

	
	$(document).ready(function(){
		$('#searchKeyword').datepicker({
			language: "kr",
			format: "yyyy/mm/dd",
		    todayHighlight: true
		}
		);
		$('#searchKeyword').datepicker('update', new Date());
		accordionInit();
		$("table tr")[0].click();
	});
	
	function accordionInit(){
		$( "#accordion" )
	      .accordion({
	        header: "> div > h3",
	        collapsible: true
	      })
	      .sortable({
	        axis: "y",
	        handle: "h3",
	        stop: function( event, ui ) {
	          // IE doesn't register the blur when sorting
	          // so trigger focusout handlers to remove .ui-state-focus
	          ui.item.children( "h3" ).triggerHandler( "focusout" );
	 
	          // Refresh accordion to handle new order
	          $( this ).accordion( "refresh" );
	          
	        }
	      });
		$.ui.accordion.prototype._keydown = function( event ) {
       	};
	}
	

	/**
	 *  날짜 반 검색
	 */
	function fnSearch(){
    	$.ajax({
    		type : "POST",
    		url : contextPath + "/director/classEvent/eventList",
    		dataType : "html",
    		data : {"classId" : classVal,
    				"eventDate" : $("#searchKeyword").val()
    		},
    		success : function(data){
    			$("#accordion").html(data);
    			$("#accordion").accordion( "refresh" );
    		}
    	});
	}
	
	
	/**
	 *  클래스 클릭 시 이벤트
	 */
	function fnClick(target,code){
		$("thead > tr").removeClass("active");
		$("tbody > tr").removeClass("active");
//     	$(".table > tr").removeClass("active");
        $(target).toggleClass("active");
        classVal = code;
		
    	$.ajax({
    		type : "POST",
    		url : contextPath + "/director/classEvent/eventList",
    		dataType : "html",
    		data : {"classId" : classVal,
    				"eventDate" : $("#searchKeyword").val()
    		},
    		success : function(data){
    			$("#accordion").html(data);
    			$("#accordion").accordion( "refresh" );
    		}
    	});
	}
	

	/**
	 *  클래스 클릭 시 이벤트
	 */
	function AddAccordion(){
		
		data = '<div class="group"><h3>'
		+'목적지는  <input type="text" class="form-control ht" name="destinyNm" placeholder="목적지" required="" maxlength="50" data-parsley-errors-messages-disabled> 입니다. '
		+'<button type="submit" class="btn btn-primary float-right" onclick="DeleteAccordion(this); return false;">삭제</button>'
		+'</h3><div class="eventList">'
		+'<input type="hidden" name="eventDate" value="'+$("#searchKeyword").val()+'">'
		+'<input type="hidden" name="classId" value="'+classVal+'">'
		+'<input type="hidden" name="flag" value="I">'
		+'<div class="form-group row">'
		+'<div class="col-sm-12">출발한지 <input type="text" class="form-control ct" name="eventAlarmStartT${status.count}" value="${result.eventAlarmStartT}" placeholder="분" required="" maxlength="4" data-parsley-type="number"	 data-parsley-errors-messages-disabled> 분이 지났는데도 도착하지 않았다면 긴급알람이 옵니다.'
		+'</div>'
		+'</div>'
// 		+'<div class="form-group row">'
// 		+'<div class="col-sm-12">도착한지 <input type="text" class="form-control ct" name="eventAlarmEndT${status.count}" value="${result.eventAlarmEndT}" placeholder="분" required="" maxlength="4" data-parsley-type="number"	 data-parsley-errors-messages-disabled> 분이 지나면 긴급알람이 옵니다.'
// 		+'</div>'
// 		+'</div>'
		+'<div class="form-group row"><label for="" class="col-sm-4 col-form-label">차량 이용 여부 </label>'
		+'<div class="col-sm-8">'
		+'<input class="" type="radio" name="eventCarNeedYn" id="eventCarNeedYn_Y" value="Y"checked="checked"data-parsley-required>'
		+' <label class="" for="">Y</label>'
		+' <input class="" type="radio" name="eventCarNeedYn" id="eventCarNeedYn_Y"  value="N">'
		+' <label class="" for="">N</label>'
		+'</div>'
		+'</div></div>'
		
		$("#accordion").append(data);
		$("#accordion").accordion( "refresh" );
	}

	/**
	 *  삭제 이벤트 
	 */
	function DeleteAccordion(target){
// 		if ($(target).parent().find("input[name^='destinyNm']").val() !=undefined){
// 			delList.push($(target).parent().parent().find("input[name^='classDailyEventId']").val());
// 		}
		$(target).parent().parent().remove();
	}
	
	/**
	 *  클래스 이벤트 관리 등록
	 */
	function fnInsert(){
		
		var  len = $("#accordion").find(".group").length;
        var eventList = new Array() ;
		for (var i=0; i<len; i++){
			//h3 구역 
			var destinyNm = $($("#accordion").find(".group").get(i)).find('input[name^="destinyNm"]').val()
			//div 구역값들
			var eventDate = $($("#accordion").find(".group").get(i)).find('div').find('input[name^="eventDate"]').val();
// 			var classNm = $($("#accordion").find(".group").get(i)).find('div').find('input[name^="classNm"]').val();
// 			var eventOrder = $($("#accordion").find(".group").get(i)).find('div').find('input[name="eventOrder"]').val();
			var classId = $($("#accordion").find(".group").get(i)).find('div').find('input[name^="classId"]').val();
// 			var flag = $($("#accordion").find(".group").get(i)).find('div').find('input[name^="flag"]').val();
			var eventAlarmStartT = $($("#accordion").find(".group").get(i)).find('div').find('input[name^="eventAlarmStartT"]').val();
// 			var eventAlarmEndT = $($("#accordion").find(".group").get(i)).find('div').find('input[name^="eventAlarmEndT"]').val();
			var eventCarNeedYn = $($("#accordion").find(".group").get(i)).find('div').find('input[name^="eventCarNeedYn"]:checked').val();
			
			data = {
					"eventDate" : eventDate ,
					"eventOrder" : i+1,
					"classId" : classId,
					"destinyNm" : destinyNm,
// 					"flag" : flag,
					"eventAlarmStartT" : eventAlarmStartT,
// 					"eventAlarmEndT" : eventAlarmEndT,
					"eventCarNeedYn" : eventCarNeedYn,
			}
			eventList.push(data);
		}
// 		delData = {"delList":delList};
// 		eventList.push(delData);
		
		if($('#registFrm').parsley().validate()){
	     	$.ajax({
	     		type : "POST",
	     		url : contextPath + "/director/classEvent/insert",
// 	     		dataType : "json",
	     		data : {"list":JSON.stringify(eventList)},
		        error:function(request,status,error){
		            alert("code:"+request.status+"\n"+"error:"+error+"\n"+"message:"+request.responseText);
		        },
	     		success : function(data){
	     			location.reload();
	     		}
	     	});
	     	
		}else{
			alert("작성 시 모든 입력란에 입력해주세요.");
		}



	}
	
	
	
	</script>
</body>

</html>
