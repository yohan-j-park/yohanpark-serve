package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import jdbc.MemberDto;
import jdbc.MemberVo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberSearchDB extends JInternalFrame {
    private JPanel panel;
    private JButton btnNewButton;
    private JTextField findStr;
    private JScrollPane scrollPane;
    private JTable table;
    
    MyInterMain main;
//    MemberInputDB midb;
    Connection conn;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberSearchDB frame = new MemberSearchDB();
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
    public MemberSearchDB() {
        super("회원조회DB",true,true,true,true);
        setVisible(true);
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                main.msdb = null;
            }
        });
        setBounds(100, 100, 450, 300);
        getContentPane().add(getPanel(), BorderLayout.NORTH);
        getContentPane().add(getScrollPane(), BorderLayout.CENTER);

    }
    
    public MemberSearchDB(MyInterMain main) {
        this();
        this.main = main;
    }
    public void select() {
        // 검색어를 가져와 MemberDto.select 호출 -> 반환형: Vector타입의 vector(Vector<Vector>)
        String f = findStr.getText();
        MemberDto dto = new MemberDto();
        Vector<Vector> list = dto.select(f);
        
        // DefaultTableModel에 있는 모든 데이터를 삭제
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);
        
        // DefaultTableModel model 에 리턴받은 Vector 데이터를 추가
        for(Vector v : list) {
            model.addRow(v);
        }
        
        // model을 table에 설정
    }
    public JPanel getPanel() {
        if (panel == null) {
        	panel = new JPanel();
        	panel.setPreferredSize(new Dimension(10, 35));
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
        	        select();
        	    }
        	});
        }
        return btnNewButton;
    }
    public JTextField getFindStr() {
        if (findStr == null) {
        	findStr = new JTextField();
        	findStr.addKeyListener(new KeyAdapter() {
        	    @Override
        	    public void keyReleased(KeyEvent e) {
        	        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        	            select();
        	        }
        	    }
        	});
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
        	table = new JTable();
        	table.addMouseListener(new MouseAdapter() {
        	    @Override
        	    public void mouseClicked(MouseEvent e) {
        	        int row = table.getSelectedRow();
        	        String id = (String)table.getValueAt(row, 0);
        	        MemberDto dto = new MemberDto();
        	        MemberVo vo = dto.SelectOne(id);   //id를 매개변수로 받아 vo를 리턴하는 메소드
        	        
        	        if(main.midb == null) {        // main에 midb가 없다면
        	            main.midb = new MemberInputDB(main);   // main에 midb를 생성
        	            main.getDesktopPane().add(main.midb);
        	        }
        	            main.midb.loadData(vo);
        	            main.midb.toFront();
        	    }
        	});
        	String[] header = {"아이디","성명","성별","연락처","등록일"};
        	DefaultTableModel model = new DefaultTableModel(null, header);
        	table.setModel(model);
        }
        return table;
    }
}