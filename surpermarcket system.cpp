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

//��ʾ�����˵� 
void Menue()
{
	printf("\t\t\t\t\t1.���¼��Ϣ\n");
	printf("\t\t\t\t\t2.��Ʒ��Ϣ¼��\n");
	printf("\t\t\t\t\t3.������Ʒ\n");
	printf("\t\t\t\t\t4.�޸���Ʒ\n");
	printf("\t\t\t\t\t5.ɾ����Ʒ\n");
	printf("\t\t\t\t\t6.���㲢��ӡСƱ\n");
	printf("\t\t\t\t\t7.�˳�ϵͳ\n");
}

//������� 
int select()
{
	int i;
	printf("\t\t\t\t\t��������Ҫ������ָ������\n");
	printf("\t\t\t\t\t");
	scanf("%d",&i);
	if(i<1||i>7)
	printf("\t\t\t\t\t���벻�Ϸ�\n");
	switch(i)
	{
		case 1:printf("\t\t\t\t\t��¼\n");
		return 1;
		break;
		case 2:printf("\t\t\t\t\t��Ʒ��Ϣ¼��\n");
		return 2;
		break;
		case 3:printf("\t\t\t\t\t������Ʒ\n");
		return 3;
		break;
		case 4:printf("\t\t\t\t\t�޸���Ʒ\n");
		return 4;
		break;
		case 5:printf("\t\t\t\t\tɾ����Ʒ\n");
		return 5;
		break;
		case 6:printf("\t\t\t\t\t��ӡ�˵�\n");
		return 6;
		break;
		case 7:printf("\t\t\t\t\t�˳�ϵͳ\n");
		return 7;
		break;
	 } 
}	
//�����ı��ĵ���¼��½��Ϣ
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
	if((fp=fopen("users.txt","r"))==NULL)//������ļ������� 
	{	
		fp=fopen("users.txt","w+");
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
	if(fp==NULL)
	{
		printf("\t\t\t\t\t�޷����ļ�\n");
		exit(0);
	}
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
	
	if(fp==NULL)
	{
		printf("\t\t\t\t\t�޷����ļ�\n");
		exit(0);
	}
	
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
			system("cls");
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

int operate()
{
	int k;
	printf("\t\t\t\t\t��������Ҫ���еĲ���\n");
	printf("\t\t\t\t\t1.ע��\n");
	printf("\t\t\t\t\t2.��¼\n");
	printf("\t\t\t\t\t3.�˳�\n");
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
		printf("\t\t\t\t\t�����ֵ���Ϸ�������������\n");
		return 0;
		break;
	}
}
//��½�ɹ�����ʾ�ɲ����Ĳ˵� 
void menu()
{
	printf("\t\t\t\t\t����������Ҫ����������\n");
	printf("\t\t\t\t\t1.��Ʒ��Ϣ¼��\n");
	printf("\t\t\t\t\t2.������Ʒ\n");
	printf("\t\t\t\t\t3.�޸���Ʒ\n");
	printf("\t\t\t\t\t4.ɾ����Ʒ\n");
	printf("\t\t\t\t\t5.���㲢��ӡСƱ\n"); 
	printf("\t\t\t\t\t6.�˳�ϵͳ\n"); 
} 	
int select1()
{
	int k;
	scanf("%d",&k);
	switch(k)
	{
		case 1:
		printf("\t\t\t\t\t1.��Ʒ��Ϣ¼��\n");
		return 1;
		break;
		case 2:
		printf("\t\t\t\t\t2.������Ʒ\n");
		return 2;
		break;
		case 3:
		printf("\t\t\t\t\t3.�޸���Ʒ\n");
		return 3;
		break;
		case 4:
		printf("\t\t\t\t\tɾ����Ʒ\n");
		return 4;
		break;
		case 5:
		printf("\t\t\t\t\t5.���㲢��ӡСƱ\n");
		return 5;
		break;
		case 6:
		printf("\t\t\t\t\t6.�˳�ϵͳ\n");
		return 6;
		break;
		default:printf("������������������"); 
		return 0; 
		break;
	}
 
}
//��Ʒ��Ϣ¼��

//����һ����Ʒ�� 
struct commodity{
	char name[20];//��Ʒ�� 
	int NO;//��Ʒ��� 
	float inprice;//��Ʒ���� 
	float outprice;//��Ʒ�ۼ� 
	int amonts;//��Ʒ���� 
};

struct commodity a[20];

//ѡ����Ʒ��Ϣ¼���ɽ��еĲ����˵�
void menu1()
{
	printf("\t\t\t\t\t��������Ҫ���еĲ���������\n"); 
	printf("\t\t\t\t\t1.�ļ����������Ϣ\n"); 
	printf("\t\t\t\t\t2.�ֶ����������Ϣ\n");
	printf("\t\t\t\t\t3.��ʾ������Ʒ��Ϣ\n"); 
}
//������¼��Ʒ��Ϣ���ļ� 
void create_File1()
{
	FILE *fp;
	if((fp=fopen("kucun.txt","r"))==NULL)//������ļ������� 
	{	
		fp=fopen("kucun.txt","w+");
		if(fp==NULL)
		{
			printf("\t\t\t\t\t�޷������ļ�\n");
			exit(0);
		}
			
	}
}
//�ļ����������Ϣ
void createmessage_text()
{
	FILE *fp;
	fp=fopen("kucun.txt","w");
	if(fp==NULL)
	printf("\t\t\t\t\t�����ļ�ʧ��\n");
	fprintf(fp,"69011111 Ʈ���ճ����� 12.00 15.00 30");
	fprintf(fp,"\n");
	fprintf(fp,"69021111 ������ 1.50 2.00 200");
	fprintf(fp,"\n");
	fprintf(fp,"69031111 �츻ʿƻ�� 2.50 3.50 300");
	fprintf(fp,"\n");
	fprintf(fp,"69041111 �����о 0.70 1.00 150");
	fprintf(fp,"\n");
	fprintf(fp,"69051111 ��ҽ����Ĥ 12.00 16.50 100");
	fclose(fp);//�ر��ļ�
	printf("\t\t\t\t\t");
	printf("�ɹ�������Ϣ\n"); 
	return ;
} 
//�ֶ����������Ϣ 
int createmessage_auto() 
{
	int i,temp;
	int n;
	FILE *fp;
	
	printf("\t\t\t\t\t��������������1�������˳���������0\n");
	printf("\t\t\t\t\t");
	scanf("%d",&n);
	fp=fopen("kucun.txt","a+");
	if(fp==NULL)
	printf("\t\t\t\t\t���ļ�ʧ��\n"); 
	for(i=0;n!=0;i++)
	{
		printf("\t\t\t\t\t��ֱ�������Ʒ�Ļ��ţ����֣����ۣ��ۼ�,Ŀǰ������\n");
		printf("\t\t\t\t\t");
		scanf("%d",&a[i].NO); 
		scanf("%s",a[i].name);
		scanf("%f",&a[i].inprice);
		scanf("%f",&a[i].outprice);
		scanf("%d",&a[i].amonts);
		printf("\t\t\t\t�Ƿ������������������������1,���˳���������0\n");
		printf("\t\t\t\t\t");
		scanf("%d",&n);
	}
	temp=i;//��¼һ���ж��ٸ���Ʒ 
	//����Ʒ�ı�ţ����֣����ۣ��ۼۣ�������ֱ�д���ļ� 
	for(i=0;i<temp;i++)
	{
		fprintf(fp,"\n");
		fprintf(fp,"%-10d %-15s %-8.2f %-8.2f %-5d",a[i].NO,a[i].name,a[i].inprice,a[i].outprice,a[i].amonts);
	}
	fclose(fp);
	printf("\t\t\t\t\t��Ϣ����ɹ�\n");
	return n;
}
//��ʾ������Ʒ��Ϣ 
void showgoods_message()
{
	FILE *fp;
	int n1;
	int i;
	if((fp=fopen("kucun.txt","r"))==NULL)
	{
		printf("\t\t\t\t\t���ļ�ʧ��\n");
		exit(0);
	}
	 
	for(i=0;!feof(fp);i++)
	{	
		fscanf(fp,"%d %s %f %f %d",&a[i].NO,a[i].name,&a[i].inprice,&a[i].outprice,&a[i].amonts);
		printf("\t\t\t\t\t----------------------------\n");
		printf("\t\t\t\t\t����       Ʒ��       �ۼ�      ����\n");
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
				printf("\t\t\t\t\t������������������\n");
				break;
			} 
	}
}
//������Ʒ
void find()
{
	FILE *fp;
	int i=0;
	int flag=1;
	commodity b;
	
	fp=fopen("kucun.txt","r");
	if(fp==NULL)
	{	
		printf("\t\t\t\t\t���ļ�ʧ��\n");
		exit(0);
	}
	
	printf("\t\t\t\t\t��������Ҫ���ҵ���Ʒ����\n");
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
			printf("\t\t\t\t\t�Ѳ�ѯ������Ϣ���£�\n");
			printf("\t\t\t\t\t%-10d %-15s %-8.2f %-5d\n",a[i].NO,a[i].name,a[i].outprice,a[i].amonts);
			break;
		}
		
	}
	if(feof(fp))
	{
		printf("\t\t\t\t\tδ�ҵ�����Ʒ����ȷ�������Ƿ�����\n");
		sleep(10);
		system("cls"); 
	}
	printf("\t\t\t\t\t�Ƿ��������,������������1������������0\n");
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
//ɾ����Ʒ
void deletemessge()
{
	FILE *fp;
	int i=0,j,k;
	int flag=1,temp=-1,count;//�ж��Ƿ���� 
	commodity b[10],c;
	
	fp=fopen("kucun.txt","r");
	if(fp==NULL)
	{	
		printf("\t\t\t\t\t���ļ�ʧ��\n");
		exit(0);
	}
	count=-1;
	printf("\t\t\t\t\t��������Ҫɾ������Ʒ����\n");
	printf("\t\t\t\t\t");
	scanf("%s",c.name);
	system("cls");
	for(i=0;!feof(fp);i++)
	{
		fscanf(fp,"%d %s %f %f %d",&b[i].NO,b[i].name,&b[i].inprice,&b[i].outprice,&b[i].amonts);
		temp++;
		if(strcmp(c.name,b[i].name)==0)
		{
			printf("\t\t\t\t\t�Ѳ�ѯ������Ϣ���£�\n");
			printf("\t\t\t\t\t%-10d %-15s %-8.2f %-5d\n",b[i].NO,b[i].name,b[i].outprice,b[i].amonts);
			break;
		}
	}
	count=temp;
	printf("\t\t\t\t\t��ȷ���Ƿ�ɾ����ɾ��������1����������0\n");
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
			printf("\t\t\t\t\t���ļ�ʧ��\n");
			exit(0);
		}
		fclose(fp);
		fp=fopen("kucun.txt","r+");
		if(fp==NULL)
		{
			printf("\t\t\t\t\t��ʧ��\n");
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
	printf("\t\t\t\t\tɾ���ɹ�!\n");
	sleep(5); 
	system("cls");
	printf("\t\t\t\t\t�����ɹ���������������1���˳�������0\n"); 
	printf("\t\t\t\t\t");
	scanf("%d",&flag);
	if(flag)
	{
		deletemessge();
	}
	else
	{
		system("cls");
		printf("\t\t\t\t\t�˳��ɹ�\n");
	}
	return ; 
}

//�޸���Ʒ
void changemessage()
{
	FILE *fp;
	int i,k,j,temp,count,flag;
	commodity c,b[10];
	
	fp=fopen("kucun.txt","r");
	if(fp==NULL)
	{	
		printf("\t\t\t\t\t���ļ�ʧ��\n");
		exit(0);
	}
	
	printf("\t\t\t\t\t����������Ҫ�޸ĵ���Ʒ����\n");
	printf("\t\t\t\t\t");
	scanf("%s",c.name);
	flag=-1;
	for(j=0;!feof(fp);j++)
	{
		fscanf(fp,"%d %s %f %f %d",&b[j].NO,b[j].name,&b[j].inprice,&b[j].outprice,&b[j].amonts);
		flag++;
		if(strcmp(b[j].name,c.name)==0)
		{
			printf("\t\t\t\t\t�Ѳ�ѯ������Ϣ���£�\n");
			printf("\t\t\t\t\t%-10d %-15s %8.2f %-8.2f %-5d\n",b[j].NO,b[j].name,b[j].inprice,b[j].outprice,b[j].amonts);
			break;
		}
	}
	count=flag;
	
	if(feof(fp))
	{
		printf("\t\t\t\t\tδ�ҵ�����Ʒ����ȷ���Ƿ���ȷ����\n");
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
	
	printf("\t\t\t\t\t����������Ҫ�޸ĵ���Ϣ\n");
	printf("\t\t\t\t\t1.��Ʒ���\n");
	printf("\t\t\t\t\t2.����\n");
	printf("\t\t\t\t\t3.�ۼ�\n");
	printf("\t\t\t\t\t4.����\n");
	
	printf("\t\t\t\t\t");
	scanf("%d",&i);
	switch(i)
	{
		case 1:
			printf("\t\t\t\t\t������Ŀǰ����Ʒ���\n");
			scanf("%d",&c.NO);
			printf("\t\t\t\t\t");
			b[flag].NO=c.NO;
			break;
		case 2:
			printf("\t\t\t\t\t������Ŀǰ����\n");
			printf("\t\t\t\t\t");
			scanf("%f",&c.inprice);
			b[flag].inprice=c.inprice;
			break;
		case 3:
			printf("\t\t\t\t\t������Ŀǰ���ۼ�\n");
			printf("\t\t\t\t\t");
			scanf("%f",&c.outprice);
			b[flag].outprice=c.outprice;
			break;
		case 4:
			printf("\t\t\t\t\t������Ŀǰ������\n");
			printf("\t\t\t\t\t");
			scanf("%d",&c.amonts);
			b[flag].amonts=c.amonts;
			break;
			
	}
	
	fp=fopen("kucun.txt","w");
	if(fp==NULL)
	{
		printf("\t\t\t\t\t���ļ�ʧ��\n");
		exit(0);
	}
	fclose(fp);
	
	fp=fopen("kucun.txt","a+");
	if(fp==NULL)
	{
		printf("\t\t\t\t\t��ʧ��\n");
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
	
	printf("\t\t\t\t\t�޸�����ɣ��Ƿ��������������������1,��������0\n");
	printf("\t\t\t\t\t");
	scanf("%d",&temp);
	if(temp)
		changemessage();
	else
	{
		printf("\t\t\t\t\t���˳�\n");
		system("cls");
	}
	
	return ;
}
//��ӡ����ƾ��
struct node{
	struct commodity buy;
	int number;//�������� 
	float totall;
	struct node *next;
};//���幺�ﳵ�ڵ� 
struct node *cart;//���ﳵͷ���
//��ʾ������� 
int showbuygoods()
{
	int temp;
	printf("\t\t\t\t\t��ӭ�������ﳵ��ҳ����������Ҫִ�еĲ���\n");
	printf("\t\t\t\t\t1.��ʾ��ǰ���ﳵ�б�\n");
	printf("\t\t\t\t\t2.���ﳵ�������Ʒ\n");
	printf("\t\t\t\t\t3.���㲢��ӡ\n");
	printf("\t\t\t\t\t");
	scanf("%d",&temp);
	switch(temp)
	{
		case 1:
			printf("\t\t\t\t\t��ʾ��ǰ���ﳵ�б�\n");
			return 1;
			break;
		case 2:
			printf("\t\t\t\t\t���ﳵ�������Ʒ\n");
			return 2;
			break;
		case 3:
			printf("\t\t\t\t\t���㲢��ӡ\n");
			return 3;
			break;
		default:
			printf("\t\t\t\t\t��������\n");
			return 0;
			break;
	}
}
//�����ļ���¼���ﳵ��Ϣ
void crecartfile()
{
	FILE *fp;
	if((fp=fopen("cart.txt","r"))==NULL)//������ļ������� 
	{	
		fp=fopen("cart.txt","w+");
		if(fp==NULL)
		{
			printf("\t\t\t\t\t�޷������ļ�\n");
			exit(0);
		}
			
	}
} 
//��ʾ���ﳵ�б� 
void showcartlist()
{
	struct node *p;
	p=cart;
	FILE *fp1;
	fp1=fopen("cart.txt","r");
	if(fp1==NULL)
	{
		printf("\t\t\t\t\t�޷����ļ�\n");
		exit(0);
	}
	if(p==NULL)
	{
		printf("\t\t\t\t\t��ǰ���ﳵΪ��\n");
	}
	else
	{
		printf("\t\t\t\t\t\t\t-------------------���ﳵ�б�---------------------\n");
		printf("\t\t\t\t\t����      Ʒ��        ����     ����     �ܼ�\n");
		while(p)
		{
			printf("\t\t\t\t\t%-10d %-15s %-8.2f %-5d %-8.2f\n",p->buy.NO,p->buy.name,p->buy.outprice,p->number,p->totall);
			p=p->next;
		}
	}
	
	fclose(fp1);
	return ;
}

//���ﳵ�������Ʒ
void addcart()
{
	FILE *fp2,*fp3;
	struct node *p,*p1;
	p=cart;
	int  goodsid,k=0,select3,n;
	fp2=fopen("cart.txt","a+");
	if(fp2==NULL)
	{
		printf("\t\t\t\t\t���ﳵ���ļ�ʧ��\n");
		exit(0);
	}
	if((fp3=fopen("kucun.txt","r"))==NULL)
	{
		printf("\t\t\t\t\t����ļ���ʧ��\n");
		exit(0);
	}
	printf("\t\t\t\t\t��������Ʒ���\n");
	printf("\t\t\t\t\t");
	scanf("%d",&goodsid);
	for(k=0;!feof(fp3);k++)
	{
		fscanf(fp3,"%d %s %f %f %d",&a[k].NO,a[k].name,&a[k].inprice,&a[k].outprice,&a[k].amonts);
		printf("\t\t\t\t\t%-10d %-15s %-8.2f %-8.2f %-5d\n",a[k].NO,a[k].name,a[k].inprice,a[k].outprice,a[k].amonts);
		if(a[k].NO==goodsid)
		{
			p=new node;
			printf("\t\t\t\t\t��������Ҫ���������\n");
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
	printf("\t\t\t\t\t����ѳɹ����Ƿ����,����������1������������0\n");
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
//��ӡСƱ
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

	printf("\t\t\t\t\t��%.2fԪ\n",finalprice);
	printf("\t\t\t\t\t������ʵ���۸�\n");
	scanf("%f",&pay);
	system("cls");
	//��ӡ 
	printf("\t\t\t\t\t*****��ӭ����****����*****\n");
	
	showcartlist();	
	
	printf("\t\t\t\t\t\t\t\tӦ��%.2fԪ\n",finalprice);
	printf("\t\t\t\t\t\t\t\tʵ��%.2fԪ\n",pay);
	change=pay-finalprice;
	printf("\t\t\t\t\t\t\t\tӦ����%.2fԪ\n",change);
	printf("\t\t\t\t\t��ӭ�´ι���\n");
	
	return ;
} 
//���ﳵ����
void clearcart()
{
	FILE *fp4;
	fp4=fopen("cart.txt","w");
	if(fp4=NULL)
	{
		printf("\t\t\t\t\t��չ��ﳵʧ��\n");
		exit(0);
	}
	
	return ;
} 
//�˳�ϵͳ
void outsystem()
{
	system("cls");
	printf("\t\t\t\t\t�˳��ɹ�\n");
}
int main()
{
	int i,j,k,m;
	Menue();//��ʾ����ϵͳ�пɽ��еĲ����˵� 
	i=select();//ѡ����Ҫ����ʲô����
	switch (i)
	{
		case 1:
		create_File();//�����ļ���¼�û���Ϣ 
		k=operate();//�û�ע�ᣬ��½
		switch(k)
		{
			case 1:
			case 2:
			case 3:
				menu();//��¼�ɹ�����ʾ�ɽ��еĲ����Ĳ˵�
				sleep(10);
				printf("\t\t\t\t\t");
				j=select1();
				switch(j)
				{
					case 1://��Ʒ¼����Ϣ�����е���ز��� 
						create_File1();
						operate1();
						break;
					case 2://������Ʒ�����е���ز��� 
						find();
						break;	
					case 3://�޸���Ʒ�����е���ز���
						changemessage();
						break; 
					case 4: 
						deletemessge();//ɾ����Ʒ 
						break;
					case 5:
						crecartfile();//�����ļ���¼������Ϣ 
						m=showbuygoods();//���ﳵ�ɽ��еĲ��� 
						switch(m)
						{
							case 1:
								showcartlist();//��ʾ���ﳵ�б� 
								break;
							case 2:
								addcart();//���ﳵ�������Ʒ 
								princart();//��ӡƾ�� 
								clearcart();//������ﳵ 
								break;
							case 3:
								princart();
								clearcart();
								break;
							default:
								printf("\t\t\t\t\t��������\n");
								break;
					}
					break;
					case 6:
						outsystem();
						break;
					default:
						printf("\t\t\t\t\t��������\n");
						break;	
				}
				break;
		 	default:
				printf("\t\t\t\t\t��������\n");
				break;
		}
		break;
		default:
			printf("\t\t\t\t\t���ȵ�¼�ٽ�����ز���\n");
			break;	
	}
	return 0;
}
