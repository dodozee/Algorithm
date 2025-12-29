#include <iostream>
#include <string>
#include <cmath>
#include <set>
#include <map>
#include <stack>
#include <queue>
#include <vector>
#include <algorithm>
#define FIRST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 65
#define LL long long
#define INF 2e9

using namespace std;
struct INFO {
	int ADDH, ADDT, MINT, ADDO, MINO, Time;
};

int T, N;
INFO Minute[MAX];
bool visited[MAX];
queue<INFO> Q;

void BFS() {
	INFO Info = { 0,0,0,0,0,0 };
	Q.push(Info);

	while (!Q.empty()) {
		INFO CurInfo = Q.front();
		Q.pop();

		if ((CurInfo.Time >= 0) && (CurInfo.Time <= 60) && (!visited[CurInfo.Time])) {
			visited[CurInfo.Time] = true;
			Minute[CurInfo.Time] = CurInfo;
			Q.push({ CurInfo.ADDH,CurInfo.ADDT,CurInfo.MINT,CurInfo.ADDO,CurInfo.MINO + 1,CurInfo.Time - 1 });
			Q.push({ CurInfo.ADDH,CurInfo.ADDT,CurInfo.MINT,CurInfo.ADDO + 1,CurInfo.MINO,CurInfo.Time + 1 });
			Q.push({ CurInfo.ADDH,CurInfo.ADDT,CurInfo.MINT + 1,CurInfo.ADDO,CurInfo.MINO,CurInfo.Time - 10 });
			Q.push({ CurInfo.ADDH,CurInfo.ADDT + 1,CurInfo.MINT,CurInfo.ADDO,CurInfo.MINO,CurInfo.Time + 10 });
			Q.push({ CurInfo.ADDH + 1,CurInfo.ADDT,CurInfo.MINT,CurInfo.ADDO,CurInfo.MINO,CurInfo.Time + 60 });
		}
	};
}

int main() {
	FIRST
	BFS();
	cin >> T;
	while (T--) {
		cin >> N;
		int M = N / 60;
		int R = N % 60;
		cout << Minute[R].ADDH + M << " " << Minute[R].ADDT << " " << Minute[R].MINT << " " << Minute[R].ADDO << " " << Minute[R].MINO << "\n";
	};

	return 0;
}