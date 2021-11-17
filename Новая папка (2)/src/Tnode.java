import java.util.*;

public class Tnode {

   private final String name;
   private Tnode firstChild;
   private Tnode nextSibling;

   private Tnode(String name, Tnode firstChild, Tnode nextSibling) {
      this.name = name;
      this.firstChild = firstChild;
      this.nextSibling = nextSibling;
   }

   private String getName() {
      return this.name;
   }

   private Tnode getFirstChild() {
      return this.firstChild;
   }

   private void setFirstChild(Tnode firstChild) {
      this.firstChild = firstChild;
   }

   private Tnode getNextSibling() {
      return this.nextSibling;
   }

   private void setNextSibling(Tnode nextSibling) {
      this.nextSibling = nextSibling;
   }

   @Override
   public String toString() {
      StringBuilder end = new StringBuilder();
      List<Tnode> tempArray = new ArrayList<>();
      Tnode thisNode = this;
      end.append(thisNode.getName());
      tempArray.add(thisNode);
      Tnode sibling = thisNode.getNextSibling();
      if (thisNode.getFirstChild() != null) {
         if (thisNode.getFirstChild().getNextSibling() != null || thisNode.getFirstChild().getFirstChild() != null) {
            thisNode = thisNode.getFirstChild();
         } else {
            thisNode.setFirstChild(null);
         }
         if (!tempArray.contains(thisNode)) end.append("(");
      } else if (null != sibling) {
         if (sibling.getFirstChild() != null) {
            thisNode = thisNode.getNextSibling();
         } else {
            thisNode.setNextSibling(null);
            if (!tempArray.contains(sibling)) end.append(",").append(sibling.getName());
            end.append(")");
         }
         if (!tempArray.contains(thisNode)) end.append(",");
      }
      while (this.getFirstChild() != null) {
         if (!tempArray.contains(thisNode)) {
            end.append(thisNode.getName());
            tempArray.add(thisNode);
         }
         sibling = thisNode.getNextSibling();
         if (thisNode.getFirstChild() != null) {
            if (thisNode.getFirstChild().getNextSibling() != null || thisNode.getFirstChild().getFirstChild() != null) {
               thisNode = thisNode.getFirstChild();
            } else {
               thisNode.setFirstChild(null);
               thisNode = this;
            }
            if (!tempArray.contains(thisNode)) end.append("(");
         } else if (null != sibling) {
            if (sibling.getFirstChild() != null) {
               thisNode = thisNode.getNextSibling();
            } else {
               thisNode.setNextSibling(null);
               if (!tempArray.contains(sibling)) end.append(",").append(sibling.getName());
               thisNode = this;
               end.append(")");
            }
            if (!tempArray.contains(thisNode)) end.append(",");
         }
      }
      return end.toString();
   }

   //https://www.baeldung.com/java-check-string-number
   private static boolean isNumeric(Tnode pep) {
      if (pep.name == null) {
         return false;
      }
      try {
         Double.parseDouble(pep.name);
      } catch (NumberFormatException nfe) {
         return false;
      }
      return true;
   }

   //https://www.tabnine.com/code/java/methods/net.sf.saxon.dom.DOMNodeList/%3Cinit%3E
   public static Tnode buildFromRPN (String pol) {
      List<Tnode> end = new ArrayList<>();
      for (String str : pol.split(" ")) {
         end.add(new Tnode(str, null, null));
      }
      if (!isNumeric(end.get(0)) && end.size() == 1) {
         throw new RuntimeException(String.format("In %s consist only of mathematic operations", pol));
      }
      for (Tnode pep : end) {
         if (!isNumeric(pep) && !pep.name.equals("*")  && !pep.name.equals("/")
                 && !pep.name.equals("+") && !pep.name.equals("-")) {
            throw new RuntimeException(String.format("illegal arguments in %s", pol));
         }
      }
      int counter = 0;
      while (end.size() > 1) {
         if (end.size() < 3) {
            throw new RuntimeException(String.format("In %s not enough numerous for mathematical operation", pol));
         }
         if ((isNumeric(end.get(counter)) || end.get(counter).getFirstChild() != null)
                 && (isNumeric(end.get(counter + 1)) || end.get(counter + 1).getFirstChild() != null)
                 && (!isNumeric(end.get(counter + 2)) && end.get(counter + 2).getFirstChild() == null)) {
            Tnode previous = end.get(counter);
            Tnode next = end.get(counter + 1);
            previous.setNextSibling(next);
            Tnode upper = end.get(counter + 2);
            upper.setFirstChild(previous);
            end.remove(counter + 1);
            end.remove(counter);
            counter = 0;
            continue;
         }
         counter++;
      }
      return end.get(0);
   }

   public static void main (String[] param) {
      String rpn = "1 2 +";
      System.out.println ("RPN: " + rpn);
      Tnode res = buildFromRPN (rpn);
      System.out.println ("Tree: " + res);
   }
}