package com.ruoyi.wfm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * wfm_detial对象 wfm_detial
 *
 * @author ruoyi
 * @date 2021-09-28
 */
public class WfmDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String wfmName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String wfmType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String backend;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String backendBuild;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String frontend;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String frontendBuild;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ownerEmail;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWfmName(String wfmName)
    {
        this.wfmName = wfmName;
    }

    public String getWfmName()
    {
        return wfmName;
    }
    public void setWfmType(String wfmType)
    {
        this.wfmType = wfmType;
    }

    public String getWfmType()
    {
        return wfmType;
    }
    public void setBackend(String backend)
    {
        this.backend = backend;
    }

    public String getBackend()
    {
        return backend;
    }
    public void setBackendBuild(String backendBuild)
    {
        this.backendBuild = backendBuild;
    }

    public String getBackendBuild()
    {
        return backendBuild;
    }
    public void setFrontend(String frontend)
    {
        this.frontend = frontend;
    }

    public String getFrontend()
    {
        return frontend;
    }
    public void setFrontendBuild(String frontendBuild)
    {
        this.frontendBuild = frontendBuild;
    }

    public String getFrontendBuild()
    {
        return frontendBuild;
    }
    public void setOwnerEmail(String ownerEmail)
    {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerEmail()
    {
        return ownerEmail;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("wfmName", getWfmName())
            .append("wfmType", getWfmType())
            .append("backend", getBackend())
            .append("backendBuild", getBackendBuild())
            .append("frontend", getFrontend())
            .append("frontendBuild", getFrontendBuild())
            .append("ownerEmail", getOwnerEmail())
            .append("status", getStatus())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
