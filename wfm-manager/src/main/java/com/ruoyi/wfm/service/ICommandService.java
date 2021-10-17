package com.ruoyi.wfm.service;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2021-10-16 19:45
 * @description :
 */
public interface ICommandService {
    List<String> execute(String cmd) throws Exception;
}
