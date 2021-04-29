/**
 * Programmer: Christopher K. Leung
 * Course: CS 4310 - Operating Systems
 * Program: LRU.java
 * Description: This program will calculate the number of page faults for a given page frame size, and reference string
 *              using the least recently used (LRU) algorithm
 */

import java.util.ArrayList;
import java.util.Stack;

public class LRU {
    public static int handleLRU(int pfSize, String refString){
        //Create stack for page that was least recently used, ArrayList for keeping track of page frames
        Stack<Character>lastSeen = new Stack<>();
        ArrayList<Character> pageFrame = new ArrayList<>(pfSize);
        int pageFaults = 0;

        System.out.printf("LRU algorithm with page frame size: %d frames\n",pfSize);
        System.out.println("--------------------------------------------");

        for(int i = 0; i < refString.length(); i++){
            //obtain current page
            char currPage = refString.charAt(i);
            System.out.printf("Page Requested: %c   ",currPage);

            //if our page frame has this page, remove from stack and push same page back onto stack (mark as "new")
            if(pageFrame.contains(currPage)){
                int stackLocation = lastSeen.indexOf(currPage);
                lastSeen.remove(stackLocation);
                lastSeen.push(currPage);
                arrListPrinter.printArrList(pageFrame, pfSize, false);
            }
            //if page frame doesn't have this page
            else{
                //if page frame is full
                if(pageFrame.size() == pfSize){
                    //our least used page is at the bottom of the stack, find the page in our page frame and mark it as the victim
                    char leastUsed = lastSeen.remove(0);
                    int location = pageFrame.indexOf(leastUsed);

                    //push our new page onto the stack and replace the victim with current page
                    lastSeen.push(currPage);
                    pageFrame.set(location, currPage);
                }
                //if page frame is not full
                else{
                    lastSeen.push(currPage);
                    pageFrame.add(currPage);
                }
                //update page faults
                pageFaults++;
                arrListPrinter.printArrList(pageFrame, pfSize, true);
            }
        }
        return pageFaults;
    }
}
