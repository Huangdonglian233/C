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
void menu();
int select();
void regist ();

//显示操作菜单 
void Menue()
{
	printf("\t\t\t\t\t1.请登录信息\n");
	printf("\t\t\t\t\t2.商品信息录入\n");
	printf("\t\t\t\t\t3.查找商品\n");
	printf("\t\t\t\t\t4.修改商品\n");
	printf("\t\t\t\t\t5.删除商品\n");
	printf("\t\t\t\t\t6.结算并打印小票\n");
	printf("\t\t\t\t\t7.退出系统\n");
}

//输入操作 
int select()
{
	int i;
	printf("\t\t\t\t\t请输入需要操作的指令数字\n");
	printf("\t\t\t\t\t");
	scanf("%d",&i);
	if(i<1||i>7)
	printf("\t\t\t\t\t输入不合法\n");
	switch(i)
	{
		case 1:printf("\t\t\t\t\t登录\n");
		return 1;
		break;
		case 2:printf("\t\t\t\t\t商品信息录入\n");
		return 2;
		break;
		case 3:printf("\t\t\t\t\t查找商品\n");
		return 3;
		break;
		case 4:printf("\t\t\t\t\t修改商品\n");
		return 4;
		break;
		case 5:printf("\t\t\t\t\t删除商品\n");
		return 5;
		break;
		case 6:printf("\t\t\t\t\t打印菜单\n");
		return 6;
		break;
		case 7:printf("\t\t\t\t\t退出系统\n");
		return 7;
		break;
	 } 
}	
//创建文本文档记录登陆信息
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
	if((fp=fopen("users.txt","r"))==NULL)//如果此文件不存在 
	{	
		fp=fopen("users.txt","w+");
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
	if(fp==NULL)
	{
		printf("\t\t\t\t\t无法打开文件\n");
		exit(0);
	}
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
	
	if(fp==NULL)
	{
		printf("\t\t\t\t\t无法打开文件\n");
		exit(0);
	}
	
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
			system("cls");
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

int operate()
{
	int k;
	printf("\t\t\t\t\t请输入需要进行的操作\n");
	printf("\t\t\t\t\t1.注册\n");
	printf("\t\t\t\t\t2.登录\n");
	printf("\t\t\t\t\t3.退出\n");
	printf("\t\t\t\t\t");
	scanf("%d",&k);
	switch(k)
	{
	case 1 : 
		regist ();
		userslogin ();
		return 1;
		break;
	case 2 :
		userslogin ();
		return 2;
		break;
	case 3:
		exitlog();
		sleep(10);
		system("cls");
		return 3; 
		break;
	default:
		printf("\t\t\t\t\t输入的值不合法，请重新输入\n");
		return 0;
		break;
	}
}
//登陆成功后显示可操作的菜单 
void menu()
{
	printf("\t\t\t\t\t请输入您需要操作的数字\n");
	printf("\t\t\t\t\t1.商品信息录入\n");
	printf("\t\t\t\t\t2.查找商品\n");
	printf("\t\t\t\t\t3.修改商品\n");
	printf("\t\t\t\t\t4.删除商品\n");
	printf("\t\t\t\t\t5.结算并打印小票\n"); 
	printf("\t\t\t\t\t6.退出系统\n"); 
} 	
int select1()
{
	int k;
	scanf("%d",&k);
	switch(k)
	{
		case 1:
		printf("\t\t\t\t\t1.商品信息录入\n");
		return 1;
		break;
		case 2:
		printf("\t\t\t\t\t2.查找商品\n");
		return 2;
		break;
		case 3:
		printf("\t\t\t\t\t3.修改商品\n");
		return 3;
		break;
		case 4:
		printf("\t\t\t\t\t删除商品\n");
		return 4;
		break;
		case 5:
		printf("\t\t\t\t\t5.结算并打印小票\n");
		return 5;
		break;
		case 6:
		printf("\t\t\t\t\t6.退出系统\n");
		return 6;
		break;
		default:printf("输入有误，请重新输入"); 
		return 0; 
		break;
	}
 
}
//商品信息录入

//定义一个商品类 
struct commodity{
	char name[20];//商品名 
	int NO;//商品编号 
	float inprice;//商品进价 
	float outprice;//商品售价 
	int amonts;//商品数量 
};

struct commodity a[20];

//选择商品信息录入后可进行的操作菜单
void menu1()
{
	printf("\t\t\t\t\t请输入需要进行的操作的数字\n"); 
	printf("\t\t\t\t\t1.文件建立库存信息\n"); 
	printf("\t\t\t\t\t2.手动建立库存信息\n");
	printf("\t\t\t\t\t3.显示所有商品信息\n"); 
}
//创建记录商品信息的文件 
void create_File1()
{
	FILE *fp;
	if((fp=fopen("kucun.txt","r"))==NULL)//如果此文件不存在 
	{	
		fp=fopen("kucun.txt","w+");
		if(fp==NULL)
		{
			printf("\t\t\t\t\t无法建立文件\n");
			exit(0);
		}
			
	}
}
//文件建立库存信息
void createmessage_text()
{
	FILE *fp;
	fp=fopen("kucun.txt","w");
	if(fp==NULL)
	printf("\t\t\t\t\t创建文件失败\n");
	fprintf(fp,"69011111 飘柔日常护理 12.00 15.00 30");
	fprintf(fp,"\n");
	fprintf(fp,"69021111 优酸乳 1.50 2.00 200");
	fprintf(fp,"\n");
	fprintf(fp,"69031111 红富士苹果 2.50 3.50 300");
	fprintf(fp,"\n");
	fprintf(fp,"69041111 晨光笔芯 0.70 1.00 150");
	fprintf(fp,"\n");
	fprintf(fp,"69051111 胡医生面膜 12.00 16.50 100");
	fclose(fp);//关闭文件
	printf("\t\t\t\t\t");
	printf("成功导入信息\n"); 
	return ;
} 
//手动建立库存信息 
int createmessage_auto() 
{
	int i,temp;
	int n;
	FILE *fp;
	
	printf("\t\t\t\t\t若继续，请输入1，若需退出，请输入0\n");
	printf("\t\t\t\t\t");
	scanf("%d",&n);
	fp=fopen("kucun.txt","a+");
	if(fp==NULL)
	printf("\t\t\t\t\t打开文件失败\n"); 
	for(i=0;n!=0;i++)
	{
		printf("\t\t\t\t\t请分别输入商品的货号，名字，进价，售价,目前的数量\n");
		printf("\t\t\t\t\t");
		scanf("%d",&a[i].NO); 
		scanf("%s",a[i].name);
		scanf("%f",&a[i].inprice);
		scanf("%f",&a[i].outprice);
		scanf("%d",&a[i].amonts);
		printf("\t\t\t\t是否继续操作，若继续，请输入1,若退出，请输入0\n");
		printf("\t\t\t\t\t");
		scanf("%d",&n);
	}
	temp=i;//记录一共有多少个商品 
	//将货品的编号，名字，进价，售价，库存量分别写入文件 
	for(i=0;i<temp;i++)
	{
		fprintf(fp,"\n");
		fprintf(fp,"%-10d %-15s %-8.2f %-8.2f %-5d",a[i].NO,a[i].name,a[i].inprice,a[i].outprice,a[i].amonts);
	}
	fclose(fp);
	printf("\t\t\t\t\t信息导入成功\n");
	return n;
}
//显示所有商品信息 
void showgoods_message()
{
	FILE *fp;
	int n1;
	int i;
	if((fp=fopen("kucun.txt","r"))==NULL)
	{
		printf("\t\t\t\t\t打开文件失败\n");
		exit(0);
	}
	 
	for(i=0;!feof(fp);i++)
	{	
		fscanf(fp,"%d %s %f %f %d",&a[i].NO,a[i].name,&a[i].inprice,&a[i].outprice,&a[i].amonts);
		printf("\t\t\t\t\t----------------------------\n");
		printf("\t\t\t\t\t货号       品名       售价      数量\n");
		printf("\t\t\t\t\t%-10d %-15s %-8.2f %-5d\n",a[i].NO,a[i].name,a[i].outprice,a[i].amonts);	
	}
	fclose(fp); 
}
operate1()
{	
	int k;
	menu1();
	printf("\t\t\t\t\t");
	scanf("%d",&k);
	
	while(1)
	{
    	switch(k)
			{
    		case 1:
    			createmessage_text();
    			return 1;
				break;
			case 2:
				createmessage_auto();
				return 2;
				break;
			case 3: 
				showgoods_message();
				return 3;
				break;
			default:
				printf("\t\t\t\t\t输入有误，请重新输入\n");
				break;
			} 
	}
}
//查找商品
void find()
{
	FILE *fp;
	int i=0;
	int flag=1;
	commodity b;
	
	fp=fopen("kucun.txt","r");
	if(fp==NULL)
	{	
		printf("\t\t\t\t\t打开文件失败\n");
		exit(0);
	}
	
	printf("\t\t\t\t\t请输入你要查找的商品名称\n");
	printf("\t\t\t\t\t");
	scanf("%s",b.name);
	system("cls");
	for(i=0;!feof(fp);i++)
	{
		fscanf(fp,"%d %s %f %f %d",&a[i].NO,a[i].name,&a[i].inprice,&a[i].outprice,&a[i].amonts);
		if(strcmp(b.name,a[i].name)!=0)
		i++;
		else
		{
			printf("\t\t\t\t\t已查询到的信息如下：\n");
			printf("\t\t\t\t\t%-10d %-15s %-8.2f %-5d\n",a[i].NO,a[i].name,a[i].outprice,a[i].amonts);
			break;
		}
		
	}
	if(feof(fp))
	{
		printf("\t\t\t\t\t未找到该商品，请确认输入是否有误\n");
		sleep(10);
		system("cls"); 
	}
	printf("\t\t\t\t\t是否继续操作,若继续请输入1，否则请输入0\n");
	printf("\t\t\t\t\t");
	scanf("%d",&flag);
	if(flag) 
	find();
	else
	{
		fclose(fp);
		system("cls");
	}
	return ;
}
//删除商品
void deletemessge()
{
	FILE *fp;
	int i=0,j,k;
	int flag=1,temp=-1,count;//判断是否继续 
	commodity b[10],c;
	
	fp=fopen("kucun.txt","r");
	if(fp==NULL)
	{	
		printf("\t\t\t\t\t打开文件失败\n");
		exit(0);
	}
	count=-1;
	printf("\t\t\t\t\t请输入你要删除的商品名称\n");
	printf("\t\t\t\t\t");
	scanf("%s",c.name);
	system("cls");
	for(i=0;!feof(fp);i++)
	{
		fscanf(fp,"%d %s %f %f %d",&b[i].NO,b[i].name,&b[i].inprice,&b[i].outprice,&b[i].amonts);
		temp++;
		if(strcmp(c.name,b[i].name)==0)
		{
			printf("\t\t\t\t\t已查询到的信息如下：\n");
			printf("\t\t\t\t\t%-10d %-15s %-8.2f %-5d\n",b[i].NO,b[i].name,b[i].outprice,b[i].amonts);
			break;
		}
	}
	count=temp;
	printf("\t\t\t\t\t请确定是否删除，删除请输入1，否则输入0\n");
	printf("\t\t\t\t\t");
	scanf("%d",&flag);
	if(flag)
	{
		for(j=count+1;!feof(fp);j++)
		{	
			fscanf(fp,"%d %s %f %f %d",&b[j].NO,b[j].name,&b[j].inprice,&b[j].outprice,&b[j].amonts);
			count++;
		}
		fclose(fp);
		fp=fopen("kucun.txt","w+");
		if(fp==NULL)
		{
			printf("\t\t\t\t\t打开文件失败\n");
			exit(0);
		}
		fclose(fp);
		fp=fopen("kucun.txt","r+");
		if(fp==NULL)
		{
			printf("\t\t\t\t\t打开失败\n");
			exit(0);
		}
		for(k=0;k<=count;k++)
		{
			if(k!=temp)
			{
				if(k==0)
				{
					fprintf(fp,"%-10d %-15s %-8.2f %-8.2f %-5d",b[k].NO,b[k].name,b[k].inprice,b[k].outprice,b[k].amonts);
				}
				else
				{
					fprintf(fp,"\n");
					fprintf(fp,"%-10d %-15s %-8.2f %-8.2f %-5d",b[k].NO,b[k].name,b[k].inprice,b[k].outprice,b[k].amonts);
				}
			}
			else
			{
				if(k==0)
				{
					k+=1;
					fprintf(fp,"%-10d %-15s %-8.2f %-8.2f %-5d",b[k].NO,b[k].name,b[k].inprice,b[k].outprice,b[k].amonts);
				}
			}
		}
	}
	fclose(fp);
	printf("\t\t\t\t\t删除成功!\n");
	sleep(5); 
	system("cls");
	printf("\t\t\t\t\t操作成功，若继续请输入1，退出请输入0\n"); 
	printf("\t\t\t\t\t");
	scanf("%d",&flag);
	if(flag)
	{
		deletemessge();
	}
	else
	{
		system("cls");
		printf("\t\t\t\t\t退出成功\n");
	}
	return ; 
}

//修改商品
void changemessage()
{
	FILE *fp;
	int i,k,j,temp,count,flag;
	commodity c,b[10];
	
	fp=fopen("kucun.txt","r");
	if(fp==NULL)
	{	
		printf("\t\t\t\t\t打开文件失败\n");
		exit(0);
	}
	
	printf("\t\t\t\t\t请输入您需要修改的商品名称\n");
	printf("\t\t\t\t\t");
	scanf("%s",c.name);
	flag=-1;
	for(j=0;!feof(fp);j++)
	{
		fscanf(fp,"%d %s %f %f %d",&b[j].NO,b[j].name,&b[j].inprice,&b[j].outprice,&b[j].amonts);
		flag++;
		if(strcmp(b[j].name,c.name)==0)
		{
			printf("\t\t\t\t\t已查询到的信息如下：\n");
			printf("\t\t\t\t\t%-10d %-15s %8.2f %-8.2f %-5d\n",b[j].NO,b[j].name,b[j].inprice,b[j].outprice,b[j].amonts);
			break;
		}
	}
	count=flag;
	
	if(feof(fp))
	{
		printf("\t\t\t\t\t未找到该商品，请确认是否正确输入\n");
		fclose(fp);
		changemessage();
		exit(0);
	}
	for(j=flag+1;!feof(fp);j++)
	{
		fscanf(fp,"%d %s %f %f %d",&b[j].NO,b[j].name,&b[j].inprice,&b[j].outprice,&b[j].amonts);
		count++;
	}
	
	fclose(fp);
	
	printf("\t\t\t\t\t请输入您需要修改的信息\n");
	printf("\t\t\t\t\t1.商品编号\n");
	printf("\t\t\t\t\t2.进价\n");
	printf("\t\t\t\t\t3.售价\n");
	printf("\t\t\t\t\t4.数量\n");
	
	printf("\t\t\t\t\t");
	scanf("%d",&i);
	switch(i)
	{
		case 1:
			printf("\t\t\t\t\t请输入目前的商品编号\n");
			scanf("%d",&c.NO);
			printf("\t\t\t\t\t");
			b[flag].NO=c.NO;
			break;
		case 2:
			printf("\t\t\t\t\t请输入目前进价\n");
			printf("\t\t\t\t\t");
			scanf("%f",&c.inprice);
			b[flag].inprice=c.inprice;
			break;
		case 3:
			printf("\t\t\t\t\t请输入目前的售价\n");
			printf("\t\t\t\t\t");
			scanf("%f",&c.outprice);
			b[flag].outprice=c.outprice;
			break;
		case 4:
			printf("\t\t\t\t\t请输入目前的数量\n");
			printf("\t\t\t\t\t");
			scanf("%d",&c.amonts);
			b[flag].amonts=c.amonts;
			break;
			
	}
	
	fp=fopen("kucun.txt","w");
	if(fp==NULL)
	{
		printf("\t\t\t\t\t打开文件失败\n");
		exit(0);
	}
	fclose(fp);
	
	fp=fopen("kucun.txt","a+");
	if(fp==NULL)
	{
		printf("\t\t\t\t\t打开失败\n");
		exit(0);
	}
	for(k=0;k<count;k++)
	{
		if(k!=flag)
		{
			if(k==0)
			{
				fprintf(fp,"%-10d %-15s %-8.2f %-8.2f %-5d",b[k].NO,b[k].name,b[k].inprice,b[k].outprice,b[k].amonts);
			}
			else
			{
				fprintf(fp,"\n");
				fprintf(fp,"%-10d %-15s %-8.2f %-8.2f %-5d",b[k].NO,b[k].name,b[k].inprice,b[k].outprice,b[k].amonts);
			}
		}
		else
		{
			if(k==0)
			{
				fprintf(fp,"%-10d %-15s %-8.2f %-8.2f %-5d",b[flag].NO,b[flag].name,b[flag].inprice,b[flag].outprice,b[flag].amonts);
			}
			else
			{
				fprintf(fp,"\n");
				fprintf(fp,"%-10d %-15s %-8.2f %-8.2f %-5d",b[flag].NO,b[flag].name,b[flag].inprice,b[flag].outprice,b[flag].amonts);
			}
		}
	}
	
	fclose(fp);
	
	printf("\t\t\t\t\t修改已完成，是否继续操作，继续请输入1,否则输入0\n");
	printf("\t\t\t\t\t");
	scanf("%d",&temp);
	if(temp)
		changemessage();
	else
	{
		printf("\t\t\t\t\t已退出\n");
		system("cls");
	}
	
	return ;
}
//打印购买凭条
struct node{
	struct commodity buy;
	int number;//购买数量 
	float totall;
	struct node *next;
};//定义购物车节点 
struct node *cart;//购物车头结点
//显示购物操作 
int showbuygoods()
{
	int temp;
	printf("\t\t\t\t\t欢迎来到购物车主页，请输入需要执行的操作\n");
	printf("\t\t\t\t\t1.显示当前购物车列表\n");
	printf("\t\t\t\t\t2.向购物车中添加商品\n");
	printf("\t\t\t\t\t3.结算并打印\n");
	printf("\t\t\t\t\t");
	scanf("%d",&temp);
	switch(temp)
	{
		case 1:
			printf("\t\t\t\t\t显示当前购物车列表\n");
			return 1;
			break;
		case 2:
			printf("\t\t\t\t\t向购物车中添加商品\n");
			return 2;
			break;
		case 3:
			printf("\t\t\t\t\t结算并打印\n");
			return 3;
			break;
		default:
			printf("\t\t\t\t\t输入有误\n");
			return 0;
			break;
	}
}
//创建文件记录购物车信息
void crecartfile()
{
	FILE *fp;
	if((fp=fopen("cart.txt","r"))==NULL)//如果此文件不存在 
	{	
		fp=fopen("cart.txt","w+");
		if(fp==NULL)
		{
			printf("\t\t\t\t\t无法建立文件\n");
			exit(0);
		}
			
	}
} 
//显示购物车列表 
void showcartlist()
{
	struct node *p;
	p=cart;
	FILE *fp1;
	fp1=fopen("cart.txt","r");
	if(fp1==NULL)
	{
		printf("\t\t\t\t\t无法打开文件\n");
		exit(0);
	}
	if(p==NULL)
	{
		printf("\t\t\t\t\t当前购物车为空\n");
	}
	else
	{
		printf("\t\t\t\t\t\t\t-------------------购物车列表---------------------\n");
		printf("\t\t\t\t\t货号      品名        单价     数量     总价\n");
		while(p)
		{
			printf("\t\t\t\t\t%-10d %-15s %-8.2f %-5d %-8.2f\n",p->buy.NO,p->buy.name,p->buy.outprice,p->number,p->totall);
			p=p->next;
		}
	}
	
	fclose(fp1);
	return ;
}

//向购物车中添加商品
void addcart()
{
	FILE *fp2,*fp3;
	struct node *p,*p1;
	p=cart;
	int  goodsid,k=0,select3,n;
	fp2=fopen("cart.txt","a+");
	if(fp2==NULL)
	{
		printf("\t\t\t\t\t购物车打开文件失败\n");
		exit(0);
	}
	if((fp3=fopen("kucun.txt","r"))==NULL)
	{
		printf("\t\t\t\t\t库存文件打开失败\n");
		exit(0);
	}
	printf("\t\t\t\t\t请输入商品编号\n");
	printf("\t\t\t\t\t");
	scanf("%d",&goodsid);
	for(k=0;!feof(fp3);k++)
	{
		fscanf(fp3,"%d %s %f %f %d",&a[k].NO,a[k].name,&a[k].inprice,&a[k].outprice,&a[k].amonts);
		printf("\t\t\t\t\t%-10d %-15s %-8.2f %-8.2f %-5d\n",a[k].NO,a[k].name,a[k].inprice,a[k].outprice,a[k].amonts);
		if(a[k].NO==goodsid)
		{
			p=new node;
			printf("\t\t\t\t\t请输入需要购买的数量\n");
			printf("\t\t\t\t\t");
			scanf("%d",&n);
			p->buy.outprice=a[k].outprice;
			strcpy(p->buy.name,a[k].name);
			p->buy.NO=a[k].NO;
			p->number=n;
			p->totall=(p->buy.outprice)*(p->number);
			p->next=NULL;
			
			p1=cart;
			if(p1==NULL)
			{
				cart=p;
			}
			else
			{
				while(p1->next!=NULL)
					p1=p1->next;
					p1->next=p;
					p->next=NULL; 
			}
			fprintf(fp2,"%-10d %-15s %-8.2f %-5d %-8.2f",p->buy.NO,p->buy.name,p->buy.outprice,p->number,p->totall);
			fprintf(fp2,"\n");
			printf("\t\t\t\t\t%-10d %-15s %-8.2f %-5d %-8.2f",a[k].NO,a[k].name,a[k].outprice,p->number,p->totall);
			break;
		}
	}
	showcartlist();
	printf("\t\t\t\t\t添加已成功，是否继续,继续请输入1，否则请输入0\n");
	printf("\t\t\t\t\t");
	scanf("%d",&select3);
	if(select3)
	{
		addcart();
	}
	else
	{
		system("cls");
		fclose(fp2);
		fclose(fp3); 
	}
	return ;
}
//打印小票
void princart()
{
	struct node *p1,*p;
	int i;
	float finalprice,pay,change;

	sleep(5); 
	system("cls");
	p=cart;
	while(p)
	{
		finalprice+=p->totall;
		p=p->next;
	}

	printf("\t\t\t\t\t共%.2f元\n",finalprice);
	printf("\t\t\t\t\t请输入实付价格\n");
	scanf("%f",&pay);
	system("cls");
	//打印 
	printf("\t\t\t\t\t*****欢迎光临****超市*****\n");
	
	showcartlist();	
	
	printf("\t\t\t\t\t\t\t\t应付%.2f元\n",finalprice);
	printf("\t\t\t\t\t\t\t\t实付%.2f元\n",pay);
	change=pay-finalprice;
	printf("\t\t\t\t\t\t\t\t应找零%.2f元\n",change);
	printf("\t\t\t\t\t欢迎下次光临\n");
	
	return ;
} 
//购物车清零
void clearcart()
{
	FILE *fp4;
	fp4=fopen("cart.txt","w");
	if(fp4=NULL)
	{
		printf("\t\t\t\t\t清空购物车失败\n");
		exit(0);
	}
	
	return ;
} 
//退出系统
void outsystem()
{
	system("cls");
	printf("\t\t\t\t\t退出成功\n");
}
int main()
{
	int i,j,k,m;
	Menue();//显示整个系统中可进行的操作菜单 
	i=select();//选择需要进行什么操作
	switch (i)
	{
		case 1:
		create_File();//创建文件记录用户信息 
		k=operate();//用户注册，登陆
		switch(k)
		{
			case 1:
			case 2:
			case 3:
				menu();//登录成功后显示可进行的操作的菜单
				sleep(10);
				printf("\t\t\t\t\t");
				j=select1();
				switch(j)
				{
					case 1://商品录入信息所进行的相关操作 
						create_File1();
						operate1();
						break;
					case 2://查找商品所进行的相关操作 
						find();
						break;	
					case 3://修改商品所进行的相关操作
						changemessage();
						break; 
					case 4: 
						deletemessge();//删除商品 
						break;
					case 5:
						crecartfile();//创建文件记录购物信息 
						m=showbuygoods();//购物车可进行的操作 
						switch(m)
						{
							case 1:
								showcartlist();//显示购物车列表 
								break;
							case 2:
								addcart();//向购物车中添加商品 
								princart();//打印凭条 
								clearcart();//清除购物车 
								break;
							case 3:
								princart();
								clearcart();
								break;
							default:
								printf("\t\t\t\t\t输入有误\n");
								break;
					}
					break;
					case 6:
						outsystem();
						break;
					default:
						printf("\t\t\t\t\t输入有误\n");
						break;	
				}
				break;
		 	default:
				printf("\t\t\t\t\t输入有误\n");
				break;
		}
		break;
		default:
			printf("\t\t\t\t\t请先登录再进行相关操作\n");
			break;	
	}
	return 0;
}
