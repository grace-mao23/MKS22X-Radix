import java.util.*;
@SuppressWarnings({"unchecked", "rawtypes"})

public class Radix {

//  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    int passes = maxL(data);
    MyLinkedList[] buckets = new MyLinkedList[20];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new MyLinkedList<Integer>();
    }
    for (int i = 1; i <= passes; i++) {
      MyLinkedList<Integer> current = new MyLinkedList<Integer>();
      for (int d : data) {
        current.add(d);
      }
      System.out.println(current.toString());
      for (int x = 0; x < data.length; x++) {
      //  System.out.println(x);
        int num = current.remove(0);
        int index = (int)(num / (Math.pow(10,i-1))) % 10;
        buckets[index+9].add(num);
        System.out.println(Arrays.toString(buckets));
      }
      MyLinkedList<Integer> temp = buckets[0];
      for (int y = 1; y < 20; y++) {
        System.out.println("1: "+temp.toString());
        System.out.println(buckets[y].toString());
        temp.extend(buckets[y]);
        System.out.println("2: "+temp.toString());
      }
      System.out.println(temp.toString());
      for (int z = 0; z < data.length; z++) {
        data[z] = temp.remove(0);
      }
      clearB(buckets);
    //  System.out.println(Arrays.toString(data));
    }
  //  System.out.println(Arrays.toString(data));
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
    int[] test = new int[] { 62, 21, 32, 13, 41, 24, 25 };
    Radix.radixsort(test);
    System.out.println(Arrays.toString(test));
    int[] test2 = new int[] { 12, -13, 21,-4, 43, -32, 0, -1 };
    Radix.radixsort(test2);
    System.out.println(Arrays.toString(test2));
  }

}
