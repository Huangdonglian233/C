#include<iostream>
using namespace std;

class Rational
{
	private:
	int m;
	int n;
	void gcd();
	public:
		Rational(int M=0,int N=1)
		{
			this->m=M;
			this->n=N;
			cout<<"constractor"<<m<<"/"<<n<<endl; 
		}
		~Rational()
		{
			cout<<"destractor"<<m<<"/"<<n<<endl;
		}
		Rational operator+(Rational a);
		Rational operator-(Rational a);
		Rational operator*(Rational a);
		Rational operator/(Rational a);
		
		void output();
};
Rational Rational::operator+(Rational a)
{
	Rational temp;
	temp.m=m*a.n+n*a.m;
	temp.n=n*a.n;
	temp.gcd();
	return temp;
}
Rational Rational::operator-(Rational a)
{
	Rational temp;
	temp.m=m*a.n-n*a.m;
	temp.gcd();
	return temp;
}
Rational Rational::operator*(Rational a)
{
	Rational temp;
	temp.m=m*a.m;
	temp.n=n*a.n;
	temp.gcd();
	return temp;
}
Rational Rational::operator/(Rational a)
{
	Rational temp;
	temp.m=m*a.n;
	temp.n=n*a.m;
	temp.gcd();
	return temp;
}
void Rational::gcd()
{
	int k=n;
	int a=m;
	int b=n;
	while(k)
	{
		k=a%b;
		a=b;
		b=k;
	}
	m=m/a;
	n=n/a;
}

void Rational::output()
{
	cout<<m<<"/"<<n<<"  "<<endl;
}		

int main()
{
	Rational k;
	Rational c1(2,3),c2(3,5);
	cout<<"2/3,3/5分别进+，-，*，/的结果为:"<<endl; 
	k=c1+c2;
	k.output();
	k=c1-c2;
	k.output();
	k=c1*c2;
	k.output();
	k=c1/c2;
	k.output();
	return 0;
}


