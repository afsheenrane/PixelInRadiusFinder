package pixelInRadiusFinder;

import java.util.ArrayList;

public class PartialSubDivisionSolver {

    public static ArrayList<int[]> getAllPoints(int[] vertex, int r) {
        ArrayList<int[]> allPts = new ArrayList<int[]>((int) (Math.PI * r * r * 1.5));

        int startPt;
        int endPt = (int) (r / Math.sqrt(2));
        startPt = -endPt;

        // First solve the central square.
        for (int x = startPt; x <= endPt; x++) {
            for (int y = startPt; y <= endPt; y++) {
                allPts.add(new int[] { x + vertex[0], y + vertex[1] });
                for (int g = 0; g < 2; g++) {
                    double k = Math.sqrt(x * x + y * y);
                }
            }
        }

        // Then solve the half semi circles that remain.
        int startX = endPt;
        int endX = r;

        int endY;

        int rSq = r * r;

        for (int x = startX; x <= endX; x++) {
            endY = (int) Math.sqrt(rSq - (x * x));
            for (int y = 0; y <= endY; y++) {
                allPts.add(new int[] { x + vertex[0], y + vertex[1] });

                allPts.add(new int[] { y + vertex[0], x + vertex[1] });

                allPts.add(new int[] { -y + vertex[0], x + vertex[1] });

                allPts.add(new int[] { -x + vertex[0], y + vertex[1] });

                allPts.add(new int[] { -x + vertex[0], -y + vertex[1] });

                allPts.add(new int[] { -y + vertex[0], -x + vertex[1] });

                allPts.add(new int[] { y + vertex[0], -x + vertex[1] });

                allPts.add(new int[] { x + vertex[0], -y + vertex[1] });

                for (int g = 0; g < 16; g++) {
                    double k = Math.sqrt(x * x + y * y);
                }
            }
        }

        return allPts;
    }

}
