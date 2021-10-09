#include<stdio.h>

int main()
{
	int i;
	int h,t,m,sum;
	for(i=101;i<=999;i++)
	{
		h=(i/100);
		t=(i/10)%10;
		m=i%10;
		sum=h*h*h+t*t*t+m*m*m;
		if(i==sum)
		printf("%d\n",i);
	}
	return 0;
}


