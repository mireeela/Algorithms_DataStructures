import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

public class Knoten implements Comparable<Knoten>{                                      //4.1.3 -> implements Comparable
    //3.2.1
    String key;
    Knoten left;
    Knoten right;
    String performer;
    ArrayList<String> songs;
    LocalDate release_date;

    public String getKey(){
        return key;
    }
    public void setKey(String key){
        this.key = key;
        this.songs = new ArrayList<>();
    }
    public Knoten getLeft(){
        return left;
    }
    public void setLeft(Knoten left){
        this.left = left;
    }
    public Knoten getRight(){
        return right;
    }
    public void setRight(Knoten right){
        this.right = right;
    }
    public String getPerformer(){
        return performer;
    }
    public void setPerformer(String performer){
        this.performer = performer;
    }
    public ArrayList<String> getSongs(){
        return songs;
    }
    public void setSong(String song){
        this.songs.add(song);
    }
    public LocalDate getRelease_date(){
        return release_date;
    }
    public void setRelease_date(LocalDate release_date){
        this.release_date = release_date;
    }

    //3.2.2
    public static void gibAlbumAus(Knoten k){
        if(k.key != null){
            System.out.println("Album: " + k.getKey());
        }
        if(k.left != null){
            System.out.println("Linker Kindknoten: " + k.getLeft().getKey());
        }
        if(k.right != null){
            System.out.println("Rechter Kindknoten: " + k.getRight().getKey());
        }
        if(k.performer != null){
            System.out.println("Interpret: " + k.getPerformer());
        }
        if(!k.songs.isEmpty()){
            System.out.println("Lieder:");
            for(int i = 0; i < k.songs.size(); i++){
                System.out.println("- " + k.getSongs().get(i));
            }
        }
        if(k.release_date != null){
            System.out.println("Erscheinungsdatum: " + k.getRelease_date());
        }


    }

    //4.1.1
    public static List<Knoten> sortiere(List<Knoten> input){
        //insertion sort algorithm
        List<Knoten> sortedList = new ArrayList<>();
        for(int i = 0; i < input.size(); i++){
            Knoten curr = input.get(i);
            int j = 0;
            while(j < sortedList.size() && curr.getKey().compareTo(sortedList.get(j).getKey()) > 0){
                j++;
            }
            sortedList.add(j, curr);
        }
        return sortedList;
    }

    //4.1.3
    @Override
    public int compareTo(Knoten k) {
        return this.key.compareTo(k.key);
    }

    public static String zufallsString(){
        int stringLenght = 5;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < stringLenght; i++){
            stringBuilder.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return stringBuilder.toString();
    }

    public static List<Knoten> zufallsList(int groesse){
        List<Knoten> randomList = new ArrayList<Knoten>();
        for(int i = 0; i < groesse; i++){
            Knoten k = new Knoten();
            k.setKey(zufallsString());
            randomList.add(k);
        }
        return randomList;
    }

    public static void testMySortAlg(List<Knoten> knotenList){
        long start1 = System.nanoTime();
        Knoten.sortiere(knotenList);
        long end1 = System.nanoTime();
        long result1 = end1 - start1;
        System.out.println("Laufzeit eigene Sortieralgorithmus: " + result1);
    }
    public static void testStandardSortAlg(List<Knoten> knotenList){
        //List<Knoten> copyList = new ArrayList<>(knotenList);
        long start2 = System.nanoTime();
        Collections.sort(knotenList);
        long end2 = System.nanoTime();
        long result2 = end2 - start2;
        System.out.println("Laufzeit java Standardalgorithmus: " + result2);
    }

    public static void main(String[] args){

        Knoten k1 = new Knoten();
        k1.setKey("Paranoid");
        Knoten k2 = new Knoten();
        k2.setKey("Nothing left to Lose");
        Knoten k3 = new Knoten();
        k3.setKey("The Darkside of the Moon");
        Knoten k4 = new Knoten();
        k4.setKey("The Animals");
        Knoten k5 = new Knoten();
        k5.setKey("Thriller");
        Knoten k6 = new Knoten();
        k6.setKey("Whenever You Need Somebody");
        Knoten k7 = new Knoten();
        k7.setKey("Back in Black");

        Baum baum = new Baum();
        baum.knotenHinzufuegen(k1);
        baum.knotenHinzufuegen(k2);
        baum.knotenHinzufuegen(k3);
        baum.knotenHinzufuegen(k4);
        baum.knotenHinzufuegen(k5);
        baum.knotenHinzufuegen(k6);
        baum.knotenHinzufuegen(k7);
        // 5.1 (doppelte schluessel) test
        //Knoten k8 = new Knoten();
        //k8.setKey("Whenever You Need Somebody");
        //baum.knotenHinzufuegen(k8);

        //--------------------------------------------------------------------------------------------------------------

        //4.1.2
        /*
        List<Knoten> alben = new ArrayList<>();
        alben.add(k1);
        alben.add(k2);
        alben.add(k3);
        alben.add(k4);
        alben.add(k5);
        alben.add(k6);

        List<Knoten> sortierteAlben = Knoten.sortiere(alben);
        System.out.print("Unsortiert: ");
        for(Knoten k : alben){
            System.out.print(k.getKey() + ", ");
        }
        System.out.println();
        System.out.print("Sortiert: ");
        for(Knoten k : sortierteAlben){
            System.out.print(k.getKey() + ", ");
        }
        System.out.println();
        */

        //--------------------------------------------------------------------------------------------------------------

        //4.1.3
        /*
        int[] groessen = {100, 500, 1000, 1500, 2000};
        for(int i = 0 ; i < groessen.length; i++){
            System.out.println("Test mit List mit Groesse " + groessen[i]);
            List<Knoten> l = zufallsList(groessen[i]);
            testMySortAlg(l);
            testStandardSortAlg(l);
        }
         */

        //--------------------------------------------------------------------------------------------------------------

        //4.2.1 test
        /*
        List<Knoten> kn = new ArrayList<>();
        kn.add(k1);
        kn.add(k2);
        kn.add(k3);
        kn.add(k4);
        kn.add(k5);
        kn.add(k6);
        baum.printBaum(kn);
        */



        //--------------------------------------------------------------------------------------------------------------

        //4.2.2 test
        /*
        System.out.println("Suche nach 'Thriller':");
        Knoten gefunden = baum.findeKnoten("Thriller");

        System.out.println("Suche nach 'Smithereens':");
        Knoten gefunden2 = baum.findeKnoten("Smithereens");
         */

        //--------------------------------------------------------------------------------------------------------------

        //4.2.3 test
        /*
        baum.ausbalancieren();
        */

        //--------------------------------------------------------------------------------------------------------------

        //5.1.1 test
        /*
        baum.ausbalancieren();
        baum.baumAusgabe();
        */

        //--------------------------------------------------------------------------------------------------------------

        //5.1.2
        /*
        baum.ausbalancieren();
        baum.baumAusgabe();
        baum.knotenLoeschen("Thriller");
        System.out.println();
        baum.baumAusgabe();
         */

        //--------------------------------------------------------------------------------------------------------------

        //Baum Applikation
        Baum bauma = new Baum();
        Baum.BaumApp(bauma);

    }

}
