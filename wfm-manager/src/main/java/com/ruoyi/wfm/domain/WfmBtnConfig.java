package com.ruoyi.wfm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * wfm_btn_config对象 wfm_btn_config
 *
 * @author ruoyi
 * @date 2021-10-16
 */
public class WfmBtnConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 配置名称 */
    @Excel(name = "配置名称")
    private String name;

    /** 配置json */
    @Excel(name = "配置json")
    private String context;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setContext(String context)
    {
        this.context = context;
    }

    public String getContext()
    {
        return context;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("context", getContext())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
