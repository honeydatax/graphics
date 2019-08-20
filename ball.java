import java.util.*;
import java.applet.*;
import java.awt.*;

public class ball extends Applet {
	int ii=1;
	int x=0;
	int y=0;
	int xx=10;
	int yy=10;
	Color c=new Color(255,0,0);
	Color cc=new Color(230,230,230);
	Timer t ;
	TimerTask tk =new TimerTask(){
			public void run(){
				Graphics g =getGraphics();
				if (ii < 100){
					g.setColor(cc);
					g.fillOval(x,y,20,20);
					x=x+xx;
					y=y+yy;
					if (x>580) xx=-(xx);
					if (y>280) yy=-(yy);
					if (x<4) xx=-(xx);
					if (y<4) yy=-(yy);
					paint(g);

				}
				if (ii > 100) t.cancel();
				
				
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
		ii=110;
	}
		
	public void paint (Graphics g) {
		g.setColor(c);
		g.fillOval(x,y,20,20);
	}
}
