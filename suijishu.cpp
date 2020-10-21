#include<iostream>
using namespace std;

int main()
{
	int N,M;
	int i,small,j;
	int a[105],b[105];
	
	cin>>N;
	if(N<=0)
	cout<<"error"<<endl;
	for(i=0;i<N;i++)
	{
		cin>>a[i];
	}
	
	for(i=0;i<N;i++)
	{
	for(j=i+1;j<N;j++)
	{
		if(a[i]>a[j])
		{
		small=a[j];
		a[j]=a[i];
		a[i]=small;
		}
		
	}
	}
	
	M=1;
	b[0]=a[0];
	for(i=1;i<N;i++)
	{
			if(a[i]!=a[i-1])
			{
				b[M]=a[i];
				M++;
			}
	}
	
	cout<<M<<endl;
	for(i=0;i<M;i++)
	{
		cout<<b[i]<<" ";
	}
	return 0;
}
