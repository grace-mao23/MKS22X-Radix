public class MyLinkedList<E>{
 private int length = 0;
 private Node start,end;

 public MyLinkedList() {
   //empty constructor
 }

 // clears the list to an empty state
 public void clear() {
   length = 0;
   start = null;
   end = null;
 }

 // returns number of elements in the list
 public int size() {
   return length;
 }

 // returns true, adds value to the end of the list
 public boolean add(E value) {
   if (end == null) { // if list is totally empty
     end = new Node(value,end,null);
     start = end;
   } else {
     Node n = new Node(value, end.prev(), null);
     end.setNext(n);
     end = n;
   }
   length++;
   return true;
 }

 // getNthNode --> used in other methods
 // nodes should not be accessed from outside --> private
 private Node getNode(int index) {
   int current = 0;
   Node result = start;
   while (current < index) {
     result = result.next();
     current++;
   }
   return result;
 }

 // returns data of node at indexOf
 // throws exception if out of range
 public E get(int index) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException();
   }
   return getNode(index).getData();
 }

 // returns old element, removes element at index
 // throws exception if out of range
 public E remove(int index) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException();
   }
   E result = get(index);
   if (index == 0) {
     start = getNode(index+1);
     return result;
   }
   if (getNode(index).next() == null) {
     getNode(index-1).setNext(end);
     end = getNode(index-1);
     end.setNext(null);
     length--;
     return result;
   }
   getNode(index-1).setNext(getNode(index+1));
   getNode(index).setPrev(getNode(index-1));
   length--;
   return result;
 }


 //New Method
 //in O(1) runtime, move the elements from other onto the end of this
 //The size of other is reduced to 0
 //The size of this is now the combined sizes of both original lists
 public void extend(MyLinkedList<E> other){
   if (length == 0) { // if this is empty, make this other
     start = other.start;
     end = other.end;
   } else if (other.size() != 0) { // else if other is not empty, do this
     end.setNext(other.start);
     other.start.setPrev(end);
     end = other.end;
   } // if other is empty, nothing happens
   other.start = null;
   other.end = null;
   length += other.size();
   other.length = 0;
 }

 public String toString() {
   String result = "[";
   if (end == null) {
     return "[]";
   }
   Node current = start;
   result += current.getData() + ", ";
   while (current.next() != null) {
     current = current.next();
     result += current.getData() + ", ";
   }
   result = result.substring(0,result.length() - 2);
   return result + "]";
 }



 public static void main(String[] args) {
   MyLinkedList<Integer> test = new MyLinkedList<Integer>();
   System.out.println(test.toString());
   test.add(0);
   test.add(2);
   test.add(5);
   System.out.println(test.toString());
   MyLinkedList<Integer> test2 = new MyLinkedList<Integer>();
   test2.add(1);
   test2.add(3);
   test2.add(4);
   test2.add(6);
   System.out.println(test2.toString());
   test.extend(test2);
   System.out.println(test.toString());
 }

 class Node{
  private E data;
  private Node next,prev;

  public Node(E d, Node p, Node n) {
    data = d;
    next = n;
    prev = p;
  }

  public E getData() {
    return data;
  }

  public Node next() {
    return next;
  }

  public Node prev() {
    return prev;
  }

  public void setData(E d) {
    data = d;
  }

  public void setNext(Node n) {
    next = n;
  }

  public void setPrev(Node n) {
    prev = n;
  }
 }

}
