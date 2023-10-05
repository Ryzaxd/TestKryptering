import java.util.ArrayList;
import java.util.List;

public class Viginiere {
    public static void main(String[] args) {
        String plaintext = "HELLO";
        String key = "KEY";
        String ciphertext = encrypt(plaintext, key);
        System.out.println(ciphertext); // prints "RIJVS"
        bruteForce(ciphertext);
    }

    public static String encrypt(String plaintext, String key) {
        String ciphertext = "";
        int keyIndex = 0;
        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            char keyChar = key.charAt(keyIndex);
            int shift = (int) keyChar - 65;
            char cipherChar = (char) ((int) plainChar + shift);
            if (cipherChar > 'Z') {
                cipherChar = (char) ((int) cipherChar - 26);
            }
            ciphertext += cipherChar;
            keyIndex++;
            if (keyIndex == key.length()) {
                keyIndex = 0;
            }
        }
    return ciphertext;
    }

    public static void bruteForce(String ciphertext) {
    for (int keyLength = 1; keyLength <= ciphertext.length(); keyLength++) {
        for (String key : generateKeys(keyLength)) {
            String plaintext = decrypt(ciphertext, key);
            System.out.println("Key " + key + ": " + plaintext);
        }
    }
}

public static List<String> generateKeys(int length) {
    List<String> keys = new ArrayList<>();
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    generateKeysHelper("", alphabet, length, keys);
    return keys;
}

private static void generateKeysHelper(String prefix, char[] alphabet, int length, List<String> keys) {
    if (prefix.length() == length) {
        keys.add(prefix);
    } else {
        for (int i = 0; i < alphabet.length; i++) {
            generateKeysHelper(prefix + alphabet[i], alphabet, length, keys);
        }
    }
}

public static String decrypt(String ciphertext, String key) {
    String plaintext = "";
    int keyIndex = 0;
    for (int i = 0; i < ciphertext.length(); i++) {
        char cipherChar = ciphertext.charAt(i);
        char keyChar = key.charAt(keyIndex);
        int shift = (int) keyChar - 65;
        char plainChar = (char) ((int) cipherChar - shift);
        if (plainChar < 'A') {
            plainChar = (char) ((int) plainChar + 26);
        }
        plaintext += plainChar;
        keyIndex++;
        if (keyIndex == key.length()) {
            keyIndex = 0;
        }
    }
    return plaintext;
}

}


