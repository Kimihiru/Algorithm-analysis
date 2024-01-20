package ac;
import java.util.Arrays;
public class GradeAnaylize {
	public static void main(String[] args) {
		int[] x= {80,92,56,74,88,99,10};
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		double sum=Arrays.stream(x).sum();
		double avg=sum/x.length;
		for(int i=0;i<x.length;i++) {
			max=Math.max(x[i], max);
			min=Math.min(x[i], min);
		}
		System.out.println(max);
		System.out.println(min);
		System.out.printf("%.2f",avg);
	}
}