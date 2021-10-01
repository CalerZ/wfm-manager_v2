package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WfmDetialMapper;
import com.ruoyi.system.domain.WfmDetial;
import com.ruoyi.system.service.IWfmDetialService;
import com.ruoyi.common.core.text.Convert;

/**
 * wfm_detialService业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-28
 */
@Service
public class WfmDetialServiceImpl implements IWfmDetialService 
{
    @Autowired
    private WfmDetialMapper wfmDetialMapper;

    /**
     * 查询wfm_detial
     * 
     * @param id wfm_detial主键
     * @return wfm_detial
     */
    @Override
    public WfmDetial selectWfmDetialById(Long id)
    {
        return wfmDetialMapper.selectWfmDetialById(id);
    }

    /**
     * 查询wfm_detial列表
     * 
     * @param wfmDetial wfm_detial
     * @return wfm_detial
     */
    @Override
    public List<WfmDetial> selectWfmDetialList(WfmDetial wfmDetial)
    {
        return wfmDetialMapper.selectWfmDetialList(wfmDetial);
    }

    /**
     * 新增wfm_detial
     * 
     * @param wfmDetial wfm_detial
     * @return 结果
     */
    @Override
    public int insertWfmDetial(WfmDetial wfmDetial)
    {
        return wfmDetialMapper.insertWfmDetial(wfmDetial);
    }

    /**
     * 修改wfm_detial
     * 
     * @param wfmDetial wfm_detial
     * @return 结果
     */
    @Override
    public int updateWfmDetial(WfmDetial wfmDetial)
    {
        wfmDetial.setUpdateTime(DateUtils.getNowDate());
        return wfmDetialMapper.updateWfmDetial(wfmDetial);
    }

    /**
     * 批量删除wfm_detial
     * 
     * @param ids 需要删除的wfm_detial主键
     * @return 结果
     */
    @Override
    public int deleteWfmDetialByIds(String ids)
    {
        return wfmDetialMapper.deleteWfmDetialByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除wfm_detial信息
     * 
     * @param id wfm_detial主键
     * @return 结果
     */
    @Override
    public int deleteWfmDetialById(Long id)
    {
        return wfmDetialMapper.deleteWfmDetialById(id);
    }
}
