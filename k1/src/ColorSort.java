public class ColorSort {

   enum Color {red, green, blue}

   public static void main (String[] param) {
      // for debugging
   }
   public static void reorder (Color[] balls) {
      Color[] temp = new Color[balls.length];
      int red = 0;
      int blue = 0;
      if (balls.length == 0 || balls.length == 1) {
         return;
      }
      for (Color item : balls){
         if (item == Color.red){
            red += 1;
         }
         if (item == Color.blue){
            blue -= 1;
         }
      }
      int green = balls.length + (blue - red);
      int redcons = red;
      while (red + green - blue > 0 ){
         if(red > 0){
            balls[red - 1] = Color.red;
            red -= 1;
         }
          if (green > 0){
            balls[green + redcons - 1] = Color.green;
            green -= 1;
         }
          if (blue < 0){
                balls[balls.length + blue - 1] = Color.blue;
                blue += 1;
             }
         }
      }
   }