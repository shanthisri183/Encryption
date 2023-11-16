import java.util.Scanner;

// Press Shift twice to the open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CaesarCipher {


    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static String encrypt(String plainText, int shiftkey)
    {
        plainText = plainText.toLowerCase();
        String cipherText = "";
        for(int i=0; i<plainText.length(); i++)
        {
            int charposition = ALPHABET.indexOf(plainText.charAt(i));
            int keyval =(shiftkey + charposition) % 26;
            char replaceVal = ALPHABET.charAt(keyval);
            cipherText += replaceVal;
        }
        return cipherText;
    }

    public static String decrypt(String cipherText, int shiftkey) {
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int charposition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyval = (charposition - shiftkey) % 26;
            if (keyval < 0) {
                keyval = ALPHABET.length() + keyval;
            }
            char replaceVal = ALPHABET.charAt(keyval);
            plainText += replaceVal;
        }
        return plainText;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String for Encryption: ");
        String message = new String();
        message = sc.next();
        System.out.println(encrypt(message, 3));
        System.out.println(decrypt(encrypt(message, 3) ,3));
        sc.close();

    }
}