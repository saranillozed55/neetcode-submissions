class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        
        for(int c = 0; c < COLS ; c++) {
            // go through every single column in the first row, so 0, c
            dfs(0, c, heights, pac); // pacific ocean all columns,
            dfs(ROWS - 1, c, heights, atl);
        }
        //go through every single row for pacific and atlantic ocean
        for(int r = 0; r < ROWS; r++) {
            dfs(r, 0, heights, pac);
            dfs(r, COLS - 1, heights, atl);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public void dfs(int row, int col, int[][] heights, boolean[][] ocean) {
        ocean[row][col] = true;
        for(int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && !ocean[nr][nc] && heights[nr][nc] >= heights[row][col]) {
                dfs(nr,nc, heights, ocean);
            }
        }
    }
}
