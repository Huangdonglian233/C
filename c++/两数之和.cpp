#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
		int i,j;
		for(i=0;i<nums.size()-1;i++){
			for(j=i+1;j<nums.size();j++){
				if(target==nums[i]+nums[j]){
				return {i,j};
			}
		}
	}
	return {i,j};
}
};

