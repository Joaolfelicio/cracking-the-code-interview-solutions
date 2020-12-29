package arraystring;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */

class _01_07_RotateMatrix {
    int[][] rotate(int[][] m) {
        int n = m.length;

        if(n == 0) return m;

        for(int i = 0; i < (n + 1) / 2; i++) {
            for(int j = 0; j < n / 2; j++) {
                int temp = m[n - 1 - j][i];

                m[n - 1 - j][i] = m[n - i - 1][n - 1 - j];
                m[n - 1 - i][n - 1 - j] = m[j][n - 1 - i];
                m[j][n - 1 - i] = m[i][j];
                m[i][j] = temp;
            }
        }
        return m;
    }
}
