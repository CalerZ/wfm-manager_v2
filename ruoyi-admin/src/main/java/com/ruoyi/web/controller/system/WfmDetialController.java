package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.WfmDetial;
import com.ruoyi.system.service.IWfmDetialService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * wfm_detialController
 *
 * @author ruoyi
 * @date 2021-09-28
 */
@Controller
@RequestMapping("/system/detial")
public class WfmDetialController extends BaseController
{
    private String prefix = "system/detial";

    @Autowired
    private IWfmDetialService wfmDetialService;

    @RequiresPermissions("system:detial:view")
    @GetMapping()
    public String detial()
    {
        return prefix + "/detial";
    }

    /**
     * 查询wfm_detial列表
     */
    @RequiresPermissions("system:detial:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WfmDetial wfmDetial)
    {
        startPage();
        List<WfmDetial> list = wfmDetialService.selectWfmDetialList(wfmDetial);
        return getDataTable(list);
    }

    /**
     * 导出wfm_detial列表
     */
    @RequiresPermissions("system:detial:export")
    @Log(title = "wfm_detial", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WfmDetial wfmDetial)
    {
        List<WfmDetial> list = wfmDetialService.selectWfmDetialList(wfmDetial);
        ExcelUtil<WfmDetial> util = new ExcelUtil<WfmDetial>(WfmDetial.class);
        return util.exportExcel(list, "wfm_detial数据");
    }

    /**
     * 新增wfm_detial
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存wfm_detial
     */
    @RequiresPermissions("system:detial:add")
    @Log(title = "wfm_detial", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WfmDetial wfmDetial)
    {
        return toAjax(wfmDetialService.insertWfmDetial(wfmDetial));
    }

    /**
     * 修改wfm_detial
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WfmDetial wfmDetial = wfmDetialService.selectWfmDetialById(id);
        mmap.put("wfmDetial", wfmDetial);
        return prefix + "/edit";
    }

    /**
     * 修改保存wfm_detial
     */
    @RequiresPermissions("system:detial:edit")
    @Log(title = "wfm_detial", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WfmDetial wfmDetial)
    {
        return toAjax(wfmDetialService.updateWfmDetial(wfmDetial));
    }

    /**
     * 删除wfm_detial
     */
    @RequiresPermissions("system:detial:remove")
    @Log(title = "wfm_detial", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wfmDetialService.deleteWfmDetialByIds(ids));
    }
}
