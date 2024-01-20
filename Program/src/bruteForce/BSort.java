package bruteForce;
import java.util.ArrayList;
import java.util.List;
public class BSort {
	public static void swap(int arr[],int i,int j) {
		int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
	}
	public static void sort(int arr[]) {
        for(int i=0;i<arr.length;i++) {
        	for(int j=i+1;j<arr.length;j++) {
        		if(arr[i]>arr[j]) {
        			swap(arr,i,j);
        		}
        	}
        }
    }
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		int a[]= {7,2,1,5,9,10,13,3,4};
		int n=a.length;
		sort(a);
		for(int i=0;i<n;i++) {
			list.add(a[i]);
		}
		System.out.println(list);
	}
}