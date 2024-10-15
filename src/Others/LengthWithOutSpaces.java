package Others;


//12-09
public class LengthWithOutSpaces {
    public static void main(String[] args) {


        // one way
        String sentence = "word1 word2   word3 word1 word2";
        int length = 0;
        for (char c : sentence.toCharArray()) {
            if (c != ' ') length++;
        }
        System.out.println(length);

        // second way
        int length1 = sentence.replace(" ", "").length();
        System.out.println(length1);

        //third way -- work on this
//        String[] stringArray = sentence.split(" ");
//        int length3 = 0;
//        for(String word: stringArray){
//            length3 = word.length();
//        }
//        System.out.println(length3);
    }
}
