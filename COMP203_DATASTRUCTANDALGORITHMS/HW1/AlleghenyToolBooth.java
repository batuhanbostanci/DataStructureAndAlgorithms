

public class AlleghenyToolBooth implements TollBooth {
    private int TheNumberOfTruck;
    private int TheNumberOfReceipts;
    private int billo =0;
    public AlleghenyToolBooth(){
        this.TheNumberOfReceipts=0;
        this.TheNumberOfTruck=0;
    }
        // When the truck comes this method shows the bill
    @Override
    public void CalculationOfTotalBill(Truck truck) {
         int axles = truck.axelsCounter();
         int weight = truck.totalWeightCalculator();
         String names = truck.infoGetter();
         int bill = (axles*5) + 10*((weight/500)/2);
        System.out.println("Axles: "+ axles+" Truckweight: " + weight + " tolldue " + bill);
        System.out.println("Truck info :>" + names);


                 TheNumberOfReceipts +=1;
                 TheNumberOfTruck    +=1;
                 billo += bill;
    }
        // The method shows the total value of the day and it
    @Override
    public void DisplayTotalReceipts() {
        System.out.println("No of Trucks " + TheNumberOfTruck);
        System.out.println("Reciept " + billo);


    }

    @Override
    public void RestartmeterFunc() {
        TheNumberOfTruck=0;
        TheNumberOfReceipts=0;
    }
}
