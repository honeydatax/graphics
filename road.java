import java.util.*;
import java.applet.*;
import java.awt.*;

public class road extends Applet {
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	int[] x1 = new int[10];
	int[] y1 = new int[10];
	int[] x2 = new int[10];
	int[] y2 = new int[10];
	Color c=new Color(230,230,230);
	Color cc=new Color(255,0,0);
	Timer t ;
	TimerTask tk =new TimerTask(){
			public void run(){
				Graphics g =getGraphics();
				if (ii < 230){
					paint(g);
				}
				if (ii > 230) t.cancel();
				
				
			}
		};

	
	public void init(){
		int n;
		ii=1;
		setBackground(c);
		for(n=0;n<6;n++){
			x1[n]=(580/6)*n;
			y1[n]=(250/6)*n;
		}
		t = new Timer("Timer");
		t.scheduleAtFixedRate(tk,100,100);
	}
	public void destroy(){
		t.cancel();
		ii=230;
	}
		
	public void paint (Graphics g) {
		int n;
		g.setColor(c);
		for(n=0;n<6;n++){
			g.drawLine((580-x1[n])/2,250-(250-y1[n])/2,580-(580-x1[n])/2,250-(250-y1[n])/2);
			x1[n]=x1[n]+(580/12);
			y1[n]=y1[n]+(250/12);
			if (x1[n] > 580 ) x1[n]=0;
			if (y1[n] > 250 ) y1[n]=0;
		}
		g.setColor(cc);

		for(n=0;n<6;n++){
			g.drawLine((580-x1[n])/2,250-(250-y1[n])/2,580-(580-x1[n])/2,250-(250-y1[n])/2);
		}
		g.drawLine(580/2,250/2,580,250);
		g.drawLine(580/2,250/2,0,250);
		g.drawRect(0,0,580,250);
		
	}
}
