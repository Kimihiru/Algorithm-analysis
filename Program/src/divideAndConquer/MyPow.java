package divideAndConquer;

import java.util.Scanner;

/**
 * @author Sakura
 * 使用分治算法实现pow函数
 */
public class MyPow {
    /**
     * 分治+递归
     * 时间复杂度O(logn)
     * 空间复杂度O(logn)
     */
    public static double recursionPow(double x,long n){
        long N=n;
        return N>=0? recursionQuickMul(x,N):1.0/recursionQuickMul(x,-N);
    }
    public static double recursionQuickMul(double x,long N){
        if(N==0){
            return 1.0;
        }
        double y=recursionQuickMul(x,N/2);
        return N%2==0? y*y:y*y*x;
    }

    /**
     * 分治+迭代
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     */
    public static double iterationPow(double x,long n){
        long N=n;
        return N>=0? iterationQuickMul(x,N):1.0/iterationQuickMul(x,-N);
    }
    public static double iterationQuickMul(double x,long N){
        double ans=1.0;
        double contribute=x;
        while (N>0){
            if(N%2==1){
                ans*=contribute;
            }
            contribute*=contribute;
            N/=2;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("输入x:");
        double x=sc.nextDouble();
        System.out.print("输入n:");
        long n=sc.nextLong();
        System.out.println("分治+递归实现pow函数:"+recursionPow(x,n));
        System.out.println("分治+迭代实现pow函数:"+iterationPow(x,n));
        sc.close();
    }
}