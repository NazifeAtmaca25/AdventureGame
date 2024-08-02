import java.util.Random;

public class Snake extends Obstacle{

    public Snake() {
        super("Snake", getRandomDamage(), 12, 0);
    }

    private static int getRandomDamage() {
        Random random = new Random();
        return random.nextInt(4) + 3; // 1 ile 10 arasında rastgele bir sayı
    }
    @Override
    public int obstacleNumber() {
        Random random=new Random();
        return random.nextInt(6);
    }
}
