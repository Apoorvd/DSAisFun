package com.heyshubham.leetcode;

public class LeetCode_37 {

    //https://leetcode.com/problems/sudoku-solver/

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){

        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] == '.'){
                    for(char k ='1';k<='9';k++){
                        if(isValid(board,i,j,k)){
                            board[i][j] = k;
                            if(solve(board) == true)
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false; //not able to place any num from 1-9 at i,j
                }
            }
        }
        return true;
    }

    private boolean isValid(char [][] board,int row,int col,char val){//o(n)
        //check entire col,row
        for(int i = 0;i<9;i++){
            if(board[i][col] == val) return false;
            if(board[row][i] == val) return false;
        }

        //getting the top left corner of 3 cross 3 matrix
        //row/3 & col/3 gives u exact subarray box , we multiply these by 3
        //so that we can get the top left corner of that box(i.e box starting)
        int rowst = (row/3) * 3;
        int colst = (col/3) * 3;

        //checking the 3 cross 3 submatrix
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(board[rowst + i][colst + j] == val) return false;
            }
        }
        return true;
    }

}


/* 1 ms

private static final int[][] BOX_INDICES = {
                {0, 0, 0, 1, 1, 1, 2, 2, 2},
                {0, 0, 0, 1, 1, 1, 2, 2, 2},
                {0, 0, 0, 1, 1, 1, 2, 2, 2},
                {3, 3, 3, 4, 4, 4, 5, 5, 5},
                {3, 3, 3, 4, 4, 4, 5, 5, 5},
                {3, 3, 3, 4, 4, 4, 5, 5, 5},
                {6, 6, 6, 7, 7, 7, 8, 8, 8},
                {6, 6, 6, 7, 7, 7, 8, 8, 8},
                {6, 6, 6, 7, 7, 7, 8, 8, 8}
        };

        public void solveSudoku(char[][] board) {
            int[] rowFlag = new int[9], colFlag = new int[9], blockFlag = new int[9];
            for (int i = 0, blockIdx; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    blockIdx = i / 3 * 3 + j / 3;
                    char ch = board[i][j];
                    if (ch != '.') {
                        int flag = (1 << (ch - '0'));
                        rowFlag[i] |= flag;
                        colFlag[j] |= flag;
                        blockFlag[blockIdx] |= flag;
                    }
                }
            }

            backtrack(board, rowFlag, colFlag, blockFlag, 0, 0);
        }

        public boolean backtrack(char[][] board, int[] rowFlag, int[] colFlag, int[] blockFlag, int r, int c) {
            if (board[r][c] == '.') {
                int blockIdx = BOX_INDICES[r][c];
                int flags = rowFlag[r] | colFlag[c] | blockFlag[blockIdx];
                if (flags == 0b111_111_111_0) return false;
                for (int i = 1; i <= 9; i++) {
                    if ((flags & (1 << i)) == 0) {
                        board[r][c] = (char) ('0' + i);

                        int flag = (1 << i);
                        rowFlag[r] |= flag;
                        colFlag[c] |= flag;
                        blockFlag[blockIdx] |= flag;

                        if ((r == 8 && c == 8)
                                || (c == 8 && backtrack(board, rowFlag, colFlag, blockFlag, r + 1, 0))
                                || (c < 8 && backtrack(board, rowFlag, colFlag, blockFlag, r, c + 1))) {
                            return true;
                        }
                        board[r][c] = '.';
                        rowFlag[r] &= ~flag;
                        colFlag[c] &= ~flag;
                        blockFlag[blockIdx] &= ~flag;
                    }
                }
                return false;
            } else {
                return (r == 8 && c == 8)
                        || (c == 8 && backtrack(board, rowFlag, colFlag, blockFlag, r + 1, 0))
                        || (c < 8 && backtrack(board, rowFlag, colFlag, blockFlag, r, c + 1));
            }
        }
 */


/* 2ms
public void solveSudoku(char[][] board) {
        int[] rows = new int[] {0, 0, 0,
                               0, 0, 0,
                               0, 0, 0};
        int[] cols = new int[] {0, 0, 0,
                               0, 0, 0,
                               0, 0, 0};
        int[][] boxes = new int[][] {{0, 0, 0},
                                     {0, 0, 0},
                                     {0, 0, 0}};
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }

                int n = ch - '0';
                int digit = 1 << (n - 1);
                rows[r] |= digit;
                cols[c] |= digit;
                boxes[r / 3][c / 3] |= digit;
            }
        }

        dfs(board, 0, 0, rows, cols, boxes);
    }

    private boolean dfs(char[][] board, int r, int c, int[] rows, int[] cols, int[][] boxes) {
        if (r > 8) {
            return true;
        }

        if (c > 8) {
            return dfs(board, r + 1, 0, rows, cols, boxes);
        }

        if (board[r][c] != '.') {
            return dfs(board, r, c + 1, rows, cols, boxes);
        }

        int row = rows[r], col = cols[c], box = boxes[r / 3][c / 3];
        for (int i = 1; i <= 9; i++) {
            int digit = 1 << (i - 1);
            if ((digit & row) > 0 ||
                (digit & col) > 0 ||
                (digit & box) > 0) {
                continue;
            }

            rows[r] |= digit;
            cols[c] |= digit;
            boxes[r / 3][c / 3] |= digit;
            board[r][c] = (char) (i + '0');
            if (!dfs(board, r, c + 1, rows, cols, boxes)) {
                rows[r] = row;
                cols[c] = col;
                boxes[r / 3][c / 3] = box;
                board[r][c] = '.';
            } else {
                return true;
            }
        }

        return false;
    }
 */


/* 3ms
private boolean[][] row = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] box = new boolean[3][3][9];
    private List<int[]> empty = new ArrayList<>();
    boolean isVaild;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.') empty.add(new int[]{i,j});
                else {
                    int index = board[i][j] - '0' - 1 ;
                    row[i][index] = true;
                    column[j][index] = true;
                    box[i/3][j/3][index] = true;
                }
            }
        }
        bfs(board, 0);
    }

    private void bfs(char[][] board, int pos) {
        if(pos == empty.size()) {
            isVaild = true;
            return;
        }
        int rowNum = empty.get(pos)[0];
        int columnNum = empty.get(pos)[1];
        for (int i = 0; i <= 8 && !isVaild; i++) {
           if(!row[rowNum][i] && !column[columnNum][i] && !box[rowNum/3][columnNum/3][i]){
               row[rowNum][i] = column[columnNum][i] = box[rowNum/3][columnNum/3][i] = true;
               board[rowNum][columnNum] = (char) (i + '0' + 1);
               bfs(board, pos+1);
               row[rowNum][i] = column[columnNum][i] = box[rowNum/3][columnNum/3][i] = false;
           }
        }

    }
 */

/* 4ms
public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];
        List<Grid> grids = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    grids.add(new Grid(i, j));
                    continue;
                }
                if (!Character.isDigit(board[i][j]) || board[i][j] == '0') return;
                if (!check(board[i][j] - '0', i, j, rows, cols, boxes)) {
                    return;
                }
                setDigit(board, board[i][j], i, j, rows, cols, boxes);
            }
        }
        // System.out.println("Valid!");

        dfs(board, grids, 0, rows, cols, boxes);
    }

    private boolean dfs(char[][] board, List<Grid> grids, int idx, int[] rows, int[] cols, int[] boxes) {
        if (idx >= grids.size()) return true;
        int r = grids.get(idx).x;
        int c = grids.get(idx).y;
        for (int i = 1; i <= 9; i++) {
            if (!check(i, r, c, rows, cols, boxes)) continue;
            setDigit(board, (char) ('0' + i), r, c, rows, cols, boxes);
            if (dfs(board, grids, idx+1, rows, cols, boxes)) {
                return true;
            }
            unsetDigit(board, r, c, rows, cols, boxes);
        }
        return false;
    }

    private boolean check(int digit, int row, int col, int[] rows, int[] cols, int[] boxes) {
        int test = (1 << digit);
        if ((rows[row] & test) > 0 || (cols[col] & test) > 0 || (boxes[row / 3 * 3 + col / 3] & test) > 0) {
            return false;
        }
        return true;
    }

    private void setDigit(char[][] board, char ch, int row, int col, int[] rows, int[] cols, int[] boxes) {
        board[row][col] = ch;
        int digit = ch - '0';
        int num = (1 << digit);
        rows[row] |= num;
        cols[col] |= num;
        boxes[row / 3 * 3 + col / 3] |= num;
    }

    private void unsetDigit(char[][] board, int row, int col, int[] rows, int[] cols, int[] boxes) {
        int digit = board[row][col] - '0';
        int num = (1 << digit);
        rows[row] ^= num;
        cols[col] ^= num;
        boxes[row / 3 * 3 + col / 3] ^= num;
        board[row][col] = '.';
    }

    private static final class Grid {
        private int x, y;
        Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 */


/* 6ms
 public void solveSudoku(char[][] board) {

        function(board,0,0);


    }
    public static boolean function(char [][] board,int row_pos,int col_pos)
    {


        if(board[row_pos][col_pos]!='.')
        {
            if(row_pos==board.length-1 && col_pos==board.length-1)
            return true;
            if(function(board,col_pos==8?row_pos+1:row_pos,col_pos==8?0:col_pos+1))
                return true;
        }


        else
        {

        for(char iter_i='1';iter_i<='9';iter_i++)
        {

            if(validate(board,row_pos,col_pos,iter_i))
            {
                board[row_pos][col_pos]=iter_i;
                if(row_pos==8 && col_pos==8)
                return true;
                 if(function(board,col_pos==8?row_pos+1:row_pos,col_pos==8?0:col_pos+1))
                return true;
                board[row_pos][col_pos]='.';
            }
        }
        }
        return false;
    }


    public static boolean  validate( char board[][],int row_pos,int col_pos,char val)
    {

        for(int iter_i=0;iter_i<9;iter_i++)
        {
            if(board[row_pos][iter_i]==val)
                return false;
        }
        for(int iter_i=0;iter_i<9;iter_i++)
            if(board[iter_i][col_pos]==val)
                return false;





        //  for(;iter_i<3*(row_pos/3) + 3;iter_i++)
        // {
        //     for(;iter_j<3*(col_pos/3)+3;iter_j++)
        //         if(board[iter_i][iter_j]==val)
        //             return false;
        // }
        for( int iter_i=(row_pos/3)*3;iter_i<3*(row_pos/3) + 3;iter_i++)
        {
            for(int iter_j=(col_pos/3)*3;iter_j<3*(col_pos/3)+3;iter_j++)
                if(board[iter_i][iter_j]==val)
                    return false;
        }

        return true;
    }
 */


/* 7ms
public void solveSudoku(char[][] board) {
        int input[][]=convertInput(board);
        getResult(input,0,0);
        populateOutput(input,board);

	}
    public void populateOutput(int input[][],char[][] board){
     for(int i=0;i<input.length;i++){
         for(int j=0;j<input.length;j++){
             board[i][j]=(char)(input[i][j]+'0');
         }
     }
    }
    public boolean getResult(int [][]input,int row,int col){
        if(row==input.length && col==0){
            return true;
        }else if(input[row][col]!=-1){
           return getResult(input,getNextRow(row,col,input.length) ,getNextCol(row,col,input.length));
        }
        for(int i=1;i<=input.length;i++){
            if(isValid(input,row,col,i)){
                input[row][col]=i;
                if(getResult(input,getNextRow(row,col,input.length) ,getNextCol(row,col,input.length))){
                    return true;
                }else{
                    input[row][col]=-1;
                }

            }
        }
        return false;
    }
    public boolean isValid(int [][]input,int row,int col,int n){
        for(int i=0;i<input.length;i++){
            if(input[row][i]==n||input[i][col]==n){
                return false;
            }
        }
        int size= (int)Math.pow(input.length,0.5);
        int srow=(row/size)*size;
        int scol=(col/size)*size;
        for(int i= srow;i<srow+size;i++){
            for(int j=scol;j<scol+size;j++){
                if(input[i][j]==n){
                    return false;
                }
            }
        }

        return true;
    }
    public int getNextRow(int row,int col,int size){
       return row+((col+1)/size);
    }
    public int getNextCol(int row,int col,int size){
       return (col+1)%size;
    }


    public int[][] convertInput(char[][] board){
        int [][]input = new int[board.length][board.length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    input[i][j]=-1;
                }else{
                    input[i][j]=board[i][j]-'0';
                }
            }
        }
       return input;
    }
 */

/* worst case
public void solveSudoku(char[][] board) {
        Map<String, Set<Character>> map = buildMap(board);
        solveSudoku(board, 0, 0, map);
    }

    private boolean solveSudoku(char[][] board, int row, int col, Map<String, Set<Character>> map) {
        if(row ==9) return true;
        boolean isSolved = false;
        if (board[row][col] != '.') {
            if (col < 8) {
                isSolved = solveSudoku(board, row, col+1, map);
            } else {
                isSolved = solveSudoku(board, row+1, 0, map);
            }
        }

        else {
            for(char i = '1'; i <= '9'; i++) {
                if (map.get("r" + row).contains(i) || map.get("c" + col).contains(i)
                    || map.get("b" + getBoxId(row, col)).contains(i)) {
                    continue;
                }
                board[row][col] = i;
                map.get("r" + row).add(board[row][col]);
                map.get("c" + col).add(board[row][col]);
                map.get("b" + getBoxId(row, col)).add(board[row][col]);

                if (col < 8) {
                   isSolved = solveSudoku(board, row, col+1, map);
                } else {
                   isSolved = solveSudoku(board, row+1, 0, map);
                }

                if(isSolved) {
                    break;
                } else {
                    map.get("r" + row).remove(board[row][col]);
                    map.get("c" + col).remove(board[row][col]);
                    map.get("b" + getBoxId(row, col)).remove(board[row][col]);
                    board[row][col] = '.';
                }
            }
        }
        return isSolved;
    }


    public Map<String, Set<Character>> buildMap(char[][] board) {
        Map<String, Set<Character>> map = new HashMap<>();
        for(int row =0; row < 9; row++) {
            map.put("r" + row, new HashSet<>());
            for(int col =0; col < 9; col++) {
                if (!map.containsKey("c" + col)) {
                    map.put("c" + col, new HashSet<>());
                }
                if (!map.containsKey("b" + getBoxId(row, col))) {
                    map.put("b" + getBoxId(row, col), new HashSet<>());
                }
                if (board[row][col] == '.') continue;
                map.get("r" + row).add(board[row][col]);
                map.get("c" + col).add(board[row][col]);
                map.get("b" + getBoxId(row, col)).add(board[row][col]);
            }
        }
        return map;
    }

    private Integer getBoxId(int row, int col) {
        if (row >= 0 && row < 3 && col >=0 && col < 3) return 0;
        if (row >= 3 && row < 6 && col >=0 && col < 3) return 1;
        if (row >= 6 && row < 9 && col >=0 && col < 3) return 2;

        if (row >= 0 && row < 3 && col >=3 && col < 6) return 3;
        if (row >= 3 && row < 6 && col >=3 && col < 6) return 4;
        if (row >= 6 && row < 9 && col >=3 && col < 6) return 5;

        if (row >= 0 && row < 3 && col >=6 && col < 9) return 6;
        if (row >= 3 && row < 6 && col >=6 && col < 9) return 7;
        if (row >= 6 && row < 9 && col >=6 && col < 9) return 8;

        return -1;
    }
 */


class LeetCode_37_{

    // 0 ms solution
    /**
     * State of a bitset where all digits [1..9] are present.
     */
    private static final int ALL_SET = 0b111_111_111_0;

    /**
     * Box indices by row and column. Don't recompute what can be a constant :-)
     */
    private static final int[][] BOX_INDICES = {
            {0, 0, 0, 1, 1, 1, 2, 2, 2},
            {0, 0, 0, 1, 1, 1, 2, 2, 2},
            {0, 0, 0, 1, 1, 1, 2, 2, 2},
            {3, 3, 3, 4, 4, 4, 5, 5, 5},
            {3, 3, 3, 4, 4, 4, 5, 5, 5},
            {3, 3, 3, 4, 4, 4, 5, 5, 5},
            {6, 6, 6, 7, 7, 7, 8, 8, 8},
            {6, 6, 6, 7, 7, 7, 8, 8, 8},
            {6, 6, 6, 7, 7, 7, 8, 8, 8}
    };

    /**
     * This helper object provides a convenient API to iterate over the not-yet-filled cells of the Sudoku board.
     */
    private final SudokuSequence sequence = new SudokuSequence();

    /**
     * Current Sudoku board.
     */
    private char[][] board;


    ////// THE SOLUTION //////
    public void solveSudoku(char[][] board) {
        this.board = board;
        // fill the sequence
        sequence.init();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') {
                    sequence.add(row, col);
                    continue;
                }
                sequence.flip(row, col, c - '0');
            }
        }
        if (!solve(0)) {
            throw new IllegalArgumentException("Unsolvable Sudoku!");
        }
    }

    /**
     * Performs DFS (with some optimization) to find the first valid solution of the Sudoku puzzle ({@link #board}).
     * <p>Invalid solutions (dead-ends) are reverted to the last valid state (backtracking), never to be considered again.
     *
     * @param position current position of a cell in the {@link #sequence}
     * @return true if solution was found, false if it can't be found for a given state of the board
     */
    private boolean solve(int position) {
        if (position == sequence.size) return true; // base case: we reached the end and all the cells can be filled

        int easiest = sequence.easiest(position);
        if (easiest < 0) {
            return false;
        }
        sequence.swap(position, easiest); // move the easiest cell to the current position

        int row = sequence.row(position);
        int col = sequence.col(position);
        int set = sequence.digits(position);

        for (int lo = 1, digit; lo <= 9; lo = digit + 1) {
            digit = nextDigit(set, lo);
            if (digit > 9) break;

            sequence.flip(row, col, digit); // place the digit

            // proceed with the DFS
            if (solve(position + 1)) {
                board[row][col] = (char) ('0' + digit); // fill the board as the recursion unwinds
                return true;
            }
            // if a solution is not found, backtrack and try the next digit

            sequence.flip(row, col, digit);
        }
        sequence.swap(position, easiest); // revert modification to the sequence
        return false;
    }


    /**
     * Calculates the next digit absent from a set.
     *
     * @param set    bitset of placed digits
     * @param lowest lowest digit to consider
     * @return digit [1..9] if available or some value > 9 if the all the bits [1..9] are 1-s
     */
    private static int nextDigit(int set, int lowest) {
        set >>>= lowest;
        return Integer.numberOfTrailingZeros(~set) + lowest;
    }

    /**
     * Calculates the box index for given cell on a board.
     *
     * @param row column index
     * @param col row index
     * @return box index
     */
    private static int box(int row, int col) {
        return BOX_INDICES[row][col];
    }

    /**
     * This auxiliary class represents a sequence of unfilled Sudoku cells.
     * It is implemented as a structure of arrays (SoA) to reduce the need for heap allocations.
     */
    private static final class SudokuSequence {

        /**
         * Bitmap of the present digits by row.
         *
         * @see #digits
         */
        int[] rows;

        /**
         * Bitmap of the present digits by column.
         */
        int[] cols;

        /**
         * Bitmap of the present digits by box.
         */
        int[] boxes;

        /**
         * Mapping of the sequence position to the row index on the board.
         */
        final int[] rowSeq = new int[81];

        /**
         * Mapping of the sequence position to the column index on the board.
         */
        final int[] colSeq = new int[81];

        /**
         * Actual size of the sequence (number of the unfilled cells on the initial board).
         */
        int size;

        /**
         * Resets the state of the sequence.
         * <p>{@link #rowSeq} and {@link #colSeq} and not re-allocated,
         * we will just overwrite old values as we add new onex.
         */
        void init() {
            rows = new int[9];
            cols = new int[9];
            boxes = new int[9];
            size = 0;
        }

        /**
         * Add a new entry into the sequence.
         *
         * @param row row index
         * @param col column index
         */
        void add(int row, int col) {
            rowSeq[size] = row;
            colSeq[size] = col;
            size++;
        }

        /**
         * Given a starting position in this sequence,
         * finds in its remaining part the position which is the easiest to fill.
         * <p>Easiest here meaning that it can be filled with the least amount of possible digits, ideally just 1
         * (meaning that the rest 8 digits are already present in the respective row, column and box).
         * <p>This rather basic heuristic allows us to dramatically prune the branches of our DFS.
         * Given that most sudoku puzzles have only 1 valid solution meant to be found by a human,
         * there should almost always be a cell on a board which has only 1 valid value.
         *
         * @param from lower bound of the search
         * @return position that is the easiest to fill, or -1 if it can't be found or if the sequence state is invalid
         */
        int easiest(int from) {
            int easiest = -1, maxPopulation = 0;
            for (int i = from; i < size; i++) {
                int set = digits(i);
                if (set == ALL_SET) return -1; // if all digits are taken, then current solution is invalid
                int population = Integer.bitCount(set);
                if (population == 8) return i;
                if (population > maxPopulation) {
                    easiest = i;
                    maxPopulation = population;
                }
            }
            return easiest;
        }

        /**
         * Swaps two values in the sequence.
         *
         * @param p1 position of the first cell in this sequence
         * @param p2 position of the second cell in this sequence
         */
        void swap(int p1, int p2) {
            int tmpR = rowSeq[p1], tmpC = colSeq[p1];
            rowSeq[p1] = rowSeq[p2];
            rowSeq[p2] = tmpR;
            colSeq[p1] = colSeq[p2];
            colSeq[p2] = tmpC;
        }

        /**
         * Builds a bitset that contains the digits that are present in the row, column and box of a given cell.
         * <p>Digits are stored as 1-flags in their respective positions e.g. set with value {@code 0b101_000_001_0}
         * indicates the presence of the digits '1', '7', and '9'.
         * <p>The usage of bitsets here allows for an extremely efficient checking of the problem's core constraint.
         * Using some trickery {@link #nextDigit(int, int)} we can even iterate over just the un-placed digits in such a set.
         *
         * @param position position of the cell in this sequence
         * @return bitset of present digits
         */
        int digits(int position) {
            int ri = rowSeq[position], ci = colSeq[position], bi = box(ri, ci);
            return rows[ri] | cols[ci] | boxes[bi];
        }

        /**
         * Returns a row index of a cell.
         *
         * @param position position of a cell in this sequence
         * @return row index
         */
        int row(int position) {
            return rowSeq[position];
        }

        /**
         * Returns a column index of a cell.
         *
         * @param position position of a cell in this sequence
         * @return column index
         */
        int col(int position) {
            return colSeq[position];
        }

        /**
         * Flips the bit that indicates the presence of a digit in the given row, column, and box.
         *
         * @param row row index
         * @param col column index
         * @param val digit to set/unset
         */
        void flip(int row, int col, int val) {
            int bit = 1 << val;
            rows[row] ^= bit;
            cols[col] ^= bit;
            boxes[box(row, col)] ^= bit;
        }
    }

    // 5ms solution

    // box size
    int n = 3;
    // row size
    int N = n * n;

    int [][] rows = new int[N][N + 1];
    int [][] columns = new int[N][N + 1];
    int [][] boxes = new int[N][N + 1];

    //char[][] board; // already defined in above 0 ms solution

    boolean sudokuSolved = false;

    public boolean couldPlace(int d, int row, int col) {
    /*
    Check if one could place a number d in (row, col) cell
    */
        int idx = (row / n ) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {
    /*
    Place a number d in (row, col) cell
    */
        int idx = (row / n ) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char)(d + '0');
    }

    public void removeNumber(int d, int row, int col) {
    /*
    Remove a number which didn't lead to a solution
    */
        int idx = (row / n ) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public void placeNextNumbers(int row, int col) {
    /*
      Call backtrack function in recursion
      to continue to place numbers
      till the moment we have a solution
    */
        // if we're in the last cell
        // that means we have the solution
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        }
        // if not yet
        else {
            // if we're in the end of the row
            // go to the next row
            if (col == N - 1) backtrack(row + 1, 0);
                // go to the next column
            else backtrack(row, col + 1);
        }
    }

    public void backtrack(int row, int col) {
    /*
      Call backtrack function in recursion
      to continue to place numbers
      till the moment we have a solution
    */
        // if we're in the last cell
        // that means we have the solution
    /*
    Backtracking
    */
        // if the cell is empty
        if (board[row][col] == '.') {
            // iterate over all numbers from 1 to 9
            for (int d = 1; d <= 9; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    // if sudoku is solved, there is no need to backtrack
                    // since the single unique solution is promised
                    if (!sudokuSolved) {
                        removeNumber(d, row, col);
                    }
                }
            }
        } else {
            // Need to increment the row/col even if not placing on empty cell.
            placeNextNumbers(row, col);
        }
    }

    public void solveSudoku_(char[][] board) {
        this.board = board;

        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }
}