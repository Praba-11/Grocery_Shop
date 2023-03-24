import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        String example = "Mary;Thomas:Jane-Kate";
        String[] expectedArray = new String[]{"Mary", "Thomas", "Jane", "Kate"};
        String[] names = example.split("[;:-]");
        System.out.println(Arrays.toString(names));
    }
}
