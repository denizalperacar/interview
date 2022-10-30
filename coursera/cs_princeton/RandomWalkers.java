public class RandomWalkers {
    
    public static void main(String[] args) {

        int r = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        double steps_sum = 0;        
        for (int trail = 0; trail < trails; trail++) {

            int x = 0;
            int y = 0;
            int steps = 0;
            double direction;

            while ((Math.abs(x) + Math.abs(y)) < r) {
                steps += 1;
                direction = Math.random();
                if (direction < 0.25) x += 1;
                else if (direction >= 0.25 && direction < 0.5) y += 1;
                else if (direction >= 0.5 && direction < 0.75) x -= 1;
                else y -= 1;
            }
            steps_sum += (double) steps;
        }
        System.out.println("average number of steps = " + steps_sum / trails);
    }
}
