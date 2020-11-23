#include<stdio.h> 
struct link{
	int *head;
	int data;
	int *next;
	struct head;
};

collelink(link &La,link &Lb)
{
	int *pa,*pb,*pc;
	pa=La.head;
	pb=Lb.head;
	pa++;
	pb++;
	if((pa)!=NULL)
	{
		pc=La.head;
		while((pa)!=NULL)
		{
			pa++;
		}
		pa=Lb.next;
		delete(Lb.head);
	}
	else
	{
		pc=Lb.head;
		while(pb!=NULL)
		{
			pb++;
		}
		++pb=La.next;
	}
	
}
int main()
{
	return 0;
}
