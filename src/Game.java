import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;
    public boolean isIn=true;



    public void start(){
        //oyunun oynandığı kısım. diğer classlardaki bütün metodlar burada kullanıldı.
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
                    SafeHouse safeHouse = new SafeHouse(player);
                    if (isWin(player)) {
                        System.out.println("Tebrikler oyunu kazandınız!!!!");
                        isIn = false;
                        break;
                    }
                    safeHouse.onLocation();
                    printArea();
                    break;
                case 2:
                    ToolStore toolStore=new ToolStore(player);
                    toolStore.onLocation();
                    printArea();
                    break;
                case 3:
                    if (!player.getInventory().isFood()){
                        operation(new Cave(player),player);
                    }else {
                        System.out.println("Bu bölgeye daha önce geldiniz...");
                    }
                    break;
                case 4:
                    if (!player.getInventory().isFirewood()){
                        operation(new Forest(player),player);
                    }else {
                        System.out.println("Bu bölgeye daha önce geldiniz...");
                    }
                    break;
                case 5:
                    if (!player.getInventory().isWater()){
                        operation(new River(player),player);
                    }else{
                        System.out.println("Bu bölgeye daha önce geldiniz...");
                    }
                    break;
                case 6:
                    operation(new Mine(player),player);
                    break;
                case 7:
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
    public void operation(BattleLoc battleLoc,Player player){
        //savaş alanlarıiçin olan metod
        battleLoc.onLocation();
        battleLoc.combat();
        printItem(player);
        if (!battleLoc.isAlive()){
            System.out.println("Oyunu kaybettiniz.");
            isIn=false;
        } else {
            printArea();
        }
    }
    public boolean isWin(Player player){
        //alınması gerekn ögelerin alınıp alınmadığına bakar.
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
                "\n6->Mine:Maden bölgesi 4. zorluk bölgesi Gizemli ödülleri topla"+
                "\n7->Haritadan çıkış");
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
