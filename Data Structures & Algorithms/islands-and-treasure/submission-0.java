class Solution {
    public void islandsAndTreasure(int[][] grid) {

        // We can solve this with simple BFS...
        Queue<int[]> q = new LinkedList<>();
        // We move from the treasure to the rest of the nodes for easier calculations

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        // Now the usual BFS method... 

        int poss_rows[] = {-1 , 1 , 0 , 0};
        int poss_cols[] = {0 , 0 , -1 , 1};

        while(!q.isEmpty()){

            int temp[] = q.poll();
            int row = temp[0];
            int col = temp[1];

            for(int k = 0 ; k < 4 ; k++){
                int new_row = row + poss_rows[k];
                int new_col = col + poss_cols[k];

                // just like BFS look at four directions and check for land == MAX VALUE
                if(new_row >= 0 && new_row < rows &&
                    new_col >= 0 && new_col < cols &&
                    grid[new_row][new_col] == Integer.MAX_VALUE){
                        
                        // If Land add to the Queue , new Land (neighbour) val becomes center land + 1
                        q.offer(new int[] {new_row , new_col});
                        grid[new_row][new_col] = grid[row][col] + 1;
                    }
            }
        }
        
    }
}
