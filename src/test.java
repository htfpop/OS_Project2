import java.io.*;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(".\\data\\ReferenceString.txt");
        Scanner fs = new Scanner(f);

        //String refString = fs.nextLine();
        String refString = "615534616624114475127350113050";

        System.out.print("Reference String: ");
        for(int i = 0; i < refString.length(); i++){
            System.out.print(refString.charAt(i) + " ");
        }
        System.out.println();
        //System.out.printf("Total Page Faults: %d\r\n", FIFO.handleFIFO(6,refString));
        //System.out.println();
        System.out.printf("Total Page Faults: %d\r\n", LRU.handleLRU(5, refString));
        //System.out.println();
        //System.out.printf("Total Page Faults: %d\r\n", Optimal.handleOptimal(6, refString));

        //System.out.println(pf);
//        int counter = 0;
//        while(fs.hasNext()){
//            counter++;
//            String refString = fs.nextLine();
//            System.out.printf("%s\r\n",refString);
//        }
//        System.out.println(counter);
    }
}
