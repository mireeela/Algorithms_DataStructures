import java.util.*;

//4.2
public class Baum {
    private Knoten wurzel;
    public Knoten getWurzel() {
        return wurzel;
    }
    public void setWurzel(Knoten wurzel) {
        this.wurzel = wurzel;
    }

    //4.2.1
    public void knotenHinzufuegen(Knoten k) {
        // if keine wurzel noch
        if (wurzel == null) {
            wurzel = k;
        } else {
            knotenHinzufuegenRekursiv(wurzel, k);
        }
    }
    //hilfsmethode
    public void knotenHinzufuegenRekursiv(Knoten curr1, Knoten curr2){
        /*if(curr2.getKey().compareTo(curr1.getKey()) < 0){
            // addiere bei linke seite wenn curr1 key ist alphabetisch vor curr2 key
            if(curr1.getLeft() == null){
                curr1.setLeft(curr2);
            }else {
                knotenHinzufuegenRekursiv(curr1.getLeft(), curr2);  // mache so viel wie moeglich nach links falls es immer auf die linke seite knote gibt
            }
        }else{
            if(curr1.getRight() == null){
                curr1.setRight(curr2);
            }else {
                knotenHinzufuegenRekursiv(curr1.getRight(), curr2); // falls nicht alphabetisch vor curr2, addiere bei rechte seite, so viel wie moeglich nach rechts
            }
        }
         */
        //5.1 (keine doppelte Schluessel)
        if(curr2.getKey().compareTo(curr1.getKey()) == 0){
            System.out.println("Schluessel '" + curr2.getKey() + "' schon vorhanden");
        }

        boolean ifLinks = curr2.getKey().compareTo(curr1.getKey()) < 0;
        Knoten k = ifLinks ? curr1.getLeft() : curr1.getRight();

        if (k == null) {
            if (ifLinks) {
                curr1.setLeft(curr2);
            } else {
                curr1.setRight(curr2);
            }
        } else {
            knotenHinzufuegenRekursiv(k, curr2);
        }

    }

    //4.2.2
    public Knoten findeKnoten(String Albenname) {
        return findeKnotenRekursiv(Albenname, wurzel, 0);
    }
    //hilfsmethode
    public Knoten findeKnotenRekursiv(String Albenname, Knoten curr, int pos) {
        pos++;
        int compare = Albenname.compareTo(curr.getKey());
        try{
            if (compare == 0) {
                System.out.println("Schluesselvergleiche: " + pos);
                return curr;
            } else if (compare < 0) {
                return findeKnotenRekursiv( Albenname, curr.getLeft(), pos);
            } else {
                return findeKnotenRekursiv(Albenname, curr.getRight(), pos);
            }
        }catch(NullPointerException e){
            System.out.println("Albenname nicht in Baum");
            return null;
        }
    }

    //4.2.3
    public void ausbalancieren(){
        Baum baum = new Baum();
        List<Knoten> liste = new ArrayList<>();
        toList(wurzel, liste);

        baum.setWurzel(wurzel);
        wurzel = ausbalancierenRekursiv(liste, 0, liste.size() - 1);

        //List<Knoten> sortierteliste = Knoten.sortiere(liste);
    }
    //hilfsmethode
    public void toList(Knoten knoten, List<Knoten> liste){
        if (knoten != null) {
            toList(knoten.getLeft(), liste);
            liste.add(knoten);
            toList(knoten.getRight(), liste);
        }
    }
    //hilfsmethode
    private Knoten ausbalancierenRekursiv(List<Knoten> liste, int start, int ende) {
        if (start > ende) {
            return null;
        }
        int mitte = (start + ende) / 2;
        Knoten wurzel = liste.get(mitte);
        wurzel.setLeft(ausbalancierenRekursiv(liste, start, mitte - 1));
        wurzel.setRight(ausbalancierenRekursiv(liste, mitte + 1, ende));
        return wurzel;
    }


    /*
    public void baumAusgabe(List<Knoten> list){
        for(Knoten k : list){
            System.out.println();
            System.out.println(k.getKey());
            if(k.getLeft() != null){
                System.out.println(k.getLeft().getKey());
            }
            if(k.getRight() != null){
                System.out.println(k.getRight().getKey());
            }
        }
    }
     */


    //ueberpruefung fuer test
    public void testGefunden(List<Knoten> list){
        for(Knoten k : list){
            System.out.println("Suchen nach " + k.getKey());
            findeKnoten(k.getKey());
        }
    }

    //4.2.4
    public static void BaumApp(Baum baum){
        //Baum baum = null; -> falls immer den Beispielbaum angelegt werden muss
        List<Knoten> alleKnoten = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int num;
        do{
            System.out.println("-------------Baum Konsole-----------------");            System.out.println("Optionen:");
            System.out.println("1: Beispielbaum anlegen");
            System.out.println("2: Knoten einfuegen");
            System.out.println("3: Knoten suchen");
            System.out.println("4: Baum ausbalancieren");
            System.out.println("5: Baum ausgeben");
            System.out.println("6: Knoten loeschen");
            System.out.println("7: Fin");
            System.out.println("------------------------------------------");
            System.out.print("Waehlen Sie Nummer: ");
            num = scanner.nextInt();
            switch (num){
                case 1:
                    Knoten k1 = new Knoten();
                    k1.setKey("Paranoid");
                    alleKnoten.add(k1);
                    Knoten k2 = new Knoten();
                    k2.setKey("Nothing left to Lose");
                    alleKnoten.add(k2);
                    Knoten k3 = new Knoten();
                    k3.setKey("The Darkside of the Moon");
                    alleKnoten.add(k3);
                    Knoten k4 = new Knoten();
                    k4.setKey("The Animals");
                    alleKnoten.add(k4);
                    Knoten k5 = new Knoten();
                    k5.setKey("Thriller");
                    alleKnoten.add(k5);
                    Knoten k6 = new Knoten();
                    k6.setKey("Whenever You Need Somebody");
                    alleKnoten.add(k6);

                    baum.knotenHinzufuegen(k1);
                    baum.knotenHinzufuegen(k2);
                    baum.knotenHinzufuegen(k3);
                    baum.knotenHinzufuegen(k4);
                    baum.knotenHinzufuegen(k5);
                    baum.knotenHinzufuegen(k6);

                    System.out.println("Beispielbaum angelegt");
                    //baum.baumAusgabe(alleKnoten);

                    break;
                case 2:
                    /*if(baum == null){
                        System.out.println("Beispielbaum noch nicth angelegt"); -> falls immer beispielbaum angelegt werden muss
                        break;
                    }*/

                    System.out.print("Knoten Albenname: ");
                    scanner.nextLine();
                    String album = scanner.nextLine();
                    Knoten k7 = new Knoten();
                    k7.setKey(album);
                    alleKnoten.add(k7);
                    baum.knotenHinzufuegen(k7);

                    System.out.println("Neue Knote eingefuegt");

                    //ausgeben
                    //System.out.println("Baum jetzt:");
                    //baum.baumAusgabe(alleKnoten);
                    System.out.println("Ueberpruefen mit Suchen in Baum nach Albenname:");
                    baum.testGefunden(alleKnoten);

                    break;
                case 3:
                    System.out.print("Albenname eingeben: ");
                    scanner.nextLine();
                    String albenname = scanner.nextLine();
                    Knoten k = baum.findeKnoten(albenname);
                    if(k == null){
                        break;
                    }
                    System.out.println("Knoten Info:");
                    System.out.println("Albenname: " + albenname);
                    if(k.getLeft() != null){
                        System.out.println("Linke Seite: " + k.getLeft().getKey());
                    }
                    if(k.getRight() != null){
                        System.out.println("Rechte Seite: " + k.getRight().getKey());
                    }
                    break;
                case 4:
                    baum.ausbalancieren();
                    //System.out.println("Baum jetzt:");
                    //baum.baumAusgabe(alleKnoten);
                    //System.out.println("Ueberpruefen:");
                    //baum.testGefunden(alleKnoten);
                    System.out.println("Baum ausbalanciert");
                    break;
                case 5:
                    System.out.println("Baum:");
                    //baum.baumAusgabe(alleKnoten);
                    baum.baumAusgabe();
                    break;
                case 6:
                    System.out.print("Knoten zu loeschen: ");
                    scanner.nextLine();
                    String schluessel = scanner.nextLine();
                    baum.knotenLoeschen(schluessel);
                    System.out.println("Knote " + schluessel + " geloescht");
            }
        }while(num != 7);
        System.out.println("~fin~");
    }



    //5.1.1
    public void baumAusgabe() {
        Map<String, List<String>> bb = new HashMap<>();
        //bb.put(baum.getWurzel().getKey(), Arrays.asList(baum.getWurzel().getLeft().getKey(), baum.getWurzel().getRight().getKey()));
        baumZuMap(wurzel, bb);

        Set<String> besucht = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        besucht.add(wurzel.getKey());
        queue.add(wurzel.getKey());

        Knoten aktuell = new Knoten();

        while (!queue.isEmpty()) {
            int hoehe = queue.size();
            StringBuilder zeile = new StringBuilder();

            for(int i = 0; i < hoehe; i++){
                aktuell.setKey(queue.poll());
                zeile.append("# ").append(aktuell.getKey()).append("    ");
                try{
                    for (String k : bb.get(aktuell.getKey())) {
                        if (!besucht.contains(k)) {
                            besucht.add(k);
                            queue.add(k);
                        }
                    }
                }catch (NullPointerException e){
                    continue;
                }
            }
            System.out.println(zeile.toString().trim());

        }

    }
    //hilfsmethode
    public void baumZuMap(Knoten knoten, Map<String, List<String>> bb) {
        if (knoten == null){
            return;
        }
        List<String> kind = new ArrayList<>();
        if (knoten.getLeft() != null){
            kind.add(knoten.getLeft().getKey());
        }
        if (knoten.getRight() != null){
            kind.add(knoten.getRight().getKey());
        }

        bb.put(knoten.getKey(), kind); //jede knote mit liste ihrer kinder
        baumZuMap(knoten.getLeft(), bb);
        baumZuMap(knoten.getRight(), bb);
    }

    // 5.1.2
    public boolean knotenLoeschen(String Schluessel){
        wurzel = knotenLoeschenRekursiv(wurzel, Schluessel);
        return loeschErfolg;
    }
    //hilfsmethode
    private boolean loeschErfolg = false;
    public Knoten knotenLoeschenRekursiv(Knoten knoten, String Schluessel){

        if(Schluessel.compareTo(knoten.key)<0){
            knoten.left = knotenLoeschenRekursiv(knoten.left, Schluessel);
        }
        if(Schluessel.compareTo(knoten.key)>0){
            knoten.right = knotenLoeschenRekursiv(knoten.right, Schluessel);
        }

        if(knoten.getKey().equals(Schluessel)){
            loeschErfolg = true;
            //blatt
            if(knoten.getLeft() == null && knoten.getRight() == null){
                return null;
            }
            //ein kind
            if(knoten.getLeft() == null){
                return knoten.right;
            }
            if(knoten.getRight() == null){
                return knoten.left;
            }
            //2 kinder
            while ((knoten.right).left != null) {
                knoten.right = (knoten.right).left;
            }
            Knoten nachfolger = knoten.right;
            knoten.key = nachfolger.key;
            knoten.right = knotenLoeschenRekursiv(knoten.right, nachfolger.key);
        }
        return knoten;
    }

}

