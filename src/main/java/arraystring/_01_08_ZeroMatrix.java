package arraystring;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
class _01_08_ZeroMatrix {
    int[][] zero(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return matrix;

        boolean hasFirstRowZero = false;
        boolean hasFirstColZero = false;

        // First row has any zero? if so we zero the row at the end
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                hasFirstRowZero = true;
                break;
            }
        }

        // First col has any zero? if so we zero the col at the end
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                hasFirstColZero = true;
                break;
            }
        }

        // Set the row and col to 0 if the value is 0
        for(int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Where the row or col is 0, set the val to 0
        for(int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // If the first row has a zero, zero all the elems in the row
        if(hasFirstRowZero) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        // If the first col has a zero, zero all the elems in the col
        if(hasFirstColZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
