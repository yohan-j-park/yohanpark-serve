package format;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SimpleDatePanel extends JPanel {
    private JLabel lblNewLabel;
    private JTextField format;
    private JButton btnNewButton;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    /**
     * Create the panel.
     */
    public SimpleDatePanel() {
        setLayout(null);
        add(getLblNewLabel());
        add(getFormat());
        add(getBtnNewButton());
        add(getScrollPane());

    }

    public JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("포멧");
        	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        	lblNewLabel.setBounds(12, 10, 69, 23);
        }
        return lblNewLabel;
    }
    public JTextField getFormat() {
        if (format == null) {
        	format = new JTextField();
        	format.setBounds(93, 11, 315, 22);
        	format.setColumns(10);
        }
        return format;
    }
    public JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("실 행");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        SimpleDateFormat sdf = 
        	                new SimpleDateFormat(format.getText());
        	        String r = sdf.format(new Date()); //new Date: 현재 시각을 표시함
        	        textArea.append("format : " + format.getText() + "\n");
        	        textArea.append("result : " + r + "\n");
        	    }
        	});
        	btnNewButton.setBounds(93, 56, 91, 23);
        }
        return btnNewButton;
    }
    public JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(12, 112, 426, 178);
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
