import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListVerwaltung {
    public List<Integer> list = null;
    public void listVerwaltung(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Anlegen einer neuen Liste");
        System.out.println("2. Hinzufuegen eines Elements (Integer) am Ende der Liste");
        System.out.println("3. Ausgabe der Laenge der Liste");
        System.out.println("4. Ausgabe des Inhalts der Liste");
        System.out.println("5. Ende");
        System.out.print("Was moechten Sie tun (nummer): ");
        int input = scanner.nextInt();
        switch (input){
            case 1:
                numberOne();
                break;
            case 2:
                numberTwo();
                listVerwaltung();
                break;
            case 3:
                numberThree();
                listVerwaltung();
                break;
            case 4:
                numberFour();
                listVerwaltung();
                break;
            case 5:
                break;
            default:
                System.out.println("nicht ein nummer aus menue");
                listVerwaltung();
                break;
        }
    }
    private void numberOne(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. java.util.ArrayList");
        System.out.println("2. java.util.LinkedList");
        System.out.print("Was moechten Sie tun (nummer): ");
        int input = scanner.nextInt();
        switch(input){
            case 1:
                numberOnenumberOne();
                listVerwaltung();
                break;
            case 2:
                numberOnenumberTwo();
                listVerwaltung();
                break;
        }
    }
    private void numberOnenumberOne(){
        Scanner scanner = new Scanner(System.in);
        list = new ArrayList<Integer>();
        System.out.print("Bitte Zahlen eingeben mit Platz zwischen jeden Wert: ");
        System.out.println();
        String line = scanner.nextLine();
        String[] nums = line.trim().split(" ");
        int[] numsarr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsarr[i] = Integer.parseInt(nums[i]);
            list.add(numsarr[i]);
        }
    }
    private void numberOnenumberTwo(){
        Scanner scanner = new Scanner(System.in);
        list = new LinkedList<Integer>();
        System.out.print("Bitte Zahlen eingeben mit Platz zwischen jeden Wert: ");
        System.out.println();
        String line = scanner.nextLine();
        String[] nums = line.trim().split(" ");
        int[] numsarr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsarr[i] = Integer.parseInt(nums[i]);
            list.add(numsarr[i]);
        }
    }

    private void numberTwo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte ein Zahl zum Einfuegen geben: ");
        System.out.println();
        int num = scanner.nextInt();
        if (list != null) {
            list.add(num);
        } else {
            System.out.println("List gibt es nicht.");
        }
    }

    private void numberThree(){
        if (list != null) {
            System.out.print("Die Laenge der Liste ist: " + list.size());
            System.out.println();
        } else {
            System.out.println("List gibt es nicht.");
        }
    }

    private void numberFour(){
        if (list != null) {
            for(int i = 0; i < list.size(); i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println("List gibt es nicht.");
        }
    }



}
