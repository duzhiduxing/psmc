<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
  	.ibox {
	    clear: both;
	    margin-bottom: 25px;
	    margin-top: 0;
	    padding: 0
	}
	.tds{
		text-align:right;
		width:15%
	}
	
  </style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/news/news${csssuffix}" type="text/css">
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/Huploadify${csssuffix}" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/jcrop/css/jquery.Jcrop${csssuffix}"/> --%>
  </head>
  <%@ include file="../../../common.jsp"%>
  <body id="body">
<form id="activityForm" method="POST" >

	<div class=" panel-default" style="margin-top: 30px; border: 1px solid #ddd;">
        <div class="">
		<table class="table table-hover" style="font-size:12px; width:75%; border-collapse:separate; border-spacing:20px;" >
			<tr>
				<td class="tds">活动名称：</td>
				<td width="30%"><input id="activityName" name="activityName" value="${info.activity_name}" style="width:70%;"/></td>
				<td class="tds">创建人：</td>
				<td width="30%">
					<input id="createPerson" name="createPerson" value="${info.create_person }" style="width:70%;"/>
				</td>
			</tr>
			<tr>
				<td class="tds">创建时间：</td>
				<td width="30%"><input id="createDate" name="createDate" value="${info.create_date}" style="width:70%;"/></td>
				<td class="tds">活动开始时间：</td>
				<td width="30%"><input id="startDate" name="startDate" value="${info.start_date}" style="width:70%;"/></td>
			</tr>
			<tr>
				<td class="tds">活动结束时间：</td>
				<td width="30%"><input id="endDate" name="endDate" value="${info.end_date}" style="width:70%;"/></td>
				<td class="tds">报名截止时间：</td>
				<td width="30%"><input id="signUpEndDate" name="signUpEndDate" value="${info.sign_up_end_date}" style="width:70%;"/></td>
				
			</tr>
			<tr>
				<td class="tds">活动内容：</td>
				<td width="30%" colspan="3">
					<textarea style="width:88.5%; border-radius:5px; border: 1px solid #ccc;" rows="10" cols="" id="activityContent" name="activityContent">${info.activity_content}</textarea>
				</td>
			</tr>	
		</table>
		</div>
	</div>
		
		<input type="hidden" id="isEdit" name="isEdit" value="${isEdit}"/>
		 <input type="hidden" id="activityUuid" name="activityUuid" value="${info.activity_uuid}"/>
		 <div style= "width:75%; margin-top: 20px" class="operButon" align="center">
		   <input id="submitbtn" type="button" class="easyui-linkbutton" onclick="save()" value="提交"/>
		   <input id="reset" type="reset" class="easyui-linkbutton" onclick=" "  value="重置"/>
		   <input id="button" type="button" class="easyui-linkbutton" onclick="retList()"  value="返回列表"/></td>
		 </div>
		 
	</form>
    
  </body>
</html>
<script type="text/javascript">
var basePath = $("#basePath").val();
var infoDo = basePath+"/website/backstage/TabActivityManageController.do";
var addUrl = '<c:url value="/website/backstage/TabActivityManageController.do"/>?method=addOrUpdate';
var retrunUrl =  '<c:url value="/website/backstage/TabActivityManageController.do"/>?method=activityList';

if(!$("#isEdit").val()){
	$("#button").hide();
}
$('#activityName').textbox({
	type : "text",
	required : true
});
$('#createPerson').textbox({
	type : "text",
	required : true
});
$("#activityContent").validatebox({
	required: true,    
    validType: "text"
});

$('#createDate').datetimebox({
	required : true
});
$('#startDate').datetimebox({
	required : true
});
$('#endDate').datetimebox({
	required : true
});
$('#signUpEndDate').datetimebox({
	required : true
});

</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/wangEditor/wangEditor.min${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/uploadfy/jquery.Huploadify${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/jcrop/js/browser${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/jcrop/js/jquery.Jcrop.min${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/backstage/activity/addOrUpdateActivity.js"></script>