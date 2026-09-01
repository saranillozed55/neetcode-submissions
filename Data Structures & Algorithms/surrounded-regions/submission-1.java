class Solution {
    public void solve(char[][] board) {
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        //positions of cells 
        Queue<int[]> q = new LinkedList<>();

        int ROWS = board.length;
        int COLS = board[0].length;

        //place all bordering 'O's into the queue
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                //check if the current element is on any of the 4 edges
                if((r == 0 || c == 0 || r == ROWS - 1 || c == COLS - 1) && board[r][c] == 'O') {
                    q.offer(new int[]{r,c});
                    board[r][c] = '#';
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                //if there are any 'O's connected to this edge 'O' then it is also safe.
                //Can't surround 'O's if atleast one of them is at the edge
                if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && board[nr][nc] == 'O'){
                    board[nr][nc] = '#';
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        //Traverse matrix again and find all the remaining 'O's because they are now captured
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                else if(board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
