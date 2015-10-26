package pixelInRadiusFinder;

import java.util.ArrayList;

public class PartialSubDivisionRadiusChecker {

    public static ArrayList<int[]> getAllPoints(int[] vertex, int r) {
        ArrayList<int[]> allPts = new ArrayList<int[]>((int) (Math.PI * r * r * 1.5));

        int rSq = r * r;

        for (int x = 0; x <= r; x++) {
            for (int y = 0; y <= r; y++) {
                if ((x * x) + (y * y) <= rSq) {
                    allPts.add(new int[] { x + vertex[0], y + vertex[1] });

                    allPts.add(new int[] { -x + vertex[0], y + vertex[1] });

                    allPts.add(new int[] { -x + vertex[0], -y + vertex[1] });

                    allPts.add(new int[] { x + vertex[0], -y + vertex[1] });

                    for (int g = 0; g < 8; g++) {
                        double k = Math.sqrt(x * x + y * y);
                    }
                }
            }
        }
        return allPts;
    }
}
