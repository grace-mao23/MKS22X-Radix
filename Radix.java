import java.util.*;
@SuppressWarnings({"unchecked", "rawtypes"})

public class Radix {

//  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    int passes = maxL(data);
    MyLinkedList[] buckets = new MyLinkedList[10];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new MyLinkedList<Integer>();
    }
  //  System.out.println(Arrays.toString(buckets));
    MyLinkedList<Integer> current = new MyLinkedList<Integer>();
    for (int i : data) {
      current.add(i);
    }
  //  System.out.println(current.toString());
    for (int i = 1; i <= passes; i++) {
    //  System.out.println(i);
      for (int x = 0; x < data.length; x++) {
        int num = current.remove(0);
        int index = (int)(num / (Math.pow(10,i-1))) % 10;
      //  System.out.println(buckets[index].toString());
        buckets[index].add(num);
      }
    //  System.out.println(Arrays.toString(buckets));
      current = buckets[0];
      for (int y = 1; y < 10; y++) {
      //  System.out.println("C1: "+current.toString());
        //System.out.println("B: "+buckets[y].toString());
        current.extend(buckets[y]);
        System.out.println("C: "+current.toString());
        //System.out.println();
      }
      clearB(buckets);
    }
    System.out.println(current.toString());
  }

  // returns number of passes necessary
  private static int maxL(int[] data) {
    if (data.length == 0) {
      return 0;
    }
    int result = data[0];
    for (int i : data) {
      if (i > result) {
        result = i;
      }
    }
    return (""+result).length();
  }

  private static void clearB(MyLinkedList<Integer>[] b) {
    for (MyLinkedList<Integer> c : b) {
      c.clear();
    }
  }

  public static void main(String[] args) {
    int[] test = new int[] { 6, 2, 3, 1, 4, 5, 2 };
    Radix.radixsort(test);
  }

}
