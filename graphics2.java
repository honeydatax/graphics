import java.util.*;
import java.applet.*;
import java.awt.*;

public class graphics2 extends Applet {
	int ii=1;
	Timer t ;
	TimerTask tk =new TimerTask(){
			public void run(){
				if (ii < 100){
					ii=ii+1;
					repaint();
					//t.schedule(tk,100);
				}
				if (ii > 100) t.cancel();
				
				
			}
		};

	
	public void init(){
		ii=1;
		t = new Timer("Timer");
		t.scheduleAtFixedRate(tk,100,100);
	}
	public void destroy(){
		t.cancel();
		ii=110;
	}
		
	public void paint (Graphics g) {
		int i;
		String s;
		for(i=0;i<ii;i++){
			g.setColor(new Color(255,i*2,i*2));
			g.drawLine(i+20,20,i+20,40);

		}
		s=Integer.toString(ii)+" % ";
		g.setColor(new Color(0,0,0));
		g.drawString(s,70,30);		
	}
}
