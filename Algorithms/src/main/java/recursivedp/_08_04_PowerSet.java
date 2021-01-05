package recursivedp;

import java.util.ArrayList;
import java.util.Set;

/**
 * Write a method to return all subsets of a set
 */
class _08_04_PowerSet {

    ArrayList<ArrayList<Integer>> subSets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> subsets;

        if(set.size() == index) {
            subsets = new ArrayList<ArrayList<Integer>>();
            subsets.add(new ArrayList<Integer>());
        } else {
            subsets = subSets(set, index + 1);
            var item = set.get(index);
            var moreSubsets = new ArrayList<ArrayList<Integer>>();

            for(ArrayList<Integer> subset : subsets) {
                var newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            subsets.addAll(moreSubsets);
        }
        return subsets;
    }


}
