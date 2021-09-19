package com.huang.os;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JobScheduling {
    private int timeCount=1000;
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
                if(judge()) {
                    int key = shouldRun();
                    if (key != -1) {
                        if (!arr.contains(key))
                            arr.add(key);
                    }
                }
                shortJob(arr);
                Print();
                timeCount++;
                System.out.println(timeCount);
        }
    }

    public void Print(){
        System.out.println("任务"+"   "+"\t"+"提交时间"+'\t'+"预计运行时间"+"\t"+"状态"+"\t\t"+
                "开始时间"+"\t\t"+"目前运行时间"+'\t'+"完成时间"+'\t'+"周转时间"+'\t'+"带权周转时间");
        for (Task task : tasks) {
            System.out.println(task.getName()+'\t'+task.getTaskIn()+"\t\t"+task.getNeedTime()
                    +"\t\t"+task.getStatus()+"\t\t"+task.getStartTime()+"\t\t"+task.getRunTime()+"\t\t\t"+task.getFinishTime()+"\t\t"
                    +task.gettTime()+"\t\t"+task.getwTime());
        }
    }

    public boolean isDone(){
        for (Task task:tasks){
            if(task.getStatus()!=2){
                return false;
            }
        }
        return true;
    }

    public void canRun(){
        for (Task task:tasks) {
            if(task.getTaskIn()<=timeCount&&task.getStatus()==-1){
                task.setStatus(0);
            }
        }
    }
    public boolean judge(){
        for (Task task:tasks) {
            if(task.getStatus()==-1){
                return true;
            }
        }
        return false;
    }
    public int shouldRun(){
        List<Integer> list=new ArrayList<Integer>();
        for (int i=0;i< tasks.length;i++) {
            if(tasks[i].getStatus()==0){
                list.add(i);
            }
        }
        int key=-1;
        if(arr.size()<2) {
            key = confirm(list);
        }
        return key;
    }

    public int confirm(List<Integer> list){//计算最高响应比
        if(list.isEmpty()){
            return -1;
        }
        if(list.size()==1){
            return list.get(0);
        }
        double MaxTemp = -1;
        int key = 0;
        for (int i = 0; i < list.size(); i++) {
            double temp = 1 + (timeCount - tasks[list.get(i)].getTaskIn()) / tasks[list.get(i)].getQueueTime();
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
        tasks[key].setAvgTime((tasks[key].getFinishTime() - tasks[key].getTaskIn())
                                /tasks[key].getRunTime());
                ;
        tasks[key].setStatus(1);
        timeCount = tasks[key].getFinishTime();
        arr.add(key);
    }
    public void setFinishTime(Task task){
            task.setStatus(2);
            task.setFinishTime(timeCount);
            task.settTime(task.getFinishTime()- task.getTaskIn());
            task.setwTime(task.gettTime()/task.getNeedTime());
    }
    public void shortJob(List<Integer> list){
        if (list.size()<1){
            list.add(shouldRun());
        }
        if (list.size()==1){
            int temp=list.get(0);
            if(tasks[temp].getStartTime()==0)
                tasks[temp].setStartTime(timeCount);
            tasks[temp].setStatus(1);
            tasks[temp].setRunTime(timeCount-tasks[temp].getStartTime());
            tasks[temp].setQueueTime(tasks[temp].getNeedTime()-tasks[temp].getRunTime());
            if(tasks[temp].getQueueTime() == 0) {
                setFinishTime(tasks[temp]);
                System.out.println(temp);
                arr.remove(0);
            }
        }
        if (list.size()==2){
            int temp1=list.get(0);
            int temp2=list.get(1);
            if(tasks[temp1].getQueueTime()<=tasks[temp2].getQueueTime()&&(tasks[temp1].getStatus()==1||tasks[2].getStatus()==1)){
                if(tasks[temp1].getStartTime()==0)
                    tasks[temp1].setStartTime(timeCount);
                tasks[temp1].setStatus(1);
//                if(tasks[temp2].getStatus()==1){
//                    tasks[temp2].setRunTime(timeCount-tasks[temp2].getStartTime());
//                    tasks[temp2].setQueueTime(tasks[temp2].getNeedTime()-tasks[temp2].getRunTime());
//                }
                tasks[temp2].setStatus(0);
                tasks[temp1].setRunTime(timeCount-tasks[temp1].getStartTime());
                System.out.println("RunTime"+tasks[temp1].getRunTime());
                tasks[temp1].setQueueTime(tasks[temp1].getNeedTime()-tasks[temp1].getRunTime());
                if(tasks[temp1].getQueueTime()==0) {
                    setFinishTime(tasks[temp1]);
                    arr.remove(temp1);
                }
            }else{
                if(tasks[temp2].getStartTime()==0)
                    tasks[temp2].setStartTime(timeCount);
                tasks[temp2].setStatus(1);
                tasks[temp1].setStatus(0);
                tasks[temp2].setRunTime(timeCount-tasks[temp2].getStartTime());
                tasks[temp2].setQueueTime(tasks[temp2].getNeedTime()-tasks[temp2].getRunTime());
                if(tasks[temp2].getQueueTime()==0) {
                    setFinishTime(tasks[temp2]);
                    arr.remove(temp2);
                }
            }
        }
    }
}
//JOB1 1000 30
//JOB2 1005 20
//JOB3 1010 5
//JOB4 1020 10