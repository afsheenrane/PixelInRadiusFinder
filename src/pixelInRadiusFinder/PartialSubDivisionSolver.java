package pixelInRadiusFinder;

import java.util.ArrayList;

public class PartialSubDivisionSolver {

    public static ArrayList<int[]> getAllPoints(int[] vertex, int r) {
        ArrayList<int[]> allPts = new ArrayList<int[]>((int) (Math.PI * r * r));

        int startPt;
        int endPt = (int) (r / Math.sqrt(2));
        startPt = -endPt;

        int[] pt = new int[2];

        // First solve the central square.
        for (int x = startPt; x <= endPt; x++) {
            for (int y = startPt; y <= endPt; y++) {
                pt[0] = x + vertex[0];
                pt[1] = y + vertex[1];
                allPts.add(pt);
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
                pt[0] = x + vertex[0];
                pt[1] = y + vertex[1];
                allPts.add(pt);

                pt[0] = y + vertex[0];
                pt[1] = x + vertex[1];
                allPts.add(pt);

                pt[0] = -y + vertex[0];
                pt[1] = x + vertex[1];
                allPts.add(pt);

                pt[0] = -x + vertex[0];
                pt[1] = y + vertex[1];
                allPts.add(pt);

                pt[0] = -x + vertex[0];
                pt[1] = -y + vertex[1];
                allPts.add(pt);

                pt[0] = -y + vertex[0];
                pt[1] = -x + vertex[1];
                allPts.add(pt);

                pt[0] = y + vertex[0];
                pt[1] = -x + vertex[1];
                allPts.add(pt);

                pt[0] = x + vertex[0];
                pt[1] = -y + vertex[1];
                allPts.add(pt);
            }
        }

        return allPts;
    }

}
