#include<math.h>
#include<iostream>
using namespace std;

class Ctriangle
{
private:
	float H;
	float W;
	float L;
public:

	Ctriangle(float h,float w,float l)
	{
		h=h;
		w=w;
		l=l;
	}
	calculateC(float h,float w,float l)
	{
		float C;
		C=h+w+l;
		cout<<"C"<<" "<<C<<endl;
		return C;
	}
	calculateS(float h,float w,float l)
	{
	float S,cos,sin;
	cos=h*h+w*w-l*l;
	sin=sqrt(1-cos*cos);
	S=(h*w)*sin/2;
	cout<<"S"<<" "<<S<<endl;
	return S;
	}

};


int main()
{
	int h,w,l;
	scanf("%d%d%d",&h,&w,&l);
	Ctriangle C1(h,w,l);
	C1.calculateS(h,w,l);
	C1.calculateC(h,w,l);
	return 0;
}

