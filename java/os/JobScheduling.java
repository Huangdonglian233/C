package com.huang.os;

import java.sql.Time;
import java.util.Scanner;

public class JobScheduling {
    public static void main(String[] args) {
        JobScheduling jobScheduling=new JobScheduling();
        Task[] tasks=jobScheduling.initial();
        int nowTime=1000;
        jobScheduling.setReadyTasks(tasks,1);
        Task[] setRunTasks= jobScheduling.setRunTasks(tasks);
        System.out.println("任务"+"   "+"\t"+"提交时间"+'\t'+"预计运行时间"+"\t"+"状态"+"\t\t"+
                "已运行时间"+'\t'+"完成时间"+'\t'+"周转时间"+'\t'+"带权周转时间");
        for (Task task :tasks) {
            System.out.println(task.getName()+'\t'+task.getTaskIn()+"\t\t"+task.getNeedTime()
            +"\t\t"+task.getStatus()+"\t\t"+task.getRunTime()+"\t\t\t"+task.getFinishTime()+"\t\t"
            +task.gettTime()+"\t\t"+task.getwTime());
        }
    }
    public Task[] initial(){
        String name=null;
        int submitTime=0;
        int needTime=0;
        Task[] tasks = new Task[4];
        System.out.println("请输入作业的名称，提交时间以及估计运行时间");
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<4;i++){
            name=scanner.next();
            submitTime=scanner.nextInt();
            needTime=scanner.nextInt();
            tasks[i]=new Task(name,submitTime,needTime);
        }
        return tasks;
    }

    public int getRunTasks(Task[] tasks){
        int sum=0;
        for (Task task: tasks) {
            if(task.getStatus()=="RUN"){
                sum++;
            }
        }
        return sum;
    }

    public Task[] getReadyTasks(Task[] tasks){
        Task[] readyTasks=new Task[4];
        int i=0;
        for (Task task: tasks) {
            if(task.getStatus()=="READY"){
                readyTasks[i]=task;
                i++;
            }
        }
        return readyTasks;
    }

    public void setReadyTasks(Task[] tasks,int runTime){
        for (Task task: tasks) {
            if(tasks[0].getTaskIn()+runTime>=task.getTaskIn()){
                task.setStatus("READY");
            }
        }
    }

    public Task[] setRunTasks(Task[] tasks){
        double r=0;
        double max=0;
        Task runIn=null;
        int runLen=getRunTasks(tasks);
        Task[] readyTasks=getReadyTasks(tasks);
        if(runLen<2){
            for (Task task: readyTasks) {
                r=1+task.gettTime()/task.getNeedTime();
                if(r>max){
                    max=r;
                    runIn=task;
                }
            }
            runIn.setStatus("RUN");
            for (Task task: readyTasks) {
                if(task.getName()==runIn.getName()){
                    task=runIn;
                }
            }
            setRunTasks(tasks);
        }
        return tasks;
    }
}
//JOB1 1000 30
//JOB2 1005 20
//JOB3 1010 5
//JOB4 1020 10