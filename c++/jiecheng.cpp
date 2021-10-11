#include<iostream>
using namespace std;

const int  Max=3005;

int main() {
	int i, temp, n, m, sum, j, k;
	int a[Max] = { 0 };
	cin >> n;
	a[0] = 1;

	for (i = 2; i <= n; i++) {
		temp = 0;
		for (j = 0; j <Max; j++) {
			sum = i * a[j] + temp;
			a[j] = sum % 10;
			temp = sum / 10;
		}
	}
	
	for (m = Max- 1; m > -1; m--) {
		if (a[m] != 0)
			break;
	}

	for (k = m; k >= 0; k--) {
		cout << a[k];
	}
	return 0;
}