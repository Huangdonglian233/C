#include<malloc.h>
#include<stdlib.h>
#include<iostream>
#include<time.h>
#include<windows.h>
#include<conio.h>
#include<unistd.h>
using namespace std;

#define linksize 100
#define incresize 20
void Menue();
void select();
void regist ();

//��ʾ�����˵� 
void Menue()
{
	printf("\t\t\t\t\t1.���¼��Ϣ\n");
	printf("\t\t\t\t\t2.��Ʒ��Ϣ¼��\n");
	printf("\t\t\t\t\t3.������Ʒ\n");
	printf("\t\t\t\t\t4.�޸���Ʒ\n");
	printf("\t\t\t\t\t5.��ӡ�˵�\n");
	printf("\t\t\t\t\t6.��Ʒ��Ӧ��������\n"); 
}

//������� 
void select()
{
	int i;
	printf("\t\t\t\t\t��������Ҫ������ָ������\n");
	printf("\t\t\t\t\t"); 
	scanf("%d",&i);
	if(i<1||i>6)
	printf("\t\t\t\t\t���벻�Ϸ�\n");
	switch(i)
	{
		case 1:printf("\t\t\t\t\t���¼��Ϣ\n");
		break;
		case 2:printf("\t\t\t\t\t��Ʒ��Ϣ¼��");
		break;
		case 3:printf("\t\t\t\t\t������Ʒ\n");
		break;
		case 4:printf("\t\t\t\t\t�޸���Ʒ\n");
		break;
		case 5:printf("\t\t\t\t\t��ӡ�˵�\n");
		break;
		case 6:printf("\t\t\t\t\t��Ʒ��Ӧ��������\n");
		break;
	 } 
}	
//�����ı��ĵ���¼��Ϣ
struct usersmessage{
	char id[20];//�˺� 
	char pwd[20];//����
	char name[15];//���� 
	char email[20];//����
	long phonenumber; 
};

void create_File()
{
	FILE *fp;
	if((fp=fopen("users.txt","rb"))==NULL)//������ļ������� 
	{	
		fp=fopen("users.txt","wb+");
		if(fp==NULL)
		{
			printf("\t\t\t\t\t�޷������ļ�\n");
			exit(0);
		}
			
	}
}

//�û�ע����Ϣ
void regist ()
{
	int flag=1;
	usersmessage a,b;
	FILE *fp;
	printf("\t\t\t\t\tע����Ϣ\n");
	fp=fopen("users.txt","r");
	
	fread(&b,sizeof(struct usersmessage),1,fp);
	printf("\t\t\t\t\t�������˺�:\n");
	printf("\t\t\t\t\t");
	scanf("%s",&a.id);
	
	while(flag)
	{
		
	
		if(strcmp(a.id,b.id))
		{	
			if(!feof(fp))
			{
				fread(&b,sizeof(struct usersmessage),1,fp);
			}
			else
				break;
		}
		else
		{
			printf("\t\t\t\t\t���˺��Ѵ���,����������\n"); 
			fclose(fp);
			return;
		}
		
	}
	flag=1;
	printf("\t\t\t\t\t����������:\n");
	printf("\t\t\t\t\t");
	scanf("%d",&a.name);
	fp=fopen("users.txt","r+");
	fread(&b,sizeof(struct usersmessage),1,fp);
	
	while(flag)
	{
		if(a.name!=b.name)
		{
			if(!feof(fp))
			{
				fread(&b,sizeof(struct usersmessage),1,fp);
			}
			else
			{
				fwrite(&b,sizeof(struct usersmessage),1,fp);
				fclose(fp);
				flag=0;
				break;
			}
			
		}
		else
		{
			printf("\t\t\t\t\t�������Ѵ��ڣ�����������\n");
			fclose(fp);
		}	 
	}
	
	printf("\t\t\t\t\t�����������˺�\n");
	fopen("users.txt","r+");
	printf("\t\t\t\t\t");
	scanf("%s",&a.email);
	if(scanf("%s",&a.email))
	{
		fwrite(&b,sizeof(struct usersmessage),1,fp);
		printf("\t\t\t\t\t����󶨳ɹ�\n");
	}
	
	
	printf("\t\t\t\t\t������绰����\n");
	printf("\t\t\t\t\t");
	scanf("%ld",&a.phonenumber);
	
	printf("\t\t\t\t\t����������\n");
	printf("\t\t\t\t\t");
	scanf("%s",&a.pwd);
	printf("\t\t\t\t\t���ٴ���������\n");
	printf("\t\t\t\t\t");
	scanf("%s",&b.pwd); 
	do
	{
		if(!strcmp(a.pwd,b.pwd))  //�ж����������Ƿ���� 
		{
			fp=fopen("users.txt","a");
			fwrite(&b,sizeof(struct usersmessage),1,fp);
			printf("\t\t\t\t\t�˺�ע��ɹ������¼\n");
			fclose(fp);
			system("cls");
			break;
		}
		else
		{
			printf("\t\t\t\t\t�������벻��ȣ�����������\n");
			printf("\t\t\t\t\t");
			scanf("%s",&a.pwd);
			printf("\t\t\t\t\t���ٴ�����\n");
			printf("\t\t\t\t\t");
			scanf("%s",&b.pwd);
		}
		
	}while(1);
		
}
//�û���¼ϵͳ
void userslogin ()
{
	int flag;
	usersmessage e,f;
	FILE *fp;
	printf("\t\t\t\t\t��ӭ������¼ҳ��\n");
	fp=fopen("users.txt","r");
	
	fread(&f,sizeof(struct usersmessage),1,fp);
	
	flag=1;
	printf("\t\t\t\t\t�������˺�\n");
	printf("\t\t\t\t\t");
	scanf("%s",e.id);
	
	while(flag)
	{
		if(!strcmp(e.id,f.id))
		{
			if(!feof(fp))
				fread(&f,sizeof(struct usersmessage),1,fp);
			else
			{
				printf("\t\t\t\t\t���û��������ڣ�����������\n");
				break;
			}
		}
		else
		{
			flag=0;
			break;
		}
	}
	flag=1;
	printf("\t\t\t\t\t����������\n");
	printf("\t\t\t\t\t");
	scanf("%s",&e.pwd);
	while(flag)
	{
		if(!strcmp(e.pwd,f.pwd))
		{
			if(!feof(fp))
				fread(&f,sizeof(struct usersmessage),1,fp);
			else
			{
				printf("\t\t\t\t\t�����������������\n");
				break;
			}
		}
		else
		{	
			printf("\t\t\t\t\t��¼�ɹ�����ӭʹ�ó��й���ϵͳ��ף��ʹ�����\n");
			flag=0; 
			break;
		} 		
	}		
}
//�˳���¼ 
void exitlog()
{
	int exitnumber;
	printf("\t\t\t\t\t�ò�����Ҫ�˳���¼���Ƿ����,���˳���������1�����˳�������0\n");
	
	printf("\t\t\t\t\t");
	scanf("%d",&exitnumber);
	if(exitnumber)
	{
		system("cls");
		printf("\t\t\t\t\t�˳��ɹ�\n");
	}
}

void operate()
{
	int k;
	printf("\t\t\t\t\t��������Ҫ���еĲ���\n");
	printf("\t\t\t\t\t1.ע��\n");
	printf("\t\t\t\t\t2.��¼\n");
	printf("\t\t\t\t\t3.�˳�\n");
	printf("\t\t\t\t\t");
	scanf("%d",&k);
	while(1)
	{
		switch(k)
		{
		case 1 : 
			regist ();
			userslogin ();
			break;
		case 2 :
			
			break;
		case 3:
			exitlog();
			sleep(10);
			system("cls"); 
			break;
		default:
			printf("\t\t\t\t\t�����ֵ���Ϸ�������������\n");
		}
	}
	
} 
//��Ʒ��Ϣ¼��

//����һ����Ʒ�� 
struct commodity{
	char name[20];//��Ʒ�� 
	int number[10];//��Ʒ��� 
	float inprice;//��Ʒ���� 
	float outprice;//��Ʒ�ۼ� 
	int amonts;//��Ʒ���� 
};
//����ṹ�����ڹ������Ա� 
struct link
{
	int *elem;
	int listsize;
	int length;
	int *next;
};

//����һ�����Ա� 
Initlink(link &L)
{
	L.elem=(int*)malloc(sizeof(int));
	if(L.elem==NULL)
	return 0;
	L.length=0;	
	L.listsize=linksize;
}

//���Ա�Ԫ�ز���
void listinsert(link &L)
{
	int i,e;
	int *newbase,*p,*q;
	scanf("%d,%d",&i,&e);
	printf("�ڵ�%d��Ԫ��֮ǰ����%dԪ��",i,e);
	if(i<1||i>L.listsize)
	printf("������������������");
	else
	{
		if(L.length==L.listsize)
		newbase=(int*)malloc((L.listsize+incresize)*sizeof(int));
		if(!newbase)
		printf("����ʧ��");
		L.elem=newbase;
		L.listsize+=incresize; 
	}
	
}
void goodsmessage(link &goodsname)
{

}
//���ﳵ�ڵ� 
struct buynode
{
	struct commodity buy;
	int number;
	struct buynode *next;	
};


int main()
{
	Menue();
	select();
	create_File();
	operate();
	return 0;
}
