package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import jdbc.MemberDto;
import jdbc.MemberVo;


public class MemberInputDB extends JInternalFrame {
    //radio 버튼을 그룹화
    ButtonGroup bg = new ButtonGroup();
    
    MyInterMain main;
    Connection conn;
    
    private JLabel lblNewLabel;
    private JTextField tfId;
    private JLabel lblNewLabel_1;
    private JTextField tfIrum;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JTextField tfPhone;
    private JLabel lblNewLabel_4;
    private JTextField tfPicture;
    private JButton btnSave;
    private JButton btnModify;
    private JButton btnDelete;
    private JRadioButton btnGenderM;
    private JRadioButton btnGenderF;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberInputDB frame = new MemberInputDB();
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
    public MemberInputDB(MyInterMain main) {
        this();
        this.main = main;
    }
    public MemberInputDB() {
        super("회원가입DB",true, true, true, true);
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                main.midb = null;
            }
        });
        setBounds(100, 100, 315, 213);
        getContentPane().setLayout(null);
        getContentPane().add(getLblNewLabel());
        getContentPane().add(getTfId());
        getContentPane().add(getLblNewLabel_1());
        getContentPane().add(getTfIrum());
        getContentPane().add(getLblNewLabel_2());
        getContentPane().add(getLblNewLabel_3());
        getContentPane().add(getTfPhone());
        getContentPane().add(getLblNewLabel_4());
        getContentPane().add(getTfPicture());
        getContentPane().add(getBtnSave());
        getContentPane().add(getBtnModify());
        getContentPane().add(getBtnDelete());
        getContentPane().add(getBtnGenderM());
        getContentPane().add(getBtnGenderF());
        getContentPane().add(getBtnNewButton());
        setVisible(true);
        
        bg.add(getBtnGenderM());
        bg.add(getBtnGenderF());
       
    }

    public void loadData(MemberVo vo) {
        tfId.setText(vo.getId());
        tfIrum.setText(vo.getIrum());
        tfPhone.setText(vo.getPhone());
        tfPicture.setText(vo.getPhoto());
        if(vo.getGender().equals("m")) {
            btnGenderM.setSelected(true);
        }else {
            btnGenderF.setSelected(true);
        }
        
        
    }
    
    public JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("아이디");
        	lblNewLabel.setBounds(12, 13, 50, 15);
        }
        return lblNewLabel;
    }
    public JTextField getTfId() {
        if (tfId == null) {
        	tfId = new JTextField();
        	tfId.setColumns(10);
        	tfId.setBounds(67, 11, 105, 18);
        }
        return tfId;
    }
    public JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("성 명");
        	lblNewLabel_1.setBounds(12, 41, 50, 15);
        }
        return lblNewLabel_1;
    }
    public JTextField getTfIrum() {
        if (tfIrum == null) {
        	tfIrum = new JTextField();
        	tfIrum.setColumns(10);
        	tfIrum.setBounds(67, 38, 66, 18);
        }
        return tfIrum;
    }
    public JLabel getLblNewLabel_2() {
        if (lblNewLabel_2 == null) {
        	lblNewLabel_2 = new JLabel("성 별");
        	lblNewLabel_2.setBounds(12, 69, 50, 15);
        }
        return lblNewLabel_2;
    }
    public JLabel getLblNewLabel_3() {
        if (lblNewLabel_3 == null) {
        	lblNewLabel_3 = new JLabel("연락처");
        	lblNewLabel_3.setBounds(12, 97, 50, 15);
        }
        return lblNewLabel_3;
    }
    public JTextField getTfPhone() {
        if (tfPhone == null) {
        	tfPhone = new JTextField();
        	tfPhone.setColumns(10);
        	tfPhone.setBounds(66, 95, 96, 18);
        }
        return tfPhone;
    }
    public JLabel getLblNewLabel_4() {
        if (lblNewLabel_4 == null) {
        	lblNewLabel_4 = new JLabel("증명사진");
        	lblNewLabel_4.setBounds(12, 125, 50, 15);
        }
        return lblNewLabel_4;
    }
    public JTextField getTfPicture() {
        if (tfPicture == null) {
        	tfPicture = new JTextField();
        	tfPicture.setColumns(10);
        	tfPicture.setBounds(67, 123, 120, 18);
        }
        return tfPicture;
    }
    public JButton getBtnSave() {
        if (btnSave == null) {
        	btnSave = new JButton("저 장");
        	btnSave.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String id = tfId.getText();
        	        String irum = tfIrum.getText();
        	        String phone = tfPhone.getText();
        	        String gender = btnGenderM.isSelected()? "m" : "f";
        	        String picture = tfPicture.getText();
        	        MemberVo vo = new MemberVo(id, irum, gender, phone, picture);
        	        MemberDto dto = new MemberDto();
        	        int cnt = dto.insert(vo);
        	        if(cnt>0)System.out.println("OK");
        	        else System.out.println("오류 발생");
        	    }
        	});
        	btnSave.setBounds(57, 150, 66, 23);
        }
        return btnSave;
    }
    public JButton getBtnModify() {
        if (btnModify == null) {
        	btnModify = new JButton("수 정");
        	btnModify.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String id = tfId.getText();
        	        String irum = tfIrum.getText();
        	        String phone = tfPhone.getText();
        	        String gender = btnGenderM.isSelected()? "m" : "f";
        	        String picture = tfPicture.getText();
        	        
        	        MemberVo vo = new MemberVo(id,irum,gender,phone,picture);
        	        MemberDto dto = new MemberDto();
        	        int cnt = dto.update(vo);
        	        if(cnt>0) {
        	            // 작동
        	        }else {
        	            // 오류
        	        }
        	    }
        	});
        	btnModify.setBounds(133, 150, 74, 23);
        }
        return btnModify;
    }
    public JButton getBtnDelete() {
        if (btnDelete == null) {
        	btnDelete = new JButton("삭 제");
        	btnDelete.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String id = tfId.getText();
        	        MemberDto dto = new MemberDto();
        	        int cnt = dto.delete(id);
        	        if(cnt>0) {
        	            // 작동
        	            tfId.setText("");
        	            tfIrum.setText("");
        	            tfPhone.setText("");
        	            tfPicture.setText("");
        	        }
        	        else {
        	            // 오류
        	        }
        	    }
        	});
        	btnDelete.setBounds(214, 150, 66, 23);
        }
        return btnDelete;
    }
    public JRadioButton getBtnGenderM() {
        if (btnGenderM == null) {
        	btnGenderM = new JRadioButton("남자");
        	btnGenderM.setBounds(67, 62, 50, 23);
        }
        return btnGenderM;
    }
    public JRadioButton getBtnGenderF() {
        if (btnGenderF == null) {
        	btnGenderF = new JRadioButton("여자");
        	btnGenderF.setBounds(122, 62, 50, 23);
        }
        return btnGenderF;
    }
    public JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("파일선택");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        JFileChooser fc = new JFileChooser();
        	        int flag = fc.showOpenDialog(MemberInputDB.this);
        	        if(flag == JFileChooser.APPROVE_OPTION) {
        	            String fn = fc.getSelectedFile().getPath();
        	            tfPicture.setText(fn);
        	        }
        	    }
        	});
        	btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
        	btnNewButton.setBounds(191, 121, 96, 23);
        }
        return btnNewButton;
    }
}
