package bruteForce;
public class Main {
	public static void countChar(String s) {
		int[] ch=new int[26];
		int n=s.length();
		for(int i=0;i<n;i++) {
			char word=s.charAt(i);
			ch[word-'a']++;
		}
		int max=0;
		char ch2='a';
		for(int i=0;i<ch.length;i++) {
			if(max<ch[i]) {
				max=ch[i];
				ch2=(char)('a'+i);
			}
		}
		System.out.println(max);
		System.out.println(ch2);
	}
	
	public static void countCharUpperCase(String s) {
		char[] x=new char[26];
		int n=s.length();
		for(int i=0;i<n;i++) {
			x[s.charAt(i)-'A']++;
		}
		int max=0;
		for(int i=0;i<26;i++) {
			max=Math.max(max, x[i]);
		}
		for(int i=0;i<26;i++) {
			if(x[i]==max) {
				System.out.print((char)('A'+i));
			}
		}
	}
	
	public static int gcd(int m,int n) {
		while (n!=0) {
			int r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
	
	public static int reducedFraction(int n) {
		int ans=0;
		for (int i = 1; i < n;i++) {
			for (int j = 1; j < n;j++) {
				if (gcd(i,j)==1) {
					ans++;
				}
			}
		}
		return ans;
	}
	
	public static void perfectNumber(int n) {
		for (int m = 2; m <= n;m++) {
			int s=0;
			for (int i = 1; i < m;i++) {
				if (m%i==0) {
					s += i;
				}
			}
			if (m==s) {
				System.out.println(m);
			}
		}
	}
	
	public static int makeAHouseNumber(int m,int n) {
		int ans=0;
		for (int i = 1; i < m;i++) {
			if (i/1000==n) {
				ans++;
			}
			if ((i/100)%10==n) {
				ans++;
			}
			if ((i/10)%10==n) {
				ans++;
			}
			if (i%10==n) {
				ans++;
			}
		}
		return ans;
	}
	
	public static int count(int n) {
		int ans=0;
		for(int i=1;i<n;i++)
			if(String.valueOf(i).contains("2"))
				ans++;
		return ans;
	}
	
	//环状修改数组
	public static void rotate(int[] nums, int k) {
		int n=nums.length;
		k=k%n;
		int count=regcd(k,n);
		for(int start=0;start<count;start++) {
			int current=start;
			int prev=nums[start];
			do {
				int next=(current+k)%n;
				int temp=nums[next];
				nums[next]=prev;
				prev=temp;
				current=next;
			}while(start!=current);
		}
	}
	
	public static int regcd(int m,int n) {
		return n>0? regcd(n,m%n):m;
	}
	
	public static void main(String[] args) {
		countChar("waterbottle");
		System.out.println(makeAHouseNumber(2021,2));
		perfectNumber(10000);
		System.out.println(reducedFraction(2021));
		System.out.println(count(2023));
		countCharUpperCase("BABBACAC");
		System.out.println();
		int[] arr= {1,2,3,4,5,6,7};
		rotate(arr,4);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}