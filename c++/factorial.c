#include<stdio.h>

int main()
{
	int i,sum,term;
	term=1;
	sum=1;
	for(i=2;i<=10;i=i+1)
	{
		term=term*i;
		sum=sum+term;
	}
	printf("%d",sum);
	return 0;
}