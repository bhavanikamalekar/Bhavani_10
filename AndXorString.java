public class AndXorString {

    public static void main(String[] args) {

        String str = "Hello world";

        System.out.println("Character\tAND 127\tXOR 127");

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            int andValue = c & 127; // AND operation
            int xorValue = c ^ 127; // XOR operation

            System.out.println(c + "\t\t" + andValue + "\t\t" + xorValue);
        }
    }
}
