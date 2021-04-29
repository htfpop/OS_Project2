/**
 * Programmer: Christopher K. Leung
 * Course: CS 4310 - Operating Systems
 * Program: Optimal.java
 * Description: This program will calculate the number of page faults for a given page frame size, and reference string
 *              using the Optimal algorithm
 */
import java.util.ArrayList;

public class Optimal {
    public static int handleOptimal(int pfSize, String refString){
        //initialize our page frame with given size and return variable
        ArrayList<Character> pageFrame = new ArrayList<>(pfSize);
        int pageFaults = 0;

        System.out.printf("Optimal algorithm with page frame size: %d frames\n",pfSize);
        System.out.println("------------------------------------------------");

        for(int i = 0; i < refString.length(); i++){
            //obtain our current page in our reference string
            char c = refString.charAt(i);
            System.out.printf("Page Requested: %c   ", c);

            //if our page frame has this page then continue with no page fault
            if(pageFrame.contains(c)){
                arrListPrinter.printArrList(pageFrame, pfSize, false);
            }
            //else, check if our page frame is full or not
            else{
                //if page frame is full, search remaining reference string
                if(pageFrame.size() == pfSize){
                    //initialize our victim and found variables for parsing
                    int victim = -999;
                    boolean found = false;

                    //iterate through our page frame
                    for(int j = 0; j < pageFrame.size(); j++){
                        //search the remaining reference string for other instances of the current page in page frame
                        int findIndex = refString.indexOf(pageFrame.get(j),i);

                        //if findIndex is -1, no more instances of this page in refString. mark current page frame index as victim
                        if(findIndex == -1){
                            victim = j;
                            found = false;
                            break;
                        }

                        //else only update findIndex if another instance of our page is farther away than the rest
                        else{
                            if(findIndex > victim) {
                                victim = findIndex;
                                found = true;
                            }
                        }
                    }

                    //if we could not find the page in the remaining reference string replace it immediately
                    if(!found){
                        pageFrame.set(victim, c);
                    }

                    //else, find the instance of the page in our page frame and set that pointer to our new page
                    else{
                        pageFrame.set(pageFrame.indexOf(refString.charAt(victim)), c);
                    }

                }

                //if page frame is not full then add to the end
                else{
                    pageFrame.add(c);
                }

                //update page fault variable
                pageFaults++;
                arrListPrinter.printArrList(pageFrame, pfSize, true);
            }
        }
        return pageFaults;
    }
}
