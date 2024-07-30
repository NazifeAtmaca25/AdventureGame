import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;
    public boolean isIn=true;



    public void start(){
        Inventory inventory=new Inventory(false,false,false," "," ",0,0);
        Player player=new Player(inventory);
        player.selectChar();
        System.out.println("Hangi bölgeye gitmek istersiniz:");
        printArea();
        Scanner scanner=new Scanner(System.in);
        while (isIn){
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    SafeHouse safeHouse=new SafeHouse(player);
                    safeHouse.onLocation();
                    printArea();
                    break;
                case 2:
                    ToolStore toolStore=new ToolStore(player);
                    toolStore.onLocation();
                    printArea();
                    break;
                case 3:
                    operation(new Cave(player));
                    printItem(player);
                    if (isWin(player)){
                        System.out.println("Tebrikler oyunu kazandınız!!!!");
                        isIn=false;
                        break;
                    }

                    break;
                case 4:
                    operation(new Forest(player));
                    printItem(player);
                    if (isWin(player)){
                        System.out.println("Tebrikler oyunu kazandınız!!!!");
                        isIn=false;
                        break;
                    }
                    break;
                case 5:
                    operation(new River(player));
                    printItem(player);
                    if (isWin(player)) {
                        System.out.println("Tebrikler oyunu kazandınız!!!!");
                        isIn = false;
                        break;
                    }
                    break;
                case 6:
                    isIn=false;
                    break;
                default:
                    System.out.println("Geçerli bir değer giriniz...");
                    printArea();
                    break;
            }

        }
        if (!isWin(player)){
            System.out.println("Eksik envanter....");
            System.out.println("Oyunu kaybettiniz...");
        }

    }
    public void operation(BattleLoc battleLoc){
        battleLoc.onLocation();
        battleLoc.combat();
        if (!battleLoc.isAlive()){
            System.out.println("Oyunu kaybettiniz.");
            isIn=false;
        } else {
            printArea();
        }
    }
    public boolean isWin(Player player){
        return player.getInventory().isWater()&&player.getInventory().isFood()&&player.getInventory().isFirewood();
    }
    public void printItem(Player player){
        System.out.println("Yemek: "+player.getInventory().isFood());
        System.out.println("Odun: "+player.getInventory().isFirewood());
        System.out.println("Su: "+player.getInventory().isWater());
        System.out.println("Silah: "+player.getInventory().getWeaponName());
        System.out.println("Zırh: "+player.getInventory().getArmorName());
        System.out.println("Sağlık: "+player.getHealthy());
        System.out.println("Hasar: "+player.getDamage());
        System.out.println("Para: "+player.getMoney());
    }
    public void printArea(){
        System.out.println("1->SafeHouse:Canını yenilemek ve dinlemek için..."+
                "\n2->ToolStore:Alışveriş yapmak için..."+
                "\n3->Cave:Mağara bölgesi 1. zorluk bölgesi, Yemekleri topla"+
                "\n4->Forest:Orman bölgesi 2. zorluk bölgesi Odunarı topla"+
                "\n5->River:Nehir bölgesi 3. zorluk bölgesi Suları topla"+
                "\n6->Haritadan çıkış");
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
