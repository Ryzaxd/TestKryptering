
public class Ceasar {
    public static void main(String[] args) {
        String plaintext = "HELLO WORLD";
        int shift = 3;
        String ciphertext = encrypt(plaintext, shift);
        System.out.println(ciphertext); // prints "KHOOR ZRUOG"
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
}


