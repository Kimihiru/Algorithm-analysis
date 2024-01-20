package dp;
/*
	当i=j
		m[i][i]=0
	当i<j
		m[i][i]=min{m[i][k]+m[k+1][j]+p[i-1]p[k]p[j]}
*/
public class Matrix {
	public static void matrixChain(int[] p,int n,int[][] m,int[][] s) {
		for(int i=1;i<=n;i++) {
			m[i][i]=0;
		}
		for(int r=2;r<=n;r++) {
			for(int i=1;i<=n-r+1;i++) {
				int j=i+r-1;
				m[i][j]=m[i][i]+m[i+1][j]+p[i-1]*p[i]*p[j];
				s[i][j]=i;
				for(int k=i+1;k<j;k++) {
					int t=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(t<m[i][j]) {
						m[i][j]=t;
						s[i][j]=k;
					}
				}
			}
		}
	}
	public static void printOptimal(int[][] s,int i,int j,int[] p) {
		if(i==j) {
			System.out.print("A["+p[i-1]+","+p[i]+"]");
		}
		else {
			System.out.print("(");
			printOptimal(s,i,s[i][j],p);
			printOptimal(s,s[i][j]+1,j,p);
			System.out.print(")");
		}
	}
	public static void output(int[][] a,int n) {
		for (int i = 1; i <= n;i++) {
			for (int j = 1; j <= n;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[] p= {30,35,15,5,10,20,25};
		int n=p.length;
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		matrixChain(p,n-1,m,s);
		System.out.println("m矩阵");
		output(m,n-1);
		System.out.println("s矩阵");
		output(s,n-1);
		System.out.println("最优的运算方式的乘法次数为:"+m[1][n-1]);
		printOptimal(s,1,n-1,p);
	}
}