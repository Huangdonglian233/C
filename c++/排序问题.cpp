#include<stdio.h>
#include<iostream>
#include<string.h>
using namespace std;
#define inf 1000000000

char b[50005][100];
char str[102];
int in[30];
int use[30];
int main() {
	int G[33][33];
	int A, K;
	while (scanf("%d%d", &A, &K) != -1) {
		for (int i = 1; i <= K; i++) {
			scanf("%s", b[i]);
		}
		scanf("%s", str);
		
		memset(G, 0, sizeof(G));
		memset(in, 0, sizeof(in));
		memset(use, 0, sizeof(use));
		for (int i = 2; i <= K; i++) {
			int L1 =(int)strlen(b[i-1]);
			int L2 = (int)strlen(b[i]);
			int L ;
			if (L1 < L2)
				L = L1;
			else
				L = L2;
			for (int j = 0; j < L; j++) {
				if (b[i][j] == b[i-1][j])
					continue;
				int temp1 = b[i - 1][j] - 'a';
				int temp2 = b[i][j] - 'a';
				G[temp1][temp2] = 1;
				use[temp1] = use[temp2] = 1;
				in[temp2]++;
				break;
			}
		}
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			if (use[i])
				sum++;
		}
		if (sum != A) {
			cout << 01 << endl;
			continue;
		}
		int cnt = 0;
		int s[33];
		for (int k = 1; k <= A; k++) {
			int flag = 0;
			for (int i = 0; i < 26; i++) {
				if ((use[i] && in[i]) == 0) {
					flag++;
				}
			}
			if (flag >= 2 || flag == 0)
				break;
			for (int i = 0; i < 26; i++) {
				if (!use[i])
					continue;
				if (in[i] == 0) {
					in[i]--;
					s[cnt] = i;
					cnt++;
					for (int j = 0; j <= 26; j++) {
						if (G[i][j] && use[j]) {
							in[j]--;
						}
					}
					break;
				}
			}
		}
		if (cnt != A) {
			cout << 02 << endl;
			continue;
		}
		int j = 0;
		int ans[33];
		for (int i = 0; i < 26; i++) {
			if (use[i]) {
				ans[s[j++]] = i;
			}
		}
		for (int i = 0; str[i] != '0'; i++) {
			printf("%c", ans[str[i] - 'a'] + 'a');
		}
		cout << endl;
	}
	return 0;
}