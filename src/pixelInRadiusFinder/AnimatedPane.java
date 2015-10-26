package pixelInRadiusFinder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A general JPanel for easily running animations. Includes separate update and
 * render methods. As well as
 * an fps cap.
 * 
 * @author afsheen
 */

@SuppressWarnings("serial")
public class AnimatedPane extends JPanel implements Runnable {

    /**
     * The thread on which everything runs
     */
    private final Thread animator;

    /**
     * Boolean flag which keeps the engine running
     */
    private boolean isRunning = true;

    /**
     * Times per second that the engine physics update
     */
    protected final int updateRate;

    /**
     * delta time between physics updates
     */
    protected final double dt;

    /**
     * Maximum frames that the renderer can skip to try and keep up with the
     * updater
     */
    protected final int maxFramesSkippable;

    /**
     * Maximum frames rendered per second to prevent needless overuse of
     * resources
     */
    protected final int maxFps;

    /**
     * Create a new animated pane
     * 
     * @param updateRate The number of physics/numeric updates to be carried out
     *            per second
     * @param maxFps The total number of frames that can be rendered per second.
     *            To prevent overuse of system resources. Should be higher than
     *            your updateRate.
     * @param maxFramesSkippable For slow systems, the number of frames that can
     *            be sacrificed to conserve accurate calculations. Set this as 5
     *            if you don't know what else to do.
     */
    public AnimatedPane(int updateRate, int maxFps, int maxFramesSkippable) {
        super();

        this.setIgnoreRepaint(true);
        this.setDoubleBuffered(true);
        this.setBackground(Color.red);

        this.updateRate = updateRate;
        this.maxFps = maxFps;
        this.maxFramesSkippable = maxFramesSkippable;
        this.dt = 1.0 / updateRate; // delay between engine updates (NOT
                                    // RENDERS) in seconds

        animator = new Thread(this);
        animator.start();
    }

    public void endAnimation() {
        this.isRunning = false;
    }

    /**
     * Initialize all assets here. Before before the engine loop begins
     */
    public void init() {
    }

    /**
     * The engine update method. All calculations go here.
     */
    public void update() {
    }

    /**
     * Everything to do with rendering the objects from your update method go
     * here. The number of
     * calculations inside here should be minimal.
     * 
     * @param g2d
     */
    public void render(Graphics2D g2d) {
        // System.out.println("rendering");
        g2d.setColor(Color.black);
        for (int[] p : circ) {
            // System.out.println(p[0] + " " + p[1]);
            g2d.drawLine(p[0], p[1], p[0], p[1]);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        render((Graphics2D) g);
    }

    @Override
    public void run() {
        requestFocusInWindow();

        double currentTime = System.nanoTime() / 1e9; // current time in s
        double accumulator = 0.0;
        double timeSinceLastUpdate;

        double timeTakenForLoop;

        init();

        while (isRunning) {
            timeSinceLastUpdate = (System.nanoTime() / 1e9) - currentTime;
            currentTime = System.nanoTime() / 1e9;

            // Makes sure that the engine doesnt stop if there is a reoccuring
            // failure to keep time
            if (timeSinceLastUpdate > maxFramesSkippable * dt)
                timeSinceLastUpdate = maxFramesSkippable * dt;

            accumulator += timeSinceLastUpdate;
            while (accumulator >= dt) {
                update();
                accumulator -= dt;
            }

            repaint();

            timeTakenForLoop = (System.nanoTime() / 1e9) - currentTime;
            callSleep((1000.0 / maxFps) - (timeTakenForLoop * 1e3)); // cap the
                                                                     // FPS to
                                                                     // maxFps
                                                                     // by
                                                                     // sleeping
                                                                     // during
                                                                     // any
                                                                     // extra
                                                                     // time.

        }
        postAnimationCleanUp();

        System.out.println("EXECUTION FINISHED");
    }

    /**
     * Any cleanup that needs to be done should go here. Usually this can stay
     * empty
     */
    private void postAnimationCleanUp() {
    }

    /**
     * Pause the main thread for time milliseconds.
     * 
     * @param time the time in ms to pause the thread.
     */
    private void callSleep(double time) {
        if (time > 0) {
            try {
                Thread.sleep((long) time, (int) Math.round(((time % 1) * 1e6)));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            // System.out.println("NO SLEEP");
        }
    }

    static ArrayList<int[]> circ;

    public static void main(String[] args) {
        JFrame f = new JFrame("Test");
        circ = PartialSubDivisionSolver.getAllPoints(new int[] { 250, 250 }, 200);
        f.setSize(500, 500);
        f.add(new AnimatedPane(50, 200, 5));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        System.out.println(circ.size());

    }

}
