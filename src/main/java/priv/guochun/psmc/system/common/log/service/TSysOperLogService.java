package priv.guochun.psmc.system.common.log.service;

import org.json.JSONObject;

import priv.guochun.psmc.system.common.log.model.TSysOperLog;
import priv.guochun.psmc.system.framework.page.MyPage;

public interface TSysOperLogService {
	
	public JSONObject save(TSysOperLog tTSysOperLog);
	
	/**
	 * 获取分页日志数据
	 * @param myPage
	 * @return
	 */
	public MyPage getMyPageOfTSysOperLog(MyPage myPage);
}
