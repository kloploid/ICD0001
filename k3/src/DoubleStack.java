import java.util.*;
public class DoubleStack {
   private final LinkedList<Double> temp;
   public static void main (String[] argum) {
      // TODO!!! Your tests here!
   }

   DoubleStack() {
      temp = new LinkedList<>();
   }

   /**
    * Cloning.
    */
   @Override
   public Object clone() throws CloneNotSupportedException {
      DoubleStack endlist = new DoubleStack();
      for (int i = 0; i < temp.size(); i++) {
         endlist.temp.addLast(temp.get(i));
      }
      return endlist;
   }

   /**
    * Check for emptyness.
    * @return
    */
   public boolean stEmpty() {
      return temp.size() == 0;
   }

   /**
    * Pushing to LinkedList.
    * @param a
    */
   public void push (double a) {
      temp.push(a);
   }

   /**
    * Poping from LinkedList.
    * @return
    */
   public double pop() {
      return temp.pop();
   } // pop

   /**
    * Operations with marks.
    */
   public void op (String s) {
      if (Objects.equals(s, "+")){ // Adding
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp1 + temp2;
         push(tempnew);
      }
      else if (Objects.equals(s, "-")){ // Minusing
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp2 - temp1;
         push(tempnew);
      }
      else if (Objects.equals(s, "/")){ //divide
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp2 / temp1;
         push(tempnew);
      }
      else if (Objects.equals(s, "*")){ //Multiply
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp1 * temp2;
         push(tempnew);
      }
      else if (Objects.equals(s, "SWAP")){ //Swap elements between they.
         if (temp.size() < 2){
            throw new RuntimeException("No enouhgt element for SWAP");
         }
         double temp1 = pop();
         double temp2 = pop();
         push(temp1);
         push(temp2);
      }
      else if (Objects.equals(s, "ROT")){// Rotating 3 elements = ABC to BCA
         if (temp.size() < 3){
            throw new RuntimeException("No enouhgt element for ROT");
         }
         double temp1 = pop();
         double temp2 = pop();
         double temp3 = pop();
         push(temp2);
         push(temp1);
         push(temp3);
      }
      else if (Objects.equals(s, "DUP")){ // Duplicate last element in magazin
         if (temp.size() == 0){
            throw new RuntimeException("No enouhgt element for ROT");
         }
         double temp1 = pop();
         push(temp1);
         push(temp1);
      }
   }

   /**
    * Reading without pop.
    * @return
    */
   public double tos() {
      double temptos = temp.pop();
      temp.push(temptos);
      return temptos;
   }

   /**
    * Simply = equal.
    * @param o
    * @return
    */
   @Override
   public boolean equals (Object o) {

      if (o instanceof DoubleStack) {

         if (((DoubleStack) o).temp.size() != temp.size()) {
            return false;
         }

         for (int i = 0; i < temp.size(); i++) {
            if (!((DoubleStack) o).temp.get(i).equals(temp.get(i))) {
               return false;
            }
         }

         return true;
      }
      throw new RuntimeException("Operator does not apply to Double Stack");
   }

   /**
    * To string.
    * @return
    */
   @Override
   public String toString() {
      StringBuilder buffer = new StringBuilder();

      for (int i = temp.size() - 1; i >= 0; i--) {  // Copy all elements in buffer
         buffer.append(temp.get(i)).append(" ");
      }

      return buffer.toString();
   }

   /**
    * Very long intepreteter.
    * @param pol
    * @return
    */
   public static double interpret (String pol) {
      List<String> pop = Arrays.asList(pol.split(" "));
      DoubleStack pup = new DoubleStack();
      if (pop.size() == 1){
         return Double.parseDouble(pop.get(0));
      }
      for (String pep: pop){
         if(!Objects.equals(String.valueOf(pep), "-") ){
            if (!Objects.equals(String.valueOf(pep), "+")){
               if (!Objects.equals(String.valueOf(pep), "/")){
                  if (!Objects.equals(String.valueOf(pep), "*")){
                     if (!Objects.equals(String.valueOf(pep), "")){
                        if (!Objects.equals(String.valueOf(pep), "\t")){
                           if (!Objects.equals(String.valueOf(pep), "SWAP")){
                              if (!Objects.equals(String.valueOf(pep),"ROT")){
                                 if (!Objects.equals(String.valueOf(pep),"DUP")){
                                    pup.push(Double.parseDouble(pep));
                                 }else{
                                    pup.op(pep);
                                 }
                              }else {
                               pup.op(pep);
                              }
                           }else {
                              pup.op(pep);
                           }
                        }else {
                           pup.op(pep);
                        }
                     }else {
                        pup.op(pep);
                     }
                  }else {
                     pup.op(pep);
                  }
               }else {
                  pup.op(pep);
               }
            }else {
               pup.op(pep);
            }
         }
         else {
            pup.op(pep);
         }
      }
      if (pup.temp.size() > 1){
         throw new RuntimeException("Not enought elements.");
      }
      return pup.pop();
   }
}
import java.util.*;
public class DoubleStack {
   private final LinkedList<Double> temp;
   public static void main (String[] argum) {
      // TODO!!! Your tests here!
   }

   DoubleStack() {
      temp = new LinkedList<>();
   }

   /**
    * Cloning.
    */
   @Override
   public Object clone() throws CloneNotSupportedException {
      DoubleStack endlist = new DoubleStack();
      for (int i = 0; i < temp.size(); i++) {
         endlist.temp.addLast(temp.get(i));
      }
      return endlist;
   }

   /**
    * Check for emptyness.
    * @return
    */
   public boolean stEmpty() {
      return temp.size() == 0;
   }

   /**
    * Pushing to LinkedList.
    * @param a
    */
   public void push (double a) {
      temp.push(a);
   }

   /**
    * Poping from LinkedList.
    * @return
    */
   public double pop() {
      return temp.pop();
   } // pop

   /**
    * Operations with marks.
    */
   public void op (String s) {
      if (Objects.equals(s, "+")){ // Adding
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp1 + temp2;
         push(tempnew);
      }
      else if (Objects.equals(s, "-")){ // Minusing
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp2 - temp1;
         push(tempnew);
      }
      else if (Objects.equals(s, "/")){ //divide
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp2 / temp1;
         push(tempnew);
      }
      else if (Objects.equals(s, "*")){ //Multiply
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp1 * temp2;
         push(tempnew);
      }
      else if (Objects.equals(s, "SWAP")){ //Swap elements between they.
         if (temp.size() < 2){
            throw new RuntimeException("No enouhgt element for SWAP");
         }
         double temp1 = pop();
         double temp2 = pop();
         push(temp1);
         push(temp2);
      }
      else if (Objects.equals(s, "ROT")){// Rotating 3 elements = ABC to BCA
         if (temp.size() < 3){
            throw new RuntimeException("No enouhgt element for ROT");
         }
         double temp1 = pop();
         double temp2 = pop();
         double temp3 = pop();
         push(temp2);
         push(temp1);
         push(temp3);
      }
      else if (Objects.equals(s, "DUP")){ // Duplicate last element in magazin
         if (temp.size() == 0){
            throw new RuntimeException("No enouhgt element for ROT");
         }
         double temp1 = pop();
         push(temp1);
         push(temp1);
      }
   }

   /**
    * Reading without pop.
    * @return
    */
   public double tos() {
      double temptos = temp.pop();
      temp.push(temptos);
      return temptos;
   }

   /**
    * Simply = equal.
    * @param o
    * @return
    */
   @Override
   public boolean equals (Object o) {

      if (o instanceof DoubleStack) {

         if (((DoubleStack) o).temp.size() != temp.size()) {
            return false;
         }

         for (int i = 0; i < temp.size(); i++) {
            if (!((DoubleStack) o).temp.get(i).equals(temp.get(i))) {
               return false;
            }
         }

         return true;
      }
      throw new RuntimeException("Operator does not apply to Double Stack");
   }

   /**
    * To string.
    * @return
    */
   @Override
   public String toString() {
      StringBuilder buffer = new StringBuilder();

      for (int i = temp.size() - 1; i >= 0; i--) {  // Copy all elements in buffer
         buffer.append(temp.get(i)).append(" ");
      }

      return buffer.toString();
   }

   /**
    * Very long intepreteter.
    * @param pol
    * @return
    */
   public static double interpret (String pol) {
      List<String> pop = Arrays.asList(pol.split(" "));
      DoubleStack pup = new DoubleStack();
      if (pop.size() == 1){
         return Double.parseDouble(pop.get(0));
      }
      for (String pep: pop){
         if(!Objects.equals(String.valueOf(pep), "-") ){
            if (!Objects.equals(String.valueOf(pep), "+")){
               if (!Objects.equals(String.valueOf(pep), "/")){
                  if (!Objects.equals(String.valueOf(pep), "*")){
                     if (!Objects.equals(String.valueOf(pep), "")){
                        if (!Objects.equals(String.valueOf(pep), "\t")){
                           if (!Objects.equals(String.valueOf(pep), "SWAP")){
                              if (!Objects.equals(String.valueOf(pep),"ROT")){
                                 if (!Objects.equals(String.valueOf(pep),"DUP")){
                                    pup.push(Double.parseDouble(pep));
                                 }else{
                                    pup.op(pep);
                                 }
                              }else {
                               pup.op(pep);
                              }
                           }else {
                              pup.op(pep);
                           }
                        }else {
                           pup.op(pep);
                        }
                     }else {
                        pup.op(pep);
                     }
                  }else {
                     pup.op(pep);
                  }
               }else {
                  pup.op(pep);
               }
            }else {
               pup.op(pep);
            }
         }
         else {
            pup.op(pep);
         }
      }
      if (pup.temp.size() > 1){
         throw new RuntimeException("Not enought elements.");
      }
      return pup.pop();
   }
}
