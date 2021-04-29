import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(".\\data\\ReferenceString.txt");
        Scanner fs = new Scanner(f);

        //String refString = fs.nextLine();
        String refString = "";

//        System.out.print("Reference String: ");
//        for(int i = 0; i < refString.length(); i++){
//            System.out.print(refString.charAt(i) + " ");
//        }
        //System.out.println();
        //System.out.printf("Total Page Faults: %d\r\n", FIFO.handleFIFO(6,refString));
        //System.out.println();
        //System.out.printf("Total Page Faults: %d\r\n", LRU.handleLRU(5, refString));
        //System.out.println();
        //System.out.printf("Total Page Faults: %d\r\n", Optimal.handleOptimal(6, refString));

        //System.out.println(pf);
        ArrayList<Integer> FIFOArrList = new ArrayList<>();
        ArrayList<Integer> LRUArrList = new ArrayList<>();
        ArrayList<Integer> OptimalArrList = new ArrayList<>();
        while(fs.hasNext()){
            refString = fs.nextLine();
            FIFOArrList.add(FIFO.handleFIFO(6,refString));
            LRUArrList.add(LRU.handleLRU(6,refString));
            OptimalArrList.add(Optimal.handleOptimal(6,refString));
        }

        System.out.printf("%s - %d\r\n", FIFOArrList.toString(), sum(FIFOArrList));
        System.out.printf("%s - %d\r\n", LRUArrList.toString(), sum(LRUArrList));
        System.out.printf("%s - %d\r\n", OptimalArrList.toString(), sum(OptimalArrList));


    }

    public static int sum (ArrayList<Integer> al){
        int sum = 0;

        for(int i:al)
            sum+=i;

        return sum;
    }
}
