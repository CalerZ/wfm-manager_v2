package com.ruoyi.wfm.service.impl;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.wfm.service.IJenkinsJobService;
import com.ruoyi.wfm.utils.JobApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Caler_赵康乐
 * @create 2021-10-16 20:52
 * @description :
 */
@Service
public class JenkinsJobServiceImpl implements IJenkinsJobService {

    public Boolean run(String url, String jobName, Map<String, String> param) {
        SysUser user = ShiroUtils.getSysUser();
        JobApi jobApi = new JobApi(url, user.getLoginName(), user.getToken1()).build();
        jobApi.buildParamJob(jobName, param);
        return true;
    }
}
