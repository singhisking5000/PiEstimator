import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PiEstimator{	
	public static void main(String[] args) {  
		PiThread calculator = new PiThread();
		calculator.running = false;
		calculator.start();

	    JFrame f = new JFrame("Pi Estimator!");  
	    JButton b =new JButton("Resume");  
	    JLabel estimation = new JLabel("Pi Estimation: " + calculator.p);
		JLabel trials = new JLabel("Trials: " + calculator.n);
	    f.add(estimation);
		f.add(trials);
		f.add(b);  
	    f.setSize(300,300);  
	    f.setLayout(new GridLayout(4, 1));  
		f.setVisible(true);   

		//Upon pressing the button...
		b.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(!calculator.running){
					b.setText("Pause");
					synchronized(calculator)
					{
						calculator.running = true;
						// CAUSING ERRORS VVVVV
						calculator.notify();
					}
				} else {
					b.setText("Resume");
					System.out.println(calculator.p);
					calculator.running = false;
					// calculator.notifyAll();
				}
			}
		});

		while(true) {
			estimation.setText("Pi Estimation: " + calculator.p);
			trials.setText("Trials: " + calculator.n);
		}
	}  
}