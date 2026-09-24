class Solution {

    int rows , cols;

    int poss_rows[] = {-1 , 1 , 0 , 0};
    int poss_cols[] = {0 , 0 , -1 , 1};

    char board[][];

    public void solve(char[][] board) {
        
        // This is another Reverse DFS too... 
        //Move from the edges then to the mid 
        // from now i think it is best practice to put the 4 directions, input matrix and length as global

        this.board = board;

        // get the values for the global values

        rows = board.length;
        cols = board[0].length;

        // Check the edge values first for 'O' in them if there is then apply the dfs on them

        // this is for LEFT and then RIGHT
        for(int i = 0 ; i < rows ; i++){
            if(board[i][0] == 'O'){
                dfs(i , 0);
            }
            if(board[i][cols -1] == 'O'){
                dfs(i , cols - 1);
            }
        }

        // this is for TOP and then BOTTOM
        for(int j = 0 ; j < cols ; j++){
            if(board[0][j] == 'O'){
                dfs(0 , j);
            }
            if(board[rows - 1][j] == 'O'){
                dfs(rows - 1 , j);
            }
        }

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){

                // this works once all teh operations on the board is done
                // if the value is 'O' then change it to 'X'
                // And if the value is '#' then change it to 'O';

                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
                
            }
        }
    }

    public void dfs(int row , int col){
        
        // check for the validity for the nodes
        // since we are not using seperate loops for each side we need to make this check

        if(row < 0 || row >= rows || col < 0 || col >= cols){ // row >= rows bcor real row + 1 = rows (length function)
            return;
        }

        // check if the the node is not an 'O'
        if(board[row][col] != 'O'){
            return;
        }

        // We are marking this bcoz to prove that the node is really an edge and good node
        board[row][col] = '#';

        // check the 4 directons nodes 

        for(int i = 0 ; i < 4 ; i++){

            int new_row = row + poss_rows[i];
            int new_col = col + poss_cols[i];

            // Apply the dfs on the new nodes

            dfs(new_row , new_col);
        }
    }
}
