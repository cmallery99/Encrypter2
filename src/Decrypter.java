import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Random;

public class Decrypter {
    public static String decrypt(int[] a, int b ) {
        int[] in = a;
        int seed = b;
        Random random = new Random(seed);
        HashMap<String,String> map = new HashMap<String,String>();

        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");
        map.put("5","e");
        map.put("6","f");
        map.put("7","g");
        map.put("8","h");
        map.put("9","i");
        map.put("10","j");
        map.put("11","k");
        map.put("12","l");
        map.put("13","m");
        map.put("14","n");
        map.put("15","o");
        map.put("16","p");
        map.put("17","q");
        map.put("18","r");
        map.put("19","s");
        map.put("20","t");
        map.put("21","u");
        map.put("22","v");
        map.put("23","w");
        map.put("24","x");
        map.put("25","y");
        map.put("26","z");
        map.put("27","A");
        map.put("28","B");
        map.put("29","C");
        map.put("30","D");
        map.put("31","E");
        map.put("32","F");
        map.put("33","G");
        map.put("34","H");
        map.put("35","I");
        map.put("36","J");
        map.put("37","K");
        map.put("38","L");
        map.put("39","M");
        map.put("40","N");
        map.put("41","O");
        map.put("42","P");
        map.put("43","Q");
        map.put("44","R");
        map.put("45","S");
        map.put("46","T");
        map.put("47","U");
        map.put("48","V");
        map.put("49","W");
        map.put("50","X");
        map.put("51","Y");
        map.put("52","Z");
        map.put("53","_");
        map.put("54"," ");

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
