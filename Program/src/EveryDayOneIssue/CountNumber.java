package EveryDayOneIssue;
import java.util.Scanner;
public class CountNumber {
	public static int weishu(int n) {
		int i = 0;
		while (n>0) {
			n /= 10;
			i++;
		}
		return i;
	}
	public static int zuigao(int n) {
		return n / (int)Math.pow(10.0, weishu(n)-1);
	}
	public static int yushu(int n) {
		return n % (int)Math.pow(10.0, weishu(n) - 1);
	}
	public static int f(int n) {
		return n * (int)Math.pow(10.0, n - 1);
	}
	public static int ling(int n) {
		return (1*(1 - (int)Math.pow(10.0, weishu(n)))) / (1 - 10);
	}
	public static void CountDigit(int page, int num[]) {
		int n = weishu(page);
		int m = zuigao(page);
		int m1 = yushu(page);
		int x = f(n - 1);
		for (int i = 0; i < 10; i++) {
			num[i] += x * m;
		}
		for (int i = 0; i < m; i++) {
			num[i] += (int)Math.pow(10.0, n - 1);
		}
		num[m] += m1 + 1;
		num[0] += (n - weishu(m1) - 1) * (m1 + 1);
		if (m1 == 0) {
			return;
		}
		else {
			CountDigit(m1, num);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print("请输入一个页码,以0结束程序:");
			int page=sc.nextInt();
			if (page == 0) {
				break;
			}
			int num[] = new int[10];
			CountDigit(page, num);
			num[0] -= ling(page);
			System.out.println("数字0~9出现的次数分别为：");
			for(int i = 0; i < 10; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}