
import java.util.*;
public class DoubleStack {
   LinkedList<Double> temp = new LinkedList<>();
   ArrayList<Double> temparray = new ArrayList<>();
   public static void main (String[] argum) {
      // TODO!!! Your tests here!
   }

   DoubleStack() {

   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      DoubleStack endlist = new DoubleStack();
      for (double number: temparray){
         endlist.push(number);
      }
      return endlist;
   }

   public boolean stEmpty() {
      return temp.size() == 0;
   }

   public void push (double a) {
      temp.push(a);
      temparray.add(a);
   }

   public double pop() {
      temparray.remove(temparray.size() - 1);
      return temp.pop();
   } // pop

   public void op (String s) {
      if (Objects.equals(s, "+")){
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp1 + temp2;
         push(tempnew);
      }
      else if (Objects.equals(s, "-")){
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp2 - temp1;
         push(tempnew);
      }
      else if (Objects.equals(s, "/")){
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp2 / temp1;
         push(tempnew);
      }
      else if (Objects.equals(s, "*")){
         double temp1 = pop();
         double temp2 = pop();
         double tempnew = temp1 * temp2;
         push(tempnew);
      }
      else if (Objects.equals(s, "SWAP")){
         double temp1 = pop();
         double temp2 = pop();
         push(temp1);
         push(temp2);
      }
      else if (Objects.equals(s, "ROT")){
         double temp1 = pop();
         double temp2 = pop();
         double temp3 = pop();
         push(temp2);
         push(temp1);
         push(temp3);
      }
      else if (Objects.equals(s, "DUP")){
         double temp1 = pop();
         push(temp1);
         push(temp1);
      }
   }

   public double tos() {
      double temptos = temp.pop();
      temp.push(temptos);
      return temptos;
   }

   @Override
   public boolean equals (Object o) {
      if (o instanceof DoubleStack){
         return temparray.equals(((DoubleStack) o).temparray);
      }else {
         return false;
      }
   }

   @Override
   public String toString() {
      StringBuilder end = new StringBuilder();
      for (double pep: temparray){
         end.append(pep).append(" ");
      }
      return end.toString();
   }

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
      if (pup.temparray.size() > 1){
         throw new RuntimeException();
      }
      return pup.pop();
   }

}