package com.ruoyi.wfm.service;

import java.util.List;

import com.ruoyi.wfm.domain.WfmDetail;

/**
 * wfm_DetailService接口
 *
 * @author ruoyi
 * @date 2021-09-28
 */
public interface IWfmDetailService
{
    /**
     * 查询wfm_Detail
     *
     * @param id wfm_Detail主键
     * @return wfm_Detail
     */
    public WfmDetail selectWfmDetailById(Long id);

    /**
     * 查询wfm_Detail列表
     *
     * @param wfmDetail wfm_Detail
     * @return wfm_Detail集合
     */
    public List<WfmDetail> selectWfmDetailList(WfmDetail wfmDetail);

    /**
     * 新增wfm_Detail
     *
     * @param wfmDetail wfm_Detail
     * @return 结果
     */
    public int insertWfmDetail(WfmDetail wfmDetail);

    /**
     * 修改wfm_Detail
     *
     * @param wfmDetail wfm_Detail
     * @return 结果
     */
    public int updateWfmDetail(WfmDetail wfmDetail);

    /**
     * 批量删除wfm_Detail
     *
     * @param ids 需要删除的wfm_Detail主键集合
     * @return 结果
     */
    public int deleteWfmDetailByIds(String ids);

    /**
     * 删除wfm_Detail信息
     *
     * @param id wfm_Detail主键
     * @return 结果
     */
    public int deleteWfmDetailById(Long id);
}
