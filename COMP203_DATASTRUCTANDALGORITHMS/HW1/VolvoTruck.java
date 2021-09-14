public class VolvoTruck implements Truck {
private int axles;
private int weight;
private String name = "Truck name: Volvo plate no :lek-1021";



// this constucter for number of the axles is 0
    public VolvoTruck( int weight) {
        this.axles=0;
        this.weight = weight;
    }

    public VolvoTruck(int axles, int weight) {
        this.axles = axles;
        this.weight = weight;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
