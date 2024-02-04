package dp;

import java.util.Scanner;

/*
 * @author Sakura
 * dp解斐波那契数列
 * 分治解斐波那契数列
 */
public class Fib {
    /*
     *分治算法
     *执行用时:9ms
     */
    public static int fib(int n){
        return n<2? n:fib(n-1)+fib(n-2);
    }
    /*
     *动态规划算法
     *执行用时:0ms
     */
    public static int dpFib(int n){
        if(n<2){
            return n;
        }
        int[] dp=new int[n+1];
        dp[0]=1;dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("输入n:");
        int n=sc.nextInt();
        System.out.println(dpFib(n));
        sc.close();
    }
}
