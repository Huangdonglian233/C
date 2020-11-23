#include<iostream>
#include<stdio.h>
using namespace std;

#define N 10

double polynomail(int a[N],int i,double x,int n);
int main()
{
	double temp;
	double x;
	int a[N];
	int i,n;
	scanf("%ld",&x);
	scanf("%d",&n);
	if(n>N-1)
	exit(0);
	for(i=0;i<N;i++)
	scanf("%ld",&a[i]);
	temp=polynomail(a,i,x,n);
	printf("%ld",temp);
	return 0;
}
double polynomail(int a[N],int i,double x,int n)
{
	if(i>0)
	return (a[n-i]*polynomail(a,i-1,x,n)*x);
	else 
	return a[n];
}
