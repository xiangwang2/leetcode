package src.main.pro.xw.leetcode.minRefuelStops;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(100, 50,
                new int[][]{
                        {25, 25},
                        {50, 50},
                }));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        return minRefuelStops(target, startFuel, 0, 0, stations);
    }

    public int minRefuelStops(int target, int startFuel, int startPosition, int curDistance, int[][] stations) {
        if (startFuel < 0) {
            return -1;
        }
        if (startFuel >= target) {
            return 0;
        }
        if (startPosition >= stations.length) {
            return -1;
        }

        int nextPosition = stations[startPosition][0];
        int nextFuel = stations[startPosition][1];

        int nexDistance = nextPosition - curDistance;
        if (startFuel < nexDistance) {
            return -1;
        }

        int nAdd = minRefuelStops(target - nexDistance, startFuel - nexDistance,
                startPosition + 1, nextPosition, stations);
        int add = minRefuelStops(target - nexDistance, startFuel - nexDistance + nextFuel,
                startPosition + 1, nextPosition, stations);

        if (nAdd == -1 && add == -1) {
            return -1;
        } else if (nAdd == -1) {
            return add + 1;
        } else if (add == -1) {
            return nAdd;
        } else {
            return Math.min(nAdd, add + 1);
        }
    }
}
