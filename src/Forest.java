import java.util.Random;

public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(new Vampire(),player);
    }

    @Override
    public void combat() {
        Random random=new Random();
        int chance=random.nextInt(2);
        int playerHealt=getPlayer().getHealthy();
        System.out.println("Kombata girildi...");
        System.out.println();
        System.out.println(getPlayer().getName()+" başlangıç sağlık:"+getPlayer().getHealthy());
        int numberofVampire =getObstacle().obstacleNumber();
        while (numberofVampire >0){
            System.out.println(numberofVampire + " tane "+getObstacle().getNameO()+" var.");
            System.out.println(getObstacle().getNameO()+" başlangıç sağlık durumu:"+getObstacle().getHealthyO());
            System.out.println();
            int vampireHealt =getObstacle().getHealthyO();
            while (vampireHealt >0&&playerHealt>0){//canavar veya insandan biri ölünceye kadar devam eder
                if (chance==0){//ilk kimin başlanacağı karar verilir karakter
                    System.out.println(getPlayer().getName()+" saldırıyı yapıyor...");
                    vampireHealt -=getPlayer().getDamage();
                    if (vampireHealt <=0){
                        System.out.println(getObstacle().getNameO()+" ölmüştür.");
                        break;
                    }
                    System.out.println(getObstacle().getNameO()+" kalan sağlığı:"+ vampireHealt);
                    System.out.println(getObstacle().getNameO()+" saldırıyor.");
                    playerHealt-=getObstacle().getDamageO();
                    if (playerHealt<=0){
                        System.out.println(getPlayer().getName()+" ölmüştür");
                        break;
                    }
                    System.out.println(getPlayer().getName()+" kalan sağlık:"+playerHealt);
                }else {//canavar
                    System.out.println(getObstacle().getNameO()+" saldırıyor.");
                    playerHealt-=getObstacle().getDamageO();
                    if (playerHealt<=0){
                        System.out.println(getPlayer().getName()+" ölmüştür");
                        break;
                    }
                    System.out.println(getPlayer().getName()+" kalan sağlık:"+playerHealt);
                    System.out.println(getPlayer().getName()+" saldırıyı yapıyor...");
                    vampireHealt -=getPlayer().getDamage();
                    if (vampireHealt <=0){
                        System.out.println(getObstacle().getNameO()+" ölmüştür.");
                        break;
                    }
                    System.out.println(getObstacle().getNameO()+" kalan sağlığı:"+ vampireHealt);
                }

                System.out.println();
            }
            if (playerHealt<=0){
                System.out.println("Karakteriniz ölmüştür...");
                getPlayer().setHealthy(0);
                break;
            }else {//canavar sayısı azaltma ve para kazanma kısmı
                numberofVampire--;
                int money= getPlayer().getMoney()+4;
                getPlayer().setMoney(money);
                getPlayer().setHealthy(playerHealt);
            }
        }
        if (playerHealt>0){//odun envaterinin kazanıldığı kısım
            getPlayer().getInventory().setFirewood(true);
        }

    }

    @Override
    public boolean isAlive() {
        return getPlayer().getHealthy() > 0;
    }

    @Override
    public boolean onLocation() {
        System.out.println("Şu an orman bölgesindesiniz.");
        System.out.println("Vampirleri yenerek odun parçasını alınız...");
        return true;
    }
}
