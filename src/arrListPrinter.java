import java.util.ArrayList;

public class arrListPrinter {
    public static void printArrList(ArrayList<Character> arrList, int pfSize, boolean pf){
        char c;
        for(int i = 0; i < pfSize; i++){
            try{ c = arrList.get(i); } catch(IndexOutOfBoundsException e){ c = ' '; }
            System.out.printf("%c | ", c);
        }
        if(pf){ System.out.printf("X"); }
        System.out.println();
    }
}
