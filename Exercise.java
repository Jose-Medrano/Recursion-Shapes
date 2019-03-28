import java.util.*;

public class Exercise{

  /**
   * This method takes in an ArrayList of ints and adds them all up.
   * @return Integer is the total sum of the ArrayList.
   */
	public static Integer sumList(ArrayList<Integer> list){
		if (list == null || list.size() == 0) {
      return null;
    }

    if (list.size() == 1) {
      return list.get(0);
    }

    int sum = list.get(list.size() - 1);
    list.remove(list.size() - 1);

    return sum + sumList(list);
	}

  /**
   * This method finds the average of all the numbers within the ArrayList.
   * @return Double is the average of the numbers within the ArrayList. 
   */
	public static Double findAverage(ArrayList<Integer> list){
		if (list == null || list.size() == 0) {
      return null;
    }
 
    if (list.size() == 1) {
      return (double)list.get(0);
    }
    double sum = list.get(list.size() - 1);
    double length = list.size();

    list.remove(list.size() - 1);
    int newLength = list.size();
    ArrayList<Integer> copy = new ArrayList<Integer>(list);
    

    return (double)(sum + newLength*findAverage(copy))/length;
	}

  /**
   * This method takes in a String and returns an arraylist of the individual
   * letters.
   * @return ArrayList<Character> is the list of the characters within the
   * String.
   */
	public static ArrayList<Character> strToList(String word) {
    if (word == null) {
      return null;
    }
    ArrayList<Character> letters = new ArrayList<Character>();
    if (word.isEmpty()) {
      return letters;
    }
    if (word.length() == 1) {
      letters.add(word.charAt(0));
      return letters;
    }
    letters = strToList(word.substring(0, word.length() - 1));
    letters.add(word.charAt(word.length() - 1));
    

    return letters;
	}

	public static void main(String[] args){
		ArrayList<Integer> test1 = new ArrayList<Integer>();
    test1.add(1);
    test1.add(2);
    test1.add(3);
    //System.out.println(sumList(test1));
    System.out.println(findAverage(test1));
    String jose = new String();
    System.out.println(strToList(jose));

	}
}
