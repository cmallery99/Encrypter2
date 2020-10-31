import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Random;

public class Decrypter {
    public static String decrypt(int[] a, int b ) {
        int[] in = a;
        int seed = b;
        Random random = new Random(seed);
        HashMap<String,String> map = new HashMap<String,String>();

        map.put("0","a");
        map.put("1","b");
        map.put("2","c");
        map.put("3","d");
        map.put("4","e");
        map.put("5","f");
        map.put("6","g");
        map.put("7","h");
        map.put("8","i");
        map.put("9","j");
        map.put("10","k");
        map.put("11","l");
        map.put("12","m");
        map.put("13","n");
        map.put("14","o");
        map.put("15","p");
        map.put("16","q");
        map.put("17","r");
        map.put("18","s");
        map.put("19","t");
        map.put("20","u");
        map.put("21","v");
        map.put("22","w");
        map.put("23","x");
        map.put("24","y");
        map.put("25","z");

        int length = Array.getLength(a);

        int[] seedInts = new int[length];
        int[] newInts = new int[length];
        String[] intsString = new String[length];
        String[] charsString = new String[length];


        for (int i = 0; i < length; i++) {
            seedInts[i] = random.nextInt(10000);
        }
        for (int i = 0; i < length; i++) {
            newInts[i] = (in[i] / seedInts[i]);
        }
        for (int i = 0; i < length; i++) {
            intsString[i] = Integer.toString(newInts[i]);
        }
        for (int i = 0; i < length; i++) {
            charsString[i] = map.get(intsString[i]);
        }
        String ans = "";
        for (int i = 0; i < length; i++) {
            ans = ans+charsString[i];
        }

        return ans;
    }
}
