/**
 * Programmer: Christopher K. Leung
 * Course: CS 4310 - Operating Systems
 * Program: LRU.java
 * Description: This program will calculate the number of page faults for a given page frame size, and reference string
 *              using the First Come First Served (FCFS) algorithm
 */
import java.util.ArrayList;

public class FIFO {
    public static int handleFIFO(int pfSize, String refString){

        //check if data passed in is initialized
        if(!(pfSize > 0 && refString.length() > 0)){
            System.out.println("Input for FCFS has not been initialized");
            return 0;
        }

        //instantiate ArrayList with page frame size
        ArrayList<Character> fifo = new ArrayList<>(pfSize);

        //counters and trackers for FCFS algorithm
        char currRefStringElement = 0;
        int currArrListIndex = 0;
        int pageFaults = 0;

        for(int i = 0; i < refString.length(); i++){
            //obtain next page in reference string
            char currPage = refString.charAt(currRefStringElement++);

            //if our ArrayList contains, no page fault occurs and continue with algorithm
            if(fifo.contains(currPage)) {
                arrListPrinter.printArrList(fifo, pfSize, false);
            }
            //if our ArrayList does not contain this page
            else{
                //check to see if there are max elements in our ArrayList, if not then add to back of our ArrayList
                if(fifo.size() < pfSize){
                    fifo.add(currArrListIndex++, currPage);
                }
                //if max limits have been reached then set the oldest page to be the victim and swap with the current page
                else {
                    fifo.set(currArrListIndex++, currPage);
                }
                //update page faults and recalculate the victim page pointer
                pageFaults++;
                currArrListIndex %= pfSize;
                arrListPrinter.printArrList(fifo, pfSize, true);
            }
        }
        return pageFaults;
    }
}
