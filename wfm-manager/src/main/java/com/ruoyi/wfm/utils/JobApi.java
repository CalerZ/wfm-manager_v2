package com.ruoyi.wfm.utils;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.client.JenkinsHttpClient;
import com.offbytwo.jenkins.helper.Range;
import com.offbytwo.jenkins.model.*;
import com.ruoyi.common.utils.StringUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Job(任务) 相关操作
 *
 * 例如对任务的增、删、改、查等操作
 */
public class JobApi {
    private String url ;
    private String userName;
    private String token;

    // Jenkins 对象
    private JenkinsServer jenkinsServer;
    // http 客户端对象
    private JenkinsHttpClient jenkinsHttpClient;

    public JobApi(String url,String userName, String token){
        this.url = url;
        this.userName = userName;
        this.token = token;
    }

    public JobApi build() {
        if(StringUtils.isEmpty(url)||StringUtils.isEmpty(userName) ||StringUtils.isEmpty(token)){
            return this;
        }
        try {
            this.jenkinsServer = new JenkinsServer(new URI(url), userName, token);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return this;
    }


    /**
     * 执行带参数 Job build
     */
    public void buildParamJob(String jobName, Map<String,String> param){
        try {
            // 执行 build 任务
            JobWithDetails job = jenkinsServer.getJob(jobName);
            Build lastBuild = job.getLastBuild();
            System.out.println(lastBuild.getNumber());
            QueueReference queueReference = job.build(param);
            System.out.println(queueReference.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 Job 一定范围的 Build 列表
     */
    public void getJobBuildListRange(){
        try {
            // 获取 Job 信息
            JobWithDetails job = jenkinsServer.getJob("test-job");
            // 设定范围
            Range range = Range.build().from(1).to(2);
            System.err.println(range.getRangeString());
            // 获取一定范围的 Build 信息
            List<Build> builds = job.getAllBuilds(range);
            for (Build build:builds){
                System.out.println(build.getNumber());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 Build 基本信息
     */
    public void getJobBuildInfo(Build build){
        // 获取构建的 URL 地址
        System.out.println(build.getUrl());
        // 获取构建编号
        System.out.println(build.getNumber());
        // 获取测试报告
        //build.getTestReport();
        // 获取测试结果
        //build.getTestResult();
    }

    /**
     * 获取 Build 详细信息
     */
    public void getJobBuildDetailInfo(){
        try {
            // 获取 Job 信息
            JobWithDetails job = jenkinsServer.getJob("test-job");
            // 这里用最后一次编译来示例
            BuildWithDetails build = job.getLastBuild().details();
            // 获取构建的显示名称
            System.out.println(build.getDisplayName());
            // 获取构建的参数信息
            System.out.println(build.getParameters());
            // 获取构建编号
            System.out.println(build.getNumber());
            // 获取构建结果，如果构建未完成则会显示为null
            System.out.println(build.getResult());
            // 获取执行构建的活动信息
            System.out.println(build.getActions());
            // 获取构建持续多少时间(ms)
            System.out.println(build.getDuration());
            // 获取构建开始时间戳
            System.out.println(build.getTimestamp());
            // 获取构建头信息，里面包含构建的用户，上游信息，时间戳等
            List<BuildCause> buildCauses = build.getCauses();
            for (BuildCause bc:buildCauses){
                System.out.println(bc.getUserId());
                System.out.println(bc.getShortDescription());
                System.out.println(bc.getUpstreamBuild());
                System.out.println(bc.getUpstreamProject());
                System.out.println(bc.getUpstreamUrl());
                System.out.println(bc.getUserName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 Build Log 日志信息
     */
    public void getJobBuildLog(){
        try {
            // 获取 Job 信息
            JobWithDetails job = jenkinsServer.getJob("test-job");
            // 这里用最后一次编译来示例
            BuildWithDetails build = job.getLastBuild().details();
            // 获取构建的日志，如果正在执行构建，则会只获取已经执行的过程日志

            // Text格式日志
            System.out.println(build.getConsoleOutputText());
            // Html格式日志
            System.out.println(build.getConsoleOutputHtml());

            // 获取部分日志,一般用于正在执行构建的任务
            ConsoleLog consoleLog = build.getConsoleOutputText(0);
            // 获取当前日志大小
            System.out.println(consoleLog.getCurrentBufferSize());
            // 是否已经构建完成，还有更多日志信息
            System.out.println(consoleLog.getHasMoreData());
            // 获取当前截取的日志信息
            System.out.println(consoleLog.getConsoleLog());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取正在执行构建任务的日志信息
     */
    public void getBuildActiveLog(){
        try {
            // 这里用最后一次编译来示例
            BuildWithDetails build = jenkinsServer.getJob("test-job").getLastBuild().details();
            // 当前日志
            ConsoleLog currentLog = build.getConsoleOutputText(0);
            // 输出当前获取日志信息
            System.out.println(currentLog.getConsoleLog());
            // 检测是否还有更多日志,如果是则继续循环获取
            while (currentLog.getHasMoreData()){
                // 获取最新日志信息
                ConsoleLog newLog = build.getConsoleOutputText(currentLog.getCurrentBufferSize());
                // 输出最新日志
                System.out.println(newLog.getConsoleLog());
                currentLog = newLog;
                // 睡眠1s
                Thread.sleep(1000);
            }
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
