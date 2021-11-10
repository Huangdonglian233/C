package com.huang.os.jobscheduling;

public class Task {
    private String name;
    private int queueTime;//任务进入作业井时间
    private int taskIn;//任务提交时间
    private int startTime;//任务开始时间
    private int runTime;//任务目前运行时间
    private int finishTime;//任务完成时间
    private int tTime;//周转时间
    private int needTime;//需要时间
    private float wTime;//带权周转时间
    private int status;//0表示等待 1表示运行 -1表示未提交 2表示已完成
    private int pause;
    private int pauseTime;
    private int restartTime;

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
        this.pause=0;
        this.pauseTime=1;
        this.restartTime=0;
    }

    public int getPause() {
        return pause;
    }

    public void setPause(int pause) {
        this.pause = pause;
    }


    public void setPauseTime(int pauseTime) {
        this.pauseTime = pauseTime;
    }

    public void setQueueTime(int queueTime) {
        this.queueTime = queueTime;
    }

    public void settTime(int tTime) {
        this.tTime = tTime;
    }

    public void setwTime(float wTime) {
        this.wTime = wTime;
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
        return this.runTime;
    }

    public int getFinishTime() {
        return finishTime>1060?finishTime-1060+1100:finishTime;
    }

    public int gettTime() {
        int temp=this.finishTime-this.taskIn;
        return temp>0?temp :0;
    }

    public int getNeedTime() {
        return needTime;
    }

    public double getwTime() {
        if(this.status==2)
        return  (double)this.gettTime()/this.getNeedTime();
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
