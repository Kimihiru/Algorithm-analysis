package bruteForce;
public class Multiply {
	public static String multiply(String num1, String num2) {
		char[] x=num1.toCharArray();
		char[] y=num2.toCharArray();
		int n=x.length,m=y.length;
		int[] ans=new int[m+n];
		for(int i=n-1;i>=0;--i) {
			for(int j=m-1;j>=0;--j) {
				int mul=(x[i]-'0')*(y[j]-'0');
				int p1=i+j,p2=i+j+1;
				int sum=mul+ans[p2];
				ans[p2]=sum%10;
				ans[p1]+=sum/10;
			}
		}
		int index=ans[0]==0? 1:0;
		StringBuffer sb=new StringBuffer();
		while(index<(m+n)) {
			sb.append(ans[index]);
			index++;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(multiply("123", "456"));
	}
}