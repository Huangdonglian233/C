package com.huang.os.jcdd;

import java.util.Scanner;

public class JCDD {
    Job job;
    ListNode wait;
    ListNode finish;
    ListNode ready;
    ListNode run;
    ListNode cur;
    static String al = null;

    public static void main(String[] args) {
        JCDD jcdd = new JCDD();
        jcdd.initial();
        System.out.println("请输入要选择的算法：（pr表示优先级,rr表示事件片轮）");
        Scanner scanner = new Scanner(System.in);
        al = scanner.next();
        System.out.println(al);
        while (jcdd.judge()) {
            if (al.equals("pr") || al.equals("PR")) {
                jcdd.staticPRI();
                jcdd.print0();
            } else if (al.equals("RR") || al.equals("rr")) {
                jcdd.roundRobin();
                jcdd.print1();
            }
        }
        System.out.println(12);
    }

    public void print0() {
        cur = wait;
        System.out.println("name" + "\t\t\t\t" + "cpuTime" + "\t\t\t\t" +
                "needTime" + "\t\t\t\t" + "count" + "\t\t\t\t" + "priority" +
                "\t\t\t\t" + "state" + "\t\t\t\t");
        int i = 0;
        while (i < 4) {
            System.out.print(cur.job.getName() + "\t\t\t\t\t" + cur.job.getCpuTime() +
                    "\t\t\t\t\t" + cur.job.getNeedTime() + "\t\t\t\t\t  " + cur.job.getCount() +
                    "\t\t\t\t\t  " + cur.job.getPriority() + "\t\t\t\t\t" + cur.job.getState());
            cur = cur.next;
            i++;
            System.out.println();
        }
    }

    public void print1() {
        cur = wait;
        System.out.println("name" + "\t\t\t\t" + "cpuTime" + "\t\t\t\t" +
                "needTime" + "\t\t\t\t" + "count" + "\t\t\t\t" + "round" +
                "\t\t\t\t" + "state" + "\t\t\t\t");
        int i = 0;
        while (i < 4) {
            System.out.print(cur.job.getName() + "\t\t\t\t\t" + cur.job.getCpuTime() +
                    "\t\t\t\t\t" + cur.job.getNeedTime() + "\t\t\t\t\t  " + cur.job.getCount() +
                    "\t\t\t\t\t  " + cur.job.getRound() + "\t\t\t\t\t" + cur.job.getState());
            cur = cur.next;
            i++;
            System.out.println();
        }
    }

    public boolean judge() {
        cur = wait;
        while (cur != null) {
            if (cur.job.getState() == 'F') {
                cur = cur.next;
            } else {
                break;
            }
        }
        if (cur == null) {
            return false;
        }
        return true;
    }

    public void initial() {
        finish = null;
        run = null;
        ready = null;
        String name = null;
        int priority = 0;
        int needTime = 0;
        System.out.println("请输入作业的名称，优先级以及估计运行时间");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            name = scanner.next();
            priority = scanner.nextInt();
            needTime = scanner.nextInt();
            job = new Job(name, priority, needTime);
            job.setState('W');
            job.setRound(2);
            if (i == 0) {
                wait = new ListNode(job);
                cur = wait;
            } else {
                cur.next = new ListNode(job);
                cur = cur.next;
            }
        }
    }

    public void waitTOReady() {
        ready = wait;
    }

    public void readyToRun() {
        run = new ListNode(null);
        run.job = ready.job;
        if (ready.job.getState() == 'W') {
            run.job.setCount(0);
            run.job.setState('R');
        } else {
            return;
        }
        if (ready != null) {
            ready = ready.next;
        } else {
            return;
        }

    }

    public void roundRobin() {
        if (run == null) {
            if (ready == null) {
                if (judge())
                    waitTOReady();
                else return;
            } else if (ready == null && wait == null) {
                System.out.println("All jobs are finished!");
                return;
            }
            readyToRun();
        }

        if (run.job.getNeedTime() == 0) {
            run.job.setState('F');
            run = null;
            return;
        }
        run.job.setCount(run.job.getCount() + 1);
        run.job.setNeedTime(run.job.getNeedTime() - 1);
        run.job.setCpuTime(run.job.getCpuTime() + 1);
        if (run.job.getNeedTime() == 0) {
            run.job.setState('F');
            run = null;
            return;
        }
        if (run.job.getRound() == run.job.getCount()) {
            run.job.setState('W');

            if (ready == null) {
                ready = run;
            } else {
                cur = ready;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = run;
            }
            run = null;
            return;
        }
    }

    public void staticPRI() {
        if(ready==null) {
            ready = staticPRIReady();
        }
        if(run==null){
            if(judge()){
                readyToRunPRI();
            }else {
                return;
            }
        }
        run.job.setCpuTime(run.job.getCpuTime()+1);
        run.job.setCount(run.job.getCount()+1);
        run.job.setNeedTime(run.job.getNeedTime()-1);
        if(run.job.getNeedTime()==0){
            run.job.setState('F');
            run=null;
            if(judge()) {
                readyToRunPRI();
            }else {
                run=null;
                return;
            }
        }

    }

    public void readyToRunPRI(){

        run=null;
        run=ready;
        cur=ready;
        while (cur!=null) {
            if(cur.job.getState()=='e') {
                cur.job.setState('R');
                run=cur;
                break;
            }else {
                cur=cur.next;
            }
        }
    }

    public ListNode staticPRIReady() {
        ready = new ListNode(null);
        ListNode temp = null;
        int i = 0;
        while (i < 4) {
            cur = wait;
            temp = cur;
            System.out.println(11);
            while (cur.next != null) {
                if (temp.job.getPriority() < cur.next.job.getPriority() && cur.next.job.getState() == 'W') {
                    temp = cur.next;
                } else {
                    if (cur.next != null) {
                        cur = cur.next;
                        continue;
                    } else {
                        break;
                    }
                }
                cur = cur.next;
            }
            if (ready == null || ready.job == null) {
                ready.job = temp.job;
                temp.job.setState('e');
                ready.job.setState('e');
            } else {
                ListNode cur1 = new ListNode(null);
                cur1.job = temp.job;
                ListNode cur2 = ready;
                while (cur2.job != null && cur2.next != null) {
                    cur2 = cur2.next;
                }
                if (cur2.job == null) {
                    cur2.job = temp.job;
                }
                if (cur2.next == null) {
                    cur2.next = cur1;
                }
                cur1.job.setState('e');
            }
            i++;
        }
        cur = ready;
        System.out.println("ready:");
        while (cur != null) {
            System.out.print(cur.job.getName() + " ");
            cur = cur.next;
        }
        System.out.println();
        return ready;
    }

}

//JOB1 1 20
//JOB2 3 10
//JOB3 2 10
//JOB4 4 30
