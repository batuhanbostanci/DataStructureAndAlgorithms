public class MercedenzBenzTruck implements Truck {
    private int axles;
    private int weight;
    private String name = "Truck name: Mercesedes plate no :lek-1051";


    // this constucter for number of the axles is 0
    public MercedenzBenzTruck( int kilo) {
        this.axles=0;
        this.weight = kilo;
    }

    public MercedenzBenzTruck(int axles, int kilo) {
        this.axles = axles;
        this.weight = kilo;
    }

    @Override
    public String infoGetter() {
        return name;
    }

    @Override
    public int axelsCounter() {
        return axles;
    }

    @Override
    public int totalWeightCalculator() {
        return weight;
    }

    public int getAxles() {
        return axles;
    }

    public void setAxles(int axles) {
        this.axles = axles;
    }

    public int getKilo() {
        return weight;
    }

    public void setKilo(int kilo) {
        this.weight = kilo;
    }


}
