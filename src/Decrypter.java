import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Random;

public class Decrypter {
    public static String decrypt(int[] a, int b ) {
        int[] in = a;
        Random random = new Random(b);
        HashMap<Integer,String> map = new HashMap<>();

        String mapList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_ 1234567890!@#$%^&*()+-=?/.,><;:'`";

        for (int i = 0; i < mapList.length(); i++) {
            map.put((i+1) , String.valueOf(mapList.charAt(i)));
        }

        int length = Array.getLength(a);

        int[] seedInts = new int[length];
        int[] newInts = new int[length];
        String[] charsString = new String[length];


        for (int i = 0; i < length; i++) {
            seedInts[i] = (random.nextInt(10000) + 1);
        }
        for (int i = 0; i < length; i++) {
            newInts[i] = (in[i] / seedInts[i]);
        }

        for (int i = 0; i < length; i++) {
            charsString[i] = map.get(newInts[i]);
        }
        String ans = "";
        for (int i = 0; i < length; i++) {
            ans = ans+charsString[i];
        }

        return ans;
    }
}
