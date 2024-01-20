package divideAndConquer;
import java.util.*;
public class MyQuickSort {
//	public static int count=1;
	public static void QuickSort(int a[], int p, int r) {
	    if (p < r) {
	        int q = Partition(a, p, r);
	        QuickSort(a, p, q - 1); //¶Ô×ó°ë¶ÎÅÅÐò
	        QuickSort(a, q + 1, r); //¶ÔÓÒ°ë¶ÎÅÅÐò
	    }
	}
	public static void Swap(int a[], int i, int j) {
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	public static int Partition(int a[], int p, int r) {
	    int i = p, j = r + 1;
	    int x = a[p];
	    while (true) {
	        while (a[++i]<x&&i<r) {}
	        while (a[--j]>x) {}
	        if (i>=j) {
	        	break;
	        }
	        else {
	            Swap(a, i, j);
	        }
	    }
//	    System.out.print("µÚ"+count+"ÌË");
//	    for(int k=0;k<a.length;k++) {
//	    	System.out.print(a[k]+" ");
//	    }
//	    System.out.println();
//	    count++;
	    a[p] = a[j];
	    a[j] = x;
	    return j;
	}
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		int a[]= {7,2,1,5,9,10,13,3,4};
		int n=a.length;
		QuickSort(a,0,n-1);
		for(int i=0;i<n;i++) {
			list.add(a[i]);
		}
		System.out.println(list);	
	}
}