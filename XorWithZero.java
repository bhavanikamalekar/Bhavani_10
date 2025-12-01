public class XorWithZero {

    public static void main(String[] args) {

        String str = "Hello world";

        System.out.println("Character\tASCII\tXOR 0 Result");

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            int ascii = (int) c;     // ASCII value
            int xorVal = c ^ 0;      // XOR with 0

            System.out.println(c + "\t\t" + ascii + "\t\t" + xorVal);
        }
    }
}
