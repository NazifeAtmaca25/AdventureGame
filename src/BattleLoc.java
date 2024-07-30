public abstract class BattleLoc extends Location{

    private Obstacle obstacle;


    public BattleLoc(Obstacle obstacle,Player player) {
        super(player);
        this.obstacle = obstacle;
    }

    public abstract boolean isAlive();

    public abstract void combat();

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }


}
