class Solution {
    public int numIslands(char[][] grid) {
        // can be solved with simple BFS..

        int rows = grid.length;
        int cols = grid[0].length;

        int[] poss_r = {-1, 1, 0, 0};
        int[] poss_c = {0, 0, -1, 1};

        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // check if the block is an island

                if (grid[r][c] == '1') {
                    islands++;

                    // If it is an island add it to an Queue to check its neighbours later
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {r, c});

                    grid[r][c] = '0'; // mark as visited

                    while (!q.isEmpty()) {
                        int[] temp = q.poll();
                        int row = temp[0];
                        int col = temp[1];

                        // Get the top of the queue and their row and column value
                        // we need to check the top , down , left and right of the node we extracted

                        for (int i = 0; i < 4; i++) {
                            int new_row = row + poss_r[i];
                            int new_col = col + poss_c[i];

                            if (new_row >= 0 && new_row < rows && new_col >= 0 && new_col < cols
                                && grid[new_row][new_col] == '1') {
                                // mark it as visited

                                grid[new_row][new_col] = '0';

                                // add it to the queue for future processing

                                q.offer(new int[] {new_row, new_col});
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}
