// Java Program to create a simple group of radio buttons  
// (with image )and add item listener to them 
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 
class solve extends JFrame implements ItemListener { 
  
    // frame 
    static JFrame f; 
  
    // radiobuttons 
    static JRadioButton b, b1; 
  
    // create a label 
    static JLabel l1; 
  
    // main class 
    public static void main(String[] args) 
    { 
        // create a new frame 
        f = new JFrame("frame"); 
  
        // create a object 
        solve s = new solve(); 
  
        // create a panel 
        JPanel p = new JPanel(); 
  
        // create a new label 
        JLabel l = new JLabel("which website do you like?"); 
        l1 = new JLabel("geeksforgeeks selected"); 
  
        // create Radio buttons 
        b = new JRadioButton("geeksforgeeks", new ImageIcon("f:/gfg.jpg")); 
        b1 = new JRadioButton("others"); 
  
        // create a button group 
        ButtonGroup bg = new ButtonGroup(); 
  
        // add item listener 
        b.addItemListener(s); 
        b1.addItemListener(s); 
  
        // add radio buttons to button group 
        bg.add(b); 
        bg.add(b1); 
  
        b.setSelected(true); 
  
        // add button and label to panel 
        p.add(l); 
        p.add(b); 
        p.add(b1); 
        p.add(l1); 
  
        f.add(p); 
  
        // set the size of frame 
        f.setSize(400, 400); 
  
        f.show(); 
    } 
  
    public void itemStateChanged(ItemEvent e) 
    { 
        if (e.getSource() == b) { 
            if (e.getStateChange() == 1) { 
                l1.setText("geeksforgeeks selected"); 
            } 
        } 
        else { 
  
            if (e.getStateChange() == 1) { 
                l1.setText("others selected"); 
            } 
        } 
    } 
} 