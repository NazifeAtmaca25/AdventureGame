public class Forest extends BattleLoc{
    public Forest() {
        super(new Vampire());
    }

    @Override
    public void combat() {
        int playerHealt=getPlayer().getHealthy();
        System.out.println("Kombata girildi...");
        int numberofVampire=getObstacle().obstacleNumber();
        while (numberofVampire>0){
            int vampireHealt=getObstacle().getHealthyO();
            while (vampireHealt>0&&playerHealt>0){
                System.out.println(getPlayer().getName()+" saldırıyı yapıyor...");
                vampireHealt-=getPlayer().getDamage();
                System.out.println(getObstacle().getNameO()+" kalan sağlığı:"+vampireHealt);
                System.out.println(getObstacle().getNameO()+" saldırıyor.");
                playerHealt-=getObstacle().getDamageO();
                System.out.println(getPlayer().getName()+" kalan sağlık:"+playerHealt);
            }
            if (playerHealt==0){
                System.out.println("Karakteriniz ölmüştür...");
                break;
            }else {
                numberofVampire--;
                int money= getPlayer().getMoney()+7;
                getPlayer().setMoney(money);
                getPlayer().setHealthy(playerHealt);
            }
        }
        if (playerHealt>0){
            getPlayer().getInventory().setFirewood(true);
        }

    }

    @Override
    public boolean onLocation() {
        System.out.println("Şu an orman bölgesindesiniz.");
        System.out.println("Vampirleri yenerek odun parçasını alınız...");
        return true;
    }
}
