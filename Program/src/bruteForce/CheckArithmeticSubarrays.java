package bruteForce;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CheckArithmeticSubarrays {
	public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r){
		List<Boolean> list=new ArrayList<Boolean>();
		int m=l.length;
		for(int i=0;i<m;i++) {
			int[] ans=Arrays.copyOfRange(nums, l[i], r[i]+1);
			Arrays.sort(ans);
			int d=ans[1]-ans[0];
			boolean x=true;
			for(int j=1;j<=Math.abs(l[i]-r[i]);j++) {
				if(d!=ans[j]-ans[j-1]) {
					x=false;
					break;
				}
			}
			list.add(x);
		}
		return list;
	}
}