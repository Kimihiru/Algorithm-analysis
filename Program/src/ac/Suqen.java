package ac;

import java.util.*;

public class Suqen {
	public static boolean isPrime(int x) {
		for(int i=2;i*i<=x;i++) {
			if(x%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int n=sc.nextInt();
		int weeks=n/(5*a+2*b);
		int days=1;
		int sum=0;
		while(sum<n%(5*a+2*b)) {
			if(days%7<6&&days%7>0) {
				sum+=a;
				days++;
			}
			else {
				sum+=b;
				days++;
			}
		}
		System.out.println(7*weeks+days-1);
		sc.close();
	}
}