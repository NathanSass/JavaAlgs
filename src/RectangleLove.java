/**
 * Created by nathansass on 9/15/16.
 */
public class RectangleLove {

    public static void main(String[] args) {
        Rectangle r1 = new RectangleLove().new Rectangle(0,0,1,1);
        Rectangle r2 = new RectangleLove().new Rectangle(1,1,2,2);
//        Rectangle r2 = new RectangleLove().new Rectangle(10,10,2,2);
        System.out.println(new RectangleLove().findOverlap(r1, r2));
    }

    public String findOverlap(Rectangle r1, Rectangle r2) {
        Rectangle result = new Rectangle();

        int minX = Math.max(r1.leftX, r2.leftX);
        int maxX = Math.min(r1.leftX + r1.width, r2.leftX + r2.width);

        int minY = Math.max(r1.bottomY, r2.bottomY);
        int maxY = Math.min(r1.bottomY + r1.height, r2.bottomY + r2.height);

        result.leftX = minX;
        result.bottomY = minY;
        result.width = maxX - minX;
        result.height = maxY - minY;


        if (isInside(r1, result) && isInside(r2, result) && result.isValid()) {
            return result.toString();
        } else {
            return "No Overlap";
        }

    }

    public boolean isInside(Rectangle parent, Rectangle child) {
        if ((child.leftX >= parent.leftX) &&
                (child.leftX + child.width <= parent.leftX + parent.width) &&
                (child.bottomY >= parent.bottomY) &&
                (child.bottomY + child.height <= parent.bottomY + parent.height)) {
            return true;
        } else {
            return false;
        }

    }

    public class Rectangle {

        // coordinates of bottom left corner
        Integer leftX;
        Integer bottomY;

        // dimensions
        Integer width;
        Integer height;

        public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public boolean isValid() {
            if( leftX >= 0 &&
                    bottomY >= 0 &&
                    width >= 0 &&
                    height >= 0) {
                return true;
            } else {
                return false;
            }
        }

        public Rectangle() {}

        public String toString() {
            return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);
        }
    }
}


