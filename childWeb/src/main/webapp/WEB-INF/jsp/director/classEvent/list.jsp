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
    
    
</head>
  
	<style>
	table tr.active {background: #ccc;}
	.ct{    display: inline; width:30%  }
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
         <h2 class="mt-3">클래스 이벤트 관리 </h2>
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
					클래스 이벤트 추가
				</a>
				</div>
				</div>
	      		
	          	<div class="col-md-4" style="overflow-y: auto;height: 350px;">
		          	<table class="table">
		              <thead>
		                <tr>
		                  <th>클래스명</th>
		                </tr>
		              </thead>
		              <tbody id="class">
		              	<c:if test="${fn:length(resultList)!=0}">
		                 	<c:forEach var="result" items="${ resultList }" varStatus="status">
				                <tr style="cursor: pointer;" onclick="fnClick(this,${ result.classId } );return false;">
				                  <td>${result.classNm }</td>
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
	          		<div id="accordion">
					  <div class="group">
						    <h3>반을 선택해 주세요</h3>
						    <div class="eventList">
						    
						    </div>			
						</div>
	
					</div>	
	          	</div>
	          	
	          	
	      		
	          	<div class="col-md-12">
	          	<div class="float-right mt-3 mb-3">
				<button type="button" class="btn btn-primary" onclick="fnInsert();">클래스 이벤트 등록</button>
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
	var clickVal;

	
	$(document).ready(function(){
		$('#searchKeyword').datepicker({
			language: "kr",
			format: "yyyy/mm/dd",
// 			daysOfWeekDisabled: "0",
		    todayHighlight: true
		}
		);
		$('#searchKeyword').datepicker('update', new Date());
		accordionInit();
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
    		data : {"classId" : clickVal,
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
    	$("#class > tr").removeClass("active");
        $(target).toggleClass("active");
        clickVal = code;
		
    	$.ajax({
    		type : "POST",
    		url : contextPath + "/director/classEvent/eventList",
    		dataType : "html",
    		data : {"classId" : clickVal,
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
		+'<input type="text" class="form-control ct" id="classNm" name="classNm" placeholder="목적지" required="" maxlength="50">'
		+'<button type="submit" class="btn btn-primary float-right" onclick="DeleteAccordion(this); return false;">삭제</button>'
		+'</h3><div class="eventList">'
		+'승차 시간 <input type="text" class="form-control ct" id="classNm" name="classNm" placeholder="목적지" required="" maxlength="50">'
		+'</div></div>'
		$("#accordion").append(data);
		$("#accordion").accordion( "refresh" );
	}
	
	function DeleteAccordion(target){
		$(target).parent().parent().remove();
	}
	
	
	
	/**
	 *  체크박스 클릭시 업데이트
	 */
	function chkBoxOnClick(target,code){
		
		var use_yn = $(target).is(":checked") ? 'Y' : 'N';
		var exercise_equip_cd = clickVal;
		var exercise_range_cd = code;
		
    	$.ajax({
    		type : "POST",
    		url : contextPath + "/director/classEvent/insert",
    		dataType : "html",
    		data : {"use_yn" : use_yn, 
    				"exercise_equip_cd" : exercise_equip_cd,
    				"exercise_range_cd" : exercise_range_cd,
    				},
    		success : function(data){
//     			$("#part").html(data);
    		}
    	});
        
	}
	
	
	
	/**
	 *  부위 클릭 시 상세정보 입력창 
	 */
	function partClick(target,code){

		var exercise_equip_cd = clickVal;
		var exercise_range_cd = code;
		var use_yn = $(target).find("input:checkbox").is(":checked") ? true : false;
		if(!use_yn){
			alert('기구-부위 매핑 체크박스를 체크해주세요.');
			return;
		}
    	$.ajax({
    		type : "POST",
    		url : contextPath + "/director/classEvent/partDetail",
    		dataType : "html",
    		data : {
    				"exercise_equip_cd" : exercise_equip_cd,
    				"exercise_range_cd" : exercise_range_cd
    				},
    		success : function(data){
    			$("#partDetail").html(data);
    		}
    	});
        
	}
	
	
	
	/**
	 *  기구-부위 등록  
	 */
	function fnInsert(){
		
		var  len = $("#accordion").find(".group").length;
        var eventList = new Array() ;

		
		for (var i=0; i<len; i++){
//             var data = new Object() ;
			var classNm = $($("#accordion").find(".group").get(i)).find('div').find('input[name="classNm"]').val();
			
			data = {
					"classNm" : classNm,
					"ddd" : classNm
			}
			eventList.push(data);
		}
		
		debugger;
// 		console.log(clickVal);
// 		var partArray=[];
// 		$("input:checkbox[name=partChk]:checked").each(function(){
// 			partArray.push($(this).val());
// 		});
// 		console.log(partArray);
// 		var jsonData = JSON.stringify(eventList) ;

    	$.ajax({
    		type : "POST",
    		url : contextPath + "/director/classEvent/insert",
    		dataType : "json",
    		data : {"list":eventList},
    		success : function(data){
    		}
    	});
	}
	
	
	/**
	 *  기구-부위 상세등록  
	 */
	function fnDetailInsert(){

		if(!confirm("기구-부위 상세등록을 하시겠습니까?")) return;
		if($('#registFrm').parsley().validate()){
			var data = $("#registFrm").serialize();
	    	$.ajax({
	    		type : "POST",
	    		url : contextPath + "/director/classEvent/detailUpdate",
	    		dataType : "json",
	    		data : data,
	    		success : function(data){
	    	    	
	    		}
	    	});
		}
	}
	
	
	
	</script>
</body>

</html>
