package pixelInRadiusFinder;

import java.util.ArrayList;

public class CircleAlgorithmBenchmarker {

    public static void main(String[] args) {
        final int ITRS = 5000;
        final int RADIUS = 30;
        final int[] VERTEX = { 300, 300 };

        System.out.println("Starting tests");
        System.out.println("Iterations: " + ITRS);
        System.out.println("Radius: " + RADIUS);

        for (int g = 0; g < 5; g++) {
            System.out.println("\n**********ROUND " + (g + 1) + "**********");

            testNRC(VERTEX, RADIUS, ITRS);
            testPSD_RC(VERTEX, RADIUS, ITRS); // 0.735
            testPSDS(VERTEX, RADIUS, ITRS); // 0.737
            testFSDS(VERTEX, RADIUS, ITRS); // 0.667
            testFSD_RC(VERTEX, RADIUS, ITRS); // 0.69

        }
        System.out.println("Tests completed!");
    }

    /**
     * Tests the Full Sub-Division Solver to find the pixels within a radius.
     * 
     * @param VERTEX
     * @param RADIUS
     * @param ITRS
     */
    private static void testFSDS(final int[] VERTEX, final int RADIUS, final int ITRS) {
        ArrayList<int[]> result = null;
        long runtime;
        long startTime;
        startTime = System.nanoTime();
        for (int i = 0; i < ITRS; i++) {
            result = FullSubDivisionSolver.getAllPoints(VERTEX, RADIUS);
        }

        runtime = System.nanoTime() - startTime;
        System.out.println("Runtime(FSDS): " + runtime / (ITRS * 1e6) + "ms. L: " + result.size());
    }

    /**
     * Tests the Naive Radius Checker algorithm to find the pixels within a
     * radius.
     * 
     * @param VERTEX
     * @param RADIUS
     * @param ITRS
     */
    private static void testNRC(final int[] VERTEX, final int RADIUS, final int ITRS) {
        ArrayList<int[]> result = null;
        long runtime;
        long startTime;
        startTime = System.nanoTime();
        for (int i = 0; i < ITRS; i++) {
            result = NaiveRadiusChecker.getAllPoints(VERTEX, RADIUS);
        }
        runtime = System.nanoTime() - startTime;
        System.out.println("Runtime(NRC): " + runtime / (ITRS * 1e6) + "ms. L: " + result.size());
    }

    /**
     * Tests the Partial Sub-Division Solver to find the pixels within a radius.
     * 
     * @param VERTEX
     * @param RADIUS
     * @param ITRS
     */
    private static void testPSDS(final int[] VERTEX, final int RADIUS, final int ITRS) {
        ArrayList<int[]> result = null;
        long runtime;
        long startTime;
        startTime = System.nanoTime();
        for (int i = 0; i < ITRS; i++) {
            result = PartialSubDivisionSolver.getAllPoints(VERTEX, RADIUS);
        }
        runtime = System.nanoTime() - startTime;
        System.out.println("Runtime(PSDS): " + runtime / (ITRS * 1e6) + "ms. L: " + result.size());
    }

    /**
     * Tests the Partial Sub-Division Radius Checker algorithm to find the
     * pixels within a radius.
     * 
     * @param VERTEX
     * @param RADIUS
     * @param ITRS
     */
    private static void testPSD_RC(final int[] VERTEX, final int RADIUS, final int ITRS) {
        ArrayList<int[]> result = null;
        long runtime;
        long startTime;
        startTime = System.nanoTime();
        for (int i = 0; i < ITRS; i++) {
            result = PartialSubDivisionRadiusChecker.getAllPoints(VERTEX, RADIUS);

        }
        runtime = System.nanoTime() - startTime;
        System.out.println("Runtime(PSD-RC): " + runtime / (ITRS * 1e6) + "ms. L: " + result.size());
    }

    /**
     * Tests the Full Sub-Division Radius Checkerto find the pixels within a
     * radius.
     * 
     * @param VERTEX
     * @param RADIUS
     * @param ITRS
     */
    private static void testFSD_RC(final int[] VERTEX, final int RADIUS, final int ITRS) {
        ArrayList<int[]> result = null;
        long runtime;
        long startTime;
        startTime = System.nanoTime();
        for (int i = 0; i < ITRS; i++) {
            result = FullSubDivisionRadiusChecker.getAllPoints(VERTEX, RADIUS);
        }

        runtime = System.nanoTime() - startTime;
        System.out.println("Runtime(FSD_RC): " + runtime / (ITRS * 1e6) + "ms. L: " + result.size());
    }

}
