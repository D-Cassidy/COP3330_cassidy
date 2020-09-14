public class Encrypter {

    // Replaces each digit with the result of adding 7 and modulus by 10
    public static String encryptDigits(String digits) {
         int num;
         String newString = "";

         for (int i = 0; i < 4; i++) {
              num = digits.charAt(i) - 48;
              num = (num + 7) % 10;
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

    // Encrypts four digit string of numbers using encryptDigits() and swapDigits()
    public String encrypt(String numToEncrypt) {
         String newString;
         newString = encryptDigits(numToEncrypt);
         newString = swapDigits(newString);

         return newString;
    }
}
