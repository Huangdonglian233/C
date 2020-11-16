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

//显示操作菜单 
void Menue()
{
	printf("\t\t\t\t\t1.请登录信息\n");
	printf("\t\t\t\t\t2.商品信息录入\n");
	printf("\t\t\t\t\t3.查找商品\n");
	printf("\t\t\t\t\t4.修改商品\n");
	printf("\t\t\t\t\t5.打印菜单\n");
	printf("\t\t\t\t\t6.商品供应不足提醒\n"); 
}

//输入操作 
void select()
{
	int i;
	printf("\t\t\t\t\t请输入需要操作的指令数字\n");
	printf("\t\t\t\t\t"); 
	scanf("%d",&i);
	if(i<1||i>6)
	printf("\t\t\t\t\t输入不合法\n");
	switch(i)
	{
		case 1:printf("\t\t\t\t\t请登录信息\n");
		break;
		case 2:printf("\t\t\t\t\t商品信息录入");
		break;
		case 3:printf("\t\t\t\t\t查找商品\n");
		break;
		case 4:printf("\t\t\t\t\t修改商品\n");
		break;
		case 5:printf("\t\t\t\t\t打印菜单\n");
		break;
		case 6:printf("\t\t\t\t\t商品供应不足提醒\n");
		break;
	 } 
}	
//创建文本文档记录信息
struct usersmessage{
	char id[20];//账号 
	char pwd[20];//密码
	char name[15];//姓名 
	char email[20];//邮箱
	long phonenumber; 
};

void create_File()
{
	FILE *fp;
	if((fp=fopen("users.txt","rb"))==NULL)//如果此文件不存在 
	{	
		fp=fopen("users.txt","wb+");
		if(fp==NULL)
		{
			printf("\t\t\t\t\t无法建立文件\n");
			exit(0);
		}
			
	}
}

//用户注册信息
void regist ()
{
	int flag=1;
	usersmessage a,b;
	FILE *fp;
	printf("\t\t\t\t\t注册信息\n");
	fp=fopen("users.txt","r");
	
	fread(&b,sizeof(struct usersmessage),1,fp);
	printf("\t\t\t\t\t请输入账号:\n");
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
			printf("\t\t\t\t\t该账号已存在,请重新输入\n"); 
			fclose(fp);
			return;
		}
		
	}
	flag=1;
	printf("\t\t\t\t\t请输入名字:\n");
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
			printf("\t\t\t\t\t该名字已存在，请重新输入\n");
			fclose(fp);
		}	 
	}
	
	printf("\t\t\t\t\t请输入邮箱账号\n");
	fopen("users.txt","r+");
	printf("\t\t\t\t\t");
	scanf("%s",&a.email);
	if(scanf("%s",&a.email))
	{
		fwrite(&b,sizeof(struct usersmessage),1,fp);
		printf("\t\t\t\t\t邮箱绑定成功\n");
	}
	
	
	printf("\t\t\t\t\t请输入电话号码\n");
	printf("\t\t\t\t\t");
	scanf("%ld",&a.phonenumber);
	
	printf("\t\t\t\t\t请输入密码\n");
	printf("\t\t\t\t\t");
	scanf("%s",&a.pwd);
	printf("\t\t\t\t\t请再次输入密码\n");
	printf("\t\t\t\t\t");
	scanf("%s",&b.pwd); 
	do
	{
		if(!strcmp(a.pwd,b.pwd))  //判断两次输入是否相等 
		{
			fp=fopen("users.txt","a");
			fwrite(&b,sizeof(struct usersmessage),1,fp);
			printf("\t\t\t\t\t账号注册成功，请登录\n");
			fclose(fp);
			system("cls");
			break;
		}
		else
		{
			printf("\t\t\t\t\t两次输入不相等，请重新输入\n");
			printf("\t\t\t\t\t");
			scanf("%s",&a.pwd);
			printf("\t\t\t\t\t请再次输入\n");
			printf("\t\t\t\t\t");
			scanf("%s",&b.pwd);
		}
		
	}while(1);
		
}
//用户登录系统
void userslogin ()
{
	int flag;
	usersmessage e,f;
	FILE *fp;
	printf("\t\t\t\t\t欢迎来到登录页面\n");
	fp=fopen("users.txt","r");
	
	fread(&f,sizeof(struct usersmessage),1,fp);
	
	flag=1;
	printf("\t\t\t\t\t请输入账号\n");
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
				printf("\t\t\t\t\t该用户名不存在，请重新输入\n");
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
	printf("\t\t\t\t\t请输入密码\n");
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
				printf("\t\t\t\t\t密码错误，请重新输入\n");
				break;
			}
		}
		else
		{	
			printf("\t\t\t\t\t登录成功，欢迎使用超市管理系统，祝您使用愉快\n");
			flag=0; 
			break;
		} 		
	}		
}
//退出登录 
void exitlog()
{
	int exitnumber;
	printf("\t\t\t\t\t该操作将要退出登录，是否继续,若退出，请输入1，不退出请输入0\n");
	
	printf("\t\t\t\t\t");
	scanf("%d",&exitnumber);
	if(exitnumber)
	{
		system("cls");
		printf("\t\t\t\t\t退出成功\n");
	}
}

void operate()
{
	int k;
	printf("\t\t\t\t\t请输入需要进行的操作\n");
	printf("\t\t\t\t\t1.注册\n");
	printf("\t\t\t\t\t2.登录\n");
	printf("\t\t\t\t\t3.退出\n");
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
			printf("\t\t\t\t\t输入的值不合法，请重新输入\n");
		}
	}
	
} 
//商品信息录入

//定义一个商品类 
struct commodity{
	char name[20];//商品名 
	int number[10];//商品编号 
	float inprice;//商品进价 
	float outprice;//商品售价 
	int amonts;//商品数量 
};
//定义结构体用于构造线性表 
struct link
{
	int *elem;
	int listsize;
	int length;
	int *next;
};

//创建一个线性表 
Initlink(link &L)
{
	L.elem=(int*)malloc(sizeof(int));
	if(L.elem==NULL)
	return 0;
	L.length=0;	
	L.listsize=linksize;
}

//线性表元素插入
void listinsert(link &L)
{
	int i,e;
	int *newbase,*p,*q;
	scanf("%d,%d",&i,&e);
	printf("在第%d个元素之前插入%d元素",i,e);
	if(i<1||i>L.listsize)
	printf("输入有误，请重新输入");
	else
	{
		if(L.length==L.listsize)
		newbase=(int*)malloc((L.listsize+incresize)*sizeof(int));
		if(!newbase)
		printf("分配失败");
		L.elem=newbase;
		L.listsize+=incresize; 
	}
	
}
void goodsmessage(link &goodsname)
{

}
//购物车节点 
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
