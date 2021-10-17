package com.ruoyi.wfm.helper;

import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Caler_赵康乐
 * @create 2021-10-16 19:45
 * @description :
 */
public class CmdTaskHelper implements Callable<List<String>> {
    private String command;

    public CmdTaskHelper(String command) {
        this.command = command;
    }

    @Override
    public List<String> call() throws Exception {
        Process process = null;
        int exitVal = 0;
        List<String> returnList = new ArrayList<>();
        try {
            process = Runtime.getRuntime().exec(command);
            // Runtime.exec()创建的子进程公用父进程的流，不同平台上，父进程的stream buffer可能被打满导致子进程阻塞，从而永远无法返回。
            //针对这种情况，我们只需要将子进程的stream重定向出来即可。
            ExecutorService executorService = Executors.newCachedThreadPool();
            Future<List<String>> info = executorService.submit(new RedirCmdStream(process.getInputStream()));
            Future<List<String>> error = executorService.submit(new RedirCmdStream(process.getErrorStream()));
            returnList.addAll(info.get());
            returnList.addAll(error.get());
            exitVal = process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        if (exitVal != 0) {
            throw new RuntimeException("cmd任务执行失败");
        }
        return returnList;
    }

    class RedirCmdStream implements Callable<List<String>> {
        InputStream is;

        RedirCmdStream(InputStream is) {
            this.is = is;
        }

        @Override
        public List<String> call() throws Exception {
            List<String> strings = new ArrayList<>();
            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    strings.add(line);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
                throw new RuntimeException(ioe.getMessage());
            }
            return strings;
        }
    }


}
