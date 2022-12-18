package format;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JMenuBar;

public class DeciamlPanel extends JPanel {
    private JLabel lblNewLabel;
    private JTextField pattern;
    private JLabel lblNewLabel_1;
    private JTextField number;
    private JButton btnNewButton;
    private JScrollPane scrollPane;
    private JTextArea textArea;


    /**
     * Create the panel.
     */
    public DeciamlPanel() {
        setLayout(null);
        add(getLblNewLabel());
        add(getPattern());
        add(getLblNewLabel_1());
        add(getNumber());
        add(getBtnNewButton());
        add(getScrollPane());

    }

    public JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("pattern");
        	lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
        	lblNewLabel.setBounds(0, 13, 93, 33);
        }
        return lblNewLabel;
    }
    public JTextField getPattern() {
        if (pattern == null) {
        	pattern = new JTextField();
        	pattern.setBounds(105, 16, 306, 27);
        	pattern.setColumns(10);
        }
        return pattern;
    }
    public JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("number");
        	lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
        	lblNewLabel_1.setBounds(0, 56, 93, 33);
        }
        return lblNewLabel_1;
    }
    public JTextField getNumber() {
        if (number == null) {
        	number = new JTextField();
        	number.setColumns(10);
        	number.setBounds(105, 59, 306, 27);
        }
        return number;
    }
    public JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("실 행");
        	btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        double d = Double.parseDouble(number.getText());
        	        String p = pattern.getText();
        	        DecimalFormat df = new DecimalFormat(p);
        	        String r = df.format(d);
        	        
        	        textArea.append("pattern : " + p + "\n");
        	        textArea.append("number : " + d + "\n");
        	        textArea.append("result : " + r + "\n");
        	        
        	        
        	        
        	        
        	    }
        	});
        	btnNewButton.setBounds(105, 99, 306, 27);
        }
        return btnNewButton;
    }
    public JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(12, 164, 399, 126);
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
