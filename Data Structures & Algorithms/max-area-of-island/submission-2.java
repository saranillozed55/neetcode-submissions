class Solution {

    int[][] directions = {{-1,0},{1,0},{0,-1}, {0,1}}; // up, down, left, right

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1 && !visited[row][col]) {
                    int area = dfs(grid, row, col, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col, boolean[][] visited) {

        int rows = grid.length;
        int cols = grid[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols) return 0;

        if(grid[row][col] == 0) return 0;

        if(visited[row][col]) return 0;

        visited[row][col] = true;

        int area = 1;
        for(int[] dir : directions) {
            area += dfs(grid, row + dir[0], col + dir[1], visited);
        }
        return area;
    }
}
