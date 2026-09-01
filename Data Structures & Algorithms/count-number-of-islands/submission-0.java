class Solution {
    
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
    int islands = 0;

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // must go through each cell
        //calling dfs when we land on an unvisited '1'
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == '1' && !visited[row][col]) {
                    islands++;
                    dfs(grid, row, col, visited);
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols) return;

        //don't need to check if the '0' is visited
        if(grid[row][col] == '0') return;

        if(visited[row][col]) return;

        visited[row][col] = true;

        for(int[] dir : directions) {
            dfs(grid, row + dir[0], col + dir[1], visited);
        }

    }
}
