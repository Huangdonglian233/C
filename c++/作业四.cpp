#include<iostream>
using namespace std;

class Rational
{
	private:
	int m;
	int n;
	
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
		Rational(Rational & p)
		{
			cout<<"copy destractor,before call"<<m<<"/"<<n<<endl;
			m=p.m;
			n=p.n;
		}
		gcd(int M,int N)
		{
			int k;
			while(N)
			{
				k=M%N;
				M=N;
				N=k;
			}
			return M; 
		}
		void add(Rational &x,Rational &y)
		{
			int k,h;
			int a;
			k=x.m*y.n+y.m*x.n;
			h=x.n*y.n;
			a=gcd(k,h);
			cout<<k/a<<"/"<<h/a<<endl;
		}
		void dis(Rational &x,Rational &y)
		{
			int k,h;
			int a;
			k=x.m*y.n-x.n*y.m;
			h=x.n*y.n;
			a=gcd(k,h);
			cout<<k/a<<"/"<<h/a<<endl;
		}
		void cheng(Rational &x,Rational &y)
		{
			int k,h;
			int a;
			k=x.m*y.m;
			h=x.n*y.n;
			a=gcd(k,h);
			cout<<k/a<<"/"<<h/a<<endl;
		}
		void chu(Rational &x,Rational &y)
		{
			int k,h;
			int a;
			k=x.m*y.n;
			h=x.n*y.m;
			a=gcd(k,h);
			cout<<k/a<<"/"<<h/a<<endl;
		}
};

int main()
{
	Rational c1(2,3),c2(3,5);
	c1.dis(c1,c2);
	c1.add(c1,c2);
	c1.cheng(c1,c2);
	c1.chu(c1,c2);
	c1.~Rational();
	c2.~Rational();
}


