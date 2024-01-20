package bruteForce;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Line {
	public static int gcd(int m,int n) {
		while(n!=0) {
			int r=m%n;
			m=n;
			n=r;
		}
		return m;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		Set<String> ans=new HashSet<>();
		for(int x1=0;x1<x;x1++) {
			for(int x2=0;x2<x;x2++) {
				for(int y1=0;y1<y;y1++) {
					for(int y2=0;y2<y;y2++) {
						if(x1==x2||y1==y2) {
							continue;
						}
						StringBuilder sb=new StringBuilder();
						int a=x2-x1,b=y2-y1,t=gcd(b,a);
						sb.append(b/t+" ");sb.append(a/t+" ");
						int m=y1*a-b*x1;
						t=gcd(m,a);
						sb.append(m/t+" ");sb.append(a/t+" ");
						ans.add(sb.toString());
					}
				}
			}
		}
		System.out.println(ans.size()+x+y);
		sc.close();
	}
}
