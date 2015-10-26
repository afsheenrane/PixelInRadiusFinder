package pixelInRadiusFinder;

import java.util.ArrayList;

public class NaiveRadiusChecker {

    /**
     * Computed all integer points centered around the vertex given the radius
     * r. <br>
     * This uses a naive radius checker which just checks all points in the
     * circle's AABB to see if there are within the correct radius or not.
     * 
     * @param vertex the center of the circle.
     * @param r the radius of the circle.
     * @return an arraylist of all integer based points inside the circle.
     */
    public static ArrayList<int[]> getAllPoints(int[] vertex, int r) {
        ArrayList<int[]> allPts = new ArrayList<int[]>((int) (Math.PI * r * r * 1.5));

        int startX = -r;
        int endX = r;

        int startY = -r;
        int endY = r;

        int rSq = r * r;

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if ((x * x) + (y * y) <= rSq) {
                    allPts.add(new int[] { x + vertex[0], y + vertex[1] });
                }
            }
        }

        return allPts;
    }

}
