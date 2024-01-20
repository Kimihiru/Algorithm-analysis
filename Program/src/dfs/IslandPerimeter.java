package dfs;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==1) {
					return dfs(grid,i,j);
				}
			}
		}
		return 0;
	}
	public static int dfs(int[][] grid,int i,int j) {
		if(isNotInArea(grid,i,j)||grid[i][j]==0) {
			return 1;
		}
		if(grid[i][j]!=1) {
			return 0;
		}
		grid[i][j]=2;
		return dfs(grid,i-1,j)+dfs(grid,i+1,j)+dfs(grid,i,j-1)+dfs(grid,i,j+1);
	}
	public static boolean isNotInArea(int[][] grid,int i,int j) {
		return i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
