package bruteForce;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class DeleteString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String x=sc.nextLine();
		int t=sc.nextInt();
		int[] a=new int[x.length()];
		ArrayList<Integer> list = new ArrayList<Integer>();
		int cnt=0;
		for(int i=0;i<a.length;i++) {
			a[i]=x.charAt(i)-'A';
			list.add(a[i]);
			if(list.size()>1&&cnt<t) {
				list.remove(list.indexOf(Collections.max(list)));
				cnt++;
			}
		}
		for(int i=0;i<list.size();i++) {
			System.out.print((char)(list.get(i)+'A'));
		}
		sc.close();
	}
}