import java.io.PrintWriter;

public class Test {
    public static void main(String[] args){
        Example<String> e = new Example<>("Hello");
        e.getName();
        System.out.println(e.getObj());
        Example1<Example> s = new Example1<>(e);
    }
}
class Example<T> implements Ex{
    T obj;
    Example(T o){
        obj = o;
    }
    public T getObj(){
        return obj;
    }
    public String getName(){
        return obj.getClass().getName();
    }
}
interface Ex{
    public String getName();
}
class Example1<N extends Example & Ex> {
    Example1(N o){
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println(o.getClass());
    }
}