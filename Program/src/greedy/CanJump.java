package greedy;
//贪心选择：每次选择当前状态下最大的能量值e
public class CanJump {
	public static boolean canJump(int[] nums) {
		int m=nums.length;
		int e=0;
		for(int i=0;i<m;i++) {
			if(i<=e) {
				e=Math.max(e, i+nums[i]);
				if(e>=m-1) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] nums= {3,2,1,1,4};
		System.out.println(canJump(nums));
	}
}
