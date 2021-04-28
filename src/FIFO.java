import java.util.ArrayList;

public class FIFO {
    public static int handleFIFO(int pfSize, String refString){
        ArrayList<Character> fifo = new ArrayList<>(pfSize);
        char currRefStringElement = 0;
        int currArrListIndex = 0;
        int pageFaults = 0;
        for(int i = 0; i < refString.length(); i++){
            char currElement = refString.charAt(currRefStringElement++);

            if(fifo.contains(currElement))
                continue;
            else{
                if(fifo.size() < pfSize){
                    fifo.add(currArrListIndex++, currElement);
                }
                else {
                    fifo.set(currArrListIndex++, currElement);
                }
                pageFaults++;
                currArrListIndex %= pfSize;
            }
        }
        return pageFaults;

    }
}
