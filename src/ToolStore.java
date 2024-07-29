import java.util.Scanner;

public class ToolStore extends NormalL{
    public ToolStore() {
        super("ToolStore");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Şu an mağazadasınız.");
        System.out.println("İstediğiniz ürünü alınız.");
        return true;
    }
    public void menu(){
        System.out.println("SİLAHLAR");
        System.out.println("1->Tabanca, Hasar:2, Para:25"+
                "\n2->Kılıç, Hasar:3, Para:35"+
                "\n3->Tüfek, Hasar:7, Para:45");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("ZIRHLAR");
        System.out.println("4->Hafif, Engelleme:1, Para:15"+
                "\n5->Orta, Engelleme:3, Para:25"+
                "\n6->Ağır, Engelleme:5, Para:40");
        System.out.println("-----------------------------------------------------------------");
    }

    public void buy(){
        boolean isCorrect=true;
        int hasar= getPlayer().getDamage(),healt= getPlayer().getHealthy(),money= getPlayer().getMoney();
        System.out.println("Mevcut bakiyeniz:"+getPlayer().getMoney());
        System.out.println("Almak istediğiniz ürünün numarasını giriniz:");
        Scanner scanner=new Scanner(System.in);
        while (isCorrect){
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    if (money-25>0){
                        getPlayer().getInventory().setWeaponName("Tabanca");
                        getPlayer().getInventory().setWeaponDamage(2);
                        hasar+=2;
                        getPlayer().setDamage(hasar);
                        money-=25;
                        getPlayer().setMoney(money);
                    } else {
                        System.out.println("Paranız yeterli değildir.");
                    }
                    break;
                case 2:
                    if (money-35>0){
                        getPlayer().getInventory().setWeaponName("Kılıç");
                        getPlayer().getInventory().setWeaponDamage(3);
                        hasar+=3;
                        getPlayer().setDamage(hasar);
                        money-=35;
                        getPlayer().setMoney(money);
                    }else {
                        System.out.println("Paranız yeterli değildir.");
                    }
                    break;
                case 3:
                    if (money-45>0){
                        getPlayer().getInventory().setWeaponName("Tüfek");
                        getPlayer().getInventory().setWeaponDamage(7);
                        hasar+=7;
                        getPlayer().setDamage(hasar);
                        money-=45;
                        getPlayer().setMoney(money);
                    }else {
                        System.out.println("Paranız yeterli değildir.");
                    }
                    break;
                case 4:
                    if (money-15>0){
                        getPlayer().getInventory().setArmorName("Hafif");
                        getPlayer().getInventory().setArmorDefence(1);
                        healt+=1;
                        getPlayer().setHealthy(healt);
                        money-=15;
                        getPlayer().setMoney(money);
                    }else {
                        System.out.println("Paranız yeterli değildir.");
                    }
                    break;
                case 5:
                    if (money-25>0){
                        getPlayer().getInventory().setArmorName("Orta");
                        getPlayer().getInventory().setArmorDefence(3);
                        healt+=3;
                        getPlayer().setHealthy(healt);
                        money-=25;
                        getPlayer().setMoney(money);
                    }else {
                        System.out.println("Paranız yeterli değildir.");
                    }
                    break;
                case 6:
                    if (money-40>0){
                        getPlayer().getInventory().setArmorName("Ağır");
                        getPlayer().getInventory().setArmorDefence(40);
                        healt+=5;
                        getPlayer().setHealthy(healt);
                        money-=40;
                        getPlayer().setMoney(money);
                    }else {
                        System.out.println("Paranız yeterli değildir.");
                    }
                    break;
                default:
                    System.out.println("Geçerli bi değer giriniz.");
            }
        }
    }
}
