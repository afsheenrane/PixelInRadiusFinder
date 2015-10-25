package pixelInRadiusFinder;

import java.util.ArrayList;

public class FullSubDivisionRadiusChecker {

    public static ArrayList<int[]> getAllPoints(int[] vertex, int r) {
        ArrayList<int[]> allPts = new ArrayList<int[]>((int) (Math.PI * r * r));

        int rSq = r * r;

        int[] pt = new int[2];

        for (int x = 0; x <= r; x++) {
            for (int y = 0; y <= x; y++) {
                if ((x * x) + (y * y) <= rSq) {
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

                    for (int g = 0; g < 16; g++) {
                        double k = Math.sqrt(x * x + y * y);
                    }
                }
            }
        }
        return allPts;
    }
}
