import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {


    public static void main(String[] args) {
        String param1[] = {"Argentina","Brazil", "Peru", "Venezuela"};
        String param2[] = {"Argentina","Brazil", "Peru", "Venezuela"};
        System.out.println(diffs(param1, param2));
    }

    /*
    Metodo que recibe dos arrays de tipo String. Si todos los elementos son iguales, retorna un map con los elementos ordenados alfabeticamente
    De lo contrario, si hay elementos diferentes, retorna un map con estos elementos diferentes.
     */
    public static Map diffs (String[] list1, String[] list2) {
        int same = 0;
        for (int i = 0; i <= list1.length-1; i++) {
            for(int j = 0; j <= list2.length-1; j++) {
                if (list1[i].equals(list2[j])){
                    same++;
                    break;
                }
            }
        }
        boolean differentFound = false;
        String [] equ=new String[same];
        String [] diff=new String[list1.length];
        int p=0;
        for (int i = 0; i <= list1.length-1; i++) {
            boolean foundElement = false;
            for(int j = 0; j <= list2.length-1; j++) {
                if (list1[i].equals(list2[j])) {
                    equ[p]=  list1[i]+"";
                    p++;
                    foundElement = true;
                }
            }
            if(foundElement == false){
                differentFound = true;
                diff[i]=list1[i];
            }
        }
        if(differentFound == false){
            System.out.println("Los elementos son iguales --> Devolver hasmap ordenado");
            Map<String, Integer> mapEquals = new HashMap<String, Integer>();
            for (int i = 0; i < list1.length; i++) {
                mapEquals.put(list1[i], list1[i].length());
            }
            Map mapOrdenado = new TreeMap(mapEquals);
            return mapOrdenado;
        }else{
            System.out.println("Los elementos son diferentes --> Devolver elementos diferentes");
            Map<String, Integer> mapDifferents = new HashMap<String, Integer>();
            for (int i = 0; i < diff.length; i++) {
                if(diff[i]!=null){
                    mapDifferents.put(diff[i], diff[i].length());
                }
            }
            return mapDifferents;
        }
    }
}
