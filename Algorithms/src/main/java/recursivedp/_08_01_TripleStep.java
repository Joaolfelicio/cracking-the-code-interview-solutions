package recursivedp;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
class _08_01_TripleStep {

    int countWays(int steps) {
        var stepsAllowed = new int[] {1,2,3};

        var table = new int[steps + 1];
        table[0] = 1;

        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < stepsAllowed.length; j++) {

                if(i + stepsAllowed[j] < table.length && table[i] != 0) {
                    table[i + stepsAllowed[j]] += table[i];
                }
            }
        }
        return table[steps];
    }
}
