package com.ruoyi.wfm.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.wfm.domain.WfmDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wfm.mapper.WfmDetailMapper;
import com.ruoyi.wfm.service.IWfmDetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * wfm_detailService业务层处理
 *
 * @author ruoyi
 * @date 2021-09-28
 */
@Service
public class WfmDetailServiceImpl implements IWfmDetailService
{
    @Autowired
    private WfmDetailMapper wfmDetailMapper;

    /**
     * 查询wfm_detail
     *
     * @param id wfm_detail主键
     * @return wfm_detail
     */
    @Override
    public WfmDetail selectWfmDetailById(Long id)
    {
        return wfmDetailMapper.selectWfmDetailById(id);
    }

    /**
     * 查询wfm_detail列表
     *
     * @param wfmDetail wfm_detail
     * @return wfm_detail
     */
    @Override
    public List<WfmDetail> selectWfmDetailList(WfmDetail wfmDetail)
    {
        return wfmDetailMapper.selectWfmDetailList(wfmDetail);
    }

    /**
     * 新增wfm_detail
     *
     * @param wfmDetail wfm_detail
     * @return 结果
     */
    @Override
    public int insertWfmDetail(WfmDetail wfmDetail)
    {
        return wfmDetailMapper.insertWfmDetail(wfmDetail);
    }

    /**
     * 修改wfm_detail
     *
     * @param wfmDetail wfm_detail
     * @return 结果
     */
    @Override
    public int updateWfmDetail(WfmDetail wfmDetail)
    {
        wfmDetail.setUpdateTime(DateUtils.getNowDate());
        return wfmDetailMapper.updateWfmDetail(wfmDetail);
    }

    /**
     * 批量删除wfm_detail
     *
     * @param ids 需要删除的wfm_detail主键
     * @return 结果
     */
    @Override
    public int deleteWfmDetailByIds(String ids)
    {
        return wfmDetailMapper.deleteWfmDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除wfm_detail信息
     *
     * @param id wfm_detail主键
     * @return 结果
     */
    @Override
    public int deleteWfmDetailById(Long id)
    {
        return wfmDetailMapper.deleteWfmDetailById(id);
    }
}
