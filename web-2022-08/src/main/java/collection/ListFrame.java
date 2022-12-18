package collection;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import gui.MyInterMain;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.CompoundBorder;

public class ListFrame extends JInternalFrame {
    List<Data> list = new ArrayList<Data>();
    int index = -1;
    
    
    private JLabel lblNewLabel;
    private JTextField id;
    private JLabel lblNewLabel_1;
    private JTextField irum;
    private JLabel lblNewLabel_1_1;
    private JTextField age;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_1_1;
    private JButton btnNewButton_1_2;
    private JScrollPane scrollPane;
    private JButton btnNewButton_2;
    private JSeparator separator;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ListFrame frame = new ListFrame();
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
    public ListFrame() {
        super("회원조회", true, true, true, true);
        setBounds(100, 100, 577, 459);
        getContentPane().setLayout(null);
        getContentPane().add(getLblNewLabel());
        getContentPane().add(getId());
        getContentPane().add(getLblNewLabel_1());
        getContentPane().add(getIrum());
        getContentPane().add(getLblNewLabel_1_1());
        getContentPane().add(getAge());
        getContentPane().add(getBtnNewButton());
        getContentPane().add(getBtnNewButton_1());
        getContentPane().add(getBtnNewButton_1_1());
        getContentPane().add(getBtnNewButton_1_2());
        getContentPane().add(getScrollPane());
        getContentPane().add(getBtnNewButton_2());
        getContentPane().add(getSeparator());
        
        setVisible(true);
    }

    public JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("아이디");
        	lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel.setBounds(12, 10, 59, 23);
        }
        return lblNewLabel;
    }
    public JTextField getId() {
        if (id == null) {
        	id = new JTextField();
        	id.setBounds(82, 11, 121, 22);
        	id.setColumns(10);
        }
        return id;
    }
    public JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("성명");
        	lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_1.setBounds(12, 43, 59, 23);
        }
        return lblNewLabel_1;
    }
    public JTextField getIrum() {
        if (irum == null) {
        	irum = new JTextField();
        	irum.setColumns(10);
        	irum.setBounds(82, 44, 121, 22);
        }
        return irum;
    }
    public JLabel getLblNewLabel_1_1() {
        if (lblNewLabel_1_1 == null) {
        	lblNewLabel_1_1 = new JLabel("나이");
        	lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_1_1.setBounds(12, 76, 59, 23);
        }
        return lblNewLabel_1_1;
    }
    public JTextField getAge() {
        if (age == null) {
        	age = new JTextField();
        	age.setColumns(10);
        	age.setBounds(82, 77, 121, 22);
        }
        return age;
    }
    public JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("조회");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String mId = id.getText();
        	        Data temp = new Data(mId,null,0);
        	        index = list.indexOf(temp);
        	        if(index >= 0) {        	            
        	            Data d = list.get(index);
        	            irum.setText(d.getIrum());
        	            age.setText(d.getAge()+"");
        	        }else {
        	            JOptionPane.showMessageDialog(ListFrame.this, "ID가 존재하지 않습니다.");
        	            irum.setText("");
        	            age.setText("");
        	        }
        	    }
        	});
        	btnNewButton.setBounds(215, 10, 59, 23);
        }
        return btnNewButton;
    }
    public JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
        	btnNewButton_1 = new JButton("저장");
        	btnNewButton_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String mId = id.getText();
        	        String mIrum = irum.getText();
        	        int mAge = Integer.parseInt(age.getText());
        	        Data data = new Data(mId,mIrum,mAge);
        	        list.add(data);
        	        
        	        id.requestFocus();
        	        id.selectAll();
        	    }
        	});
        	btnNewButton_1.setBounds(82, 125, 59, 23);
        }
        return btnNewButton_1;
    }
    public JButton getBtnNewButton_1_1() {
        if (btnNewButton_1_1 == null) {
        	btnNewButton_1_1 = new JButton("수정");
        	btnNewButton_1_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        if(index>=0) {
        	            String mId = id.getText();
        	            String mIrum = irum.getText();
        	            int mAge = Integer.parseInt(age.getText());
        	            Data d = new Data(mId, mIrum, mAge);
        	            list.set(index, d);
        	        }else {
        	            JOptionPane.showMessageDialog(ListFrame.this, "수정 할 자료가 없습니다.");
        	        }
        	        
        	    }
        	});
        	btnNewButton_1_1.setBounds(144, 125, 59, 23);
        }
        return btnNewButton_1_1;
    }
    public JButton getBtnNewButton_1_2() {
        if (btnNewButton_1_2 == null) {
        	btnNewButton_1_2 = new JButton("삭제");
        	btnNewButton_1_2.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        if(index>=0) {
        	            list.remove(index);
        	            id.setText("");
        	            irum.setText("");
        	            age.setText("");
        	            textArea.setText("");
        	            id.requestFocus();
        	        }else {
                        JOptionPane.showMessageDialog(ListFrame.this, "삭제 할 자료가 없습니다.");
        	        }
        	    }
        	});
        	btnNewButton_1_2.setBounds(204, 125, 59, 23);
        }
        return btnNewButton_1_2;
    }
    public JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(311, 43, 223, 354);
        	scrollPane.setViewportView(getTextArea());
        }
        return scrollPane;
    }
    public JButton getBtnNewButton_2() {
        if (btnNewButton_2 == null) {
        	btnNewButton_2 = new JButton("전체출력");
        	btnNewButton_2.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        textArea.setText(""); // textArea에 이미 있던 데이터들 삭제
        	        for(Data d : list) {
        	            textArea.append(d.toString());
        	        }
        	    }
        	});
        	btnNewButton_2.setBounds(457, 10, 77, 23);
        }
        return btnNewButton_2;
    }
    public JSeparator getSeparator() {
        if (separator == null) {
        	separator = new JSeparator();
        	separator.setBounds(12, 113, 262, 2);
        }
        return separator;
    }
    public JTextArea getTextArea() {
        if (textArea == null) {
        	textArea = new JTextArea();
        }
        return textArea;
    }
}
