import java.util.Random;

public class Snake extends Obstacle{

    public Snake() {
        super("Snake", getRandomDamage(), 12, 0);
    }

    private static int getRandomDamage() {
        //yılanların hasarı 3 ile 6 arasında rastgele bir değer olmalı
        Random random = new Random();
        return random.nextInt(4) + 3;
    }
    @Override
    public int obstacleNumber() {
        //yılanların satısı diğerlerinden farklı olaarak 1-5 arası olmalı
        Random random=new Random();
        return random.nextInt(6);
    }
}
