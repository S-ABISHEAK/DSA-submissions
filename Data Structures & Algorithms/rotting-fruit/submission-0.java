class Solution {
    public int orangesRotting(int[][] grid) {

        // This is an simple BFS too...
        int minutes = 0;

        int poss_rows[] = {-1, 1, 0, 0};
        int poss_cols[] = {0, 0, -1, 1};

        /*We need to find the number of fresh nodes...
        rotting everything is needed so we reduce the count gradually */

        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        // fresh and rotttten nodes are found.. procede with normal BFS..

        while (!q.isEmpty() && fresh > 0) {

            int initial_rotten = q.size();
            
            // Process only the rotten oranges that existed at the start of this minute.
            // Newly rotten oranges are added to the queue but will be processed in the next minute (next BFS level).

            /*
            use this level method for  : 
            
            How many minutes?
            How many levels?
            Minimum number of steps?
            Distance from source?
            Nodes at distance K?
            
            */

            for (int k = 0; k < initial_rotten; k++) {

                int temp[] = q.poll();
                int row = temp[0];
                int col = temp[1];

                // Apply the 4 possibilities

                for (int i = 0; i < 4; i++) {

                    int new_row = row + poss_rows[i];
                    int new_col = col + poss_cols[i];

                    if(new_row >= 0 && new_row < rows && 
                       new_col >= 0 && new_col < cols  &&
                       grid[new_row][new_col] == 1){ // Valid node and if node not rotten
                                                    
                        grid[new_row][new_col] = 2;
                        q.offer(new int[] {new_row , new_col});
                        fresh--;

                       }
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
