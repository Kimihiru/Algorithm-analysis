package math;
public class JudgeSquareSum {
	public static boolean judgeSquareSum(int c) {
		for(int i=2;i*i<=c;i++) {
			if(c%i!=0) {
				continue;
			}
			int exp=0;
			while(c%i==0) {
				c/=i;
				exp++;
			}
			if(i%4==3&&exp%2!=0) {
				return false;
			}
		}
		return c%4!=3;
	}
	public static void main(String[] args) {
		int c=5;
		System.out.println(judgeSquareSum(c));
	}
}