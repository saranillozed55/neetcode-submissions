class Solution {


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor == color) return image;
        int[][] directions = {{-1,0},{1,0},{0,-1}, {0,1}}; // up, down, left, right
        int rows = image.length;
        int cols = image[0].length;

        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        visited[sr][sc] = true;
        image[sr][sc] = color;

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] == originalColor) {
                    image[newRow][newCol] = color;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
        return image;
    }
}