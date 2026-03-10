import java.util.*;

public class Graph {
    private Map<Knoten, List<Kanten>> graph = new HashMap<>();
    //5.2.1
    public void knotenHinzufuegen(char knotenID) {
        Knoten k = new Knoten();
        k.setKey(String.valueOf(knotenID));
        graph.put(k, new ArrayList<>());
    }

    public void kanteHinzufuegen(char knoten1ID, char knoten2ID, double gewicht) {
        int checked = 0;
        Knoten von = null;
        Knoten nach = null;
        for (Map.Entry<Knoten, List<Kanten>> entry : graph.entrySet()) {
            Knoten knoten = entry.getKey();
            if(knoten.getKey().equals(String.valueOf(knoten1ID))){
                checked++;
                von = knoten;
            }
            if(knoten.getKey().equals(String.valueOf(knoten2ID))){
                checked++;
                nach = knoten;
            }
        }
        if(checked == 2){
            //beide knoten existieren
            //von knoten1ID nach knoten2ID
            Kanten kanten = new Kanten();
            kanten.setZiel(nach);
            kanten.setGewicht(gewicht);
            graph.get(von).add(kanten);

            System.out.println("Kante hinzugefuegt");
        }else {
            System.out.println("Solche Knoten gibt es nicht");
        }
    }

    public void alleKnotenAusgeben() {
        System.out.print("Knoten: ");
        for (Map.Entry<Knoten, List<Kanten>> entry1 : graph.entrySet()){
            Knoten knoten = entry1.getKey();
            System.out.print(knoten.getKey() + ", ");
        }
        System.out.println();
    }

    public void alleKantenAusgeben() {
        for (Map.Entry<Knoten, List<Kanten>> entry1 : graph.entrySet()) {
            Knoten knoten = entry1.getKey();
            List<Kanten> kanten = entry1.getValue();
            try {
                for(Kanten k : kanten){
                    System.out.println("Kante " + k.getGewicht() + " von " + knoten.getKey() + " nach " + k.getZiel().getKey());
                }
            } catch (NullPointerException e) {
                System.out.println("Keine Kanten von " + knoten.getKey());
            }
        }
    }

    //5.2.2
    public static void graphApp(Graph graph){
        Scanner scanner = new Scanner(System.in);
        int num;
        do{
            System.out.println("-------------Graph Konsole----------------");
            System.out.println("Optionen:");
            System.out.println("1: Knoten hinzufuegen");
            System.out.println("2: Kanten hinzufuegen");
            System.out.println("3: Alle Knoten Ausgeben");
            System.out.println("4: Alle Kanten Ausgeben");
            System.out.println("5: Tiefensuche ");
            System.out.println("6: Dijkstra Algorithmus");
            System.out.println("7: Fin");
            System.out.println("------------------------------------------");
            System.out.print("Waehlen Sie Nummer: ");
            num = scanner.nextInt();
            switch (num){
                case 1:
                    System.out.print("Knoten Char: ");
                    scanner.nextLine();
                    String knoten = scanner.nextLine();
                    if(knoten.length() != 1){
                        System.out.println("Knote muss Char sein");
                        break;
                    }
                    graph.knotenHinzufuegen(knoten.charAt(0));//char
                    System.out.println("Knote " + knoten + " hinzugefuegt");
                    break;
                case 2:
                    System.out.print("Von Knote: ");
                    scanner.nextLine();
                    String knoten1ID = scanner.nextLine();
                    System.out.print("Nach Knote: ");
                    //scanner.nextLine();
                    String knoten2ID = scanner.nextLine();
                    System.out.print("Mit Gewicht: ");
                    //scanner.nextDouble();
                    double gewicht = scanner.nextDouble();
                    graph.kanteHinzufuegen(knoten1ID.charAt(0), knoten2ID.charAt(0), gewicht);
                    break;
                case 3:
                    graph.alleKnotenAusgeben();
                    break;
                case 4:
                    graph.alleKantenAusgeben();
                    break;
                case 5:
                    graph.tiefensuche();
                    break;
                case 6:
                    System.out.print("Startknoten: ");
                    scanner.nextLine();
                    String start = scanner.nextLine();
                    graph.dijkstra(start.charAt(0));
                    break;
            }
        }while (num != 7);
        System.out.println("~fin~");

    }

    //5.2.3
    void tiefensuche(){
        Set<Knoten> besucht = new HashSet<>();
        for (Knoten knoten : graph.keySet()) {
            if (!besucht.contains(knoten)) {
                tiefensucheRekursiv(knoten, besucht);
            }
        }
    }
    //hilfsmethode
    public void tiefensucheRekursiv(Knoten knoten, Set<Knoten> besucht) {
        System.out.println("pre order: " + knoten.getKey());
        besucht.add(knoten);
        for (Kanten k : graph.get(knoten)) {
            Knoten knotennachbar = k.getZiel();
            if (!besucht.contains(knotennachbar)) {
                tiefensucheRekursiv(knotennachbar, besucht);
            }
        }
        System.out.println("post order: " + knoten.getKey());
    }

    //5.2.4
    void dijkstra(char startKnotenID){
        Map<Knoten, Double> entfernung = new HashMap<>();

        PriorityQueue<Knoten> queue = new PriorityQueue<>(Comparator.comparingDouble(entfernung::get));

        Knoten start = null;
        for(Knoten k : graph.keySet()){
            entfernung.put(k, Double.POSITIVE_INFINITY);

            if(k.getKey().equals(String.valueOf(startKnotenID))){
                start = k;
            }
        }

        entfernung.put(start, 0.0);
        queue.add(start);


        while (!queue.isEmpty()) {
            Knoten u = queue.poll();
            for (Kanten k : graph.getOrDefault(u, new ArrayList<>())) {
                Knoten v = k.getZiel();
                double alt = entfernung.get(u) + k.getGewicht();
                if (alt < entfernung.get(v)) {
                    entfernung.put(v, alt);
                    queue.add(v);
                }
            }
        }

        for (Knoten ziel : graph.keySet()) {
            double e = entfernung.get(ziel);
            if (e == Double.POSITIVE_INFINITY) {
                System.out.println(ziel.getKey() + ": nicht erreichbar");
            } else {

                System.out.println(ziel.getKey() + ": Entfernung: " + e);
            }
        }



    }


    public static void main(String[] args){
        Graph graph1 = new Graph();
        Graph.graphApp(graph1);
    }
}
