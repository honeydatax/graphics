import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;




public class xyz4 extends Applet {
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
	int pxxx[] = new int[divds];
	int pyyy[] = new int[divds];
	int pzzz[] = new int[divds];
	
	Color c=new Color(255,255,255);
	Color cc=new Color(0,0,0);
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


	public void rndn(){
			ax=(int) Math.round(Math.random()*((double) divds-1));
			ay=(int) Math.round(Math.random()*((double) divds-1));
		}
	public void genarates(){
			rndn();
		

	}
	

	public void init(){
		int bn=0;
		cox=this.getAppletContext();
		bitmap1=createVolatileImage(650,300);
		gg=bitmap1.createGraphics();
		setBackground(c);
		for (bn=0;bn<divds;bn++){
			genarates();
			pxxx[bn]=ax;
			pyyy[bn]=ay;
			pzzz[bn]=bn;
		}
		t = new Timer("Timer");
		t.scheduleAtFixedRate(tk,1000,1000);
	}
	public void destroy(){
		t.cancel();
		ii=230;
		gg.dispose();
	}
		
	public void paint (Graphics g) {
		int n=0;
		int bn=0;
		gg.setColor(c);
		gg.fillRect(0,0,650,300);
		for (n=0;n<divds;n++){
			drawPlanet(n);
		}
		g.drawImage(bitmap1,0,0,null);
		for (bn=0;bn<divds;bn++){
			pzzz[bn]=pzzz[bn]+1;
			if (pzzz[bn]==divds){
				genarates();
				pxxx[bn]=ax;
				pyyy[bn]=ay;
				pzzz[bn]=0;
			}
		}

	}
	

	public void drawPlanet(int z){
			int bn=0;
			int zzz1=0;
			int zzz2=0;
			int xxx1=0;
			int yyy1=0;	
			int xxx2=0;
			int yyy2=0;
			int xyz=0;
			int xxz=0;
			int yyz=0;
			int x=0;
			int y=0;
			for (bn=0;bn<divds;bn++){
				if (pzzz[bn]==z){
					xxz=zy*z;
					yyz=zy*z;
					x=pxxx[bn];
					y=pyyy[bn];
					zzz1=xxz/divds;
					zzz2=yyz/divds;
					xxx1=center(maxx,xxz)+(zzz1*x);
					yyy1=center(maxy,yyz)+(zzz2*y);
					xxx2=zzz1;
					yyy2=zzz2;
					gg.setColor(cc);
					gg.fillOval(xxx1,yyy1,xxx2,yyy2);
					gg.setColor(c);
					gg.drawOval(xxx1,yyy1,xxx2,yyy2);
				}
			}
		}
		public int center(int maxxy,int zz){
			return (maxxy-zz)/2;
		}
		public int invertxy(int xy,int divs){
			return divs-xy;
		}	
}
