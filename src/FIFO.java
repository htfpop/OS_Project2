import java.util.ArrayList;

public class FIFO {
    public static int handleFIFO(int pfSize, String refString){
        ArrayList<Character> fifo = new ArrayList<>(pfSize);
        char currRefStringElement = 0;
        int currArrListIndex = 0;
        int pageFaults = 0;
        for(int i = 0; i < refString.length(); i++){
            char currElement = refString.charAt(currRefStringElement++);

            if(fifo.contains(currElement)) {
                printFIFO(fifo, pfSize, false);
                continue;
            }
            else{
                if(fifo.size() < pfSize){
                    fifo.add(currArrListIndex++, currElement);
                }
                else {
                    fifo.set(currArrListIndex++, currElement);
                }
                pageFaults++;
                currArrListIndex %= pfSize;
                printFIFO(fifo, pfSize, true);
            }
        }
        return pageFaults;
    }

    public static void printFIFO(ArrayList<Character> arrList, int pfSize,  boolean pf){
        char c;
        for(int i = 0; i < pfSize; i++){
            try{ c = arrList.get(i); } catch(IndexOutOfBoundsException e){ c = ' '; }
            System.out.printf("%c | ", c);
        }
        if(pf){ System.out.printf("X"); }
        System.out.println();
    }
}
