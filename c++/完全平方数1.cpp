#include<stdio.h>
#include<math.h>
int main()
{
	int i,j,k,l,qw,bw,sw,gw;
	for(i=1000;i<10000;i++)
	  {	j=sqrt(i);
	  	qw=i/1000;
	  	bw=i%1000/100;
	  	sw=i%100/10;
	  	gw=i%10;
	  	if(qw==bw&&sw==gw&&i==j*j)
	  
	  	printf("%d  ",i);
	  }
 
return 0;	 
}
