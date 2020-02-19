/*

����
N��Mũ���� �迭�� ǥ���Ǵ� �̷ΰ� �ִ�.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
�̷ο��� 1�� �̵��� �� �ִ� ĭ�� ��Ÿ����, 0�� �̵��� �� ���� ĭ�� ��Ÿ����. �̷��� �̷ΰ� �־����� ��, (1, 1)���� ����Ͽ� (N, M)�� ��ġ�� �̵��� �� ������ �ϴ� �ּ��� ĭ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. �� ĭ���� �ٸ� ĭ���� �̵��� ��, ���� ������ ĭ���θ� �̵��� �� �ִ�.

���� �������� 15ĭ�� ������ (N, M)�� ��ġ�� �̵��� �� �ִ�. ĭ�� �� ������ ���� ��ġ�� ���� ��ġ�� �����Ѵ�.

�Է�
ù° �ٿ� �� ���� N, M(2 �� N, M �� 100)�� �־�����. ���� N���� �ٿ��� M���� ������ �̷ΰ� �־�����. ������ ������ �پ �Է����� �־�����.

���
ù° �ٿ� ������ �ϴ� �ּ��� ĭ ���� ����Ѵ�. �׻� ������ġ�� �̵��� �� �ִ� ��츸 �Է����� �־�����.



*/

#include<cstdio>
#include<queue>
using namespace std;

struct Point {
	int x;
	int y;
};

int dist[100][100];
int a[100][100];

int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };



int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &a[i][j]);
		}
	}

	queue<Point> q;
	dist[0][0] = 1;
	q.push({0,0});
	
	while (!q.empty()) {
		Point current = q.front();
		q.pop();
		if (current.x==n-1 &&current.y== m-1) {
			printf("%d",dist[n-1][m-1]);
		}
		for (int i =0; i<4; i++) {
			int nx =current.x+dx[i]; int ny =current.y+dy[i];
			if (nx>=0 && nx<n && ny>=0 && ny<m && a[nx][ny] 
			&& dist[nx][ny] == 0) {
				if (a[nx][ny]) {
					q.push({nx,ny});
					a[nx][ny] = 0;
					dist[nx][ny] = dist[current.x][current.y] + 1;
				}
			}
		}
	}
}