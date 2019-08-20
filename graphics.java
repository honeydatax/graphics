import java.applet.*;
import java.awt.*;

public class graphics extends Applet {
	public void paint (Graphics g) {
		int i;
		for(i=0;i<10;i++){
			g.setColor(new Color(255,i*(255/9),i*(255/9)));
			g.fillRect(15*i,15*i,150,150);
		}
		g.drawString("graphics.!",20,20);

	}
}
