package arraystring;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
class _01_08_ZeroMatrix {
    int[][] zero(int[][] matrix) {
        boolean[] zerosRowArr = new boolean[matrix.length];
        boolean[] zerosColArr = new boolean[matrix[0].length];

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0) {
                   zerosRowArr[row] = true;
                   zerosColArr[col] = true;
                }
            }
        }

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(zerosRowArr[row] || zerosColArr[col]) {
                    matrix[row][col] = 0;
                }
            }
        }

        return matrix;
    }
}
