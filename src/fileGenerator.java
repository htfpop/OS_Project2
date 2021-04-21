import java.io.*;
import java.util.Random;
public class fileGenerator {
    public static void main(String[] args) throws IOException {
        String dataSetDir = ".\\data\\";

        for(int i = 0; i < 50; i++){
            String refString = getRefString();

            genFile(refString, dataSetDir,3, i+1);
            genFile(refString, dataSetDir,4, i+1);
            genFile(refString, dataSetDir,5, i+1);
            genFile(refString, dataSetDir,6, i+1);
        }
    }

    public static void genFile(String refString, String dir, int page, int currentFileNum) throws IOException {
        String path = dir+page+"PageFrames\\"+"refString"+currentFileNum+".txt";
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("NumberOfPageFrame Value:");
        pw.println(page);
        pw.println("Reference String:");
        pw.println(refString);
        pw.close();
    }
    public static String getRefString(){
        Random rd = new Random();
        String refString = "";

        for(int i = 0; i < 30; i++){
            refString += rd.nextInt(10);
        }
        return refString;
    }
}
