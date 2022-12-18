package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PatternFrame extends JInternalFrame {
    private JLabel lblNewLabel;
    private JTextField EmailPattern;
    private JLabel lblEmailInput;
    private JTextField EmailValue;
    private JButton btnNewButton;
    private JLabel lblPhonePattern;
    private JTextField PhonePattern;
    private JLabel lblPhoneInput;
    private JTextField PhoneValue;
    private JButton btnPhoneCheck;
    private JSeparator separator;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PatternFrame frame = new PatternFrame();
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
    public PatternFrame() {
        super("패턴검색", true, true, true, true);

        setBounds(100, 100, 687, 428);
        getContentPane().setLayout(null);
        getContentPane().add(getLblNewLabel());
        getContentPane().add(getEmailPattern());
        getContentPane().add(getLblEmailInput());
        getContentPane().add(getEmailValue());
        getContentPane().add(getBtnNewButton());
        getContentPane().add(getLblPhonePattern());
        getContentPane().add(getPhonePattern());
        getContentPane().add(getLblPhoneInput());
        getContentPane().add(getPhoneValue());
        getContentPane().add(getBtnPhoneCheck());
        getContentPane().add(getSeparator());
        getContentPane().add(getScrollPane());
        
        setVisible(true);

    }
    public JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("Email Pattern");
        	lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        	lblNewLabel.setBounds(12, 10, 85, 22);
        }
        return lblNewLabel;
    }
    public JTextField getEmailPattern() {
        if (EmailPattern == null) {
        	EmailPattern = new JTextField();
        	EmailPattern.setText("\\w+@\\w+\\.\\w+(\\.\\w+)?");
        	EmailPattern.setBounds(108, 11, 407, 21);
        	EmailPattern.setColumns(10);
        }
        return EmailPattern;
    }
    public JLabel getLblEmailInput() {
        if (lblEmailInput == null) {
        	lblEmailInput = new JLabel("Email Input");
        	lblEmailInput.setHorizontalAlignment(SwingConstants.LEFT);
        	lblEmailInput.setBounds(12, 42, 85, 22);
        }
        return lblEmailInput;
    }
    public JTextField getEmailValue() {
        if (EmailValue == null) {
        	EmailValue = new JTextField();
        	EmailValue.setColumns(10);
        	EmailValue.setBounds(108, 42, 407, 22);
        }
        return EmailValue;
    }
    public JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("Email Check");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String ep = EmailPattern.getText();
        	        String v = EmailValue.getText();
        	        boolean b = Pattern.matches(ep, v);
        	        textArea.append("이메일 패턴 : " + ep);
        	        textArea.append("\n이메일 입력 : " + v);
        	        textArea.append("\n체크 결과 : " + b);
        	        textArea.append("-".repeat(40)+ "\n");
        	        
        	    }
        	});
        	btnNewButton.setBounds(527, 10, 136, 54);
        }
        return btnNewButton;
    }
    public JLabel getLblPhonePattern() {
        if (lblPhonePattern == null) {
        	lblPhonePattern = new JLabel("Phone Pattern");
        	lblPhonePattern.setHorizontalAlignment(SwingConstants.LEFT);
        	lblPhonePattern.setBounds(12, 94, 85, 22);
        }
        return lblPhonePattern;
    }
    public JTextField getPhonePattern() {
        if (PhonePattern == null) {
        	PhonePattern = new JTextField();
        	PhonePattern.setText("\\d{2,3}-\\d{3,4}-\\d{4}$");
        	PhonePattern.setColumns(10);
        	PhonePattern.setBounds(108, 95, 407, 21);
        }
        return PhonePattern;
    }
    public JLabel getLblPhoneInput() {
        if (lblPhoneInput == null) {
        	lblPhoneInput = new JLabel("Phone Input");
        	lblPhoneInput.setHorizontalAlignment(SwingConstants.LEFT);
        	lblPhoneInput.setBounds(12, 126, 85, 22);
        }
        return lblPhoneInput;
    }
    public JTextField getPhoneValue() {
        if (PhoneValue == null) {
        	PhoneValue = new JTextField();
        	PhoneValue.setColumns(10);
        	PhoneValue.setBounds(108, 126, 407, 22);
        }
        return PhoneValue;
    }
    public JButton getBtnPhoneCheck() {
        if (btnPhoneCheck == null) {
        	btnPhoneCheck = new JButton("Phone Check");
        	btnPhoneCheck.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String pp = PhonePattern.getText();
        	        String pv = PhoneValue.getText();
        	        boolean b = Pattern.matches(pp,pv);
        	        
                    textArea.append("연락처 패턴 : " + pp);
                    textArea.append("\n연락처 입력 : " + pv);
                    textArea.append("\n체크 결과 : " + b);
                    textArea.append("-".repeat(40)+ "\n");
        	    }
        	});
        	btnPhoneCheck.setBounds(527, 94, 136, 54);
        }
        return btnPhoneCheck;
    }
    public JSeparator getSeparator() {
        if (separator == null) {
        	separator = new JSeparator();
        	separator.setBounds(12, 74, 651, 2);
        }
        return separator;
    }
    public JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(12, 176, 651, 213);
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
}
