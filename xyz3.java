import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;

public class xyz3 extends Applet {
	int ii=1;
	int divds=8;
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
	int centerx=maxx/2;
	int centery=maxy/2;
	int zx=maxx/divds;
	int zy=maxy/divds;
	int xz=zx;
	int yz=zy;
	Color c=new Color(255,255,255);
	Color cc=new Color(0,0,0);
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
		cox=this.getAppletContext();
		setBackground(c);
		genarete();
		t = new Timer("Timer");
		//t.scheduleAtFixedRate(tk,1000,1000);
	}
	public void destroy(){
		t.cancel();
		ii=230;
	}
		
	public void paint (Graphics g) {
	int n=0;
		for (n=0;n<8;n++){
			genarete();
			xz=zx+xz;
			yz=zy+yz;
			drawPlanet(ax,ay,yz,yz,cc,g);
		}
	}
	
	public void rndn(){
			ax=(int) Math.round(Math.random()*5.00);
			ay=(int) Math.round(Math.random()*5.00);
		}
	public void genarete(){
			rndn();
		

	}

	public void drawPlanet(int x,int y,int xxz,int yyz,Color color1,Graphics screen){
			int zzz1=0;
			int zzz2=0;
			int xxx1=0;
			int yyy1=0;	
			int xxx2=0;
			int yyy2=0;
			int xyz=0;

			zzz1=xxz/divds;
			zzz2=yyz/divds;
			xxx1=center(maxx,xxz)+(zzz1*x);
			yyy1=center(maxy,yyz)+(zzz2*y);
			xxx2=zzz1;
			yyy2=zzz2;
			screen.setColor(color1);
			screen.fillOval(xxx1,yyy1,xxx2,yyy2);
			screen.setColor(c);
			screen.drawOval(xxx1,yyy1,xxx2,yyy2);
		}
		public int center(int maxxy,int zz){
			return (maxxy-zz)/2;
		}
		public int invertxy(int xy,int divs){
			return divs-xy;
		}	
}
