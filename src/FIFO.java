/**
 * Programmer: Christopher K. Leung
 * Course: CS 4310 - Operating Systems
 * Program: FCFS.java
 * Description: This program will calculate the number of page faults for a given page frame size, and reference string
 *              using the First Come First Served (FCFS) algorithm
 */
import java.util.ArrayList;

public class FCFS {
    public static int handleFCFS(int pfSize, String refString){

        //check if data passed in is initialized
        if(!(pfSize > 0 && refString.length() > 0)){
            System.out.println("Input for FCFS has not been initialized");
            return 0;
        }

        //instantiate ArrayList with page frame size
        ArrayList<Character> pageFrame = new ArrayList<>(pfSize);

        //counters and trackers for FCFS algorithm
        char currRefStringElement = 0;
        int currArrListIndex = 0;
        int pageFaults = 0;

        for(int i = 0; i < refString.length(); i++){
            //obtain next page in reference string
            char currPage = refString.charAt(currRefStringElement++);

            //if our ArrayList contains, no page fault occurs and continue with algorithm
            if(pageFrame.contains(currPage)) {
                arrListPrinter.printArrList(pageFrame, pfSize, false);
            }
            //if our ArrayList does not contain this page
            else{
                //check to see if there are max elements in our ArrayList, if not then add to back of our ArrayList
                if(pageFrame.size() < pfSize){
                    pageFrame.add(currArrListIndex++, currPage);
                }
                //if max limits have been reached then set the oldest page to be the victim and swap with the current page
                else {
                    pageFrame.set(currArrListIndex++, currPage);
                }
                //update page faults and recalculate the victim page pointer
                pageFaults++;
                currArrListIndex %= pfSize;
                arrListPrinter.printArrList(pageFrame, pfSize, true);
            }
        }
        return pageFaults;
    }
}