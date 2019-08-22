import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;

public class alien extends Applet {
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	int x1 =0;
	int y1 =0;
	int x2 =0;
	int y2 =0;
	int ax=0;
	int ay=0;
	int maxx=580;
	int maxy=250;
	Color c=new Color(230,230,0);
	Color cc=new Color(255,0,0);
	Timer t ;
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
		ii=1;
		cox=this.getAppletContext();
		setBackground(c);
			x1=(maxx/6);
			y1=(maxy/6);
		genarete();
		t = new Timer("Timer");
		t.scheduleAtFixedRate(tk,100,200);
	}
	public void destroy(){
		t.cancel();
		ii=230;
	}
		
	public void paint (Graphics g) {
		drawAlien(ax,ay,x1,c,g);
		genarete();
		
		x1=x1+(maxx/12);
		y1=y1+(maxy/12);
		
		drawAlien(ax,ay,x1, cc,g);
	}
	
	public void genarete(){
		if (x1 > maxx ) {
			x1=0;
			ax=(int) Math.round(Math.random()*5.00);
			ay=(int) Math.round(Math.random()*5.00);

		}
		if (y1 > maxy ) {
			y1=0;
			ax=(int) Math.round(Math.random()*5.00);
			ay=(int) Math.round(Math.random()*5.00);
			}

	}

	public void drawAlien(int x,int y,int z,Color color1,Graphics screen){
			int n=0;
			int nn=0;
			int nnn=0;
			int nnnn=0;

			nn=(maxx-z)/2;
			nnn=maxx-(maxx-z)/2;
			nnnn=((nnn-nn)/6)*z+nn;
			nn=y1/6;
			nnn=nn*x;
			nnnn=((z)/6)*(x);
			nnn=nn*y;
			screen.setColor(color1);
			screen.fillOval((maxx-z)/2+nnnn,(maxy-y1)/2+nnn,(z)/6,nn);
		}
}
