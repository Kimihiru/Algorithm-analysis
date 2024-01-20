package divideAndConquer;

public class BinarySearch {
	public static int search(int[] nums, int target) {
		int n=nums.length;
		int left=0;
		int right=n-1;
		if(n==0) {
			return -1;
		}
		while(left<=right) {
			int mid=(left+right)/2;
			if(nums[mid]==target) {
				return mid;
			}
			else if(nums[mid]<target) {
				left=mid+1;
			}
			else if(nums[mid]>target) {
				right=mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] nums= {-1,0,3,5,9,12};
		int target=13;
		System.out.println(search(nums,target));
	}
}
