package com.huang.os;

public class Task {
    private String name;
    private int queueTime;//任务进入作业井时间
    private int taskIn;//任务进入时间
    private int startTime;//任务开始时间
    private int runTime;//任务目前运行时间
    private int finishTime;//任务完成时间
    private int tTime;//周转时间


    public void setAvgTime(int avgTime) {
        this.avgTime = avgTime;
    }

    private int needTime;//需要时间
    private double wTime;//带权周转时间
    private int status;//0表示等待 1表示运行 -1表示未提交
    private int avgTime;
    public Task(String name, int taskIn, int needTime) {
        this.name = name;
        this.taskIn = taskIn;
        this.tTime = 0;
        this.startTime=0;
        this.needTime = needTime;
        this.finishTime=0;
        this.wTime = 0;
        this.runTime=0;
        this.status = -1;
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
        return runTime-this.startTime;
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
        if(this.status==1)
        return this.tTime/this.needTime;
        else return 0;
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
