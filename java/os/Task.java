package com.huang.os;

public class Task {
    private String name;
    private int queueTime;//任务进入作业井时间
    private int taskIn;//任务提交时间
    private int startTime;//任务开始时间
    private int runTime;//任务目前运行时间
    private int finishTime;//任务完成时间
    private int tTime;//周转时间
    private int needTime;//需要时间
    private double wTime;//带权周转时间
    private int status;//0表示等待 1表示运行 -1表示未提交 2表示已完成
    private int avgTime;
    private int pauseTime;

    public Task(String name, int taskIn, int needTime) {
        this.name = name;
        this.taskIn = taskIn;
        this.tTime = 0;
        this.startTime=0;
        this.needTime = needTime;
        this.finishTime=0;
        this.queueTime=needTime;
        this.wTime = 0;
        this.runTime=0;
        this.status = -1;
        this.pauseTime=0;
    }

    public int getPauseTime() {
        return pauseTime;
    }

    public void setPauseTime(int pauseTime) {
        this.pauseTime = pauseTime;
    }

    public void setQueueTime(int queueTime) {
        this.queueTime = queueTime;
    }
    public void setAvgTime(int avgTime) {
        this.avgTime = avgTime;
    }

    public void settTime(int tTime) {
        this.tTime = tTime;
    }

    public void setwTime(double wTime) {
        this.wTime = wTime;
    }

    public void setNeedTime(int needTime) {
        this.needTime = needTime;
    }

    public int getQueueTime() {
        return queueTime;
    }


    public String getName() {
        return name;
    }

    public int getTaskIn() {
        return taskIn;
    }


    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getRunTime() {
        return runTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int gettTime() {
        int temp=this.runTime+this.startTime-this.taskIn;
        return temp>0?temp :0;
    }

    public int getNeedTime() {
        return needTime;
    }

    public double getwTime() {
        if(this.status==2)
        return this.tTime/this.needTime;
        else return 0;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public int getStatus() {
        return status;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
