package com.ruoyi.wfm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wfm.mapper.WfmBtnMapper;
import com.ruoyi.wfm.domain.WfmBtn;
import com.ruoyi.wfm.service.IWfmBtnService;
import com.ruoyi.common.core.text.Convert;

/**
 * wfm_btnService业务层处理
 *
 * @author ruoyi
 * @date 2021-10-16
 */
@Service
public class WfmBtnServiceImpl implements IWfmBtnService
{
    @Autowired
    private WfmBtnMapper wfmBtnMapper;

    /**
     * 查询wfm_btn
     *
     * @param id wfm_btn主键
     * @return wfm_btn
     */
    @Override
    public WfmBtn selectWfmBtnById(Long id)
    {
        return wfmBtnMapper.selectWfmBtnById(id);
    }

    /**
     * 查询wfm_btn列表
     *
     * @param wfmBtn wfm_btn
     * @return wfm_btn
     */
    @Override
    public List<WfmBtn> selectWfmBtnList(WfmBtn wfmBtn)
    {
        return wfmBtnMapper.selectWfmBtnList(wfmBtn);
    }

    /**
     * 新增wfm_btn
     *
     * @param wfmBtn wfm_btn
     * @return 结果
     */
    @Override
    public int insertWfmBtn(WfmBtn wfmBtn)
    {
        return wfmBtnMapper.insertWfmBtn(wfmBtn);
    }

    /**
     * 修改wfm_btn
     *
     * @param wfmBtn wfm_btn
     * @return 结果
     */
    @Override
    public int updateWfmBtn(WfmBtn wfmBtn)
    {
        wfmBtn.setUpdateTime(DateUtils.getNowDate());
        return wfmBtnMapper.updateWfmBtn(wfmBtn);
    }

    /**
     * 批量删除wfm_btn
     *
     * @param ids 需要删除的wfm_btn主键
     * @return 结果
     */
    @Override
    public int deleteWfmBtnByIds(String ids)
    {
        return wfmBtnMapper.deleteWfmBtnByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除wfm_btn信息
     *
     * @param id wfm_btn主键
     * @return 结果
     */
    @Override
    public int deleteWfmBtnById(Long id)
    {
        return wfmBtnMapper.deleteWfmBtnById(id);
    }
}
