import java.util.Random;

public class Snake extends Obstacle{

    public Snake() {
        super("Snake", 3, 12, 0);
    }

    @Override
    public int obstacleNumber() {
        Random random=new Random();
        return random.nextInt(6);
    }
}
