package priv.guochun.psmc.system.framework.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.service.UploadAssemblyInterface;
import priv.guochun.psmc.system.framework.upload.util.FtpUtil;
import priv.guochun.psmc.system.framework.upload.util.PSMCFileUtils;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.website.backstage.attachment.model.TabAttachment;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;
@Scope("prototype")
@Controller
@RequestMapping("/system/freamwork/fileUploadController")
public class FileUploadController extends MyController {
	@Autowired
	private UploadAssemblyInterface uploadAssemblyInterface;
	@Autowired
	private TabAttachmentService tabAttachmentService;
	@RequestMapping(params="method=fileUpload")
	@ResponseBody
	public void fileUpload(HttpServletRequest request,HttpServletResponse response,String oneLevelClassify) throws IllegalStateException, IOException{
		request.setAttribute("imagePath", this.getImagePath(oneLevelClassify));
		UploadFileModel upf = uploadAssemblyInterface.getFile(request);
		FtpUtil ftu = FtpUtil.getFtputil();
		String filepath = ftu.uploadFile(upf);
		super.responseJson(true,filepath, response);
	}
	@RequestMapping(params="method=testFileDownload")
	public View testFileDownload(HttpServletRequest request,HttpServletResponse response,String filePath) throws IllegalStateException, IOException{
		FtpUtil ftu = FtpUtil.getFtputil();
		File resFiel = ftu.downloadFileByFtp(filePath);
		return this.responseFile(resFiel, PSMCFileUtils.getFileNameByPath(filePath), response);
	}
	@RequestMapping(params="method=getImage")
	public void getImage(HttpServletRequest request,HttpServletResponse response,String filePath) throws Exception{
		filePath = PSMCFileUtils.decodedFileName(filePath);
		FtpUtil ftu = FtpUtil.getFtputil();
		File resFiel = ftu.downloadFileByFtp(filePath);
		this.responseImage(response, resFiel);
	}
	@RequestMapping(params="method=fileDelete")
	@ResponseBody
	public void fileDelete(HttpServletRequest request,HttpServletResponse response,String filePath) throws IllegalStateException, IOException{
		FtpUtil ftu = FtpUtil.getFtputil();
	     ftu.deleteFile(filePath);
		super.responseJson(true,"文件："+filePath+"删除成功！", response);
	}
	@RequestMapping(params="method=listFiles")
	@ResponseBody
	public void listFiles(HttpServletRequest request,HttpServletResponse response,String filePath) throws IllegalStateException, IOException{
		FtpUtil ftu = FtpUtil.getFtputil();
	    Map<String,Object> resm = ftu.getFileList(filePath);
	    JSONObject jsob = new JSONObject(resm);
		super.responseJson(jsob, response);
	}
	
	/**
	 * 文件批量上传
	 * @param request
	 * @param response
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(params="method=fileBatchUpload")
	@ResponseBody
	public void fileBatchUpload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		request.setAttribute("imagePath", SystemPropertiesUtil.getMobileImagePath());
		List<UploadFileModel> uploadFileModelList = uploadAssemblyInterface.getFiles(request);
		FtpUtil ftu = FtpUtil.getFtputil();
		String paths = "";
		if(uploadFileModelList != null && uploadFileModelList.size() > 0) {
			for (int i = 0; i < uploadFileModelList.size();  i++) {
				String filepath = ftu.uploadFile(uploadFileModelList.get(i));
				//添加附件信息
				TabAttachment attachment = new TabAttachment();
				attachment.setFileName(uploadFileModelList.get(i).getFileSystemName());
				attachment.setFilePath(uploadFileModelList.get(i).getCustom_file_path());
				attachment.setFilePrefix(SystemPropertiesUtil.getfilePrefixPath());
				attachment.setFileRealName(uploadFileModelList.get(i).getFileRealName());
				attachment.setFileSuffix(uploadFileModelList.get(i).getSuffix());
				attachment.setSort(i + 1);
				String attachmentUuid = tabAttachmentService.addAttachment(attachment);
				if(i > 0) {
					paths += ",";
				}
				paths += attachmentUuid;
			}
		}
		super.responseJson(true,paths, response);
	}
	
	/**
	 * 文件上传
	 * @param request
	 * @param response
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(params="method=fileUploadByPC")
	@ResponseBody
	public void fileUploadByPC(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		request.setAttribute("imagePath", SystemPropertiesUtil.getMobileImagePath());
		List<UploadFileModel> uploadFileModelList = uploadAssemblyInterface.getFiles(request);
		FtpUtil ftu = FtpUtil.getFtputil();
		String paths = "";
		TabAttachment attachment = null;
		if(uploadFileModelList != null && uploadFileModelList.size() > 0) {
			for (int i = 0; i < uploadFileModelList.size();  i++) {
				String filepath = ftu.uploadFile(uploadFileModelList.get(i));
				//添加附件信息
				attachment = new TabAttachment();
				attachment.setFileName(uploadFileModelList.get(i).getFileSystemName());
				attachment.setFilePath(uploadFileModelList.get(i).getCustom_file_path());
				attachment.setFilePrefix(SystemPropertiesUtil.getfilePrefixPath());
				attachment.setFileRealName(uploadFileModelList.get(i).getFileRealName());
				attachment.setFileSuffix(uploadFileModelList.get(i).getSuffix());
				attachment.setSort(i + 1);
				String attachmentUuid = tabAttachmentService.addAttachment(attachment);
			}
		}
		super.responseJson(attachment, response);
	}

	private String getImagePath(String oneLevelClassify){
		String imagePath = "";
		if(StringUtils.isNotBlank(oneLevelClassify)){
			switch (oneLevelClassify) {
			case ContantsUtil.ONE_LEVEL_CLASSIFY_11:
				imagePath = SystemPropertiesUtil.getInnovationCustomPath();
				break;
			case ContantsUtil.ONE_LEVEL_CLASSIFY_12:
				imagePath = SystemPropertiesUtil.getAssistanceCustomPath();
				break;
			case ContantsUtil.ONE_LEVEL_CLASSIFY_13:
				imagePath = SystemPropertiesUtil.getLiteraryFormCustomPath();
				break;
			case ContantsUtil.ONE_LEVEL_CLASSIFY_14:
				imagePath = SystemPropertiesUtil.getLogisticsCenterCustomPath();
				break;
			case ContantsUtil.DEPT_TYPE_1:
				imagePath = SystemPropertiesUtil.getDeptInnovationCustomPath();
				break;
			case ContantsUtil.DEPT_TYPE_2:
				imagePath = SystemPropertiesUtil.getDeptLiteraryFormCustomPath();
				break;
			case ContantsUtil.ACTIVITY:
				imagePath = SystemPropertiesUtil.getActivityCustomPath();
				break;
			default:
				break;
			}
		}
		return imagePath;
	}
}
