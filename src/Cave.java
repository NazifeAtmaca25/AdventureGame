import java.util.Random;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(new Zombie(),player);
    }

    @Override
    public void combat() {
        Random random=new Random();
        int chance=random.nextInt(2);
        int playerHealt=getPlayer().getHealthy();
        System.out.println("Kombata girildi...");
        System.out.println();
        System.out.println(getPlayer().getName()+" başlangıç sağlık:"+getPlayer().getHealthy());
        int numberofZombie =getObstacle().obstacleNumber();
        while (numberofZombie >0){
            System.out.println(numberofZombie+ " tane "+getObstacle().getNameO()+" var.");
            System.out.println(getObstacle().getNameO()+" başlangıç sağlık durumu:"+getObstacle().getHealthyO());
            System.out.println();
            int zombieHealt =getObstacle().getHealthyO();
            while (zombieHealt >0&&playerHealt>0){
                if (chance==0){
                    System.out.println(getPlayer().getName()+" saldırıyı yapıyor...");
                    zombieHealt -=getPlayer().getDamage();
                    if (zombieHealt<=0){
                        System.out.println(getObstacle().getNameO()+" ölmüştür.");
                        break;
                    }
                    System.out.println(getObstacle().getNameO()+" kalan sağlığı:"+ zombieHealt);
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
                    zombieHealt -=getPlayer().getDamage();
                    if (zombieHealt<=0){
                        System.out.println(getObstacle().getNameO()+" ölmüştür.");
                        break;
                    }
                    System.out.println(getObstacle().getNameO()+" kalan sağlığı:"+ zombieHealt);
                }

                System.out.println();
            }
            if (playerHealt<=0){
                System.out.println("Karakteriniz ölmüştür...");
                getPlayer().setHealthy(0);
                break;
            }else {
                numberofZombie--;
                int money= getPlayer().getMoney()+4;
                getPlayer().setMoney(money);
                getPlayer().setHealthy(playerHealt);
            }
        }
        if (playerHealt>0){
            getPlayer().getInventory().setFood(true);
        }
    }

    @Override
    public boolean isAlive() {
        return getPlayer().getHealthy() > 0;
    }


    @Override
    public boolean onLocation() {
        System.out.println("Şu an mağara bölgesindesiniz.");
        System.out.println("Zombileri yenerek yemekeleri toplayınız...");
        return true;
    }
}
