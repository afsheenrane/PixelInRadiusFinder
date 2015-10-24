package pixelInRadiusFinder;

import java.util.ArrayList;

public class CircleAlgorithmBenchmarker {

    public static void main(String[] args) {
        final int ITRS = 500;
        final int RADIUS = 300;
        final int[] VERTEX = { 300, 300 };

        // Just warm up the JVM
        for (int i = 0; i < 10000; i++) {
            double g = i * 2 + 3 - 4 + 5 / 6;
        }

        System.out.println("Starting tests");
        System.out.println("Iterations: " + ITRS);
        System.out.println("Radius: " + RADIUS);

        for (int g = 0; g < 3; g++) {
            System.out.println("\n**********ROUND " + (g + 1) + "**********");

            testNRC(VERTEX, RADIUS, ITRS);
            testPSD_RC(VERTEX, RADIUS, ITRS);
            testPSDS(VERTEX, RADIUS, ITRS);
            testFSDS(VERTEX, RADIUS, ITRS);

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

}
