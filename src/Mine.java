public class Mine extends BattleLoc{
    public Mine(Player player) {
        super(new Snake() , player);
    }

    @Override
    public boolean isAlive() {
        return getPlayer().getHealthy() > 0;
    }

    @Override
    public void combat() {

    }

    @Override
    public boolean onLocation() {
        System.out.println("Şu an maden bölgesindesiniz...");
        System.out.println("Yılanları yenerek ödülleri alınız...");
        return true;
    }
}
