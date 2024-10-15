package hackerRank;

public class DecryptMessage {

    public static String decrypt(String encryptedMessage) {
        // Step 1: Split the message into words
        String[] words = encryptedMessage.split(" ");

        // Step 2: Reverse the order of words
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            decryptedMessage.append(expandWord(words[i]));
            if (i > 0) {
                decryptedMessage.append(" ");
            }
        }

        return decryptedMessage.toString();
    }

    // Function to expand a compressed word
    public static String expandWord(String word) {
        StringBuilder expandedWord = new StringBuilder();
        int n = word.length();

        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);

            // Check if the next character is a digit (indicating frequency)
            if (i + 1 < n && Character.isDigit(word.charAt(i + 1))) {
                int frequency = word.charAt(i + 1) - '0';  // Convert character to digit
                // Append the character 'frequency' times
                for (int j = 0; j < frequency; j++) {
                    expandedWord.append(currentChar);
                }
                i++;  // Skip the digit
            } else {
                // Append the character as it is if no digit follows
                expandedWord.append(currentChar);
            }
        }

        return expandedWord.toString();
    }

    public static void main(String[] args) {
        String encryptedMessage = "hacker2ank";
        System.out.println(decrypt(encryptedMessage));  // Output: "hello world"
    }
}
