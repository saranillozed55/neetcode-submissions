class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{-1, 0}, {1, 0}, {0,-1}, {0,1}};
        int level = 0;
        int numFresh = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 2) {
                    q.offer(new int[]{row,col});
                    visited[row][col] = true;
                }
                else if(grid[row][col] == 1) {
                    numFresh++;
                }
            }
        }

        if(numFresh == 0) {
            return level;
        }

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];

                for(int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && 
                    grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        grid[newRow][newCol] = 2;
                        numFresh--;
                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
            level++;
            if(numFresh == 0) {
                return level;
            }
        }
        return -1;
    }
}
