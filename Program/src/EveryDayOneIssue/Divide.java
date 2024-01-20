package EveryDayOneIssue;

public class Divide {
	public static int divide(int dividend, int divisor) {
		int count=0;
		int a=Math.abs(dividend);
		int b=Math.abs(divisor);
		int c=a-b;
		if(a==0||a<b) {
			return 0;
		}
		try {
			while(c>=b) {
				count++;
				a=c;
				c=a-b;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(dividend<0&&divisor<0) {
			count=count+1;
		}
		else if(dividend<0||divisor<0){
			count=-count-1;
		}
		else{
			count=count+1;
		}
		return count;
	}
	public static void main(String[] args) {
		int dividend=-2147483648;
		int divisor=-1;
		System.out.println(divide(dividend, divisor));
	}
}
