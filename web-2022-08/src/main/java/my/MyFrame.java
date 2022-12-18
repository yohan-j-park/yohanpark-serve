package my;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
    JButton b = new JButton("exit");
    
    public MyFrame() {
       setBounds(10,20,400,500);
       setLayout(null);
       b.setBounds(50,100,150,200);
       add(b);
    }
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
    }
}
