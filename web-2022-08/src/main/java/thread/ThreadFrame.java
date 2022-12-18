package thread;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadFrame extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JButton btnNewButton;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private JButton btnNewButton_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ThreadFrame frame = new ThreadFrame();
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
    public ThreadFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 386, 358);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getTextField());
        contentPane.add(getBtnNewButton());
        contentPane.add(getScrollPane());
        contentPane.add(getBtnNewButton_1());
    }

    public JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setBounds(12, 10, 130, 28);
        	textField.setColumns(10);
        }
        return textField;
    }
    public JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("Run");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        // 1 ~ 999,999,999까지의 수를 0.5씩 증가시켜 더하는 로직 (시간이 많이 걸리는 작업)
        	        long sum = 0L;
        	        for(double i=0; i<999999999; i=i+0.5) {
        	            sum += (long)i;
        	        }
        	        textArea.setText("sum : " + sum);
        	    }
        	});
        	btnNewButton.setBounds(153, 10, 97, 28);
        }
        return btnNewButton;
    }
    public JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(12, 65, 348, 246);
        	scrollPane.setViewportView(getTextArea());
        }
        return scrollPane;
    }
    public JTextArea getTextArea() {
        if (textArea == null) {
        	textArea = new JTextArea();
        }
        return textArea;
    }
    public JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
        	btnNewButton_1 = new JButton("Thread");
        	btnNewButton_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        
        	        Thread t = new Thread(new Runnable() {

                        @Override 
                        public void run() {                             
                            // 1 ~ 999,999,999까지의 수를 0.5씩 증가시켜 더하는 로직 (시간이 많이 걸리는 작업)
                            long sum = 0L; 
                            for(double i=0; i<999999999; i=i+0.5) {
                                sum += (long)i;
                            }
                            textArea.setText("sum : " + sum);
                        }    
        	        });
        	        t.start();
        	    }
        	});
        	btnNewButton_1.setBounds(263, 10, 97, 28);
        }
        return btnNewButton_1;
    }
}
