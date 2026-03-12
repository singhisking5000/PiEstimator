public class PiThread extends Thread {
    public boolean running = true;
    private int c = 0;
    public int n = 0;
    public double p = 0;
    public boolean maxed = false;

    public void run() {
        while (true) {
            // we MUST synchronize on whatever object could be accessed by multiple
            // threads at the same time. In this case it's ourselves.
            synchronized (this) { // are we paused?
                if (!running) { 
                    try {
                        System.out.println("PAUSED --------------------------------------------------------------------------------------");
                        this.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        System.out.println(" we are catching some errors with syncronization");
                        e.printStackTrace();
                    }
                }
            }

            if (n < Integer.MAX_VALUE)
            {
                    double x = Math.random();
                double y = Math.random();
                if ((x * x) + (y * y) < 1) {
                    c++;
                }
                n++;
                if (n%1000 == 0)
                {
                    p = 4*((double)c / (double)n);
                }
            } else {
                maxed = true;
            }
            // Debug tool
            //System.out.println("C: " + c + " -=- N: " + n + " -=- P: " + p);
        }
    }
}
