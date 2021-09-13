#include<iostream>
#include<stack>
#include<queue>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x){
        stack<int> S;
        queue<int> Q;
        if(x<0||(x%10==0&&x!=0)){
        	cout<<"false"<<endl;
        	return false;
		}
        int y=x;
        while(y>0){
           int temp=y%10;
		   cout<<"temp:"<<temp<<endl;
           S.push(temp);
           Q.push(temp);
           y=y/10;
        }
        cout<<"size:"<<S.size()<<endl;
        while(S.size()){
        	int j,k;
        	j=S.top();
        	k=Q.front();
        	cout<<j<<","<<k<<endl;
        	Q.pop();
        	S.pop();
        	if(j!=k){
        		cout<<"false"<<"111"<<endl;
        		return false;
			}	
		}
		if(!S.empty()||!Q.empty()){
			cout<<"false"<<endl;
			return false;
		}
		else{
			cout<<"true"<<endl;
			return true;
		}
    }
};

int main(){
	int num;
	Solution S;
	cin>>num;
	S.isPalindrome(num);
}
