//package gui;
//
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//
//public class Lotto extends JFrame {
//    private JScrollPane scrollPane;
//    private JButton btnNewButton;
//    private JTextArea textArea;
//    
//
//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Lotto frame = new Lotto();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    /**
//     * Create the frame.
//     */
//    public Lotto() {
//        super();
//        setBounds(100, 100, 1096, 502);
//        getContentPane().setLayout(null);
//        getContentPane().add(getScrollPane());
//        getContentPane().add(getBtnNewButton());
//        setVisible(true);
//
//    }
//    public JScrollPane getScrollPane() {
//        if (scrollPane == null) {
//        	scrollPane = new JScrollPane();
//        	scrollPane.setBounds(37, 36, 1008, 325);
//        	scrollPane.setViewportView(getTextArea_1());
//        }
//        return scrollPane;
//    }
//    public JButton getBtnNewButton() {
//        if (btnNewButton == null) {
//        	btnNewButton = new JButton("이번 주 행운의 숫자는?!");
//        	btnNewButton.addActionListener(new ActionListener() {
//        	    public void actionPerformed(ActionEvent e) {
//        	        Set<Integer> set = new HashSet();
//                  do {
//                      int n = (int)(Math.random()*45)+1;
//                      set.add(n);
//                  }while(set.size()<6);
//                    
//                    textArea.append(set.toString() + "\n");
//        	        
//        	    }
//        	});
//        	btnNewButton.setFont(new Font("HY엽서L", Font.PLAIN, 25));
//        	btnNewButton.setBounds(85, 382, 918, 66);
//        }
//        return btnNewButton;
//    }
//    public JTextArea getTextArea_1() {
//        if (textArea == null) {
//        	textArea = new JTextArea();
//        	textArea.setFont(new Font("Eras Demi ITC", Font.BOLD, 30));
//        }
//        return textArea;
//    }
//}
