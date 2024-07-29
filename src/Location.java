public abstract class Location {
    private Player player;
    private String nameL;
    public Location(String nameL){
        this.nameL=nameL;
    }

    public abstract boolean onLocation();

    public String getNameL() {
        return nameL;
    }

    public void setNameL(String nameL) {
        this.nameL = nameL;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
