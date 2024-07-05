package src.main.pro.xw.leetcode.isRobotBounded;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isRobotBounded("GGLLGG"));
    }

    public boolean isRobotBounded(String instructions) {
        int[][] point = new int[1][2];
        point[0] = new int[]{0, 0};
        char[] instructionsChar = instructions.toCharArray();
        int baseForward = 0;
        int xy = 1;
        int step = 1;
        for (int i = 0; i < instructionsChar.length; i++) {
            char instruction = instructionsChar[i];
            if (instruction == 'G') {
                point[0][xy] = point[0][xy] + step;
            } else {
                baseForward = getForward(baseForward, instruction);
                xy = getXY(baseForward);
                step = getStep(baseForward);
            }
        }
        if (point[0][0] == 0 && point[0][1] == 0) {
            return true;
        }

        if (baseForward == 0) {
            return false;
        } else {
            return true;
        }
    }

    private int getXY(int forward) {
        if (forward == 0 || forward == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    private int getStep(int forward) {
        if (forward == 0 || forward == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    // 0 = n, 1 = e, 2 = s, 3 = w
    private int getForward(int forward, char instruction) {
        if (instruction == 'L') {
            return (forward + 3) % 4;
        } else {
            return (forward + 1) % 4;
        }
    }
}
