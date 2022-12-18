package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import iostream.ScoreDao;
import iostream.ScoreVo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoreSearch extends JInternalFrame {
    private JPanel panel;
    private JButton btnNewButton;
    private JTextField findStr;
    private JScrollPane scrollPane;
    private JTable table;
    
    MyInterMain main;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ScoreSearch frame = new ScoreSearch();
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
    public ScoreSearch() {
        super("성적 조회",true,true,true,true);
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                main.ss = null;
            }
        });
        setVisible(true);
        setBounds(100, 100, 768, 352);
        getContentPane().setLayout(new BorderLayout(0, 0));
        getContentPane().add(getPanel(), BorderLayout.NORTH);
        getContentPane().add(getScrollPane(), BorderLayout.CENTER);

    }
    
    public ScoreSearch(MyInterMain main) {
        this();
        this.main = main;
    }

    public JPanel getPanel() {
        if (panel == null) {
        	panel = new JPanel();
        	panel.setPreferredSize(new Dimension(10, 26));
        	panel.setLayout(new BorderLayout(0, 0));
        	panel.add(getBtnNewButton(), BorderLayout.EAST);
        	panel.add(getFindStr(), BorderLayout.CENTER);
        }
        return panel;
    }
    public JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("검색");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String find = findStr.getText().trim();
        	        ScoreDao dao = new ScoreDao();
        	        List<ScoreVo> list = dao.read();
        	        DefaultTableModel model = (DefaultTableModel)table.getModel();
        	        model.setRowCount(0);  //기존에 테이블이 가지고 있던 데이터가 사라진다.
        	        for(ScoreVo vo : list) {
        	            if(vo.getId().contains(find) || vo.getSubject().contains(find)) {
        	                model.addRow(vo.getVector());
        	            }
        	        }
        	        table.updateUI();
        	    }
        	});
        }
        return btnNewButton;
    }
    public JTextField getFindStr() {
        if (findStr == null) {
        	findStr = new JTextField();
        	findStr.setColumns(10);
        }
        return findStr;
    }
    public JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }
    public JTable getTable() {
        if (table == null) {
            // 헤더 생성
            ScoreDao dao = new ScoreDao();
            List<ScoreVo> list = dao.read();
            Vector vector = new Vector();
            for(ScoreVo s : list) {
                vector.add(s.getVector());
            }
            
            DefaultTableModel model = new DefaultTableModel();
            String[] header = {"순번","아이디","시험일자","과목","점수"};
            Vector<String> vs = new Vector(Arrays.asList(header));
            model.setDataVector(vector, vs);
            
        	table = new JTable(model);
        	table.addMouseListener(new MouseAdapter() {    
        	    //Mouse에 있는 모든 EventListener를 포괄하는 MouseAdapter
        	    //접미사가 Listener면 Interface , Adapter면 재정의한 class
        	    //Listener를 사용하면 마우스에 포함된 모든 메소드를 재정의해야하는데(사용하지 않음에도) 모든 이벤트를 포괄하는Adapter로 재정의하여 간편하게 사용함
        	    
        	    @Override
        	    public void mouseClicked(MouseEvent e) {
        	        int row = table.getSelectedRow();      //
        	        
        	        if(main.si == null) {      //MyInterMain 안에 ScoreInput 창이 없으면
        	            main.si = new ScoreInput(main);
        	            main.getDesktopPane().add(main.si);
        	            main.getDesktopPane().updateUI();
        	            main.si.toFront();                     
        	            // 138~141: ss에서 si창이 없을 시 ss의 row를 클릭하면 si창이 뜨게 하는 코드

        	        }
        	        
        	        Integer serial = (Integer)(table.getValueAt(row, 0));
        	        String id = (String)table.getValueAt(row, 1);
        	        String mDate = (String)table.getValueAt(row, 2);
        	        String subject = (String)table.getValueAt(row, 3);
        	        int score = (Integer)(table.getValueAt(row, 4));
        	        
        	        main.si.getTfSerial().setText(serial.toString());
        	        main.si.getTfId().setText(id);
        	        main.si.getTfMdate().setText(mDate);
        	        main.si.getTfSubject().setText(subject);
        	        main.si.getTfScore().setText(score+"");
        	                
        	        
        	    }
        	});
        }
        return table;
    }
}
