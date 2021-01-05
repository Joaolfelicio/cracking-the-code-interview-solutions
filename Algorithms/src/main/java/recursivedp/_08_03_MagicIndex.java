package recursivedp;

/**
 * Magic Index: A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 */
class _08_03_MagicIndex {

    int findMagicIndex(int[] arr) {
        return findMagicIndex(0, arr.length - 1, arr);
    }

    int findMagicIndex(int left, int right, int[] arr) {
        if(left > right) return -1;

        int middleIndex = left + ((right - left) / 2);
        int middleValue = arr[middleIndex];

        if(middleIndex == middleValue) {
            return middleValue;
        }

        //Search left
        int leftIndex = Math.min(middleIndex - 1, middleValue);
        if(findMagicIndex(left, leftIndex, arr) >= 0) return left;

        //Search right
        int rightIndex = Math.min(middleIndex + 1, middleValue);
        int rightSide = findMagicIndex(rightIndex, right, arr);

        return rightSide;
    }
}
