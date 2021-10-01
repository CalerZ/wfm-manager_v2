package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * @author Caler_赵康乐
 * @create 2021-10-01 19:04
 * @description :
 */
public class SysUserDo extends SysUser{

    private static final long serialVersionUID = 1L;

    private String teamName;
    private String wfmName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getWfmName() {
        return wfmName;
    }

    public void setWfmName(String wfmName) {
        this.wfmName = wfmName;
    }
}
