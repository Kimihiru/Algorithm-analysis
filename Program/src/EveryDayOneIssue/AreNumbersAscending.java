package EveryDayOneIssue;
public class AreNumbersAscending {
	public static boolean areNumbersAscending(String s) {
		int i=-1;
		for(String str:s.split(" ")) {
			try {
				int j=Integer.parseInt(str);
				if(j<=i) {
					return false;
				}
				i=j;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String s="1 box has 3 blue 4 red 6 green and 12 yellow marbles";
		System.out.println(areNumbersAscending(s));
	}
}
//知识点：split分词