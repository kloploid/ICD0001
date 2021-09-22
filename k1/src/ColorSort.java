public class ColorSort {

    enum Color {red, green, blue}

    public static void main(String[] param) {
        // for debugging
    }

    public static void reorder(Color[] balls) {
        //Balls counting in array
        int red = 0;
        int blue = 0;
        for (Color ball : balls) {
            if (ball == Color.red) {
                red += 1;
            }
            if (ball == Color.blue) {
                blue += 1;
            }
        }
        int green = balls.length - (red + blue);
        //Balls insert in array
        int index = 0;
        while (index <= balls.length) {
            if (red > 0) {
                balls[index] = Color.red;
                red -= 1;
            } else if (green > 0) {
                balls[index] = Color.green;
                green -= 1;
            } else if (blue > 0) {
                balls[index] = Color.blue;
                blue -= 1;
            }
            index += 1;
        }
    }
}