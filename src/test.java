import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(".\\data\\ReferenceString.txt");
        Scanner fs = new Scanner(f);

        //String refString = fs.nextLine();
        String refString = "022467551356344120536760051101";

        for(int i = 0; i < refString.length(); i++){
            System.out.print(refString.charAt(i) + " ");
        }
        System.out.println();
        System.out.println(FIFO.handleFIFO(6,refString));
        System.out.println(LRU.handleLRU(6, refString));

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
