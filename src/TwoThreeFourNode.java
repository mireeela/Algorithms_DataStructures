import java.util.ArrayList;

public class TwoThreeFourNode {
    //3. Knotenklasse für objektorientierten 2,3,4 - Baum
    ArrayList<Integer> keys = new ArrayList<>();
    ArrayList<TwoThreeFourNode> knoten = new ArrayList<>();

    public void setKey(int k){
        if(keys.size() == 3){
            System.out.println("Maximale Anzahl an Schluesseln erreicht");
        }
        if(keys.isEmpty() || keys.size() < 3){
            keys.add(k);
        }
    }
    public ArrayList<Integer> getKeys(){
        return keys;
    }
    public void setKnote(TwoThreeFourNode k){
        if(knoten.size() == 4){
            System.out.println("Maximale Anzahl an Knoten erreicht");
        }
        if(knoten.isEmpty() || knoten.size() < 4){
            knoten.add(k);
        }

    }
    public ArrayList<TwoThreeFourNode> getKnoten(){
        return knoten;
    }

    public static void main(String[] args){
        TwoThreeFourNode wurzel = new TwoThreeFourNode();
        wurzel.setKey(9);
        //Linke Seite der Wurzel
        TwoThreeFourNode k1 = new TwoThreeFourNode();
        k1.setKey(3);
        wurzel.setKnote(k1);
        // Linke Seite der Linke Seite der Wurzel
        TwoThreeFourNode k2 = new TwoThreeFourNode();
        k2.setKey(2);
        k1.setKnote(k2);
        // Rechte Seite der Linke Seite der Wurzel
        TwoThreeFourNode k3 = new TwoThreeFourNode();
        k3.setKey(5);
        k3.setKey(7);
        k3.setKey(8);
        k1.setKnote(k3);
        // Rechte Seite der Wurzel
        TwoThreeFourNode k4 = new TwoThreeFourNode();
        k4.setKey(27);
        k4.setKey(93);
        wurzel.setKnote(k4);
        // Linke Seite der Rechte Seite der Wurzel
        TwoThreeFourNode k5 = new TwoThreeFourNode();
        k5.setKey(15);
        k4.setKnote(k5);
        // Mittlere Seite der Rechte Seite der Wurzel
        TwoThreeFourNode k6 = new TwoThreeFourNode();
        k6.setKey(67);
        k4.setKnote(k6);
        // Rechte Seite der Rechte Seite der Wurzel
        TwoThreeFourNode k7 = new TwoThreeFourNode();
        k7.setKey(104);
        k7.setKey(120);
        k4.setKnote(k7);

        // Struktur
        System.out.println("Wurzel: " + wurzel.getKeys());
        for (TwoThreeFourNode knote : wurzel.getKnoten()) {
            System.out.println("Knote von Wurzel: " + knote.getKeys());
            for(TwoThreeFourNode knote2 : knote.getKnoten()){
                System.out.println("Knote von " + knote.getKeys() + ": " + knote2.getKeys());
            }
        }
    }
}
