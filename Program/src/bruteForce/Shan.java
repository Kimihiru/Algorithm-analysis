package bruteForce;
import java.util.*;
public class Shan {
	public static boolean isHill(int x) {
		String s=new StringBuilder(x+"").reverse().toString();
		if(s.equals(String.valueOf(x))&&isLeftIncrease(x)&&isRightDecrease(x)) {
			return true;
		}
		return false;
	}
	public static boolean isLeftIncrease(int x) {
		int l=String.valueOf(x).length();
		int[] arr=new int[l];
		for(int i=0;i<l;i++) {
			arr[i]=(int) ((x/Math.pow(10,l-i-1))%10);
		}
		if(l%2==0) {
			for(int i=0;i<l/2-1;i++) {
				if(arr[i+1]<arr[i]) {
					return false;
				}
			}
		}
		else if(l%2!=0) {
			for(int i=0;i<l/2;i++) {
				if(arr[i+1]<arr[i]) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isRightDecrease(int x) {
		int l=String.valueOf(x).length();
		int[] arr=new int[l];
		for(int i=0;i<l;i++) {
			arr[i]=(int) ((x/Math.pow(10,l-i-1))%10);
		}
		if(l%2==0) {
			for(int i=l/2;i<l-1;i++) {
				if(arr[i+1]>arr[i]) {
					return false;
				}
			}
		}
		else if(l%2!=0) {
			for(int i=l/2;i<l-1;i++) {
				if(arr[i+1]>arr[i]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int ans=0;
		for(int i=2022;i<=2022222022;i++) {
			if(isHill(i)) {
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}