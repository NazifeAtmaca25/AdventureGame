import java.util.Random;

public class Mine extends BattleLoc{
    public Mine(Player player) {
        super(new Snake() , player);
    }

    @Override
    public boolean isAlive() {
        return getPlayer().getHealthy() > 0;
    }

    @Override
    public void combat() {
        Random random=new Random();
        int chance= random.nextInt(2);
        int playerHealt=getPlayer().getHealthy();
        System.out.println("Kombata girildi...");
        System.out.println();
        System.out.println(getPlayer().getName()+" başlangıç sağlık:"+getPlayer().getHealthy());
        int numberofSnake =getObstacle().obstacleNumber();
        while (numberofSnake>0){
            System.out.println(numberofSnake + " tane "+getObstacle().getNameO()+" var.");
            System.out.println(getObstacle().getNameO()+" başlangıç sağlık durumu:"+getObstacle().getHealthyO());
            System.out.println();
            int snakeHealt =getObstacle().getHealthyO();
            while (snakeHealt>0&&playerHealt>0){
                if (chance==0){
                    System.out.println(getPlayer().getName()+" saldırıyı yapıyor...");
                    snakeHealt -=getPlayer().getDamage();
                    if (snakeHealt <=0){
                        System.out.println(getObstacle().getNameO()+" ölmüştür.");
                        break;
                    }
                    System.out.println(getObstacle().getNameO()+" kalan sağlığı:"+ snakeHealt);
                    System.out.println(getObstacle().getNameO()+" saldırıyor.");
                    playerHealt-=getObstacle().getDamageO();
                    if (playerHealt<=0){
                        System.out.println(getPlayer().getName()+" ölmüştür");
                        break;
                    }
                    System.out.println(getPlayer().getName()+" kalan sağlık:"+playerHealt);
                }else {
                    System.out.println(getObstacle().getNameO()+" saldırıyor.");
                    playerHealt-=getObstacle().getDamageO();
                    if (playerHealt<=0){
                        System.out.println(getPlayer().getName()+" ölmüştür");
                        break;
                    }
                    System.out.println(getPlayer().getName()+" kalan sağlık:"+playerHealt);
                    System.out.println(getPlayer().getName()+" saldırıyı yapıyor...");
                    snakeHealt -=getPlayer().getDamage();
                    if (snakeHealt <=0){
                        System.out.println(getObstacle().getNameO()+" ölmüştür.");
                        break;
                    }
                    System.out.println(getObstacle().getNameO()+" kalan sağlığı:"+ snakeHealt);
                }
                System.out.println();
            }
            if (playerHealt<=0){
                System.out.println("Karakteriniz ölmüştür...");
                getPlayer().setHealthy(0);
                break;
            }else {
                //alınacak ödülleri buraya yaz...
                numberofSnake--;
                int money= getPlayer().getMoney()+4;
                getPlayer().setMoney(money);
                getPlayer().setHealthy(playerHealt);
            }
        }

    }

    @Override
    public boolean onLocation() {
        System.out.println("Şu an maden bölgesindesiniz...");
        System.out.println("Yılanları yenerek ödülleri alınız...");
        return true;
    }
}
