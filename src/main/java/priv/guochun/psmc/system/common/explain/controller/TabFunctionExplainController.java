package priv.guochun.psmc.system.common.explain.controller;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import priv.guochun.psmc.system.common.explain.model.TabFunctionExplain;
import priv.guochun.psmc.system.common.explain.service.TabFunctionExplainService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.util.JsonUtil;

/**
 * 功能说明控制类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/system/common/functionExplainController")
public class TabFunctionExplainController extends MyController{
	
	@Autowired
	private TabFunctionExplainService tabFunctionExplainService;
	
	/**
	 * 保存或修改功能说明信息
	 * @param explain
	 * @throws IOException
	 */
	@RequestMapping(params="method=addOrUpdate")
	public void addOrUpdate(TabFunctionExplain explain) throws IOException{
		String explainUuid = tabFunctionExplainService.addOrUpdateExplain(explain);
		super.responseJson(explainUuid, this.response());
	}
	
	/**
	 * 查询功能说明信息
	 * @param functionCode
	 * @throws IOException
	 */
	@RequestMapping(params="method=queryExplain")
	public void queryExplain(String functionCode) throws IOException{
		TabFunctionExplain explain = tabFunctionExplainService.queryExplainByCode(functionCode);
		super.responseJson(explain, this.response());
	}
	
}
