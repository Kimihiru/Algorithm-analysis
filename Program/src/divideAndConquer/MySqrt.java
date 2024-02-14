package divideAndConquer;
import java.util.Scanner;
/**
 * @author Sakura
 * 使用分治算法以及数学归纳法实现sqrt函数
 */
public class MySqrt {
    /**
     * 二分查找
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     */
    public static int binarySqrt(int x){
        int l=0, r=x, ans=-1;
        while (l<=r){
            int mid=(l+r)/2;
            if((long)mid*mid<=x){
                ans=mid;
                l=mid+1;
            }
            else {
                r=mid-1;
            }
        }
        return ans;
    }
    /**
     * 数学归纳法:牛顿迭代法
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     */
    public static int newtonSqrt(int x){
        if(x==0){
            return 0;
        }
        double C=x, x0=x;
        while (true){
            double xi=0.5*(x0+C/x0);
            if(Math.abs(x0-xi)<1e-7){
                break;
            }
            x0=xi;
        }
        return (int)x0;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("输入x:");
        int x=sc.nextInt();
        System.out.println("使用二分查找求解x的平方根,"+x+"的平方根:"+binarySqrt(x));
        System.out.println("使用牛顿迭代法求解x的平方根,"+x+"的平方根:"+newtonSqrt(x));
        sc.close();
    }
}