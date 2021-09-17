package com.huang.os;

import java.sql.Time;

public class Task {
    private String name;
    private int taskIn;//任务进入时间
    private int startTime;//任务开始时间
    private int runTime;//任务运行时间
    private int finishTime;//任务完成时间
    private int tTime;//周转时间
    private int needTime;//需要时间
    private double wTime;//带权周转时间
    private String status;
    public Task(String name, int taskIn, int needTime) {
        this.name = name;
        this.taskIn = taskIn;
        this.tTime = 0;
        this.startTime=0;
        this.needTime = needTime;
        this.finishTime=0;
        this.wTime = 0;
        this.runTime=0;
        this.status = "WAIT";
    }

    public String getName() {
        return name;
    }

    public int getTaskIn() {
        return taskIn;
    }

    public int getStartTime() {
        return startTime;
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
        return this.runTime+this.startTime-this.taskIn;
    }

    public int getNeedTime() {
        return needTime;
    }

    public double getwTime() {
        if(this.status=="FINISH")
        return this.tTime/this.needTime;
        else return 0;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaskIn(int taskIn) {
        this.taskIn = taskIn;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void settTime(int tTime) {
        this.tTime = tTime;
    }

    public void setNeedTime(int needTime) {
        this.needTime = needTime;
    }

    public void setwTime(double wTime) {
        this.wTime = wTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
