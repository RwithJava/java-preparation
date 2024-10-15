package Others;

import java.util.Arrays;
import java.util.List;

public class InsertSymbolsInString {

    /*
     Insert pipe symbols in between the string characters if the string length is greater than 1 :

     List<String> valuesTray = Arrays.asList("A", "1", "B", "C", "10", "EYE", "50", "49", "@#");
     */

    public static void main(String[] args) {
        List<String> valuesTray = Arrays.asList("A", "1", "B", "C", "10", "EYE", "50", "49", "@#");

        valuesTray.stream()
                .map(s->s.length()>1?String.join("|",s.split("")):s)
                .forEach(System.out::println);
    }
}
