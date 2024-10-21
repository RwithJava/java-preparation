package hackerRank;

public class DecryptEncryptedMessage {

    public static void main(String[] args) {
        String encryptedMessage = "hacker2ank ab2 m2 n3";
        System.out.println(decryptedMessage(encryptedMessage));  // Output: "hello world"
    }

    private static String decrypt(String encryptedMessage) {

        String[] words = encryptedMessage.split(" ");
        StringBuilder decryptedMessage = new StringBuilder();


        for (int i = words.length - 1; i >= 0; i--) {
            decryptedMessage.append(encodeMessage(words[i]));
            if (i > 0) {
                decryptedMessage.append(" ");
            }
        }

        return decryptedMessage.toString();
    }

    private static String encodeMessage(String word) {

        StringBuilder expanded = new StringBuilder();
        int length = word.length();

        for (int i = 0; i < length; i++) {

            char currentCharacter = word.charAt(i);

            if (i + 1 < length && Character.isDigit(word.charAt(i + 1))) {

//                Let's say word = "a5b3", and i = 0:
//
//                word.charAt(i + 1) would be '5' (the character at position 1).
//                '5' - '0' gives us 53 - 48 = 5.
//                So, frequency would be assigned the value 5.
//                This technique is commonly used when parsing numbers from strings, where the numbers are represented as characters (e.g., parsing digits from a string).

                int frequency = word.charAt(i + 1) - '0';
                expanded.append(String.valueOf(currentCharacter).repeat(Math.max(0, frequency)));
                i++;
            } else {
                expanded.append(currentCharacter);
            }
        }

        return expanded.toString();
    }

    private static String decryptedMessage(String encryptedMessage){

        StringBuilder decryptedMessage = new StringBuilder();
        String[] words = encryptedMessage.split(" ");

        for (int i =words.length-1;i >= 0 ;i--){
            decryptedMessage.append(expandWord(words[i]));
            if(i>0)  decryptedMessage.append(" ");
        }

        return decryptedMessage.toString();
    }

    private static String expandWord(String word) {

        int length = word.length();
        StringBuilder expandedWord = new StringBuilder();

        for (int i = 0;i<length;i++){

            char currentChar = word.charAt(i);

            if(i+1 < length && Character.isDigit(word.charAt(i + 1 ))){
                int frequency = word.charAt(i + 1) - '0';
                expandedWord.append(String.valueOf(currentChar).repeat(Math.max(0, frequency)));
                i++;
            }else{
                expandedWord.append(currentChar);
            }
        }

        return  expandedWord.toString();
    }
}
