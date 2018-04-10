package priv.guochun.psmc.system.framework.activiti.model;

import java.util.Date;
import java.math.BigDecimal;

public class TFlowInstance {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.tfi_uuid
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private String tfiUuid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.tfc_uuid
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private String tfcUuid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.flow_no
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private String flowNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.flow_cn_name
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private String flowCnName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.flow_en_name
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private String flowEnName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.flow_entrance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private String flowEntrance;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.flow_version
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private Float flowVersion;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.flow_state
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private Integer flowState;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.flow_start_time
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private Date flowStartTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.flow_limit_hour
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private BigDecimal flowLimitHour;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.flow_end_time
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private Date flowEndTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_flow_instance.flow_end_limit_time
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	private Date flowEndLimitTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.tfi_uuid
	 * @return  the value of t_flow_instance.tfi_uuid
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public String getTfiUuid() {
		return tfiUuid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.tfi_uuid
	 * @param tfiUuid  the value for t_flow_instance.tfi_uuid
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setTfiUuid(String tfiUuid) {
		this.tfiUuid = tfiUuid == null ? null : tfiUuid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.tfc_uuid
	 * @return  the value of t_flow_instance.tfc_uuid
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public String getTfcUuid() {
		return tfcUuid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.tfc_uuid
	 * @param tfcUuid  the value for t_flow_instance.tfc_uuid
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setTfcUuid(String tfcUuid) {
		this.tfcUuid = tfcUuid == null ? null : tfcUuid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.flow_no
	 * @return  the value of t_flow_instance.flow_no
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public String getFlowNo() {
		return flowNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.flow_no
	 * @param flowNo  the value for t_flow_instance.flow_no
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setFlowNo(String flowNo) {
		this.flowNo = flowNo == null ? null : flowNo.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.flow_cn_name
	 * @return  the value of t_flow_instance.flow_cn_name
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public String getFlowCnName() {
		return flowCnName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.flow_cn_name
	 * @param flowCnName  the value for t_flow_instance.flow_cn_name
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setFlowCnName(String flowCnName) {
		this.flowCnName = flowCnName == null ? null : flowCnName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.flow_en_name
	 * @return  the value of t_flow_instance.flow_en_name
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public String getFlowEnName() {
		return flowEnName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.flow_en_name
	 * @param flowEnName  the value for t_flow_instance.flow_en_name
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setFlowEnName(String flowEnName) {
		this.flowEnName = flowEnName == null ? null : flowEnName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.flow_entrance
	 * @return  the value of t_flow_instance.flow_entrance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public String getFlowEntrance() {
		return flowEntrance;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.flow_entrance
	 * @param flowEntrance  the value for t_flow_instance.flow_entrance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setFlowEntrance(String flowEntrance) {
		this.flowEntrance = flowEntrance == null ? null : flowEntrance.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.flow_version
	 * @return  the value of t_flow_instance.flow_version
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public Float getFlowVersion() {
		return flowVersion;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.flow_version
	 * @param flowVersion  the value for t_flow_instance.flow_version
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setFlowVersion(Float flowVersion) {
		this.flowVersion = flowVersion;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.flow_state
	 * @return  the value of t_flow_instance.flow_state
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public Integer getFlowState() {
		return flowState;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.flow_state
	 * @param flowState  the value for t_flow_instance.flow_state
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setFlowState(Integer flowState) {
		this.flowState = flowState;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.flow_start_time
	 * @return  the value of t_flow_instance.flow_start_time
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public Date getFlowStartTime() {
		return flowStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.flow_start_time
	 * @param flowStartTime  the value for t_flow_instance.flow_start_time
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setFlowStartTime(Date flowStartTime) {
		this.flowStartTime = flowStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.flow_limit_hour
	 * @return  the value of t_flow_instance.flow_limit_hour
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public BigDecimal getFlowLimitHour() {
		return flowLimitHour;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.flow_limit_hour
	 * @param flowLimitHour  the value for t_flow_instance.flow_limit_hour
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setFlowLimitHour(BigDecimal flowLimitHour) {
		this.flowLimitHour = flowLimitHour;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.flow_end_time
	 * @return  the value of t_flow_instance.flow_end_time
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public Date getFlowEndTime() {
		return flowEndTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.flow_end_time
	 * @param flowEndTime  the value for t_flow_instance.flow_end_time
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setFlowEndTime(Date flowEndTime) {
		this.flowEndTime = flowEndTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_flow_instance.flow_end_limit_time
	 * @return  the value of t_flow_instance.flow_end_limit_time
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public Date getFlowEndLimitTime() {
		return flowEndLimitTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_flow_instance.flow_end_limit_time
	 * @param flowEndLimitTime  the value for t_flow_instance.flow_end_limit_time
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setFlowEndLimitTime(Date flowEndLimitTime) {
		this.flowEndLimitTime = flowEndLimitTime;
	}
}