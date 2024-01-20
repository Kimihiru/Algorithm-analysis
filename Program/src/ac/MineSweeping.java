package ac;
public class MineSweeping {
	public static void main(String[] args) {
		int n=3;
		int m=4;
		int[][] x= {{0,1,0,0},
					{1,0,1,0},
					{0,0,1,0}};
		int[][] dxy= {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
		int[][] ans=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				ans[i][j]=x[i][j]==1? 9:0;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<dxy.length;k++) {
					if(x[i][j]==1) {
						break;
					}
					int dx=i+dxy[k][0];
					int dy=j+dxy[k][1];
					if(dx<0||dy<0||dx>=n||dy>=m) {
						continue;
					}
					if(x[dx][dy]==1) {
						ans[i][j]++;
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}