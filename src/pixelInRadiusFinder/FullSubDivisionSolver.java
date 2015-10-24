package pixelInRadiusFinder;

import java.util.ArrayList;

public class FullSubDivisionSolver {

    public static ArrayList<int[]> getAllPoints(int[] vertex, int r) {
        ArrayList<int[]> allPts = new ArrayList<int[]>((int) (Math.PI * r * r));

        int endPt = (int) (r / Math.sqrt(2));

        int[] pt = new int[2];

        // Add in central cross that gets missed out.
        pt[0] = 0;
        pt[1] = 0;
        allPts.add(pt);

        pt[0] = 1;
        pt[1] = 0;
        allPts.add(pt);

        pt[0] = 0;
        pt[1] = 1;
        allPts.add(pt);

        pt[0] = -1;
        pt[1] = 0;
        allPts.add(pt);

        pt[0] = 0;
        pt[1] = -1;
        allPts.add(pt);

        // First solve the central square.
        for (int x = 1; x <= endPt; x++) {
            for (int y = 1; y <= endPt; y++) {
                pt[0] = x + vertex[0];
                pt[1] = y + vertex[1];
                allPts.add(pt);

                pt[0] = -x + vertex[0];
                pt[1] = y + vertex[1];
                allPts.add(pt);

                pt[0] = x + vertex[0];
                pt[1] = -y + vertex[1];
                allPts.add(pt);

                pt[0] = -x + vertex[0];
                pt[1] = -y + vertex[1];
                allPts.add(pt);

                // Just to simulate scenarios where each point's distance from
                // the center would like to be known. This has a negligible
                // effect on runtime.
                for (int g = 0; g < 8; g++) {
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

                // Just to simulate scenarios where each point's distance from
                // the center would like to be known. This has a negligible
                // effect on runtime.
                for (int g = 0; g < 16; g++) {
                    double k = Math.sqrt(x * x + y * y);
                }
            }
        }
        return allPts;
    }

}
