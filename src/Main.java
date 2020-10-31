import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Encrypt or Decrypt: ");
        String ed = input.nextLine();

        if (ed.equals("Encrypt")) {

            System.out.print("Enter seed or enter zero for random: ");
            int seed = input.nextInt();

            if (seed == 0) {
                seed = random.nextInt(10000);
            }

            System.out.print("Enter string to encrypt: ");
            String s = input.next();
            int[] i = Encrypter.encrypt(s, seed);

            System.out.println(Arrays.toString(i) + seed);
        }
        if (ed.equals("Decrypt")) {

            System.out.print("Enter seed: ");
            int seed = input.nextInt();

            System.out.print("Enter length of message: ");
            int length = input.nextInt();

            int[] message = new int[length];

            for (int i = 0; i < length; i++) {
                System.out.print("Enter number: ");
                message[i] = input.nextInt();
            }

            String ans = Decrypter.decrypt(message,seed);

            System.out.println(ans);

        }
    }
}
