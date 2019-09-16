package com.jizhang.activiti.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * @author aaron
 * @since 2019-09-16
 */
public class WorkOrderProduct implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * uuid
     */
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    private LocalDateTime updatedTime;

    /**
     * 客户id
     */
    private Long companyId;

    /**
     * 任务状态，1-已创建，2-待分配，3-待办理，4-已完成，5-未还成
     */
    private Integer taskStatus;

    /**
     * 任务内容
     */
    private String taskContent;

    /**
     * 是否逻辑删除 0-未删除 1-已删除
     */
    private Integer isDeleted;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "WorkOrderProduct{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", productName=" + productName +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        ", companyId=" + companyId +
        ", taskStatus=" + taskStatus +
        ", taskContent=" + taskContent +
        ", isDeleted=" + isDeleted +
        "}";
    }
}
