#include<stdint.h>
#include<iostream>
#include<stack>
using namespace std;
//颠倒二进制位 
class Solution {
public:
     uint32_t reverseBits(uint32_t n) {
    	stack<int> S;
        uint32_t temp=0;
    	for(int i=0;i<32;i++){
    		int k=(n>>i)&1;
    		S.push(k);
		}
    	for(int i=0;i<32;i++){
    		
            temp+=S.top()<<i;
    		S.pop();
		}
		cout<<temp;
        return temp;
	}
};

int main(){
	Solution a;
	uint32_t n=11111111111111111111111111111101;
	a.reverseBits(n);
	return 0;
} 
