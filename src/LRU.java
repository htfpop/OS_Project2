import java.util.ArrayList;
import java.util.Stack;

public class LRU {
    public static int handleLRU(int pfSize, String refString){
        Stack<Character>lastSeen = new Stack<>();
        ArrayList<Character> lru = new ArrayList<>(pfSize);
        int arrListHead = 0;
        int pageFaults = 0;

        for(int i = 0; i < refString.length(); i++){
            char currElement = refString.charAt(i);

            if(lru.contains(currElement)){
                int stackLocation = lastSeen.indexOf(currElement);
                lastSeen.remove(stackLocation);
                lastSeen.push(currElement);
                FIFO.printFIFO(lru, pfSize, false);
            }
            else{
                if(lru.size() == pfSize){
                    char leastUsed = lastSeen.remove(0);
                    int location = lru.indexOf(leastUsed);
                    lastSeen.push(currElement);
                    lru.set(location, currElement);
                }
                else{
                    lastSeen.push(currElement);
                    lru.add(currElement);
                }
                pageFaults++;
                FIFO.printFIFO(lru, pfSize, true);
            }
        }
        return pageFaults;
    }
}
