public class Main implements Interface1{
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.Age());
        System.out.println(m.OldAge());
    }

    @Override
    public int Age() {
        return 17;
    }

    @Override
    public int OldAge() {
        return 100;
    }
}
interface Interface1 {
    int Age();
    default int OldAge() {
        return 99;
    }
}
