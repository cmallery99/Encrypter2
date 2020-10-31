import java.util.HashMap;
import java.util.Random;

public class Encrypter {
    public static int[] encrypt(String a,int b) {
        HashMap<String,String> map = new HashMap<String,String>();

        map.put("a","0");
        map.put("b","1");
        map.put("c","2");
        map.put("d","3");
        map.put("e","4");
        map.put("f","5");
        map.put("g","6");
        map.put("h","7");
        map.put("i","8");
        map.put("j","9");
        map.put("k","10");
        map.put("l","11");
        map.put("m","12");
        map.put("n","13");
        map.put("o","14");
        map.put("p","15");
        map.put("q","16");
        map.put("r","17");
        map.put("s","18");
        map.put("t","19");
        map.put("u","20");
        map.put("v","21");
        map.put("w","22");
        map.put("x","23");
        map.put("y","24");
        map.put("z","25");

        int seed = b;
        String s = a;

        Random random = new Random(seed);

        int length = s.length();
        String[] cr = new String[length];
        String[] in = new String[length];
        int[] ina = new int[length];
        int[] seedInts = new int[length];
        int[] ans = new int[length];

        //coverts string to array of strings
        for (int i = 0; i < length; i++) {
            cr[i] = String.valueOf(s.charAt(i));
        }
        //maps letters to numbers(strings)
        for (int i = 0; i < length; i++) {
            in[i] = map.get(cr[i]);
        }
        // converts array of strings to array of ints
        for (int i = 0; i < length; i++) {
            ina[i] = Integer.parseInt(in[i]);
        }
        // generate random int array
        for (int i = 0; i < length; i++) {
            seedInts[i] = random.nextInt(10000);
        }
        for (int i = 0; i < length; i++) {
            ans[i] = (ina[i] * seedInts[i]);
        }


        return ans;
    }
}
