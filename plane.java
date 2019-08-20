import java.util.*;
import java.applet.*;
import java.awt.*;

public class plane extends Applet {
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	Color c=new Color(200,200,255);
	Color cc=new Color(200,128,0);
	Timer t ;
	TimerTask tk =new TimerTask(){
			public void run(){
				Graphics g =getGraphics();
				if (y < 230){
					y=y+yy;
					paint(g);

				}
				if (ii > 230) t.cancel();
				
				
			}
		};

	
	public void init(){
		ii=1;
		setBackground(cc);
		t = new Timer("Timer");
		t.scheduleAtFixedRate(tk,100,100);
	}
	public void destroy(){
		t.cancel();
		ii=230;
	}
		
	public void paint (Graphics g) {
		g.setColor(c);
		g.fillRect(0,0,640,y);
		g.setColor(cc);
		g.fillRect(0,y,640,300);
	}
}
