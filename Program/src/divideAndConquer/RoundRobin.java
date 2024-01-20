package divideAndConquer;
public class RoundRobin {
	public static void fillTable(int[][] table,int x,int y,int step) {
		if (step == 1) {
			return;
		}
		step /= 2;
		fillTable(table,x, y, step);
		fillTable(table,x + step, y, step);
		for (int i = 0; i < step;i++) {
			for (int j = 0; j < step;j++) {
				table[x + step + i][y + step + j] = table[x + i][y + j];
				table[x + i][step + j + y] = table[step + i + x][j + y];
			}
		}
	}
	public static void main(String[] args) {
		int n=8;
		int[][] table=new int[n+1][n+1];
		for (int i = 1; i <= n;i++) {
			table[i][1] = i;
		}
		fillTable(table,1, 1, n);
		System.out.print("日期");
		for (int i = 1; i < n; i++) {
			System.out.print(i+" ");
		}
		System.out.println("天");
		System.out.println("--------------");
		System.out.println("选手");
		for(int i=1;i<=n;i++) {
			System.out.print(i+"|");
			for(int j=2;j<=n;j++) {
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
	}
}