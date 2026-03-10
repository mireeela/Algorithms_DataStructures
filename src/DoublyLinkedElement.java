public class DoublyLinkedElement {
    // 1. Doppelt verkettete Liste
    // 1.1
    String s;
    DoublyLinkedElement next;
    DoublyLinkedElement previous;

    public DoublyLinkedElement getNext(){
        return next;
    }
    public DoublyLinkedElement getPrevious(){
        return previous;
    }
    public void setNext(DoublyLinkedElement next){
        this.next = next;
    }
    public void setPrevious(DoublyLinkedElement previous){
        this.previous = previous;
    }
    public String getData(){
        return s;
    }
    public void setData(String s){
        this.s = s;
    }

}
