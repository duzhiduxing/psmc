var basePath = $("#basePath").val();

/**
 * 系统基础公共处理对象
 */
var commonObj = new Object();

/**
 * 属地组织树
 * @param chkStyle 单选radio/多选checkbox
 * @param rootPId 默认加载的根节点的id,如果不传递,则默认加载全省的.
 * @param Callback(ids,names) 回调函数,如果不传递回调函数，则程序自动给cityId、cityName赋值
 * ids:选中的id集合,如果是checkbox,ids则英文逗号","隔开
 * namess:选中的name集合,如果是checkbox,names则英文逗号","隔开
 */
commonObj.loadRegoinTree = function(chkStyle,rootPId,Callback){
	if(!rootPId){
		rootPId="00";
	}
	$("#regionTreeDiaLog").dialog({
		modal: true,
		closed: true,
        title: "属地组织树",
        resizable: true,
        width: 220,
        height: 400,
        cache: false,
        href:basePath+"/jsp/system/common/city/cityTree.jsp?chkStyle="+chkStyle+"&rootPId="+rootPId,
        buttons:[{
			text:'确认',
			iconCls:'icon-save',
			handler:function(){
				var ids="";
				var names="";
				var treeObj = $.fn.zTree.getZTreeObj("regionTree");
				var nodes = treeObj.getCheckedNodes(true);
				var nodesLength = nodes.length;
				for(var i=0;i<nodesLength;i++){
					var node = nodes[i];
					ids+=node.ID;
					names+=node.NAME;
					if(i<nodesLength-1){
						ids+=",";
						names+=",";
					}
				}
				if(Callback){
					Callback(ids,names);
				}else{
					$("#cityId").val(ids).blur().focus();
					$("#cityName").val(names).blur().focus();
				}
				$('#regionTreeDiaLog').window('close');
			}
		},{
			text:'关闭',
			iconCls:'icon-no',
			handler:function(){
				$('#regionTreeDiaLog').window('close');
			}
		}]
    });
	$('#regionTreeDiaLog').window('open');
};

/**
 * 统一初始化分页组件 主要是为了保证表格样式的统一性
 * @param option{tabId:表格id,toolbar:按钮div的id,url:数据远程加载地址,columns:显示字段
 * idField:主键}
 * 
 */
commonObj.initPaginationGrid = function(option){
	$('#'+option.tabId).datagrid({
		title:"数据列表",
		columns:option.columns,
	    url:option.url,
	    autoRowHeight:false,
	    toolbar:"#"+option.toolbar,
	    pagination:true,
	    rownumbers:true,
	    fitColumns:true,
	    autoRowHeight:false,
	    remoteSort:false,
	    resizeHandle:"both",
	    nowrap:false,
	    idField:option.idField,
	    striped:true,
	    ctrlSelect:true,
	    onLoadError:function(XMLHttpRequest, textStatus, errorThrown){
	    	commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
	    }
	}); 
	$('#'+option.tabId).datagrid('resize');
};


/**
 *  初始化数据字典的combobox
 *  @param id input id
 *  @param dictNo 数据字典编码
 *  @param defaultValue 默认选中的值
 */
commonObj.initDictCombobox = function(id,dictNo,defaultValue,validate){
	$('#'+id).combobox({
		panelHeight:100,
		method:"GET",
	    url:basePath+'/system/common/dicyController.do?method=loadDict&dictNo='+dictNo,    
	    valueField:'ID',    
	    textField:'NAME',
	    value:defaultValue,
	    required:validate,
	    editable:false
	}); 
};


/**
 *easyui表单提交后的统一处理
 *@param data :{res:success/fail,rmsg:错误描述}
 */
commonObj.showResponse = function(data,callback){
	try{
		if(data=='timeout'){ 
	    	return false;
	    };
		if(allowedAlert(data)){
			return false;
		};
		if(callback){
			return callback(data);
		};
		data = JSON.parse(data);
		if(data.res=='success'){
			commonObj.alert("操作成功!","info");
		}else{
			if(data.rmsg !=null && data.rmsg!='' ){
				commonObj.alert("操作失败,["+data.rmsg+"]","warning");
			}else{
				commonObj.alert("操作失败,请联系管理员!","warning");
				console.warn("错误描述:"+data.rmsg);
			}
		}
	}catch(e){
		commonObj.alert("系统错误,请联系管理员!","error");
		console.info(" e:"+e.message);
	}
};

commonObj.alert = function(msg,icon){
	if("error" == icon){
		msg="系统错误,请联系管理员!";
		$.messager.alert('错误',msg,icon);
	}else if("info" == icon){
		$.messager.alert('消息',msg,icon);
	}else if("warning" == icon){
		$.messager.alert('警告',msg,icon);
	}else if("question" == icon){
		$.messager.alert('question',msg,icon);
	}else{
		$.messager.alert('消息',msg,icon);
	}
};

/**
 * 错误统一捕获处理
 */
commonObj.showError = function(XMLHttpRequest, textStatus, errorThrown){	
	var status  = XMLHttpRequest.status;
	var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus");
    if(sessionstatus=='timeout'){ 
    	//如果超时，统一处理，此处直接返回
    	return;
    }
	if(status == 500){
		var responseText = XMLHttpRequest.responseText;
		allowedAlert(responseText);
		return;
	}
	commonObj.alert("系统错误,请联系管理员!","error");
};

function allowedAlert(text){
	if(text.indexOf("priv.guochun.psmc.authentication.aop.exception.NotAllowedException") !=-1){
		commonObj.alert("用户无权限进行该操作,请联系管理员进行授权!","warning");
		return true;
	}
	return false;
}

commonObj.isAuth = function(operateNo){
	var auth = false;
	if(operateNo == undefined || operateNo == null || operateNo == "")
		return auth;
	var _url=basePath + "/authentication/loginController.do?method=authenticationOperate&operateNo="+operateNo;
	$.ajax({
		async:false,
		cache:false,
		type:'POST',
		dataType:"text",
		context:document.body,
		url:_url,
		success:function(data){
			var dataObj = JSON.parse(data);
			if(dataObj.res == "success"){
				auth = true;
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {
			commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
		}
	});
	return auth;
};


$.ajaxSetup({ 
     complete:function(XMLHttpRequest,textStatus){   
        var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头,sessionstatus， 
            if(sessionstatus=='timeout'){   
                  //如果超时就处理 ，指定要跳转的页面  
                 var top = getTopWinow(); //获取当前页面的顶层窗口对象
                 alert("登录超时,请重新登录.");
                 top.location.href=XMLHttpRequest.getResponseHeader("sessionTimeoutUrl"); //跳转到登陆页面，可以修改为自己需要跳转的页面
             }   
     }   
});

/** 
 * 在页面中任何嵌套层次的窗口中获取顶层窗口 
 * @return 当前页面的顶层窗口对象 
 */
function getTopWinow(){  
  var p = window;  
  while(p != p.parent){  
      p = p.parent;  
  }  
  return p;  
}  
