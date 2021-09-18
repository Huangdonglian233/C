package com.huang.os;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JobScheduling {

    private int timeCount=0;
    private int nowTime=1000;
    private Task[] tasks=new Task[4];
    private List arr=new ArrayList();

    public static void main(String[] args) {
        JobScheduling jobScheduling=new JobScheduling();
        jobScheduling.initial();
        jobScheduling.Print();
        jobScheduling.run();
        jobScheduling.Print();
    }

    public void initial(){
        String name=null;
        int submitTime=0;
        int needTime=0;
        System.out.println("请输入作业的名称，提交时间以及估计运行时间");
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<4;i++){
            name=scanner.next();
            submitTime=scanner.nextInt();
            needTime=scanner.nextInt();
            tasks[i]=new Task(name,submitTime,needTime);
        }
    }
    public void run(){
        while (!isDone()){
            canRun();
            int key=shouldRun();
            if(key==-1){
                timeCount++;
            }else {
                excute(key);
            }
        }
    }

    public void Print(){
        System.out.println("任务"+"   "+"\t"+"提交时间"+'\t'+"预计运行时间"+"\t"+"状态"+"\t\t"+
                "目前运行时间"+'\t'+"完成时间"+'\t'+"周转时间"+'\t'+"带权周转时间");
        for (Task task : tasks) {
            System.out.println(task.getName()+'\t'+task.getTaskIn()+"\t\t"+task.getNeedTime()
                    +"\t\t"+task.getStatus()+"\t\t"+task.getRunTime()+"\t\t\t"+task.getFinishTime()+"\t\t"
                    +task.gettTime()+"\t\t"+task.getwTime());
        }
    }

    public boolean isDone(){
        for (Task task:tasks){
            if(task.getStatus()!=1){
                return false;
            }
        }
        return true;
    }

    public void canRun(){
        for (Task task:tasks) {
            if(task.getQueueTime()<timeCount&&task.getStatus()!=1){
                task.setStatus(0);
            }
        }
    }

    public int shouldRun(){
        List<Integer> list=new ArrayList<Integer>();
        for (int i=0;i< tasks.length;i++) {
            if(tasks[i].getStatus()==0){
                list.add(i);
            }
        }
        int key=confirm(list);
        return key;
    }

    public int confirm(List<Integer> list){
        if(list.isEmpty()){
            return -1;
        }
        double MaxTemp = -1;
        int key = 0;
        for (int i = 0; i < list.size(); i++) {
            double temp = (timeCount - tasks[list.get(i)].getQueueTime()) / tasks[list.get(i)].getRunTime();
            if (temp > MaxTemp) {
                MaxTemp = temp;
                key = i;
            }
        }
        return list.get(key);
    }

    public void excute(int key) {
        tasks[key].setStartTime(timeCount);
        tasks[key].setFinishTime(timeCount + tasks[key].getRunTime());
        tasks[key].setAvgTime((tasks[key].getFinishTime() - tasks[key].getQueueTime())
                                /tasks[key].getRunTime());
                ;
        tasks[key].setStatus(1);
        timeCount = tasks[key].getFinishTime();
        arr.add(key);
    }
}
//JOB1 1000 30
//JOB2 1005 20
//JOB3 1010 5
//JOB4 1020 10