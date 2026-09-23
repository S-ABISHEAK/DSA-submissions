class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        // Solve this with an simple BFS..
        int poss_row[] = {-1 , 1 , 0 , 0};
        int poss_col[] = {0 , 0 , -1 , 1};

        int max_size = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){

                if(grid[r][c] == 1){

                    //consider this as visited ?? 
                    grid[r][c] = 0;

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {r,c});

                    int curr_size = 1;

                    while(!q.isEmpty()){
                        
                        
                        int temp[] = new int[2];
                        temp = q.poll();

                        int row = temp[0];
                        int col = temp[1];

                        for(int i = 0 ; i < 4 ; i++){

                            int new_row = row + poss_row[i];
                            int new_col = col + poss_col[i];

                            if(new_row >= 0 && new_row < rows
                               && new_col >= 0 && new_col < cols &&
                               grid[new_row][new_col] == 1){

                                curr_size++;
                                grid[new_row][new_col] = 0;
                                q.offer(new int[] {new_row , new_col});

                               }
                        }

                    }
                    max_size = Math.max(max_size , curr_size);
                }
            }
        }
        return max_size;
    }
}