public class SafeHouse extends NormalL{
    public SafeHouse() {
        super("SafeHouse");
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
        return true;
    }
}
