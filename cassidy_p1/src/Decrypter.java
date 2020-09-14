public class Decrypter {
    // 1. Decrypt the string by inverting the encrypt function.
    // 2. Return the decrypted integer as a String.

    public static String decryptDigits(String digits) {
         int num;
         String newString = "";

         for (int i = 0; i < 4; i++) {
              num = digits.charAt(i) - 48;

              num = num - 7;
              if (num < 0)
                   num = num + 10;

              newString = newString + num;
         }

         return newString;
    }

    // Swaps the first digit with third, and second digit with fourth
    public static String swapDigits(String digits) {
         String newString = "";
         newString = newString + digits.charAt(2);
         newString = newString + digits.charAt(3);
         newString = newString + digits.charAt(0);
         newString = newString + digits.charAt(1);

         return newString;
    }

    // Decrypts four digit string of numbers using decryptDigits() and swapDigits()
    public String decrypt(String numToDecrypt) {
         String newString;
         newString = swapDigits(numToDecrypt);
         newString = decryptDigits(newString);

         return newString;
    }

    public static void main(String[] args) {
         Decrypter myDecrypter = new Decrypter();
         System.out.println(myDecrypter.decrypt("0189"));
    }
}
