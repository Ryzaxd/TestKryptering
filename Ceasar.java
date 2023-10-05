
public class Ceasar {
    public static void main(String[] args) {
        String plaintext = "HELLO WORLD";
        int shift = 3;
        String ciphertext = encrypt(plaintext, shift);
        System.out.println(ciphertext); // prints "KHOOR ZRUOG"
        Ceasar.bruteForce(ciphertext);
    }

    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) (c + shift);
                if (!Character.isLetter(c)) {
                    c -= 26;
                }
            }
            ciphertext.append(c);
        }
        return ciphertext.toString();
    }

    public static void bruteForce(String ciphertext) {
        for (int shift = 0; shift < 26; shift++) {
            String plaintext = decrypt(ciphertext, shift);
            System.out.println("Shift " + shift + ": " + plaintext);
        }
    }
    
    public static String decrypt(String ciphertext, int shift) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) (c - shift);
                if (!Character.isLetter(c)) {
                    c += 26;
                }
            }
            plaintext.append(c);
        }
        return plaintext.toString();
    }
    
}

