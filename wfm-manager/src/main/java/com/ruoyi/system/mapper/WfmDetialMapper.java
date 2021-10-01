package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WfmDetial;

/**
 * wfm_detialMapper接口
 * 
 * @author ruoyi
 * @date 2021-09-28
 */
public interface WfmDetialMapper 
{
    /**
     * 查询wfm_detial
     * 
     * @param id wfm_detial主键
     * @return wfm_detial
     */
    public WfmDetial selectWfmDetialById(Long id);

    /**
     * 查询wfm_detial列表
     * 
     * @param wfmDetial wfm_detial
     * @return wfm_detial集合
     */
    public List<WfmDetial> selectWfmDetialList(WfmDetial wfmDetial);

    /**
     * 新增wfm_detial
     * 
     * @param wfmDetial wfm_detial
     * @return 结果
     */
    public int insertWfmDetial(WfmDetial wfmDetial);

    /**
     * 修改wfm_detial
     * 
     * @param wfmDetial wfm_detial
     * @return 结果
     */
    public int updateWfmDetial(WfmDetial wfmDetial);

    /**
     * 删除wfm_detial
     * 
     * @param id wfm_detial主键
     * @return 结果
     */
    public int deleteWfmDetialById(Long id);

    /**
     * 批量删除wfm_detial
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWfmDetialByIds(String[] ids);
}
