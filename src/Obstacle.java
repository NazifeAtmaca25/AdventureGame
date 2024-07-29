import java.util.Random;

public class Obstacle {
    private String nameO;
    private int damageO;
    private int healthyO;
    private int monet0;

    public Obstacle(String nameO, int damageO, int healthyO, int monet0) {
        this.nameO = nameO;
        this.damageO = damageO;
        this.healthyO = healthyO;
        this.monet0 = monet0;
    }
    public int obstacleNumber(){
        Random random=new Random();
        return random.nextInt(4);
    }

    public String getNameO(){
        return nameO;
    }
    public void setNameO(String nameO){
        this.nameO=nameO;
    }

    public int getDamageO() {
        return damageO;
    }

    public void setDamageO(int damageO) {
        this.damageO = damageO;
    }

    public int getHealthyO() {
        return healthyO;
    }

    public void setHealthyO(int healthyO) {
        this.healthyO = healthyO;
    }

    public int getMonet0() {
        return monet0;
    }

    public void setMonet0(int monet0) {
        this.monet0 = monet0;
    }
}
