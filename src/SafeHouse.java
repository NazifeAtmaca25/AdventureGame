public class SafeHouse extends NormalL{
    public SafeHouse(Player player) {
        super(player);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Şu an evinizdesiniz.");
        System.out.println("Canınız yenileniyor");
        switch (getPlayer().getName()){
            case "Samuray":
                getPlayer().setHealthy(21);
                break;
            case "Okçu":
                getPlayer().setHealthy(18);
                break;
            case "Şovalye":
                getPlayer().setHealthy(24);
        }
        System.out.println("Güncel can:"+getPlayer().getHealthy());
        return true;
    }
}
