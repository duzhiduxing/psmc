<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/news/news${csssuffix}" type="text/css">
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/Huploadify${csssuffix}" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/jcrop/css/jquery.Jcrop${csssuffix}"/> --%>
  </head>
  <%@ include file="../../../common.jsp"%>
  <body id="body">
<form id="editForm" method="POST" class="newsForm" >

		<ul >
			<li ><label>信息标题</label><br>
				<input  id="newsTitle" name="newsTitle"></input>
			</li>
			<li ><label >信息内容</label><br>
			 <!--非全屏模式-->
			    <div id="container">
			        <!--菜单栏-->
			        <div id="toolbar-container">
			            <div id="editor-toolbar"></div>
			            <div id="btn-container">
			                <button id="btn1">全屏</button>
			            </div>
			        </div>
			        <input id="hiddencontent" type="hidden" name="newsContent"/>
			        <div id="newsContent" class="newsContent">
			      
			       </div>
                </div>
                </li>
			<li ><label>信息时间</label><br>
				<input id="newsDate" name="newsDate" editable="false" ></input></li>
			<li ><label >信息创建人：</label><br>
				<input  id="newAutor" name="newAutor"></input></li>
		</ul>
	 <input type="hidden" id="isedit" name="isEdit" value="${isEdit}"/>
	 <input type="hidden" id="newsUuid" name=newsUuid value="${info.uuid }"/>
	 <input type="hidden" id="oneLevelClassify" name="oneLevelClassify" value="${param.oneLevelClassify}"/>
	 <input type="hidden" id="towLevelClassify" name="towLevelClassify" value='${param.towLevelClassify}' />
	  <div class="operButon">
			<input id="submitbtn" type="button" class="easyui-linkbutton" onclick=" sbmit()" value="提交"/>
			<input id="reset" type="reset" class="easyui-linkbutton" onclick=" "  value="重置"/>
			
			<input id="button" type="reset" class="easyui-linkbutton" onclick=" retList() "  value="返回列表"/>
	</div>
	</form>
        <!--全屏模式-->
    <div id="cover" ></div>
  </body>
</html>
<script type="text/javascript">
var isEdit = "<c:out value='${isEdit}'/>";
if(isEdit){
	$("#oneLevelClassify").val('${info.one_level_classify}');
	$('#towLevelClassify').val('${info.two_level_classify}');
}
var basePath = $("#basePath").val();
//上传路径
var uploadUrl = basePath+"/website/backstage/InfoReleaseController.do";
uploadUrl ='<c:url value="'+uploadUrl+'"/>?method=uploadPicture';
//获取图片路径
var getImag='<c:url value="/system/freamwork/fileUploadController.do"/>?method=getImage&filePath=';
var _url = '<c:url value="/system/freamwork/fileUploadController.do"/>?method=fileDelete&filePath=';

//图片上路经
var imageuploadsrc = '<c:url value="/system/freamwork/fileUploadController.do"/>?method=fileUpload&oneLevelClassify='+$("#oneLevelClassify").val();
//修改保存路径
var path = '<c:url value="'+ basePath+'/website/backstage/InfoReleaseController.do"/>?method=confirmPicture';
//表单数据初始化---------------------------------------------------
var newsTitle = "${info.newsTitle}";
var newscontent = '${info.news_content}';
var editnewssrc = "${info.thumbnail_image_url}";
var addUrl = '<c:url value="/website/backstage/InfoReleaseController.do"/>?method=saveOrUpdateInfoRelease';
var retrunUrl =  '<c:url value="/website/backstage/InfoReleaseController.do"/>?method=infoReleaseList&oneLevelClassify='+$("#oneLevelClassify").val();
function formInint(isEdit){
	$('#newsDate').datetimebox({   
		editable:true   
	});
	$('#button').css("display","none");
	if (isEdit=="isEdit") {
		$('#button').css("display","inline");
			$('#newsTitle').textbox({
				value : '${info.news_title}',
				type : "text",
				required : true
			});
			$('#newsDate').datetimebox({
				value :'${info.news_date}',
				required : true,
				editable:true  
			});
			$('#newAutor').textbox({
				value : '${info.news_author}',
				type : "text",
				required : true
			});
			$('#towLevelClassify').val('${info.two_level_classify}');
			$("#oneLevelClassify").val('${info.one_level_classify}');
	}
	else{
		$('#newsTitle').textbox({
			value : "",
			type : "text",
			required : true
		});
		$('#newsDate').datetimebox({
			value : "",
			required : true,
			editable:true  
		});
		$('#newAutor').textbox({
			value : "",
			type : "text",
			required : true
		});
	}
}

</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/wangEditor/wangEditor.min${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/uploadfy/jquery.Huploadify${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/jcrop/js/browser${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/jcrop/js/jquery.Jcrop.min${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/backstage/infoRelease/infoAddOrEdit.js"></script>