import java.awt.*;
import java.util.*;
import java.util.Scanner;

public class TestTollBooth {

    public static void main(String[]args){


               // Truck mercedes = new MercedenzBenzTruck(5,12000);
               // Truck volvo = new VolvoTruck(2,5000);
               // booth.CalculationOfTotalBill(mercedes);
               //booth.CalculationOfTotalBill(volvo);
                 TollBooth booth = new AlleghenyToolBooth();
                    Truck mercedes;
                    Truck volvo;
                 LinkedList<Truck > ll = new LinkedList<Truck  >();
                 ll.add(  mercedes = new MercedenzBenzTruck(5,12500));
                 ll.add(  volvo = new VolvoTruck(6,15000));
                 int counter =0;
                 Scanner  scan = new Scanner(System.in);

                        String text = "1:Scan Barcode\n"+
                                      "2:Display Data \n"+
                                      "3:Restartmeter";


                        while(true){

                            System.out.print(text);
                            String  number = scan.nextLine();
                                if(number.equals("1")){
                                    if(counter >= ll.size()){
                                        System.out.println("no car came");
                                        continue;
                                    }
                                   booth.CalculationOfTotalBill(ll.get(counter));
                                    counter ++;

                                }
                                else if(number.equals("2")){
                                    booth.DisplayTotalReceipts();
                                }
                                else if(number.equals("3")){
                                   booth.RestartmeterFunc();
                               }


                            if (!(number.equals("1") || number.equals("2") || number.equals("3"))){
                                System.out.println("Quit");
                                break;
                            }
                        }

        scan.close();

    }
}
