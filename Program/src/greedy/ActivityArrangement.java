package greedy;
import java.util.Scanner;
public class ActivityArrangement {
	public static void GreedySelector(int n,int s[],int f[],boolean A[]) {
		A[1] = true;
		int j = 1;
		for (int i = 2; i <= n; i++) {
			if (s[i] >= f[j]) {
				A[i] = true;
				j = i;
			}
			else {
				A[i] = false;
			}
		}
	}
	public static void QuickSort(int a[], int p, int r, int b[]){
	    if (p < r) {
	        int q = Partition(a, p, r,b);
	        QuickSort(a, p, q - 1,b); 
	        QuickSort(a, q + 1, r,b); 
	    }
	}

	public static int Partition(int a[], int p, int r,int b[]){
	    int i = p, j = r + 1;
	    int x = a[p];
	    int y = b[p];
	    // 将< x的元素交换到左边区域
	    // 将> x的元素交换到右边区域
	    while (true) {
	        while (a[++i] < x ) ;  //先做 i=i+1;  再做 a[i]<x;
	        while (a[--j] > x) ;
	        if (i >= j) break;
	        Swap(a, j, i);
	        Swap(b, j, i);
	    }
	    a[p] = a[j];
	    a[j] = x;
	    b[p] = b[j];
	    b[j] = y;
	    return j;
	}
	public static void Swap(int a[], int j, int i) {
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print("请输入活动的个数,n=");
			int n=sc.nextInt();
			int[] s=new int[n+1];
			int[] f=new int[n+1];
			boolean[] A=new boolean[n+1];
			if(n==0) {
				break;
			}
			System.out.println("请分别输入开始时间s[i]和结束时间f[i]:");
			for (int i = 1; i <= n; i++) {
				System.out.print("s["+i+"]=");
				s[i]=sc.nextInt();
				System.out.print("f["+i+"]=");
				f[i]=sc.nextInt();
				System.out.println();
			}
			QuickSort(f, 1, n, s);
			System.out.println("按结束时间非减序排列如下:");
			System.out.println(" "+"序号  开始时间  结束时间");
			System.out.println("--------------------------------");
			for (int i = 1; i <= n; i++) {
				System.out.println(i+" "+s[i]+" "+f[i]);
			}
			System.out.println("--------------------------------");
			GreedySelector(n, s, f, A);
			System.out.println("安排的活动序号依次为：");
			for (int i = 1; i <= n; i++) {
	            if (A[i]) {
	            	System.out.println(i+" "+s[i]+"-->"+f[i]);
	            }
	        }
			System.out.println();
		}
		sc.close();
	}
}