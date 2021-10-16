package com.ruoyi.wfm.service;

import java.util.List;
import com.ruoyi.wfm.domain.WfmBtn;

/**
 * wfm_btnService接口
 *
 * @author ruoyi
 * @date 2021-10-16
 */
public interface IWfmBtnService
{
    /**
     * 查询wfm_btn
     *
     * @param id wfm_btn主键
     * @return wfm_btn
     */
    public WfmBtn selectWfmBtnById(Long id);

    /**
     * 查询wfm_btn列表
     *
     * @param wfmBtn wfm_btn
     * @return wfm_btn集合
     */
    public List<WfmBtn> selectWfmBtnList(WfmBtn wfmBtn);

    /**
     * 新增wfm_btn
     *
     * @param wfmBtn wfm_btn
     * @return 结果
     */
    public int insertWfmBtn(WfmBtn wfmBtn);

    /**
     * 修改wfm_btn
     *
     * @param wfmBtn wfm_btn
     * @return 结果
     */
    public int updateWfmBtn(WfmBtn wfmBtn);

    /**
     * 批量删除wfm_btn
     *
     * @param ids 需要删除的wfm_btn主键集合
     * @return 结果
     */
    public int deleteWfmBtnByIds(String ids);

    /**
     * 删除wfm_btn信息
     *
     * @param id wfm_btn主键
     * @return 结果
     */
    public int deleteWfmBtnById(Long id);
}
