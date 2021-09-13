#include<stdio.h>
#include<malloc.h>
#define Maxsize 100 
#define Incresize 10 

struct Lnode{
	int data;
	int *next;
};
struct Sqlist
{
	int *prior;
	Lnode A;
	int *head;
	int listsize;
	int length;
	int incresize;
};

Init_link()
{
	Sqlist L;
	L.head=(int *)malloc(sizeof(int));
	if(L.head==NULL)
	printf("error\n");
	else
	{
		L.listsize=Maxsize;
		L.length=0;
	}
	
}
locate_link(Sqlist &L,int x)
{
	int *p;
	p=L.head;
	int i;
	for(i=0;i<L.length;i++)
	if(L.A.data!=x)
	p+=1;
	else 
	return i; 
}
int length(Sqlist &L)
{
	int i=0;
	while(i<L.length&&L.A.next!=NULL)
	i++;
	printf("该线性表的长度为",i);
	return i;
}
int main()
{
	return 0;
}
