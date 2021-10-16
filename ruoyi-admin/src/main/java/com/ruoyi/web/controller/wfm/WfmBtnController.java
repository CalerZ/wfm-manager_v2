package com.ruoyi.web.controller.wfm;

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
import com.ruoyi.wfm.domain.WfmBtn;
import com.ruoyi.wfm.service.IWfmBtnService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * wfm_btnController
 *
 * @author ruoyi
 * @date 2021-10-16
 */
@Controller
@RequestMapping("/wfm/btn")
public class WfmBtnController extends BaseController
{
    private String prefix = "wfm/btn";

    @Autowired
    private IWfmBtnService wfmBtnService;

    @RequiresPermissions("wfm:btn:view")
    @GetMapping()
    public String btn()
    {
        return prefix + "/btn";
    }

    /**
     * 查询wfm_btn列表
     */
    @RequiresPermissions("wfm:btn:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WfmBtn wfmBtn)
    {
        startPage();
        List<WfmBtn> list = wfmBtnService.selectWfmBtnList(wfmBtn);
        return getDataTable(list);
    }

    /**
     * 导出wfm_btn列表
     */
    @RequiresPermissions("wfm:btn:export")
    @Log(title = "wfm_btn", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WfmBtn wfmBtn)
    {
        List<WfmBtn> list = wfmBtnService.selectWfmBtnList(wfmBtn);
        ExcelUtil<WfmBtn> util = new ExcelUtil<WfmBtn>(WfmBtn.class);
        return util.exportExcel(list, "wfm_btn数据");
    }

    /**
     * 新增wfm_btn
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存wfm_btn
     */
    @RequiresPermissions("wfm:btn:add")
    @Log(title = "wfm_btn", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WfmBtn wfmBtn)
    {
        return toAjax(wfmBtnService.insertWfmBtn(wfmBtn));
    }

    /**
     * 修改wfm_btn
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WfmBtn wfmBtn = wfmBtnService.selectWfmBtnById(id);
        mmap.put("wfmBtn", wfmBtn);
        return prefix + "/edit";
    }

    /**
     * 修改保存wfm_btn
     */
    @RequiresPermissions("wfm:btn:edit")
    @Log(title = "wfm_btn", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WfmBtn wfmBtn)
    {
        return toAjax(wfmBtnService.updateWfmBtn(wfmBtn));
    }

    /**
     * 删除wfm_btn
     */
    @RequiresPermissions("wfm:btn:remove")
    @Log(title = "wfm_btn", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wfmBtnService.deleteWfmBtnByIds(ids));
    }
}
