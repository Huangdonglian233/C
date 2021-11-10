package com.huang.os.jcdd;

public class ListNode {
    protected Job job;
    ListNode next;
    public ListNode(Job job1, ListNode next) { this.job = job1; this.next = next; }

    public ListNode(Job job) {
        this.job= job;
    }
}