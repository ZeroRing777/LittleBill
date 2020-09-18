package util;
import java.awt.Color;


public class ColorUtil {
	
	public static Color blue=Color.decode("#3399FF");
	public static Color gray=Color.decode("#999999");
	  public static Color backgroundColor = Color.decode("#F0FFF0");
	  public static Color warningColor = Color.decode("#FF3333");
	  
	  public static Color getByPercentage(int per) {
	        if (per > 100)
	            per = 100;
	        int r = 51;
	        int g = 255;
	        int b = 51;
	        float rate = per / 100f;
	        r = (int) ((255 - 51) * rate + 51);
	        g = 255 - r + 51;
	        Color color = new Color(r, g, b);
	        return color;
	    }

	
}
