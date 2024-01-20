package bruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class LessDo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		int[] copy=Arrays.copyOf(arr, N);
		Arrays.sort(copy);
		int mid=(0+N)/2;
		int more=0,less=0,flag=0;
		for(int i=0;i<N;i++) {
			if(arr[i]<copy[mid]) {more++;}
			if(arr[i]>copy[mid]) {less++;}
		}
		System.out.println(more+"\t"+less);
		if(more>=less) {flag=1;}
		for(int i=0;i<N;i++) {
			if(arr[i]<copy[mid]) {
				arr[i]=copy[mid]-arr[i]+flag;
			}
			else {
				arr[i]=0;
			}
		}
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}
