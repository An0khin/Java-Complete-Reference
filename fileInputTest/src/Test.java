import java.io.FileInputStream;
import java.io.PrintWriter;

public class Test {
    public static void main(String[] args) {
        int i;

        PrintWriter pw = new PrintWriter(System.out, true);


        try(FileInputStream fis = new FileInputStream("E:/Programming/ALL/Java/JavaCompleteRef/fileInputTest/out/production/fileInputTest/" +
                "Text.txt");) {
            do {
                i = fis.read();
                if(i != -1) pw.print((char) i);
                //if(i != -1) System.out.println((char) i);
            } while (i != -1);
            pw.flush();
        } catch (Exception e) {System.out.println("aaa");}
    }
}
