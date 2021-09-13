/*ʵ��һ��������������������BSTIterator ����ʾһ�����������������������BST���ĵ�������
BSTIterator(TreeNode root) ��ʼ�� BSTIterator ���һ������BST �ĸ��ڵ� root ����Ϊ���캯����һ���ָ�����ָ��
Ӧ��ʼ��Ϊһ���������� BST �е����֣��Ҹ�����С�� BST �е��κ�Ԫ�ء�
boolean hasNext() �����ָ���Ҳ�����������֣��򷵻� true �����򷵻� false ��
int next()��ָ�������ƶ���Ȼ�󷵻�ָ�봦�����֡�
ע�⣬ָ���ʼ��Ϊһ���������� BST �е����֣����Զ� next() ���״ε��ý����� BST �е���СԪ�ء�

����Լ���?next()?����������Ч�ģ�Ҳ����˵�������� next()?ʱ��BST ��������������ٴ���һ����һ�����֡�
*/
#include<iostream>
#include<Stack>
using namespace std; 
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(NULL), right(NULL) {}
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
 
class BSTIterator {
private:
	TreeNode* real;
	stack<TreeNode*> sta;
public:
    BSTIterator(TreeNode* root) {
    	real=root;
    }
    
    int next() {
        while(real!=NULL){
		sta.push(real);
		real=real->left;	
		}
		real=sta.top();
		int var=real->val;
		sta.pop();
		real=real->right;
		return var;
    }
    
    bool hasNext() {
    	return !sta.empty()||real!=NULL;
    }
};

