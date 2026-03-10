import java.util.Enumeration;
import java.util.Scanner;

public class DoublyLinkedList {
    // 1. Doppelt verkettete Liste
    // 1.2
    int length;
    DoublyLinkedElement first;
    DoublyLinkedElement last;

    public void addFirst(DoublyLinkedElement addedFirst){
        if(isEmpty()){
            first = last = addedFirst;
        }else {
            addedFirst.setNext(first);
            first.setPrevious(addedFirst);
            first = addedFirst;
        }
        length++;

    }
    public void addLast(DoublyLinkedElement addedLast){
        if(isEmpty()){
            first = last = addedLast;
        } else {
            addedLast.setPrevious(last);
            last.setNext(addedLast);
            last = addedLast;
        }
        length++;

    }
    public DoublyLinkedElement getFirst(){
        return first;
    }
    public DoublyLinkedElement getLast(){
        return last;
    }
    public int getLength(){
        return length;
    }
    public boolean isEmpty(){
        if(length == 0){
            return true;
        } else {
            return false;
        }
    }


    //1.4
    public boolean add(DoublyLinkedElement e, int position){
        // if position out of bound
        if(position > length){
            System.out.println("position out of bound");
            return false;
        }

        // if position at start
        if(position == 1){
            addFirst(e);
            return true;
        }
        // if position at end
        // length + 1 because "Das Element, das sich aktuell an dieser Stelle befindet,
        // soll mit allen folgenden Elementen wieder an das neue Element angehängt werden"
        if(position == length+1){
            addLast(e);
            return true;
        }

        // if position in middle
        // copy old list
        DoublyLinkedList oldList = new DoublyLinkedList();
        DoublyLinkedElement currElement = first;
        for(int i = 1; i <= length; i++){
            oldList.addLast(currElement);
            currElement = currElement.getNext();
        }
        // create new list
        length++;
        DoublyLinkedList newList = new DoublyLinkedList();
        DoublyLinkedElement currElementOldList = oldList.first;
        for(int i = 1; i <= length; i++){
            if(i != position){
                newList.addLast(currElementOldList);
                currElementOldList = currElementOldList.getNext();
            } else {
                newList.addLast(e);
            }
        }
        return true;
    }

    //1.3 + 1.4
    public static void application(DoublyLinkedList linkedList){
        Scanner scanner = new Scanner(System.in);
        int num;
        do{
            System.out.println("Optionen:");
            System.out.println("1: Listenelement am Anfang hinzufuegen");
            System.out.println("2: Listenelement am Ende hinzufuegen");
            System.out.println("3: Laenge der Liste ausgeben");
            System.out.println("4: Erstes Element ausgeben");
            System.out.println("5: Letztes Element ausgeben");
            System.out.println("6: Element einfuegen an beliebigen Stelle");  //1.4
            System.out.println("7: Fin");
            System.out.print("Nummer: ");
            num = scanner.nextInt();
            switch (num){
                case 1:
                    DoublyLinkedElement doublyLinkedElement1 = new DoublyLinkedElement();
                    System.out.print("Element: ");
                    String el = scanner.next();
                    doublyLinkedElement1.setData(el);
                    linkedList.addFirst(doublyLinkedElement1);
                    break;
                case 2:
                    DoublyLinkedElement doublyLinkedElement2 = new DoublyLinkedElement();
                    System.out.print("Element: ");
                    String el2 = scanner.next();
                    doublyLinkedElement2.setData(el2);
                    linkedList.addLast(doublyLinkedElement2);
                    break;
                case 3:
                    System.out.println("List Length: " + linkedList.getLength());
                    break;
                case 4:
                    System.out.println("First Element: " + linkedList.getFirst().getData());
                    break;
                case 5:
                    System.out.println("Last Element: " + linkedList.getLast().getData());
                    break;
                case 6:                                                         //1.4
                    System.out.print("Element: ");
                    String el3 = scanner.next();
                    DoublyLinkedElement doublyLinkedElement3 = new DoublyLinkedElement();
                    doublyLinkedElement3.setData(el3);
                    System.out.print("an Stelle: ");
                    int pos = scanner.nextInt();
                    linkedList.add(doublyLinkedElement3, pos);
                    break;
            }
        }while(num != 7);
    }

    public static void main(String[] args){
        // 1.3 + 1.4
        DoublyLinkedList linkedList = new DoublyLinkedList();
        application(linkedList);

    }

}
