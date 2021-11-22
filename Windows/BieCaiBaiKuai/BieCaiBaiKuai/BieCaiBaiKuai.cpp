// BieCaiBaiKuai.cpp : 定义应用程序的入口点。
//

#include "framework.h"
#include "BieCaiBaiKuai.h"
#include "time.h"

#define MAX_LOADSTRING 100
#define BLOCK 100
// 全局变量:
HINSTANCE hInst;                                // 当前实例
WCHAR szTitle[MAX_LOADSTRING] = TEXT("别踩白块游戏");                  // 标题栏文本
WCHAR szWindowClass[MAX_LOADSTRING] = TEXT("DunKaiGUIFundation");            // 主窗口类名

// 此代码模块中包含的函数的前向声明:
ATOM                MyRegisterClass(HINSTANCE hInstance);
BOOL                InitInstance(HINSTANCE, int);
LRESULT CALLBACK    WndProc(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    About(HWND, UINT, WPARAM, LPARAM);


int APIENTRY wWinMain(_In_ HINSTANCE hInstance,
                     _In_opt_ HINSTANCE hPrevInstance,
                     _In_ LPWSTR    lpCmdLine,
                     _In_ int       nCmdShow)
{
    UNREFERENCED_PARAMETER(hPrevInstance);
    UNREFERENCED_PARAMETER(lpCmdLine);

    // TODO: 在此处放置代码。

    // 初始化全局字符串
    LoadStringW(hInstance, IDS_APP_TITLE, szTitle, MAX_LOADSTRING);
    LoadStringW(hInstance, IDC_BIECAIBAIKUAI, szWindowClass, MAX_LOADSTRING);
    MyRegisterClass(hInstance);

    // 执行应用程序初始化:
    if (!InitInstance (hInstance, nCmdShow))
    {
        return FALSE;
    }

    HACCEL hAccelTable = LoadAccelerators(hInstance, MAKEINTRESOURCE(IDC_BIECAIBAIKUAI));

    MSG msg;

    // 主消息循环:
    while (GetMessage(&msg, nullptr, 0, 0))
    {
        if (!TranslateAccelerator(msg.hwnd, hAccelTable, &msg))
        {
            TranslateMessage(&msg);
            DispatchMessage(&msg);
        }
    }

    return (int) msg.wParam;
}



//
//  函数: MyRegisterClass()
//
//  目标: 注册窗口类。
//
ATOM MyRegisterClass(HINSTANCE hInstance)
{
    WNDCLASSEXW wcex;

    wcex.cbSize = sizeof(WNDCLASSEX);

    wcex.style          = CS_HREDRAW | CS_VREDRAW;
    wcex.lpfnWndProc    = WndProc;
    wcex.cbClsExtra     = 0;
    wcex.cbWndExtra     = 0;
    wcex.hInstance      = hInstance;
    wcex.hIcon          = LoadIcon(hInstance, MAKEINTRESOURCE(IDI_BIECAIBAIKUAI));
    wcex.hCursor        = LoadCursor(nullptr, IDC_ARROW);
    wcex.hbrBackground  = (HBRUSH)(COLOR_WINDOW+1);
    wcex.lpszMenuName   = NULL;
    wcex.lpszClassName  = szWindowClass;//菜单名
    wcex.hIconSm        = LoadIcon(wcex.hInstance, MAKEINTRESOURCE(IDI_SMALL));
 

    return RegisterClassExW(&wcex);
}

//
//   函数: InitInstance(HINSTANCE, int)
//
//   目标: 保存实例句柄并创建主窗口
//
//   注释:
//
//        在此函数中，我们在全局变量中保存实例句柄并
//        创建和显示主程序窗口。
//
BOOL InitInstance(HINSTANCE hInstance, int nCmdShow)
{
   hInst = hInstance; // 将实例句柄存储在全局变量中

   HWND hWnd = CreateWindowW(szWindowClass, szTitle,WS_CAPTION|WS_SYSMENU|WS_MAXIMIZEBOX,
      450, 100, 4*BLOCK+17, 4*BLOCK+40, nullptr, nullptr, hInstance, nullptr);

   if (!hWnd)
   {
      return FALSE;
   }

   ShowWindow(hWnd, nCmdShow);
   UpdateWindow(hWnd);

   return TRUE;
}

//
//  函数: WndProc(HWND, UINT, WPARAM, LPARAM)
//
//  目标: 处理主窗口的消息。
//
//  WM_COMMAND  - 处理应用程序菜单
//  WM_PAINT    - 绘制主窗口
//  WM_DESTROY  - 发送退出消息并返回
//
//
LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{
    static int bw[4];//每屏四个黑块
    RECT rect;
    POINT point;//鼠标点击坐标
    static int n = 0;//
    static int tm = 0;
    static int getId;
    TCHAR  szMsg[200];
    static int dis = 0;
    switch (message)
    {
    case WM_CREATE:
    {
        srand((unsigned)time(NULL));
        for (int i = 0; i < 4; i++)
        {
            bw[i] = rand() % 4;
        }
        SetTimer(hWnd, 1, 10, NULL);
    }
        break;
    case WM_TIMER://定时器
        tm++;
        break;
    case WM_PAINT:
        {
            PAINTSTRUCT ps;
            HBRUSH hBrush;

            HDC hdc = BeginPaint(hWnd, &ps);//绘图句柄
            //Rectangle(hdc, 0, 0, 100, 100);
            //画水平线
            for (int i = 0; i < 4; i++)
            {
                MoveToEx(hdc, 0, i*BLOCK, NULL);
                LineTo(hdc, 400, i*BLOCK);

                MoveToEx(hdc, i * BLOCK, 0, NULL);
                LineTo(hdc, i * BLOCK, 400);
            }
            //画黑块
            for (int i = 0; i < 4; i++)
            {
                SetRect(&rect, bw[i] * BLOCK, i * BLOCK, (bw[i] + 1) * BLOCK, (i + 1) * BLOCK);
                hBrush = CreateSolidBrush(RGB(0, 0, 0));
                SelectObject(hdc,hBrush);
                Rectangle(hdc, rect.left,rect.top,rect.right,rect.bottom);
                DeleteObject(hBrush); 
            }
            // TODO: 在此处添加使用 hdc 的任何绘图代码...
            EndPaint(hWnd, &ps);
        }
        break;
    case WM_LBUTTONDOWN://鼠标左键点击消息
    {
        point.x = LOWORD(lParam);
        point.y = HIWORD(lParam);
        if (point.x / BLOCK != bw[3]) {
            wsprintf(szMsg, L"\t您输了！用时：%d.%d秒 格数：%d\n\n \t是否继续游戏？", tm / 100,tm-(tm/100)*100 ,n);
            MessageBox(hWnd, szMsg, L"游戏结束", MB_OK);
            n = 0;
            tm = 0;
            for (int i = 0; i < 4; i++)
            {
                 bw[i] = rand() % 4;
            }
            RedrawWindow(hWnd, NULL, NULL, RDW_ERASE);
            InvalidateRect(hWnd, NULL, true);
            
            //exit(0);
        }
        else
        {
            for (int i = 3; i > 0; i--)
            {
                bw[i] = bw[i - 1];
            }
            bw[0] = rand() % 4;
            //滚动窗口
            n++;
            ScrollWindow(hWnd, 0, BLOCK, NULL, NULL);
        }
    }
        break;
    case WM_CLOSE://关闭窗口
        DestroyWindow(hWnd);//窗口销毁
        break;
    case WM_DESTROY://窗口销毁消息
        PostQuitMessage(0);
        break;
    default:
        return DefWindowProc(hWnd, message, wParam, lParam);
    }
    return 0;
}