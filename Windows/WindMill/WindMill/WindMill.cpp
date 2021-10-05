// WindMill.cpp : 定义应用程序的入口点。
//

#include "framework.h"
#include "WindMill.h"
#include"math.h"

#define MAX_LOADSTRING 100
#define PI 3.1415926

// 全局变量:
HINSTANCE hInst;                                // 当前实例
WCHAR szTitle[MAX_LOADSTRING];                  // 标题栏文本
WCHAR szWindowClass[MAX_LOADSTRING];            // 主窗口类名
int nNum = 0, nMaxNum = 20;

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
    LoadStringW(hInstance, IDC_WINDMILL, szWindowClass, MAX_LOADSTRING);
    MyRegisterClass(hInstance);

    // 执行应用程序初始化:
    if (!InitInstance (hInstance, nCmdShow))
    {
        return FALSE;
    }

    HACCEL hAccelTable = LoadAccelerators(hInstance, MAKEINTRESOURCE(IDC_WINDMILL));

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
    wcex.hIcon          = LoadIcon(hInstance, MAKEINTRESOURCE(IDI_WINDMILL));
    wcex.hCursor        = LoadCursor(nullptr, IDC_ARROW);
    wcex.hbrBackground  = (HBRUSH)(COLOR_WINDOW+1);
    wcex.lpszMenuName   = MAKEINTRESOURCEW(IDC_WINDMILL);
    wcex.lpszClassName  = szWindowClass;
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
   HWND hWnd = CreateWindowW(szWindowClass, L"旋转的风车", WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, 0, 600, 450, nullptr, nullptr, hInstance, nullptr);
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
    HDC hdc;
    HBRUSH hbrush;
    HPEN hpen;
    PAINTSTRUCT ps;

    int nCentrex, nCentrey;
    double fAngle;

    switch (message)
    {
    case WM_COMMAND:
        {
            int wmId = LOWORD(wParam);
            // 分析菜单选择:
            switch (wmId)
            {
            case IDM_ABOUT:
                DialogBox(hInst, MAKEINTRESOURCE(IDD_ABOUTBOX), hWnd, About);
                break;
            case IDM_EXIT:
                DestroyWindow(hWnd);
                break;
            default:
                return DefWindowProc(hWnd, message, wParam, lParam);
            }
        }
        break;
    case WM_PAINT:
        {
            hdc = BeginPaint(hWnd, &ps);
            // TODO: 在此处添加使用 hdc 的任何绘图代码...
            SetMapMode(hdc, MM_ANISOTROPIC);
            SetWindowExtEx(hdc, 400, 300, NULL);
            SetViewportExtEx(hdc, 600, 450, NULL);
            SetViewportOrgEx(hdc, 300, 200, NULL);
         
            hpen = (HPEN)GetStockObject(BLACK_PEN);//绘制外圆画笔

            SelectObject(hdc, hpen);
            Ellipse(hdc, - 100, - 100, 100, 100);
            hbrush = CreateSolidBrush(RGB(255, 0, 0));

            SelectObject(hdc, hbrush);
            fAngle = 2 * PI / nMaxNum * nNum;
            nCentrex = (int)(50 * cos(fAngle));
            nCentrey = (int)(50 * sin(fAngle));
            Pie(hdc, nCentrex - 50, nCentrey + 50, nCentrex + 50, nCentrey - 50,
                (int)(nCentrex + 50 * cos(fAngle + PI )),
                (int)(nCentrey + 50 * sin(fAngle + PI )),
                (int)(nCentrex - 50 * cos(fAngle + PI )),
                (int)(nCentrey - 50 * sin(fAngle + PI )));

            hbrush = CreateSolidBrush(RGB(255, 255, 0));
            SelectObject(hdc, hbrush);
            fAngle = 2 * PI / nMaxNum * nNum;
            nCentrex = (int)(50 * cos(fAngle+2*PI/3));
            nCentrey = (int)(50 * sin(fAngle+2*PI/3));
            Pie(hdc, nCentrex - 50, nCentrey + 50, nCentrex + 50, nCentrey - 50,
                (int)(nCentrex + 50 * cos(fAngle + 2 * PI / 3)),
                (int)(nCentrey + 50 * sin(fAngle + 2 * PI / 3)),
                (int)(nCentrex - 50 * cos(fAngle + 2 * PI / 3)),
                (int)(nCentrey - 50 * sin(fAngle + 2 * PI / 3)));

            hbrush = CreateSolidBrush(RGB(0, 255, 255));
            SelectObject(hdc, hbrush);
            fAngle = 2 * PI / nMaxNum * nNum;
            nCentrex = (int)(50 * cos(fAngle + 4 * PI / 3));
            nCentrey = (int)(50 * sin(fAngle + 4 * PI / 3));
            Pie(hdc, nCentrex - 50, nCentrey + 50, nCentrex + 50, nCentrey - 50,
                (int)(nCentrex + 50 * cos(fAngle + 4 * PI / 3)),
                (int)(nCentrey + 50 * sin(fAngle + 4 * PI / 3)),
                (int)(nCentrex - 50 * cos(fAngle + 4 * PI / 3)),
                (int)(nCentrey - 50 * sin(fAngle + 4 * PI / 3)));
            nNum++;
            Sleep(100);
            InvalidateRect(hWnd, NULL, 1);
            EndPaint(hWnd, &ps);
        }
        break;
    case WM_DESTROY:
        PostQuitMessage(0);
        break;
    default:
        return DefWindowProc(hWnd, message, wParam, lParam);
    }
    return 0;
}

// “关于”框的消息处理程序。
INT_PTR CALLBACK About(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam)
{
    UNREFERENCED_PARAMETER(lParam);
    switch (message)
    {
    case WM_INITDIALOG:
        return (INT_PTR)TRUE;

    case WM_COMMAND:
        if (LOWORD(wParam) == IDOK || LOWORD(wParam) == IDCANCEL)
        {
            EndDialog(hDlg, LOWORD(wParam));
            return (INT_PTR)TRUE;
        }
        break;
    }
    return (INT_PTR)FALSE;
}
