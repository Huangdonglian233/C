#include<iostream>
using namespace std;

const Stack_init_size=100;
const stackicrement=10;

typedef struct sqstack
{
	SElemtype *elem;
	int top;
	int stacksize;
	int incrementsize;
};

InitStack(sqstack &S)
{
	int maxsize=Stack_init_size;
	int incrementsize=stackincrement;
	S.elem=new SElemtype[maxsize];
	S.top=-1;
	S.stacksize=maxsize;
	S.increment=stackincrement;
}
