class Solution {
    
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int MAX = Integer.MAX_VALUE;
        
        Queue<int[]> q = new LinkedList<>();

        // place all treasure chests into the queue
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 0) {
                    q.offer(new int[]{r,c});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];

            for(int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && grid[nr][nc] == MAX){
                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
