package com.ruoyi.wfm.mapper;

import java.util.List;

import com.ruoyi.wfm.domain.WfmDetail;

/**
 * wfm_detailMapper接口
 *
 * @author ruoyi
 * @date 2021-09-28
 */
public interface WfmDetailMapper
{
    /**
     * 查询wfm_detail
     *
     * @param id wfm_detail主键
     * @return wfm_detail
     */
    public WfmDetail selectWfmDetailById(Long id);

    /**
     * 查询wfm_detail列表
     *
     * @param wfmDetail wfm_detail
     * @return wfm_detail集合
     */
    public List<WfmDetail> selectWfmDetailList(WfmDetail wfmDetail);

    /**
     * 新增wfm_detail
     *
     * @param wfmDetail wfm_detail
     * @return 结果
     */
    public int insertWfmDetail(WfmDetail wfmDetail);

    /**
     * 修改wfm_detail
     *
     * @param wfmDetail wfm_detail
     * @return 结果
     */
    public int updateWfmDetail(WfmDetail wfmDetail);

    /**
     * 删除wfm_detail
     *
     * @param id wfm_detail主键
     * @return 结果
     */
    public int deleteWfmDetailById(Long id);

    /**
     * 批量删除wfm_detail
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWfmDetailByIds(String[] ids);
}
