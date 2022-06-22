package synthesistaxgovernance.datasource.po.datachip.realestate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import synthesistaxgovernance.api.common.AbstractDataChipModel;
import synthesistaxgovernance.datasource.generatetable.annotation.ColumnInfo;
import synthesistaxgovernance.datasource.generatetable.annotation.TableInfo;

import java.util.Date;

/**
 * 竣工结算对象 t_project_acceptance_settle
 *
 * @author huangxiong
 * @date 2021-08-31
 */
@TableInfo(comment = "竣工结算对象")
@TableName(value = "real_estate_project_acceptance_settle")
public class ProjectAcceptanceSettlePO extends AbstractDataChipModel {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ColumnInfo(comment = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目编号
     */
    @ColumnInfo(comment = "项目编号")
    private String projectCode;

    /**
     * 项目名称
     */
    @ColumnInfo(comment = "项目名称")
    private String projectName;

    /**
     * 结算时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ColumnInfo(comment = "结算时间")
    private Date settleTime;

    /**
     * 状态
     */
    @ColumnInfo(comment = "状态")
    private String status;

    /**
     * 删除状态
     */
    private String delFlag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
