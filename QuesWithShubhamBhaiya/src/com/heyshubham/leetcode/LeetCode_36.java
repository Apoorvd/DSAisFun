package com.heyshubham.leetcode;

public class LeetCode_36 {

    //https://leetcode.com/problems/valid-sudoku/

        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                // Represent the value  [  1,     2,     3,     4,     5,     6,     7,     8,     9  ]
                boolean[] appearedRow = {false, false, false, false, false, false, false, false, false};
                boolean[] appearedCol = {false, false, false, false, false, false, false, false, false};
                boolean[] appearedBox = {false, false, false, false, false, false, false, false, false};
                for (int j = 0; j < 9; j++) {
                    // Check validity for rows
                    int val = board[i][j];
                    if (val != (int) '.') {
                        val -= '1';
                        if (appearedRow[val] == true) {
                            return false;
                        }
                        appearedRow[val] = true;
                    }


                    // Check validity for columns
                    val = board[j][i];
                    if (val != (int) '.') {
                        val -= '1';
                        if (appearedCol[val] == true) {
                            return false;
                        }
                        appearedCol[val] = true;
                    }


                    // Check validity of grids
                    val = board[((i % 3) * 3) + (j % 3)][((i / 3) * 3) + (j / 3)];
                    if (val != (int) '.') {
                        val -= '1';
                        if (appearedBox[val] == true) {
                            return false;
                        }
                        appearedBox[val] = true;
                    }

                }
            }

            return true;
        }
}

/*
public boolean isValidSudoku(char[][] board)
    {
        Set<String> hs = new HashSet<>();

        for(int i=0;i<9;i++)//Loop through the complete matrix
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    String row = board[i][j] + "in row" + i;//Make a unique key for every element
                    String col = board[i][j] + "in col" + j;
                    String mat = board[i][j] + "in mat" + i/3 + "and" + j/3;

                    if(hs.contains(row) || hs.contains(col) || hs.contains(mat))
                        return false;//If any of them is already contained in our hashset, simply return false.

					//If none of the above condition matches then we add all the unique keys for a particular number.

                    hs.add(row);
                    hs.add(col);
                    hs.add(mat);
                }
            }
        }
        return true;
    }
 */


/*
private final static int BOARD_SIZE = 81;
    private final static int SUB_GRID_SIZE = 3;

    public boolean isValidSudoku(char[][] board) {
        System.gc();
        HashSet<Character>[] rowSets = new HashSet[board.length];
        HashSet<Character>[][] subSets = new HashSet[SUB_GRID_SIZE][SUB_GRID_SIZE];

        int k;
        for(int i=0;i<board.length;i++){
            rowSets[i] = new HashSet<Character>();
            if(i%3==0){
                k = i/3;
                for(int j=0;j<SUB_GRID_SIZE;j++){
                    subSets[k][j] = new HashSet<Character>();
                }
            }
        }

        int[] rowMisses = new int[board.length];
        int[][] subSetMisses = new int[SUB_GRID_SIZE][SUB_GRID_SIZE];
        HashSet<Character> colSet = new HashSet<Character>();

        char c;
        int row, col=0, colMiss=0, rowMiss=0, subCol=0,subRow=0;
        for(int i=0;i<BOARD_SIZE;i++){
            row = i / board.length;
            col = i % board.length;
            c = board[row][col];

            if(i!=0 && col % board.length == 0){
                if(colSet.size()+colMiss!=9){
                    return false;
                }
                colSet.clear();
                colMiss=0;
            }

            subCol = col / SUB_GRID_SIZE;
            subRow = i / 27;

            if(c!='.'){
                colSet.add(c);
                rowSets[col].add(c);
                subSets[subRow][subCol].add(c);

            }else{
                colMiss++;
                rowMisses[col]++;
                subSetMisses[subRow][subCol]++;
            }
        }
        if(colSet.size()+colMiss!=9){
                return false;
        }
        k=0;
        for(int i=0;i<subSets.length;i++){
            for(int j=0;j<subSets[0].length;j++){
                if(subSets[i][j].size()+subSetMisses[i][j]!=9){
                    return false;
                }
                if(rowSets[k].size()+rowMisses[k]!=9){
                    return false;
                }
                k++;
            }
        }

        return true;
    }
 */


/*
public boolean isValidSudoku(char[][] board) {
        return validateRows(board) && validateCols(board) && validateBoxes(board);
    }

    private boolean validateRows(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            if(!validateRow(board, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateRow(char[][] board, int row) {
        boolean[] seen = new boolean[9];
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == '.') {
                continue;
            }
            final int val = board[row][i] - '1';
            if(seen[val]) {
                return false;
            }
            seen[val] = true;
        }
        return true;
    }

    private boolean validateCols(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            if(!validateCol(board, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateCol(char[][] board, int col) {
        boolean[] seen = new boolean[9];
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == '.') {
                continue;
            }
            final int val = board[i][col] - '1';
            if(seen[val]) {
                return false;
            }
            seen[val] = true;
        }
        return true;
    }

    private boolean validateBoxes(char[][] board) {
        for(int row = 0; row <= 6; row += 3) {
            for(int col = 0; col <= 6; col += 3) {
                if(!validateBox(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateBox(char[][] board, int startRow, int startCol) {
        boolean[] seen = new boolean[9];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[startRow + i][startCol + j] == '.') {
                    continue;
                }
                final int val = board[startRow + i][startCol + j] - '1';
                if(seen[val]) {
                    return false;
                }
                seen[val] = true;
            }
        }
        return true;
    }
 */

/*
public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> row = new HashSet<>();
			HashSet<Character> column = new HashSet<>();
			HashSet<Character> cube = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j]))
					return false;
				if (board[j][i] != '.' && !column.add(board[j][i]))
					return false;
				int RowIndex = 3 * (i / 3) + j / 3;
				int ColIndex = 3 * (i % 3) + j % 3;
				if (board[RowIndex][ColIndex] != '.'
						&& !cube.add(board[RowIndex][ColIndex]))
					return false;
			}
		}
		return true;
	}
}
 */

/*
public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    if (!isValid(board, r, c)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValid(char[][] board, int r, int c) {
        for (int i = 0; i < 9; i++) {
            if (i != r && board[i][c] == board[r][c]) return false;
            if (i != c && board[r][i] == board[r][c]) return false;
        }

        int startRow = (r / 3) * 3;
        int startCol = (c / 3) * 3;

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if (!(row == r && col == c)) {
                    if (board[r][c] == board[row][col]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
 */


/*
 public boolean isValidSudoku(char[][] board) {
        int p=0;
        int w=9;
        char noNum= '.';
        for(int i =0 ;i<w ;i++){
            for(int j =0;j<w;j++){
                p=j+1;
                while(p<w){
                    if(board[i][p]==noNum){p++;continue;}
                    else if(board[i][p]==board[i][j]){

                        return false;
                    }
                    p++;
                }
                p=i+1;
                while(p<w){
                    if(board[p][j]==noNum){p++;continue;}
                    else if(board[p][j]==board[i][j]){

                        return false;
                    }
                    p++;
                }
                p=0;
                int x=(i/3)*3;
                int y=(j/3)*3;
                while(p<w){
                    if(board[x+p%(w/3)][y+p/(w/3)]==noNum){p++;continue;}
                    else if(board[x+p%(w/3)][y+p/(w/3)]==board[i][j]){
                        if(x+p%(w/3)!=i && y+p/(w/3)!=j)
                            return false;
                    }
                    p++;
                }

            }

        }
        return true;
    }
 */