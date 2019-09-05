import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class paint3d extends Applet implements MouseListener{
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	int zz=(24-8)*12;
	int gridv=1;
	int [] maps= new int[8*8*8+6]; 
	Color c=new Color(0,0,0);
	Color cc=new Color(255,255,255);
	Polygon poly1;
	Timer t ;
	VolatileImage bitmap1;
	Graphics2D gg1;
	AppletContext cox;
	
	TimerTask tk =new TimerTask(){
			public void run(){
			/*	Graphics g =getGraphics();
				if (ii < 230){
					paint(g);
				}
				if (ii > 230) t.cancel();
				
			*/	
			}
		};

	
	public void init(){
		int n;
		Color cc1;
		cox=this.getAppletContext();
		bitmap1=createVolatileImage(600,300);
		gg1=bitmap1.createGraphics();
		gg1.setColor(cc);
		gg1.fillRect(0,0,600,300);
		gg1.setColor(c);
		for (n=0;n<(12*8);n=n+12){
			gg1.drawRect(0,n,12,12);
		}
		gg1.fillRect(0,12*9,12,12);
		maps[0]=(int) '3';
		maps[1]=(int) 'D';
		maps[2]=8;
		maps[4]=8;
		maps[5]=8;
		for (n=6;n<(8*8*8+6);n++){
			maps[5]=0;
		}
		setBackground(cc);
		//t = new Timer("Timer");
		addMouseListener(this);
		cox.showStatus("paint");
		//t.scheduleAtFixedRate(tk,100,200);
	}
	public void destroy(){
		//t.cancel();
		ii=230;
		gg1.dispose();
	}


		public int center(int maxxy,int z){
			return ((maxxy-z)/2);
		}

		
	public void paint (Graphics g) {
		drawinto((zz/12));
		if (gridv!=0)grid(zz);
		g.drawImage(bitmap1,0,0,null);
	}
		public void mouseClicked(MouseEvent e){
			int xp =e.getX();
			int yp =e.getY();
			int door=-1;
			
			if ( xp>center(600,zz) && yp>center(300,zz) && xp<(center(600,zz)+zz) && yp<(center(300,zz)+zz)) door=0;
			if ( xp>0 && yp>0 && xp<(13) && yp<(12*8)) door=1;
			if ( xp>0 && yp>(12*9) && xp<(13) && yp<(12*10)) door=2;
			if (door == 0 ) {
				xp=(xp-center(600,zz))/(zz/8);
				yp=(yp-center(300,zz))/(zz/8);
				setxyz(xp,yp,zz/12-(24-8));
				repaint();				
			}
			if (door == 1 ) {
				yp=yp/12;
				zz=(24-8+yp)*12;
				repaint();				
			}
			if (door == 2 ) {
				gridv=gridv+1;
				if (gridv>1)gridv=0;
				repaint();				
			}


			}

		public void mouseExited(MouseEvent ee){
			}
		public void mouseEntered(MouseEvent ee){

			}
		public void mousePressed(MouseEvent ee){

			}
		public void mouseReleased(MouseEvent ee){

			}
			
		public void grid(int z){
			int n;	
			gg1.setColor(c);
			for (n=0;n<z+1;n=n+z/8){
			
				gg1.drawLine(center(600,z)+n,center(300,z),center(600,z)+n,center(300,z)+z);
				if (n<300) gg1.drawLine(center(600,z),center(300,z)+n,center(600,z)+z,center(300,z)+n);
			}


		}
		public void setxyz(int x,int y, int z){
				int n=z*64+y*8+x+6;
				int nn=maps[n];
				nn++;
				if (nn>1) nn=0;
				maps[n]=nn;
				
		}
		public void drawinto(int z){
			int nx=0;
			int ny=0;
			int nz=0;
			int zzz=zz-1;
			gg1.setColor(cc);
			gg1.fillRect(center(600,12*24),center(300,12*24),center(600,12*24)+12*24,center(300,12*24)+12*24);

			gg1.setColor(c);
			for (nz=(24-8);nz<24;nz=nz+1){
				for (ny=0;ny<8;ny=ny+1){
					for (nx=0;nx<8;nx=nx+1){
						zz=nz*12;
						if (maps[(nz-(24-8))*64+ny*8+nx+6] == 1 ) gg1.fillRect(center(600,zz)+(nx*(zz/8)),center(300,zz)+(ny*(zz/8)),(zz/8),(zz/8));

				}
				
			}
			if (zz>=zzz) nz=60;
		}
	}
}
