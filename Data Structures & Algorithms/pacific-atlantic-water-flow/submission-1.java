class Solution {

        int rows , cols;

        int poss_rows[] = {-1, 1, 0, 0};
        int poss_cols[] = {0, 0, -1, 1};

        int[][] heights;


    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        /*the above global variables are very important and the heights matrix also gave error so
        we create an variable with same type and name and use the this keyword */

        this.heights = heights;

        // This is an Reverse DFS we move from the oceans to the nodes...

        List<List<Integer>> answer = new ArrayList<>();

        rows = heights.length;
        cols = heights[0].length;

        
        // The needed values are defined...

        // we need to manage seperate boolean matrices for both the oceans
        // so is a same node on both the matrices are good then we can add it to the answer

        boolean pacific[][] = new boolean[rows][cols];
        boolean atlantic[][] = new boolean[rows][cols];

        // the most important thing is the set of recurssive calls..
        // from every part of each ocean PACIFIC (top + right) ATLANTIC (bottom + LEFT) needs an call

        //Because any boundary cell can be the starting point of a valid reverse-flow path.

        // Left part of land

        for(int i = 0 ; i < rows ; i++){
            rev_dfs(i, 0, pacific);
        }

        // Top part of land

        for(int j = 0 ; j < cols ; j++){
            rev_dfs(0 , j , pacific);
        }

        // Right part of land

        for(int i = 0 ; i < rows ; i++){
            rev_dfs(i , cols - 1 , atlantic);
        }

        // bottom part of land

        for(int j = 0 ; j < cols ; j++){
            rev_dfs(rows - 1 , j , atlantic);
        }

        // now simultaneously check the both boolean arrays and get the answer nodes

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){

                if(pacific[i][j] && atlantic[i][j]){
                    answer.add(Arrays.asList(i , j));
                }
            }
        }
        return answer;

    }

    public void rev_dfs(int row, int col, boolean[][] visited) {

        if (visited[row][col]) { // Check if node is visited or not
            return;
        }

        visited[row][col] = true;

        // water will flow from the higher height to lower height

        /* if we are starting from the edges then then the nodes
        adjecrnt or from where water flows should be higher */

        for (int i = 0; i < 4; i++) {
            int new_row = row + poss_rows[i];
            int new_col = col + poss_cols[i];

            // first check if the nodes are valid or not

            if (new_row >= 0 && new_row < rows && new_col >= 0 && new_col < cols) {
                // Now check if the adj. nodes are huge or equal to or not
                if (heights[new_row][new_col] >= heights[row][col]) {
                    rev_dfs(new_row, new_col, visited);
                }
            }
        }
    }
}
