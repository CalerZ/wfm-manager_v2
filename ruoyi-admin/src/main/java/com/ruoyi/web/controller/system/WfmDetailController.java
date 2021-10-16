package com.ruoyi.web.controller.system;

import java.util.List;

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
import com.ruoyi.wfm.domain.WfmDetail;
import com.ruoyi.wfm.service.IWfmDetailService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * wfm_detailController
 *
 * @author ruoyi
 * @date 2021-09-28
 */
@Controller
@RequestMapping("/wfm")
public class WfmDetailController extends BaseController
{
    private String prefix = "wfm/";

    @Autowired
    private IWfmDetailService wfmDetailService;

    /**
     * 查询wfm_detail列表
     */
//    @RequiresPermissions("system:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WfmDetail wfmDetail)
    {
        startPage();
        List<WfmDetail> list = wfmDetailService.selectWfmDetailList(wfmDetail);
        return getDataTable(list);
    }


    /**
     * wfm_detail
     */
    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        WfmDetail wfmDetail = wfmDetailService.selectWfmDetailById(id);
        mmap.put("wfmDetail", wfmDetail);
        return prefix + "/detail";
    }

}
