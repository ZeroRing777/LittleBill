package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GUIUtil {
	
	private static String imageFolder="/Users/zeroring/Desktop/img";

	public static void useLNF(JFrame f) {
	    try {
	    	UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel");
	    	SwingUtilities.updateComponentTreeUI(f);
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	/**
	 *
	 * @param p
	 * @param strech 
	 */
	public static void showPanel(JPanel p, double strech) {
	
		
		JFrame f=new JFrame();
		useLNF(f);
		f.setSize(800,800);
		f.setLocationRelativeTo(null);
		//f.setBackground(ColorUtil.backgroundColor);
		CenterPanel cp=new CenterPanel(strech);
		f.setContentPane(cp);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    p.setBackground(ColorUtil.backgroundColor);
	    cp.show(p);
	}
	
	public static boolean checkEmpty(JTextField tf, String input) {
		
		String text=tf.getText().trim();
		if(0==text.length()) {
			JOptionPane.showMessageDialog(null,input+" 不能为空");
			tf.grabFocus();
			return false;
		}
		return true;
		
	}
	
	public static boolean checkNumber(JTextField tf, String input) {
		
		if(!checkEmpty(tf,input)) return false;
		String text=tf.getText().trim();
		try {
	        Float.parseFloat(text);
	        return true;
	    } catch (NumberFormatException e1) {
	        JOptionPane.showMessageDialog(null, input + " 需要是数字");
	        tf.grabFocus();
	        return false;
	    }
	}
	
	public static boolean checkZero(JTextField tf, String input) {
		if(!checkNumber(tf,input)) return false;
		String text=tf.getText().trim();
	    if(Float.parseFloat(text)==(float)0) {
	    	 JOptionPane.showMessageDialog(null, input + " 不能为零");
	         tf.grabFocus();
	         return false;
	    }
	    
	    return true;
	}
	
	public static void setColor(Color color,JComponent...cs) {
		
		for(JComponent c:cs) {
			c.setForeground(color);
			
		}
	}
	public static void setImageIcon(JButton b, String fileName, String tip) {
		
		    ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		    Image image=i.getImage();
		    
		    i.setImage(image.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		    
		    b.setIcon(i);
		    setColor(ColorUtil.blue,b);
		   
		    b.setPreferredSize(new Dimension(320, 85));
		    b.setToolTipText(tip);
		    b.setVerticalTextPosition(JButton.BOTTOM);
		    b.setHorizontalTextPosition(JButton.CENTER);
		    b.setText(tip);
		}
		
	}
	
	


