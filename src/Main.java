import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println(Arrays.toString(args));

        String ed = args[0];


        if (ed.equals("-e")) {

            String sEncrypt = args[1];

            String filePath = args[2];

            try {
                File file = new File(filePath);
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                }
                else {
                    System.out.println("File already exists.");
                }
            }
            catch (IOException e) {
                System.out.println("An error has occurred.");
                e.printStackTrace();
            }

            try {
                FileWriter writer = new FileWriter(filePath);

                int seed = random.nextInt(10000 );

                int[] ia = Encrypter.encrypt(sEncrypt, seed);

                int length = ia.length;

                for (int i = 0; i < length; i++ ) {
                    writer.write(String.valueOf(ia[i]) + System.getProperty("line.separator"));
                }

                writer.append(String.valueOf(seed));
                writer.close();
                System.out.println("Successfully wrote to file.");

            }
            catch (IOException e) {
                System.out.println("An error has occurred.");
                e.printStackTrace();
            }

        }
        if (ed.equals("-d")) {

            String filePath = args[1];

            ArrayList<String> in = new ArrayList<>();

            try {
                File file = new File(filePath);
                Scanner reader = new Scanner(file);

                while (reader.hasNextLine()) {
                    in.add(reader.nextLine());
                }

            }
            catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            int length = in.size();

            int seed = Integer.parseInt(in.get(length - 1));

            in.remove(length-1);

            length = in.size();

            int[] message = new int[length];

            for (int i = 0; i < length; i++) {
                message[i] = Integer.parseInt(in.get(i));
            }

            String ans = Decrypter.decrypt(message,seed);

            System.out.println(ans);

        }
    }
}
