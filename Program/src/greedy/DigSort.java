package greedy;

import java.util.*;

public class DigSort {
	public static int digNum(int x) {
		int sum=0;
		while(x>0) {
			sum+=x%10;
			x/=10;
		}
		return sum;
	}
	public static void swap(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static int partition(int[] a,int p,int r) {
		int i=p;
		int j=r+1;
		int x=a[p];
		while(true) {
			while(a[++i]<x&&i<r) {}
			while(a[--j]>x) {}
			if(i>=j) {
				break;
			}
			else {
				swap(a,i,j);
			}
		}
		a[p]=a[j];
		a[j]=x;
		return j;
	}
	public static void quickSort(int[] a,int p,int r) {
		if(p<r) {
			int q=partition(a,p,r);
			quickSort(a,p,q-1);
			quickSort(a,q+1,r);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=13;
		int m=5;
		Integer[] x=new Integer[n];
		for(int i=0;i<n;i++) {
			x[i]=i+1;
		}
		//quickSort(y,0,y.length-1);
		Arrays.sort(x,(o1,o2)->digNum(o1)!=digNum(o2)? digNum(o1)-digNum(o2):o1-o2);
		System.out.println(x[m-1]);
		sc.close();
	}
}