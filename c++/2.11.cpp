#define overflow 0
Int_data(Sqlist &va,int e)
{
	int i,j;
	int *p;
	if(va.length==va.listsize)
	return (overflow);
	else  
	{
		for(i=0;i<va.length&&e>va.elem[i];i++) 	
			p=p->next;
		for(j=va.length-1;j>=i;j--)
			va.elem[j+1]=va.elem[j]; 
		elem[i]=e;
		va.length++;
		return OK;
	}
}
