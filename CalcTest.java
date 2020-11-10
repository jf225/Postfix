public class CalcTest {
    public static void main(String[] args) {
        PostfixCalculator p = new PostfixCalculator();
        // adding this so file is different for github
        String s = new String("3 1 +");
        p.setEquation(5, s);
        p.Calculate();
}
}
