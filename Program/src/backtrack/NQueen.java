package backtrack;
import java.util.Scanner;
public class NQueen {
	public static int n;
	public static int[] x;
	public static long sum=0;
	public static boolean place(int k) {
		for (int j = 1; j < k; j++) {
			if ((Math.abs(k - j) == Math.abs(x[j] - x[k])) || (x[k] == x[j])) {
				return false;
			}
		}
		return true;
	}
	public static void backTrack(int t) {
		if (t > n) {
			output();
			sum++;
		}else {
			for (int i = 1; i <= n; i++) {
				x[t] = i;
				if(place(t)) {
					backTrack(t+1);
				}
			}
		}
	}
	public static void output() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j == x[i]) {
					System.out.print("Q"+" ");
				}else {
					System.out.print("."+" ");
				}
			}
			System.out.println("\t"+"第"+i+"个皇后放在棋盘的第"+x[i]+"列");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print("请输入皇后的个数,0结束程序：");
			n=sc.nextInt();
			if(n<=0)break;
			x=new int[n+1];
			System.out.println(n+"皇后问题的各种摆法如下：");
			backTrack(1);
			System.out.println(n+"个皇后，共有 "+sum+"种摆法。");
		}
		sc.close();
	}
}