import java.text.SimpleDateFormat;
import java.util.*;

public class Answer {

   public static void main (String[] param) {

      // TODO!!! Solutions to small problems 
      //   that do not need an independent method!
    
      // conversion double -> String
         Double a = 2.4;
         a.toString();
      // conversion String -> int
         String b = "2";
         Integer.valueOf(b);
      // "hh:mm:ss"
      String pattern = " hh:mm:ss";
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
      String date = simpleDateFormat.format(new Date());
      System.out.println(date);
      // cos 45 deg
      Double rad = Math.toRadians(45);
      Math.cos(rad);

      // table of square roots
      String screen = "";
      int counter = 0;
      while (counter < 100){
         screen = counter + " " + Double.toString(Math.sqrt(counter));
         System.out.println(screen);
         counter += 5;
      }

      String firstString = "ABcd12";
      String result = reverseCase (firstString);
      System.out.println ("\"" + firstString + "\" -> \"" + result + "\"");

      // reverse string

      String s = "How  many	 words   here";
      int nw = countWords (s);
      System.out.println (s + "\t" + String.valueOf (nw));

      // pause. COMMENT IT OUT BEFORE JUNIT-TESTING!

      final int LSIZE = 100;
      ArrayList<Integer> randList = new ArrayList<Integer> (LSIZE);
      Random generaator = new Random();
      for (int i=0; i<LSIZE; i++) {
         randList.add (Integer.valueOf (generaator.nextInt(1000)));
      }

      // minimal element

      // HashMap tasks:
      //    create
      //    print all keys
      //    remove a key
      //    print all pairs

      System.out.println ("Before reverse:  " + randList);
      reverseList (randList);
      System.out.println ("After reverse: " + randList);

      System.out.println ("Maximum: " + maximum (randList));
   }

   /** Finding the maximal element.
    * @param a Collection of Comparable elements
    * @return maximal element.
    * @throws NoSuchElementException if <code> a </code> is empty.
    */
   static public <T extends Object & Comparable<? super T>>
         T maximum (Collection<? extends T> a) 
            throws NoSuchElementException {
      T max = null;
      int trigger1 = 0;

         for (T pep :a){
            if (trigger1 == 0){
               max = pep;
               trigger1 = 1;
            }
            if (max.compareTo(pep) < 0){
               max = pep;
            }
         }
         return max;
   }

   /** Counting the number of words. Any number of any kind of
    * whitespace symbols between words is allowed.
    * @param text text
    * @return number of words in the text
    */
   public static int countWords (String text) {
      char[] temp = text.toCharArray();
      int counter = 0;
      int trigger = 0;
      for (char pep :temp){
         if (Character.isLetter(pep) && trigger == 0){
            counter += 1;
            trigger = 1;
         }
         else if (Character.isLetter(pep) && trigger == 1){
            trigger = 1;
         }
         else if (!Character.isLetter(pep) && trigger == 1){
            trigger = 0;
         }
      }
      return counter;
   }

   /** Case-reverse. Upper -> lower AND lower -> upper.
    * @param s string
    * @return processed string
    */
   public static String reverseCase (String s) {
      StringBuilder temp = new StringBuilder();
      for (char pep :s.toCharArray()){
         if (pep == Character.toLowerCase(pep)){
            pep = Character.toUpperCase(pep);
         }
         else if (pep == Character.toUpperCase(pep)){
            pep = Character.toLowerCase(pep);
         }
         temp.append(pep);
      }
      return temp.toString();
   }

   /** List reverse. Do not create a new list.
    * @param list list to reverse
    */
   public static <T extends Object> void reverseList (List<T> list)
      throws UnsupportedOperationException {
         T temp1;
         T temp2;
         int counter = 0;
         while(counter < list.size() / 2){
            temp1 = list.get(counter);
            temp2 = list.get(list.size() - (counter + 1));
            list.set(list.size() - (counter + 1),temp1);
            list.set(counter,temp2);
            counter += 1;
         }
   }
}
