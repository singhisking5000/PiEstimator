public class PiThread extends Thread {
    public boolean running = true;
    private int c = 0;
    private int n = 0;
    private int p = 0;

    public void run() {
        while (true) {
            System.out.println("\t A running");
            // we MUST synchronize on whatever object could be accessed by multiple
            // threads at the same time. In this case it's ourselves.
            synchronized (this) {
                if (!running) { // are we paused?
                    try {
                        System.out.println("Paused!");
                        this.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //System.out.println("not paused anymore!");
                    //do your calculation

                    //every 10000 calculations calculate actual pi and either write to screen or store in a variable or however you want to do it.
                }
            }

            if (n < 1000000)
            {
                double x = Math.random();
                double y = Math.random();

                if((x*x) + (y*y) < 1)
                {

                }
            }
        }
    }

    //private int

    public static void main(String[] args) {
        PiThread example = new PiThread();
        example.start();
        example.running = false;
        System.out.println("letting it run");
        example.running = true;
        // once agian we must synchronize on the object that could be
        // accessed by more than one thread (same object as above) example
        // synchronized (example) {
        //     example.notify();
        // }
    }
}
