package dp;
public class LCS {
	public static void LCSLength(char[] x,char[] y,int m,int n,int[][] c,int[][] b) {
		for(int i=1;i<=m;i++) {
			c[i][0]=0;
		}
		for(int i=1;i<=n;i++) {
			c[0][i]=0;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(x[i-1]==y[j-1]) {
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=1;
				}else if(c[i-1][j]>=c[i][j-1]) {
					c[i][j]=c[i-1][j];
					b[i][j]=2;
				}else {
					c[i][j]=c[i][j-1];
					b[i][j]=3;
				}
			}
		}
	}
	public static void LCSOUT(int[][] b,char[] x,int i,int j) {
		if(i==0||j==0)return;
		if(b[i][j]==1) {
			LCSOUT(b,x,i-1,j-1);
			System.out.print(x[i-1]);//cout<<x[i-1];
		}else if(b[i][j]==2) {
			LCSOUT(b,x,i-1,j);
		}else {
			LCSOUT(b,x,i,j-1);
		}
	}
	public static void output(int[][] a, int m, int n) {
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(a[m][n]+" ");//cout<<a[m][n]<<" ";
			}
			System.out.println();//cout<<endl;
		}
	}
	public static void main(String[] args) {
		char[] x= {'A','B','C','D','B','D','A'};
		char[] y= {'A','B','A','D','D'};
		int m=x.length;
		int n=y.length;
		int[][] c=new int[m+1][n+1];
		int[][] b=new int[m+1][n+1];
		LCSLength(x,y,m,n,c,b);
//		System.out.println("C����");
//		output(c,m,n);
//		System.out.println("B����");
//		output(b,m,n);
		System.out.println("����������еĳ�����"+c[m][n]);
		System.out.print("�������������:");
		LCSOUT(b,x,m,n);
	}
}