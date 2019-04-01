public class Radix {

//  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data){
    int passes = maxL(data);
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    MyLinkedList<Integer> current = new MyLinkedList<Integer>();
    for (int i : data) {
      current.add(i);
    }
    for (int i = 1; i <= passes; i++) {
      for (int x = 0; x < data.length; x++) {
        int num = current.remove(0);
        int index = (int)(num / (Math.pow(10,i-1))) % 10;
      }
    }
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

}
