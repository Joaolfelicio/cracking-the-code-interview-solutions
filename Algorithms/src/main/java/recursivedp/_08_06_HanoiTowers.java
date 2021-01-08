package recursivedp;

import java.util.Stack;

/**
 * In the classic problem of the towers of Hanoi,
 * you have 3 towers and N disks of different sizes which can slide onto any tower.
 * The puzzle starts with disks sorted in ascending order of size from top to bottom
 * (i.e., each disk sits on top of an even larger one).
 * You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto another tower.
 * (3) A disk cannot be placed on top of a smaller disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */
class _08_06_HanoiTowers {

    public class Tower {
        private Stack<Integer> disks = new Stack<>();

        public void add(int value) {
            if (!disks.isEmpty() && disks.peek() <= value) {
                System.out.println("Error placing disk " + value);
            } else {
                disks.push(value);
            }
        }

        public void moveTopTo(Tower tower) {
            int top = disks.pop();
            tower.add(top);
        }

        public void moveDisks(int quantity, Tower destination, Tower buffer) {
            if (quantity <= 0) return;

            moveDisks(quantity - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(quantity - 1, destination, this);
        }
    }
}
