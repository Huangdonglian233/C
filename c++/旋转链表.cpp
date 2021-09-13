#include<iostream> 
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
};
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
    	if(k==0||head==NULL||head->next==NULL)
    	return head;
        int i;
        ListNode *p;
        p=head;
        int temp;
        
        int n=1;
        while(p->next!=NULL){
        	p=p->next;
        	n++;
		}
		
		k=n-k%n;
		if(k==n)
		return head;
		p->next=head;
        for(i=0;i<k;i++){
        		p=p->next;
		}
		
		ListNode* q;
		q=p;
		p=p->next;
		q->next=NULL;
		return p;
    }
};
