package format;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.ChoiceFormat;
import java.awt.event.ActionEvent;

public class ChoicePanel extends JPanel {
    private JLabel lblNewLabel;
    private JTextField limit;
    private JLabel lblNewLabel_1;
    private JTextField grade;
    private JButton btnNewButton;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private JLabel score;
    private JTextField textField;

    /**
     * Create the panel.
     */
    public ChoicePanel() {
        setLayout(null);
        add(getLblNewLabel());
        add(getLimit());
        add(getLblNewLabel_1());
        add(getGrade());
        add(getBtnNewButton());
        add(getScrollPane());
        add(getScore());
        add(getTextField());

    }

    public JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("limit");
        	lblNewLabel.setBounds(12, 10, 66, 21);
        }
        return lblNewLabel;
    }
    public JTextField getLimit() {
        if (limit == null) {
        	limit = new JTextField();
        	limit.setBounds(88, 10, 319, 21);
        	limit.setColumns(10);
        }
        return limit;
    }
    public JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("grade");
        	lblNewLabel_1.setBounds(12, 42, 66, 21);
        }
        return lblNewLabel_1;
    }
    public JTextField getGrade() {
        if (grade == null) {
        	grade = new JTextField();
        	grade.setColumns(10);
        	grade.setBounds(88, 42, 319, 21);
        }
        return grade;
    }
    public JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("실행");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        
        	        String[] temp = limit.getText().split(",");
        	        String[] tempScore = score.getText().split(",");
        	        String[] g = grade.getText().split(",");
        	        double[] d = new double[temp.length];
        	        int[]    s = new int[tempScore.length];
        	        for(int i=0; i<tempScore.length; i++) {
        	            s[i] = Integer.parseInt(tempScore[i]);
        	        }
        	        for(int i=0; i<d.length; i++) {
        	            d[i] = Double.parseDouble(temp[i]);
        	        }
        	        ChoiceFormat cf = new ChoiceFormat(d,g);
        	        for(int i=0; i<s.length; i++) {
        	            textArea.append(s[i] + " = " + cf.format(s[i]));
        	            textArea.append("\n");
        	        }
        	    }
        	});
        	btnNewButton.setBounds(419, 72, 91, 23);
        }
        return btnNewButton;
    }
    public JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(12, 117, 426, 173);
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
    public JLabel getScore() {
        if (score == null) {
        	score = new JLabel("score");
        	score.setBounds(12, 73, 66, 21);
        }
        return score;
    }
    public JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setColumns(10);
        	textField.setBounds(88, 73, 319, 21);
        }
        return textField;
    }
}
