#include<iostream>
using namespace std;

int main()
{
	int N,M;
	int i,small;
	int a[100],b[100];
	
	scanf("%d",&N);
	for(i=0;i<N;i++)
	{
		scanf("%d",&a[i]);
	}
	
	for(i=0;i<N;i++)
	{
		if(a[i]>a[i+1])
		small=a[i];
		a[i]=a[i+1];
		a[i+1]=small;
	}
	for(i=0;i<N;i++)
	{
			if(a[i]=a[i+1])
			{
				for(i=i+1;i<N;i++)
				a[i+1]=a[i+2];
			}
	}
	
	M=0;
	for(i=0;i<N;i++)
	{
		if(a[i]!='\0')
		M++;
	}
	printf("%d\n",M);
	for(i=0;i<M;i++)
	{
		printf("%d\n",a[i]);
	}
	return 0;
}
