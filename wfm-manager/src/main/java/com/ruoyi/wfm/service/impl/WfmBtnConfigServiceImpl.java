package com.ruoyi.wfm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wfm.mapper.WfmBtnConfigMapper;
import com.ruoyi.wfm.domain.WfmBtnConfig;
import com.ruoyi.wfm.service.IWfmBtnConfigService;
import com.ruoyi.common.core.text.Convert;

/**
 * wfm_btn_configService业务层处理
 *
 * @author ruoyi
 * @date 2021-10-16
 */
@Service
public class WfmBtnConfigServiceImpl implements IWfmBtnConfigService
{
    @Autowired
    private WfmBtnConfigMapper wfmBtnConfigMapper;

    /**
     * 查询wfm_btn_config
     *
     * @param id wfm_btn_config主键
     * @return wfm_btn_config
     */
    @Override
    public WfmBtnConfig selectWfmBtnConfigById(Long id)
    {
        return wfmBtnConfigMapper.selectWfmBtnConfigById(id);
    }

    /**
     * 查询wfm_btn_config列表
     *
     * @param wfmBtnConfig wfm_btn_config
     * @return wfm_btn_config
     */
    @Override
    public List<WfmBtnConfig> selectWfmBtnConfigList(WfmBtnConfig wfmBtnConfig)
    {
        return wfmBtnConfigMapper.selectWfmBtnConfigList(wfmBtnConfig);
    }

    /**
     * 新增wfm_btn_config
     *
     * @param wfmBtnConfig wfm_btn_config
     * @return 结果
     */
    @Override
    public int insertWfmBtnConfig(WfmBtnConfig wfmBtnConfig)
    {
        return wfmBtnConfigMapper.insertWfmBtnConfig(wfmBtnConfig);
    }

    /**
     * 修改wfm_btn_config
     *
     * @param wfmBtnConfig wfm_btn_config
     * @return 结果
     */
    @Override
    public int updateWfmBtnConfig(WfmBtnConfig wfmBtnConfig)
    {
        wfmBtnConfig.setUpdateTime(DateUtils.getNowDate());
        return wfmBtnConfigMapper.updateWfmBtnConfig(wfmBtnConfig);
    }

    /**
     * 批量删除wfm_btn_config
     *
     * @param ids 需要删除的wfm_btn_config主键
     * @return 结果
     */
    @Override
    public int deleteWfmBtnConfigByIds(String ids)
    {
        return wfmBtnConfigMapper.deleteWfmBtnConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除wfm_btn_config信息
     *
     * @param id wfm_btn_config主键
     * @return 结果
     */
    @Override
    public int deleteWfmBtnConfigById(Long id)
    {
        return wfmBtnConfigMapper.deleteWfmBtnConfigById(id);
    }
}
