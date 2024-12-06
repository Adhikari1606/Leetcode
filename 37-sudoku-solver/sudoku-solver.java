class Solution {
    public boolean valid(char[][] board ,int row , int col, int num)
    {
        for(int i=0;i<9;i++)
        {
            if (board[row][i] == (char) (num + '0'))
            {
                return false;
            }
            if (board[i][col] == (char) (num + '0'))
            {
                return false;
            }
            int subgridRow = 3 * (row / 3) + i / 3; // Calculate row index of subgrid
            int subgridCol = 3 * (col / 3) + i % 3; //calculate col
            if(board[subgridRow][subgridCol]==(char)(num+'0'))
            {
                return false;
            }
        }
        return true;
    }

    public boolean solve(char[][] board,int row,int col)
    {
        
        if(row==board.length)
        {
            return true;
        }
        if (col == board[0].length)
        {
            return solve(board, row + 1, 0);
            
        }
        if(board[row][col]!='.')
        {
            return solve(board, row, col + 1);
        }
        for(int i=1;i<=9;i++)
        {
            if(valid(board,row,col,i))
            {
                board[row][col]=(char)(i+'0');
                if (solve(board, row, col + 1)) {
                    return true;
                }
                board[row][col] ='.';

            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    
    }
}