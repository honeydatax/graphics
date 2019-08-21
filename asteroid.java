import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;

public class asteroid extends Applet {
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	int[] x1 = new int[10];
	int[] y1 = new int[10];
	int[] x2 = new int[10];
	int[] y2 = new int[10];
	int ax=0;
	int ay=0;
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
			x1[0]=(580/6);
			y1[0]=(250/6);
			ax=(int) Math.round(Math.random()*5.00);
			ay=(int) Math.round(Math.random()*5.00);
			System.out.println (" z : " +Integer.toString(y1[0])+", x : " +Integer.toString(ax)+" ,y : " +Integer.toString(ay));
		t = new Timer("Timer");
		t.scheduleAtFixedRate(tk,100,200);
	}
	public void destroy(){
		t.cancel();
		ii=230;
	}
		
	public void paint (Graphics g) {
		int n=0;
		int nn=0;
		int nnn=0;
		int nnnn=0;
		String s="";
		g.setColor(c);
		n=ax;
			nn=(580-x1[0])/2;
			nnn=580-(580-x1[0])/2;
			nnnn=((nnn-nn)/6)*n+nn;
			nn=y1[0]/6;
			nnn=nn*n;
			nnnn=((x1[0])/6)*(ax);
			nnn=nn*ay;
			g.fillOval((580-x1[0])/2+nnnn,(250-y1[0])/2+nnn,(x1[0])/6,nn);


		
		x1[0]=x1[0]+(580/12);
		y1[0]=y1[0]+(250/12);
		if (x1[0] > 580 ) {
			x1[0]=0;
			ax=(int) Math.round(Math.random()*5.00);
			ay=(int) Math.round(Math.random()*5.00);
			System.out.println (" z : " +Integer.toString(y1[0])+", x : " +Integer.toString(ax)+" ,y : " +Integer.toString(ay));
		}
		if (y1[0] > 250 ) {
			y1[0]=0;
			ax=(int) Math.round(Math.random()*5.00);
			ay=(int) Math.round(Math.random()*5.00);
			System.out.println (" z : " +Integer.toString(y1[0])+", x : " +Integer.toString(ax)+" ,y : " +Integer.toString(ay));
			}

		g.setColor(cc);

		n=ax;
			nn=(580-x1[0])/2;
			nnn=580-(580-x1[0])/2;
			nnnn=((nnn-nn)/6)*n+nn;

			nn=y1[0]/6;
			nnn=nn*n;

			nnnn=((x1[0])/6)*(ax);
			nnn=nn*ay;
			g.fillOval((580-x1[0])/2+nnnn,(250-y1[0])/2+nnn,(x1[0])/6,nn);
		
		s=" z : " +Integer.toString(y1[0]);
		cox.showStatus(s);
	}
}
