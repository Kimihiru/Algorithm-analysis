package dfs;

public class NumIslands {
	/*
	 * 1为岛屿，0为海洋
	 * 边界条件:grid[i][j]=='1'
	 */
	public static int numIslands(char[][] grid) {
		int ans=0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='1') {
					dfs(grid,i,j);
					ans++;
				}
			}
		}
		return ans;
	}
	/*
	 * 上下左右深度搜索
	 */
	public static void dfs(char[][] grid,int i,int j) {
		if(isNotInArea(grid,i,j)) {
			return;
		}
		grid[i][j]='0';
		dfs(grid,i-1,j);
		dfs(grid,i+1,j);
		dfs(grid,i,j-1);
		dfs(grid,i,j+1);
	}
	/*
	 * 判断是否在岛屿内
	 */
	public static boolean isNotInArea(char[][] grid,int i,int j) {
		return i>=grid.length||j>=grid[0].length||i<0||j<0||grid[i][j]=='0';
	}
	public static void main(String[] args) {
		char[][] grid= {{'1','1','1','1','0'},
						{'1','1','0','1','0'},
						{'1','1','0','0','0'},
						{'0','0','0','0','0'}};
		System.out.println(numIslands(grid));
	}
}