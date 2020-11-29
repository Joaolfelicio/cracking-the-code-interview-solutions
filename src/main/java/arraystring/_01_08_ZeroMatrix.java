package arraystring;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
class _01_08_ZeroMatrix {
    int[][] zero(int[][] matrix) {
        boolean[][] zeroedArr = new boolean[matrix.length][matrix[0].length];

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0 && !zeroedArr[row][col]) {
                    zeroRowColumn(matrix, zeroedArr, row, col);
                }
            }
        }
        return matrix;
    }

    void zeroRowColumn(int[][] matrix, boolean[][] zeroedArr, int row, int col) {
        for(int i = 0; i < matrix[row].length; i++) {
            if(matrix[row][i] != 0) {
                matrix[row][i] = 0;
                zeroedArr[row][i] = true;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][col] != 0) {
                matrix[i][col] = 0;
                zeroedArr[i][col] = true;
            }
        }
    }
}
