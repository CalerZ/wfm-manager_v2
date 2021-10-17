package com.ruoyi.wfm.service.impl;

import com.ruoyi.wfm.helper.CmdTaskHelper;
import com.ruoyi.wfm.service.ICommandService;
import com.ruoyi.wfm.utils.CMDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Caler_赵康乐
 * @create 2021-10-16 19:49
 * @description :
 */
@Service
public class CommandServiceImpl implements ICommandService {

    public List<String> execute(String cmd) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<List<String>> future = executorService.submit(new CmdTaskHelper(cmd));
        return future.get();
    }

}
