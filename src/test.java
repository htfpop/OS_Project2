import java.io.*;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(".\\data\\ReferenceString.txt");
        Scanner fs = new Scanner(f);

        String refString = fs.nextLine();
        int pf = FIFO.handleFIFO(6,refString);
        System.out.println(pf);
//        int counter = 0;
//        while(fs.hasNext()){
//            counter++;
//            String refString = fs.nextLine();
//            System.out.printf("%s\r\n",refString);
//        }
//        System.out.println(counter);
    }
}
