package recursivedp;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits"
 * such that the robot cannot step on them. Design an algorithm to find a path for the robot
 * from the top left to the bottom right.
 */
class _08_02_RobotInAGrid {
    List<Point> findPath(boolean[][] grid) {
        var path = new LinkedList<Point>();

        if(grid.length == 0 ||!grid[0][0]) return path;

        if(findPath(grid, grid.length - 1, grid[0].length - 1, path)) return path;

        return new LinkedList<Point>();
    }

    boolean findPath(boolean[][] grid, int row, int col, List<Point> path) {
        if(row < 0 || col < 0 || !grid[row][col]) return false;

        var isOrigin = row == 0 && col == 0;

        if(isOrigin || findPath(grid, row, col - 1, path) || findPath(grid, row - 1, col, path)) {
            path.add(new Point(row, col));
            return true;
        }

        return false;
    }

}
