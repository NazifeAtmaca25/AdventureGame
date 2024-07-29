public class River extends BattleLoc{
    public River() {
        super(new Bear());
    }

    @Override
    public void combat() {
        int playerHealt=getPlayer().getHealthy();
        System.out.println("Kombata girildi...");
        int numberofBear =getObstacle().obstacleNumber();
        while (numberofBear >0){
            int bearHealt =getObstacle().getHealthyO();
            while (bearHealt >0&&playerHealt>0){
                System.out.println(getPlayer().getName()+" saldırıyı yapıyor...");
                bearHealt -=getPlayer().getDamage();
                System.out.println(getObstacle().getNameO()+" kalan sağlığı:"+ bearHealt);
                System.out.println(getObstacle().getNameO()+" saldırıyor.");
                playerHealt-=getObstacle().getDamageO();
                System.out.println(getPlayer().getName()+" kalan sağlık:"+playerHealt);
            }
            if (playerHealt==0){
                System.out.println("Karakteriniz ölmüştür...");
                getPlayer().setHealthy(0);
                break;
            }else {
                numberofBear--;
                int money= getPlayer().getMoney()+12;
                getPlayer().setMoney(money);
                getPlayer().setHealthy(playerHealt);
            }
        }
        if (playerHealt>0){
            getPlayer().getInventory().setWater(true);
        }
    }

    @Override
    public boolean onLocation() {
        System.out.println("Şu an nehir bölgesindesiniz.");
        System.out.println("Ayıları yenerek suları toplayınız...");
        return true;
    }
}
