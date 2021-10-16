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
import com.ruoyi.wfm.domain.WfmBtnConfig;
import com.ruoyi.wfm.service.IWfmBtnConfigService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * wfm_btn_configController
 *
 * @author ruoyi
 * @date 2021-10-16
 */
@Controller
@RequestMapping("/wfm/config")
public class WfmBtnConfigController extends BaseController
{
    private String prefix = "wfm/config";

    @Autowired
    private IWfmBtnConfigService wfmBtnConfigService;

    @RequiresPermissions("wfm:config:view")
    @GetMapping()
    public String config()
    {
        return prefix + "/config";
    }

    /**
     * 查询wfm_btn_config列表
     */
    @RequiresPermissions("wfm:config:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WfmBtnConfig wfmBtnConfig)
    {
        startPage();
        List<WfmBtnConfig> list = wfmBtnConfigService.selectWfmBtnConfigList(wfmBtnConfig);
        return getDataTable(list);
    }

    /**
     * 导出wfm_btn_config列表
     */
    @RequiresPermissions("wfm:config:export")
    @Log(title = "wfm_btn_config", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WfmBtnConfig wfmBtnConfig)
    {
        List<WfmBtnConfig> list = wfmBtnConfigService.selectWfmBtnConfigList(wfmBtnConfig);
        ExcelUtil<WfmBtnConfig> util = new ExcelUtil<WfmBtnConfig>(WfmBtnConfig.class);
        return util.exportExcel(list, "wfm_btn_config数据");
    }

    /**
     * 新增wfm_btn_config
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存wfm_btn_config
     */
    @RequiresPermissions("wfm:config:add")
    @Log(title = "wfm_btn_config", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WfmBtnConfig wfmBtnConfig)
    {
        return toAjax(wfmBtnConfigService.insertWfmBtnConfig(wfmBtnConfig));
    }

    /**
     * 修改wfm_btn_config
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WfmBtnConfig wfmBtnConfig = wfmBtnConfigService.selectWfmBtnConfigById(id);
        mmap.put("wfmBtnConfig", wfmBtnConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存wfm_btn_config
     */
    @RequiresPermissions("wfm:config:edit")
    @Log(title = "wfm_btn_config", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WfmBtnConfig wfmBtnConfig)
    {
        return toAjax(wfmBtnConfigService.updateWfmBtnConfig(wfmBtnConfig));
    }

    /**
     * 删除wfm_btn_config
     */
    @RequiresPermissions("wfm:config:remove")
    @Log(title = "wfm_btn_config", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wfmBtnConfigService.deleteWfmBtnConfigByIds(ids));
    }
}
