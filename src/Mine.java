import java.util.Random;

public class Mine extends BattleLoc{
    public ToolStore toolStore;
    public Mine(Player player) {
        super(new Snake() , player);
        this.toolStore=new ToolStore(player);
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
        while (numberofSnake>0){//canavarlar ölünceye kadar döngüde
            System.out.println(numberofSnake + " tane "+getObstacle().getNameO()+" var.");
            System.out.println(getObstacle().getNameO()+" başlangıç sağlık durumu:"+getObstacle().getHealthyO());
            System.out.println();
            int snakeHealt =getObstacle().getHealthyO();
            while (snakeHealt>0&&playerHealt>0){//canavar veya insandan biri ölünceye kdar devam ediyor
                if (chance==0){//ilk kimin başlayacağına kadar veriliyor oyuncu
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
                }else {//canavar
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
                //canavarı öldürdüğünde canavardan düşen rastgele eşyaların verilmesi
                numberofSnake--;
                int chance1=random.nextInt(101);
                int chance2=random.nextInt(101);
                if (chance1<=15){//silah
                    if (chance2<=20){
                        System.out.println("Tebrikler tüfek düştü...");
                        int hasar=toolStore.haveWeapon();
                        getPlayer().getInventory().setWeaponName("Tüfek");
                        getPlayer().getInventory().setWeaponDamage(7);
                        hasar+=7;
                        getPlayer().setDamage(hasar);
                        getPlayer().getInventory().setWeapon(true);
                        System.out.println("Yeni hasar:"+getPlayer().getDamage());
                        System.out.println();
                    } else if (chance2<=50) {
                        System.out.println("Tebrikler kılıç düştü...");
                        int hasar=toolStore.haveWeapon();
                        getPlayer().getInventory().setWeaponName("Kılıç");
                        getPlayer().getInventory().setWeaponDamage(3);
                        hasar+=3;
                        getPlayer().setDamage(hasar);
                        getPlayer().getInventory().setWeapon(true);
                        System.out.println("Yeni hasar:"+getPlayer().getDamage());
                        System.out.println();
                    }else {
                        System.out.println("Tebrikler tabanca düştü...");
                        int hasar=toolStore.haveWeapon();
                        getPlayer().getInventory().setWeaponName("Tabanca");
                        getPlayer().getInventory().setWeaponDamage(2);
                        hasar+=2;
                        getPlayer().setDamage(hasar);
                        getPlayer().getInventory().setWeapon(true);
                        System.out.println("Yeni hasar:"+getPlayer().getDamage());
                        System.out.println();
                    }

                } else if (chance1<=30) {//zırh
                    if (chance2<=20){
                        System.out.println("Tebrikler ağır zırh düştü...");
                        int healt=toolStore.haveArmor();
                        getPlayer().getInventory().setArmorName("Ağır");
                        getPlayer().getInventory().setArmorDefence(40);
                        healt+=5;
                        getPlayer().setHealthy(healt);
                        getPlayer().getInventory().setArmor(true);
                        System.out.println("Yeni sağlığınız:"+getPlayer().getHealthy());
                        System.out.println();
                    } else if (chance2<=50) {
                        System.out.println("Tebrikler orta zırh düştü...");
                        int healt=toolStore.haveArmor();
                        getPlayer().getInventory().setArmorName("Orta");
                        getPlayer().getInventory().setArmorDefence(3);
                        healt+=3;
                        getPlayer().setHealthy(healt);
                        getPlayer().getInventory().setArmor(true);
                        System.out.println("Yeni sağlığınız:"+getPlayer().getHealthy());
                        System.out.println();
                    }else {
                        System.out.println("Tebrikler zayıf zırh düştü...");
                        int healt=toolStore.haveArmor();
                        getPlayer().getInventory().setArmorName("Hafif");
                        getPlayer().getInventory().setArmorDefence(1);
                        healt+=1;
                        getPlayer().setHealthy(healt);
                        getPlayer().getInventory().setArmor(true);
                        System.out.println("Yeni sağlığınız:"+getPlayer().getHealthy());
                        System.out.println();
                    }
                } else if (chance1<=55) {//para
                    if (chance2<=20){
                        System.out.println("Tebrikler 10 para düştü");
                        int money= getPlayer().getMoney()+10;
                        getPlayer().setMoney(money);
                        System.out.println("Yeni bakiyeniz:"+getPlayer().getMoney());
                        System.out.println();
                    } else if (chance2<=50) {
                        System.out.println("Tebrikler 5 para düştü");
                        int money= getPlayer().getMoney()+5;
                        getPlayer().setMoney(money);
                        System.out.println("Yeni bakiyeniz:"+getPlayer().getMoney());
                        System.out.println();
                    }else {
                        System.out.println("Tebrikler 1 para düştü");
                        int money= getPlayer().getMoney()+1;
                        getPlayer().setMoney(money);
                        System.out.println("Yeni bakiyeniz:"+getPlayer().getMoney());
                        System.out.println();
                    }

                }else {
                    System.out.println("Hiçbir şey düşmedi");
                }

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
