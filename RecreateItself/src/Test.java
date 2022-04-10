import java.io.PrintWriter;

public class Test {
    public static void main(String[] args) {
        Block a = new Block();
        Block b = new Block(3);
        Block c = new Block(45, 6);
        a.getSize();
        b.getSize();
        c.getSize();
    }
}
class Block {
    int a, b;
    Block(int i, int j) {
        a = i;
        b = j;
    }
    Block(int i) {
        this(i, i);
    }
    Block() {
        this(0);
    }
    public void getSize() {
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println(a + " " + b);
    }
}
