package divideAndConquer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeSort {
	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }
	
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) { 
            temp[t] = arr[j];
            t++;
            j++;
        } 
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

	public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入数组的长度n:");
        int n=scanner.nextInt();
		List<Integer> list=new ArrayList<Integer>();
		int[] a=new int[n];
		int[] temp=new int[n];
        System.out.println("输入数组元素:");
        for(int i=0;i<n;i++) {
            a[i]=scanner.nextInt();
        }
        System.out.println("原数组:"+Arrays.toString(a));
		mergeSort(a,0,n-1,temp);
		for(int i=0;i<n;i++) {
			list.add(a[i]);
		}
		System.out.println("使用合并排序后:"+list);
		scanner.close();
	}
}