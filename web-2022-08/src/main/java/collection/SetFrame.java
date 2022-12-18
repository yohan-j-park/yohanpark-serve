package collection;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.awt.event.ActionEvent;


public class SetFrame extends JInternalFrame {
    private JScrollPane scrollPane;
    private JButton btnNewButton;
    private JTextArea textArea;
    private JButton btnNewButton_1;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SetFrame frame = new SetFrame();
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
    public SetFrame() {
        super("로또번호추첨", false, true, false, true);
        setBounds(100, 100, 1096, 502);
        getContentPane().setLayout(null);
        getContentPane().add(getScrollPane());
        getContentPane().add(getBtnNewButton());
        getContentPane().add(getBtnNewButton_1());
        setVisible(true);

    }
    public JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(37, 36, 1008, 325);
        	scrollPane.setViewportView(getTextArea_1());
        }
        return scrollPane;
    }
    public JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("이번 주 행운의 숫자는?!");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        Random ran = new Random();
        	        Set<Integer> lotto = new HashSet<Integer>();

        	        while(true) {
        	            int lottonum = ran.nextInt(45)+1;
        	            lotto.add(lottonum);
        	            
        	            if(lotto.size()==6) {
        	                break;
        	            }
        	        }
        	        Iterator<Integer> iter = lotto.iterator();
  
        	        while(iter.hasNext()) {
        	            int num = iter.next();
        	            textArea.append(num + " ");
        	        }
   	           	        textArea.append("\n");
        	           	            
//        	            [강사님 ver]
//                      Set<Integer> set = new HashSet();
//        	            for(int i=0; i<5; i++) {
//                      do {
//                          int n = (int)(Math.random()*45)+1;
//                          set.add(n);
//                      }while(set.size()<6);
//                        
//                        textArea.append(set.toString() + "\n");
//        	       }
        	    }
        	});
        	btnNewButton.setFont(new Font("HY엽서L", Font.PLAIN, 25));
        	btnNewButton.setBounds(85, 382, 918, 66);
        }
        return btnNewButton;
    }
    protected static void clear() {
        // TODO Auto-generated method stub
        
    }

    public JTextArea getTextArea_1() {
        if (textArea == null) {
        	textArea = new JTextArea();
        	textArea.setFont(new Font("Cambria Math", Font.PLAIN, 50));
        }
        return textArea;
    }
    public JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
        	btnNewButton_1 = new JButton("초기화");
        	btnNewButton_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        textArea.setText("");
        	    }
        	});
        	btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        	btnNewButton_1.setBounds(954, 10, 91, 23);
        }
        return btnNewButton_1;
    }
}
