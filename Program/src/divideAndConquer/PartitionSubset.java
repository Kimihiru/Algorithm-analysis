package divideAndConquer;
//n��Ԫ�ػ���Ϊm���Ӽ�������
import java.util.*;
public class PartitionSubset {
	public static int f(int n,int m) {
		if(m==0&&n==0) {
			return 1;
		}
		if(m==0||m>n) {
			return 0;
		}
		if(m==1||n==m) {
			return 1;
		}else {
			return f(n-1,m-1)+m*f(n-1,m);
		}
	}
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.print("�����뼯�ϵ�Ԫ�ظ���:");
		n=sc.nextInt();
		while(n>=1) {
			int i,j;
			int sum=0;
			for(i=1;i<=n;i++) {
				j=f(n,i);
				System.out.println("f("+n+","+i+")="+j);
				sum+=j;
			}
			System.out.println("����"+n+"�����л�����Ϊ��"+sum);
			System.out.print("�����뼯�ϵ�Ԫ�ظ���:");
			n=sc.nextInt();
		}
		sc.close();
	}
}