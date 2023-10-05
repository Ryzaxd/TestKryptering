
public class Viginiere {
    public static void main(String[] args) {
        String plaintext = "HELLO";
        String key = "KEY";
        String ciphertext = encrypt(plaintext, key);
        System.out.println(ciphertext); // prints "RIJVS"
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
}


