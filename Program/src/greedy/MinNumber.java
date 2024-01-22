package greedy;

import java.util.Arrays;

public class MinNumber {
    public static String minNumber(int[] nums){
        StringBuffer stringBuffer=new StringBuffer();
        int n=nums.length;
        String[] str=new String[n];
        for (int i=0;i<str.length;i++){
            str[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(str, (x, y) -> (x + y).compareTo(y + x));
        for (int i=0;i<n;i++){
            stringBuffer.append(str[i]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args){
        int[] nums={3,30,34,5,9};
        System.out.println(minNumber(nums));
    }
}