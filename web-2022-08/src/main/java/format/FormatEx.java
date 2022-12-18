package format;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class FormatEx extends JFrame {

    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu mnNewMenu;
    private JMenuItem mntmNewMenuItem;
    private JMenuItem mntmNewMenuItem_1;
    private JMenuItem mntmNewMenuItem_2;
    private JMenuItem mntmNewMenuItem_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormatEx frame = new FormatEx();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FormatEx() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 781, 558);
        setJMenuBar(getMenuBar_1());
        contentPane = new JPanel();
        contentPane.setFont(new Font("굴림", Font.PLAIN, 15));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel dp = new DeciamlPanel();   // panel은 컨테이너이다.

        contentPane.add(dp);
        contentPane.updateUI();
        
    }
    public JMenuBar getMenuBar_1() {
        if (menuBar == null) {
        	menuBar = new JMenuBar();
        	menuBar.add(getMnNewMenu());
        }
        return menuBar;
    }
    public JMenu getMnNewMenu() {
        if (mnNewMenu == null) {
        	mnNewMenu = new JMenu("포맷");
        	mnNewMenu.add(getMntmNewMenuItem());
        	mnNewMenu.add(getMntmNewMenuItem_1());
        	mnNewMenu.add(getMntmNewMenuItem_2());
        	mnNewMenu.add(getMntmNewMenuItem_3());
        }
        return mnNewMenu;
    }
    public JMenuItem getMntmNewMenuItem() {
        if (mntmNewMenuItem == null) {
        	mntmNewMenuItem = new JMenuItem("DeciamlFormat");
        	mntmNewMenuItem.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        contentPane.removeAll();
        	        JPanel panel = new DeciamlPanel();
        	        contentPane.add(panel);
        	        contentPane.updateUI();
        	        
        	        
        	    }
        	});
        }
        return mntmNewMenuItem;
    }
    public JMenuItem getMntmNewMenuItem_1() {
        if (mntmNewMenuItem_1 == null) {
        	mntmNewMenuItem_1 = new JMenuItem("MessageFormat");
        	mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        contentPane.removeAll();
        	        JPanel panel = new MessagePanel();
        	        contentPane.add(panel);
        	        contentPane.updateUI();
        	    }
        	});
        }
        return mntmNewMenuItem_1;
    }
    public JMenuItem getMntmNewMenuItem_2() {
        if (mntmNewMenuItem_2 == null) {
        	mntmNewMenuItem_2 = new JMenuItem("SimpleDateFormat");
        	mntmNewMenuItem_2.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        contentPane.removeAll();
        	        JPanel panel = new SimpleDatePanel();
        	        contentPane.add(panel);
        	        contentPane.updateUI();
        	    }
        	});
        }
        return mntmNewMenuItem_2;
    }
    public JMenuItem getMntmNewMenuItem_3() {
        if (mntmNewMenuItem_3 == null) {
        	mntmNewMenuItem_3 = new JMenuItem("ChoiceFormat");
        	mntmNewMenuItem_3.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        contentPane.removeAll();
                    JPanel panel = new ChoicePanel();
                    contentPane.add(panel);
                    contentPane.updateUI();
        	    }
        	});
        }
        return mntmNewMenuItem_3;
    }
}
