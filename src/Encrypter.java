import java.util.HashMap;
import java.util.Random;

public class Encrypter {
    public static int[] encrypt(String a,int b) {
        HashMap<String,Integer> map = new HashMap<>();

        String mapList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_ 1234567890!@#$%^&*()+-=?/.,><;:'`[]";

        for (int i = 0; i < mapList.length(); i++) {
            map.put(String.valueOf(mapList.charAt(i)), (i +1));
        }

        Random random = new Random(b);

        int length = a.length();
        String[] cr = new String[length];
        int[] ina = new int[length];
        int[] seedInts = new int[length];
        int[] ans = new int[length];

        //coverts string to array of strings
        for (int i = 0; i < length; i++) {
            cr[i] = String.valueOf(a.charAt(i));
        }
        //maps letters to numbers(strings)
        for (int i = 0; i < length; i++) {
            try {
                ina[i] = map.get(cr[i]);
            }
            catch (NullPointerException e) {
                System.out.println(cr[i]);
            }
        }
        // generate random int array
        for (int i = 0; i < length; i++) {
            seedInts[i] = (random.nextInt(10000) + 1);
        }
        for (int i = 0; i < length; i++) {
            ans[i] = (ina[i] * seedInts[i]);
        }


        return ans;
    }
}
