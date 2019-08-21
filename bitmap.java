import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;

public class bitmap extends Applet {
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	Color c=new Color(230,230,0);
	Color cc=new Color(255,0,0);
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
		bitmap1=createVolatileImage(580,250);
		gg=bitmap1.createGraphics();
		gg.setColor(cc);
		gg.fillRect(0,0,580,250);
		gg.setColor(c);
		nnn=0;
		for (n=0;n<250;n=n+20){
			gg.drawLine(0,n,580,n);

			for (nn=0;nn<580;nn=nn+40){
				gg.drawLine(nn+nnn,n,nn+nnn,n+20);
			}
			nnn=nnn+20;
			if (nnn>20) nnn=0;

		}
		gg.setFont(new Font("mono",Font.PLAIN,100));
		gg.drawString("JAVA",120,120);
		gg.dispose();
		setBackground(c);
		t = new Timer("Timer");

		//t.scheduleAtFixedRate(tk,100,200);
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
		g.drawImage(bitmap1,0,0,this);

		
	}
}
