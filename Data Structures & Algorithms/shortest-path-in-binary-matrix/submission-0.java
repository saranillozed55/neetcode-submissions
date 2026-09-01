class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] directions = {
    {-1,0}, {1,0}, {0,-1}, {0,1},
    {-1,-1}, {-1,1}, {1,-1}, {1,1}
};
        int rows = grid.length;
        int cols = grid[0].length;
        int botRow = rows - 1;
        int botCol = cols - 1;
        int distance = 1;
        
        if(grid[0][0] == 1 || grid[botRow][botCol] == 1) return -1;

        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];

                if(row == botRow && col == botCol) {
                    return distance;
                }
                
                for(int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // 1 is an obstacle
                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                    && grid[newRow][newCol] != 1 && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        q.offer(new int[]{newRow, newCol});
                    } 
                }
            }
            distance++;
        }
        return -1;
    }
}