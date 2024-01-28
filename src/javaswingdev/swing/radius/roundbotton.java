
package javaswingdev.swing.radius;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;


public class roundbotton extends  JTextField{
    
    public roundbotton(int cols) {
        super(cols);
         
        // We must be non-opaque since we won't fill all pixels.
        // This will also stop the UI from filling our background.
        setOpaque(false);
            
        // Add an empty border around us to compensate for
        // the rounded corners.
        setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
    }
     protected void paintComponent(Graphics g) {
        int width = getWidth() - getInsets().left - getInsets().right;
        int height = getHeight() - getInsets().top - getInsets().bottom;
            
        // Paint a rounded rectangle in the background.
        g.setColor(getBackground());
        g.fillRoundRect(getInsets().left, getInsets().top, width, height, 8, 8);
          
        // Now call the superclass behavior to paint the foreground.
        super.paintComponent(g);
    } 
    public static void main( String[] args ) {
     
         
        JPanel p = new JPanel();
        roundbotton rf = new roundbotton( 10 );
        rf.setBorder( BorderFactory.createCompoundBorder( new RoundedBorder(), rf.getBorder() ) );
       p.add( rf );
        
    }
    private static class RoundedBorder extends AbstractBorder {
         
        public Insets getBorderInsets( Component c, Insets insets ) {
            insets.left = insets.top = insets.right = insets.bottom = 18;
            return insets;
        }
         
        public void paintBorder( Component c, Graphics g, int x, int y,
                int width, int height) {
            int w = width;
            int h = height;
             
            g.translate(x, y);
            g.setColor( c.getBackground().darker() );
            g.drawRoundRect( 0, 0, w-2, h-2, 8, 8 );
            g.translate(-x, -y);
        }
         
        public boolean isBorderOpaque() {
            return true;
        }
    }
}
