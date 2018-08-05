<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>信息发布列表页面</title>
  </head>
  <script type="text/javascript" src="<%=request.getContextPath()%>/jsp/backstage/infoRelease/infoReleaseList.js"></script>
  <body id="body">
  <!-- 信息查询 -->
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="">
			<li class="li-input"><label for="" class="input-label">信息名称：</label>
				<input class="myinput" id="topicName" name="topicName"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">信息内容：</label>
				<input id="topicContent" name="topicContent" value=""></input>
			</li>
			 <li class="li-input"><label for="" class="input-label">创建人：</label>
				<input id="createPersonName" name="createPersonName"> </input>
			</li>
			<li class="li-input"><label for="" class="input-label">创建时间：</label>
				<input id="createDateBegin" name="createDateBegin" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至</label>
			<input id="createDateEnd" name="createDateEnd" ></input>
			</li>
		
			<li class="li-input"><label for="" class="input-label">信息状态：</label>
				<input id="topicStatus" name="topicStatus" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">联系电话：</label>
				<input id="telephone" name="telephone" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">最后评论人：</label>
				<input id="lastCommentPerson" name="lastCommentPerson" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">最后评论时间：</label>
			<input id="lastCommentDateBegin" name="lastCommentDateBegin" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="lastCommentDateEnd" name="lastCommentDateEnd" />
			</li>
			
	</ul>
		<input type="hidden" id="blockUuid" name="blockUuid" value="${param.blockUuid}"/>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('topicsId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
	</div> 
 </div>
 </div>
 <!--信息查询结束  -->
<!--data grid  -->
 <table id="topicsId" style="width:100%"></table>
  <!--工具栏  -->
<div id="toolbarId">
<c:if test="${param.blockUuid=='01'}">
	<g:auth operateNo="<%=OperateContantsUtil.FLEA_MARKET_PAUSE%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-lock" plain="true" id="lock">禁止评论</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.FLEA_MARKET_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.FLEA_MARKET_PREVIW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.FLEA_MARKET_UNDO%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="javascript:event.preventDefault();" plain="true" id="undo" >撤销</a>
	</g:auth>

</c:if>
<c:if test="${param.blockUuid=='02'}">
	<g:auth operateNo="<%=OperateContantsUtil.EXPOSURE_TABLE_PAUSE%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-lock" plain="true" id="lock">禁止评论</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.EXPOSURE_TABLE_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.EXPOSURE_TABLE_PREVIW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.EXPOSURE_TABLE_UNDO%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="javascript:event.preventDefault();" plain="true" id="undo" >撤销</a>
	</g:auth>
</c:if>
<c:if test="${param.blockUuid=='03'}">
	<g:auth operateNo="<%=OperateContantsUtil.RATIONALIZATION_PROPOSAL_PAUSE%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-lock" plain="true" id="lock">禁止评论</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.RATIONALIZATION_PROPOSAL_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.RATIONALIZATION_PROPOSAL_PREVIW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.RATIONALIZATION_PROPOSAL_UNDO%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="javascript:event.preventDefault();" plain="true" id="undo" >撤销</a>
	</g:auth>
</c:if>
<c:if test="${param.blockUuid=='04'}">
	<g:auth operateNo="<%=OperateContantsUtil.PRAISE_PAUSE%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-lock" plain="true" id="lock">禁止评论</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.PRAISE_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.PRAISE_PREVIW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.PRAISE_UNDO%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="javascript:event.preventDefault();" plain="true" id="undo" >撤销</a>
	</g:auth>
</c:if>
<c:if test="${param.blockUuid=='05'}">
	<g:auth operateNo="<%=OperateContantsUtil.COMPLAIN_PAUSE%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-lock" plain="true" id="lock">禁止评论</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.COMPLAIN_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.COMPLAIN_PREVIW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.COMPLAIN_UNDO%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="javascript:event.preventDefault();" plain="true" id="undo" >撤销</a>
	</g:auth>
</c:if>
</div>

  </body>
</html>

<script type="text/javascript">
var basePath = $("#basePath").val();
var topicDo = basePath+"/website/backstage/tabTopicsController.do";
var topicListUrl ='<c:url value="'+topicDo+'"/>?method=tabTopicsList&blockUuid='+$("#blockUuid").val();
var topicsDetailUrl ='<c:url value="'+topicDo+'"/>?method=topicsDetail';
var pauseTopicsCommentUrl = '<c:url value="'+topicDo+'"/>?method=pauseTopicsComment';
var deleteTopics = '<c:url value="'+topicDo+'"/>?method=deleteTopics';

//----------------------------查询框初始化开始
$('#topicName').textbox({
	type : "text"
});
$('#topicContent').textbox({
	type : "text"
});
$('#createPersonName').textbox({
	multiline:true,
	type : "text"
}); 
$('#telephone').textbox({
	multiline:true,
	type : "text"
}); 
$('#lastCommentPerson').textbox({
	multiline:true,
	type : "text"
}); 

$('#createDateBegin').datetimebox({
	editable:false
});
$('#createDateEnd').datetimebox({
	editable:false
});
$('#lastCommentDateBegin').datetimebox({
	editable:false
});
$('#lastCommentDateEnd').datetimebox({
	editable:false
});

commonObj.initDictCombobox("topicStatus","IF","",false,true);

//----------------------------查询框初始化结束
//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#topicsId").datagrid('reload');
	commonObj.showResponse(data);
}
</script>
