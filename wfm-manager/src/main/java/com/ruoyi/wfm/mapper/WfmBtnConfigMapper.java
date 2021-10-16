package com.ruoyi.wfm.mapper;

import java.util.List;
import com.ruoyi.wfm.domain.WfmBtnConfig;

/**
 * wfm_btn_configMapper接口
 *
 * @author ruoyi
 * @date 2021-10-16
 */
public interface WfmBtnConfigMapper
{
    /**
     * 查询wfm_btn_config
     *
     * @param id wfm_btn_config主键
     * @return wfm_btn_config
     */
    public WfmBtnConfig selectWfmBtnConfigById(Long id);

    /**
     * 查询wfm_btn_config列表
     *
     * @param wfmBtnConfig wfm_btn_config
     * @return wfm_btn_config集合
     */
    public List<WfmBtnConfig> selectWfmBtnConfigList(WfmBtnConfig wfmBtnConfig);

    /**
     * 新增wfm_btn_config
     *
     * @param wfmBtnConfig wfm_btn_config
     * @return 结果
     */
    public int insertWfmBtnConfig(WfmBtnConfig wfmBtnConfig);

    /**
     * 修改wfm_btn_config
     *
     * @param wfmBtnConfig wfm_btn_config
     * @return 结果
     */
    public int updateWfmBtnConfig(WfmBtnConfig wfmBtnConfig);

    /**
     * 删除wfm_btn_config
     *
     * @param id wfm_btn_config主键
     * @return 结果
     */
    public int deleteWfmBtnConfigById(Long id);

    /**
     * 批量删除wfm_btn_config
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWfmBtnConfigByIds(String[] ids);
}
