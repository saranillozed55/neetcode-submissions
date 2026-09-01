class Solution {

    int[][] directions = {{-1,0},{1,0},{0,-1}, {0,1}}; // up, down, left, right

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int originalColor = image[sr][sc];
        dfs(image, sr, sc, visited, color, originalColor);
        return image;
    }

    public void dfs(int[][] image, int row, int col, boolean[][] visited, int color, int originalColor) {
        int rows = image.length;
        int cols = image[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols) return;

        if(visited[row][col]) return;

         if(image[row][col] != originalColor) return;
        //set to visited = true
        visited[row][col] = true;
        
        image[row][col] = color;

        //check adjacent - horizontal or vertical
        for(int[] dir : directions) {
            dfs(image, row + dir[0], col + dir[1], visited, color, originalColor);
        }
    }
}