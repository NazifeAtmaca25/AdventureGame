import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private int damage;
    private int healthy;
    private int money;
    private String name;

    public Player(Inventory inventory){
        this.inventory=inventory;
    }



    public void selectChar(){
        boolean isCorrect=true;
        System.out.println("Lütfen seçmek istediğiniz karakterin numarasını girin.");
        System.out.println("1-> Samuray, Hasar:5, Sağlık:21, Para:15"+
                "\n2-> Okçu, Hasar:7, Sağlık:18, Para:20"+
                "\n3-> Şovalye, Hasar:8, Sağlık:24, Para:5");
        Scanner scanner=new Scanner(System.in);

        while (isCorrect) {
            int choice=scanner.nextInt();
            switch (choice) {
                case 1:
                    setName("Samuray");
                    setDamage(5);
                    setHealthy(21);
                    setMoney(15);
                    isCorrect=false;
                    break;
                case 2:
                    setName("Okçu");
                    setDamage(7);
                    setHealthy(18);
                    setMoney(20);
                    isCorrect=false;
                    break;
                case 3:
                    setName("Şovalye");
                    setDamage(8);
                    setHealthy(24);
                    setMoney(5);
                    isCorrect=false;
                    break;
                default:
                    System.out.println("Geçerli bi değer giriniz.");
                    break;
            }
        }


    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
