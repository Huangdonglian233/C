void campare(Sqlist &A,Sqlist &B)
{
	int i,j,k;
	int *p;
	int a[k];
	if(A.length>B.length)
	k=A.length;
	else
	k=B.length;
	for(i=0;i<k;i++)
	{
		if(A.elem[i]=B.elem[i])
		a[i]=1;
		else 
		a[i]=0;
	} 
	for(j=0;j<i;j++)
	{
		delete A.elem[j];
		delete B.elem[j]; 
	}
	for(i=0;i<k-j;i++)
	{
		A.elem[i]=A.elem[k-j+i];
		B.elem[i]=B.elem[k-j+i];
	}
	
	if(A=NULL&&B=NULL)
	printf("A=B");
	else if(A.elem[0]>B.elem[0])
	printf("A>B");
	else
	printf("A<B");
	return 0;
}
