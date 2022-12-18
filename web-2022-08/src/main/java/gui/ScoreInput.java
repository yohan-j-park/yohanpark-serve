package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import iostream.ScoreDao;
import iostream.ScoreVo;

public class ScoreInput extends JInternalFrame {
    private JLabel lblNewLabel;
    private JTextField TfSerial;
    private JLabel lblId;
    private JTextField TfId;
    private JLabel lblNewLabel_2;
    private JTextField TfMdate;
    private JLabel lblNewLabel_3;
    private JTextField TfSubject;
    private JLabel lblNewLabel_4;
    private JTextField TfScore;
    private JButton btnSave;
    private JButton btnModify;
    private JButton btnDelete;

    MyInterMain main;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ScoreInput frame = new ScoreInput();
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
    public ScoreInput() {
        super("성적입력",false, true, true, true);
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                main.si = null;
            }
        });
        setVisible(true);
        setBounds(100, 100, 240, 212);
        getContentPane().setLayout(null);
        getContentPane().add(getLblNewLabel());
        getContentPane().add(getTfSerial());
        getContentPane().add(getLblId());
        getContentPane().add(getTfId());
        getContentPane().add(getLblNewLabel_2());
        getContentPane().add(getTfMdate());
        getContentPane().add(getLblNewLabel_3());
        getContentPane().add(getTfSubject());
        getContentPane().add(getLblNewLabel_4());
        getContentPane().add(getTfScore());
        getContentPane().add(getBtnSave());
        getContentPane().add(getBtnModify());
        getContentPane().add(getBtnDelete());

    }
    public ScoreInput(MyInterMain main) {
        this();
        this.main = main;
    }
    public JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("Serial");
        	lblNewLabel.setBounds(12, 10, 50, 15);
        }
        return lblNewLabel;
    }
    public JTextField getTfSerial() {
        if (TfSerial == null) {
        	TfSerial = new JTextField();
        	TfSerial.setBounds(74, 7, 50, 21);
        	TfSerial.setColumns(10);
        }
        return TfSerial;
    }
    public JLabel getLblId() {
        if (lblId == null) {
        	lblId = new JLabel("ID");
        	lblId.setBounds(12, 38, 50, 15);
        }
        return lblId;
    }
    public JTextField getTfId() {
        if (TfId == null) {
        	TfId = new JTextField();
        	TfId.setColumns(10);
        	TfId.setBounds(74, 35, 112, 21);
        }
        return TfId;
    }
    public JLabel getLblNewLabel_2() {
        if (lblNewLabel_2 == null) {
        	lblNewLabel_2 = new JLabel("시험일자");
        	lblNewLabel_2.setBounds(12, 66, 50, 15);
        }
        return lblNewLabel_2;
    }
    public JTextField getTfMdate() {
        if (TfMdate == null) {
        	TfMdate = new JTextField();
        	TfMdate.setColumns(10);
        	TfMdate.setBounds(74, 63, 96, 21);
        }
        return TfMdate;
    }
    public JLabel getLblNewLabel_3() {
        if (lblNewLabel_3 == null) {
        	lblNewLabel_3 = new JLabel("과목");
        	lblNewLabel_3.setBounds(12, 94, 50, 15);
        }
        return lblNewLabel_3;
    }
    public JTextField getTfSubject() {
        if (TfSubject == null) {
        	TfSubject = new JTextField();
        	TfSubject.setColumns(10);
        	TfSubject.setBounds(74, 91, 125, 21);
        }
        return TfSubject;
    }
    public JLabel getLblNewLabel_4() {
        if (lblNewLabel_4 == null) {
        	lblNewLabel_4 = new JLabel("성적");
        	lblNewLabel_4.setBounds(12, 122, 50, 15);
        }
        return lblNewLabel_4;
    }
    public JTextField getTfScore() {
        if (TfScore == null) {
        	TfScore = new JTextField();
        	TfScore.setColumns(10);
        	TfScore.setBounds(74, 119, 50, 21);
        }
        return TfScore;
    }
    public JButton getBtnSave() {
        if (btnSave == null) {
        	btnSave = new JButton("저장");
        	btnSave.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        int serial = Integer.parseInt(TfSerial.getText());
        	        String id = TfId.getText();
        	        String mDate = TfMdate.getText();
        	        String subject = TfSubject.getText();
        	        int score = Integer.parseInt(TfScore.getText());
        	        
        	        ScoreVo vo = new ScoreVo(serial, id, mDate, subject, score);
        	        ScoreDao dao = new ScoreDao();
        	        dao.write(vo);
        	    }
        	});
        	btnSave.setBounds(8, 147, 64, 23);
        }
        return btnSave;
    }
    public JButton getBtnModify() {
        if (btnModify == null) {
        	btnModify = new JButton("수정");
        	btnModify.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	       // 수정된 정보를 가져와 ScoreVo객체 생성
        	       int serial = Integer.parseInt(getTfSerial().getText());
        	       String id = getTfId().getText();
        	       String mdate = getTfMdate().getText();
        	       String subject = getTfSubject().getText();
        	       int score = Integer.parseInt(getTfScore().getText());
        	       
        	       ScoreVo vo = new ScoreVo(serial, id, mdate, subject, score);
 
        	       // ScoreDao.modify(vo) 호출
        	       ScoreDao dao = new ScoreDao();
        	       dao.modify(vo);
        	    }
        	});
        	btnModify.setBounds(78, 147, 66, 23);
        }
        return btnModify;
    }
    public JButton getBtnDelete() {
        if (btnDelete == null) {
        	btnDelete = new JButton("삭제");
        	btnDelete.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        ScoreDao dao = new ScoreDao();
        	        int Serial = Integer.parseInt(((ScoreInput)main.si).getTfSerial().getText());
        	        dao.delete(Serial);
        	        
        	    }
        	});
        	btnDelete.setBounds(148, 147, 59, 23);
        }
        return btnDelete;
    }
}
