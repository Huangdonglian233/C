#include<iostream>
#include<math.h>
using namespace std;

int main()
{
	int split;
	int a,b,c,d;
	int num;
	for(num=1000;num<10000;num++) {
			split=sqrt(num);
			a=num/1000;
			b=num%1000/100;
			c=num%100/10;
			d=num%10;
			if(a==b&&c==d&&num==split*split)
			cout<<num<<endl;
	}
	return 0;
}
