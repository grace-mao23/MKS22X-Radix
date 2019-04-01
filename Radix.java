public class Radix {

  public void radixsort(int[] data){
    int passes = maxL(data);
    for (int i = 1; i <= passes; i++) {
      
    }
  }

  // returns number of passes necessary
  private int maxL(int[] data) {
    int result = data[0];
    for (int i : data) {
      if (i > result) {
        result = i;
      }
    }
    return (""+result).length();
  }

}
