public class Main {
    public static void main(String[] args) {
        Inventory inventory=new Inventory(false,false,false,"a","a",5,5);
        Player player=new Player(inventory);

       Game game=new Game(player);
       game.start();
    }
}