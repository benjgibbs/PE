package pe_problem28;

public class Problem28 {

    private final int RIGHT = 0;
    private final int DOWN  = 1;
    private final int LEFT  = 2;
    private final int UP    = 3;
    private final int X = 0;
    private final int Y = 1;
    
    public int[][] createSpiral(int size) {
        int[][] result = new int[size][size];
        int[] pos = new int[2];
        
        int count = 0;
        pos[X] = (size / 2);
        pos[Y] = (size / 2)+1;
        
        int direction = LEFT;
        int step = 1;
        int stepSz = 0;

        while (count < size * size) {
            if (step > stepSz){
                direction = ((direction + 1) % 4);
                if(direction == LEFT || direction == RIGHT)
                    stepSz +=1;
                step = 1;
            }
            move(pos, direction);
            result[pos[Y]][pos[X]] = count + 1;
            ++step;
            ++count;
        }

        return result;
    }

    private void move(int[] pos, int direction) {
        switch (direction) {
        case RIGHT:
            pos[X] += 1;
            break;
        case DOWN:
            pos[Y] += 1;
            break;
        case LEFT:
            pos[X] -= 1;
            break;
        case UP:
            pos[Y] -= 1;
            break;
        }
    }

    int sumDiagonals(int[][] toSum) {
        //Check for squareness?
        int sum = 0;
        for(int i = 0; i < toSum.length; ++i){
            sum += toSum[i][i];
            int k = toSum.length - (i+1);
            sum += toSum[i][k];
        }
        //Always one..., but to be generic
        int mid = toSum.length / 2;
        sum -= toSum[mid][mid];
        return sum;
    }

    public int sumDiagonals(int i) {
        return sumDiagonals(createSpiral(i));
    }
    
    public static void main(String[] args) {
        System.out.println("Checking spiral...");
        Problem28 p = new Problem28();
        final int size = 1001;
        int sum = p.sumDiagonals(size);
        System.out.printf("For %d the sum of diagonals is: %d", size, sum);
    }
}
