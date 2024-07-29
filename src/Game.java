public class Game {
    private Player player;
    private Location location;
    private Forest forest;

    public Game(Player player){
        this.player=player;


    }
    public void start(){
        getPlayer().selectChar();
        System.out.println("Hangi bölgeye gitmek istersiniz:");

        Forest forest1=new Forest();
        forest1.combat();
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
