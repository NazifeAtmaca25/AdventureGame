public class Cave extends BattleLoc{
    public Cave() {
        super(new Zombie());
    }

    @Override
    public void combat() {
        int playerHealt=getPlayer().getHealthy();
        System.out.println("Kombata girildi...");
        int numberofZombie =getObstacle().obstacleNumber();
        while (numberofZombie >0){
            int zombieHealt =getObstacle().getHealthyO();
            while (zombieHealt >0&&playerHealt>0){
                System.out.println(getPlayer().getName()+" saldırıyı yapıyor...");
                zombieHealt -=getPlayer().getDamage();
                System.out.println(getObstacle().getNameO()+" kalan sağlığı:"+ zombieHealt);
                System.out.println(getObstacle().getNameO()+" saldırıyor.");
                playerHealt-=getObstacle().getDamageO();
                System.out.println(getPlayer().getName()+" kalan sağlık:"+playerHealt);
            }
            if (playerHealt==0){
                System.out.println("Karakteriniz ölmüştür...");
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
    public boolean onLocation() {
        System.out.println("Şu an mağara bölgesindesiniz.");
        System.out.println("Zombileri yenerek yemekeleri toplayınız...");
        return true;
    }
}
