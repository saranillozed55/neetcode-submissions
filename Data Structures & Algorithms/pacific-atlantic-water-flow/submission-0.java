class Solution {
    //dfs solution
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        
        for(int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pac);
            dfs(heights, rows - 1, c, atl);
        }

        for(int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pac);
            dfs(heights, r, cols - 1, atl);
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(pac[row][col] && atl[row][col]) {
                    res.add(Arrays.asList(row,col));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, int row, int col, boolean[][] ocean) {
        
        ocean[row][col] = true;

        for(int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length && !ocean[newRow][newCol] && heights[newRow][newCol] >= heights[row][col])
                dfs(heights, newRow, newCol, ocean);
            }
        }

    }

