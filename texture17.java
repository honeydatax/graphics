import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;

public class texture17 extends Applet {
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	Color c=new Color(255,255,255);
	Color cc=new Color(0,0,0);
	Color cc1;
	Polygon poly;
	Timer t ;
	VolatileImage bitmap1;
	Graphics2D gg;
	AppletContext cox;
	
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
		int nn;
		int nnn;
		ii=1;
		cox=this.getAppletContext();
		//t.scheduleAtFixedRate(tk,100,200);
	}
	public void destroy(){
		//t.cancel();
		ii=230;
	}
		
	public void paint (Graphics g) {
		int bn=0;
		int n=0;
		int nn=0;
		int nnn=0;
		int nnnn=0;
		for (bn=25;bn<150;bn=bn+5){
			n=150-bn;
			cc1=new Color(bn*1000/589,bn*1000/589,bn*1000/589);
			g.setColor(cc1);
			g.fillRect(150-n,150-n,n*2,n*2 );
		}
		
	}
}
