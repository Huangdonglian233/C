package com.huang.os.jcdd;

/*
char        Name[10];
   int         Proi;
   int         Round;
   int         CpuTime;
   int         NeedTime;
   int         Count;
   char        State;
   PCBSTRUCT*  Next;
 */

public class Job {
    private String name;
    private int priority;
    private int round;
    private int cpuTime;
    private int needTime;
    private int count;
    private char state;

    public Job(String name, int priority, int needTime) {
        this.name = name;
        this.priority = priority;
        this.needTime = needTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }

    public int getNeedTime() {
        return needTime;
    }

    public void setNeedTime(int needTime) {
        this.needTime = needTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }
}
