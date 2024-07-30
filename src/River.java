import java.util.Random;

public class River extends BattleLoc{
    public River(Player player) {
        super(new Bear(),player);
    }

    @Override
    public void combat() {
        Random random=new Random();
        int chance= random.nextInt(2);
        int playerHealt=getPlayer().getHealthy();
        System.out.println("Kombata girildi...");
        System.out.println();
        System.out.println(getPlayer().getName()+" başlangıç sağlık:"+getPlayer().getHealthy());
        int numberofBear =getObstacle().obstacleNumber();
        while (numberofBear >0){
            System.out.println(numberofBear + " tane "+getObstacle().getNameO()+" var.");
            System.out.println(getObstacle().getNameO()+" başlangıç sağlık durumu:"+getObstacle().getHealthyO());
            System.out.println();
            int bearHealt =getObstacle().getHealthyO();
            while (bearHealt >0&&playerHealt>0){
                if (chance==0){
                    System.out.println(getPlayer().getName()+" saldırıyı yapıyor...");
                    bearHealt -=getPlayer().getDamage();
                    if (bearHealt <=0){
                        System.out.println(getObstacle().getNameO()+" ölmüştür.");
                        break;
                    }
                    System.out.println(getObstacle().getNameO()+" kalan sağlığı:"+ bearHealt);
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
                    bearHealt -=getPlayer().getDamage();
                    if (bearHealt <=0){
                        System.out.println(getObstacle().getNameO()+" ölmüştür.");
                        break;
                    }
                    System.out.println(getObstacle().getNameO()+" kalan sağlığı:"+ bearHealt);
                }

                System.out.println();
            }
            if (playerHealt<=0){
                System.out.println("Karakteriniz ölmüştür...");
                getPlayer().setHealthy(0);
                break;
            }else {
                numberofBear--;
                int money= getPlayer().getMoney()+4;
                getPlayer().setMoney(money);
                getPlayer().setHealthy(playerHealt);
            }
        }
        if (playerHealt>0){
            getPlayer().getInventory().setWater(true);
        }
    }
    @Override
    public boolean isAlive() {
        return getPlayer().getHealthy() > 0;
    }

    @Override
    public boolean onLocation() {
        System.out.println("Şu an nehir bölgesindesiniz.");
        System.out.println("Ayıları yenerek suları toplayınız...");
        return true;
    }
}
