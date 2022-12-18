package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import iostream.ScoreDao;
import jdbc.ScoreDto;
import jdbc.ScoreVo;

public class ScoreSearchDB extends JInternalFrame {
    private JPanel panel;
    private JButton btnNewButton;
    private JTextField findStr;
    private JScrollPane scrollPane;
    private JTable table;
    
    MyInterMain main;
    Connection conn;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ScoreSearchDB frame = new ScoreSearchDB();
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
    public ScoreSearchDB() {
        super("성적 조회DB",true,true,true,true);
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                main.ssdb = null;
            }
        });
        setVisible(true);
        setBounds(100, 100, 768, 352);
        getContentPane().setLayout(new BorderLayout(0, 0));
        getContentPane().add(getPanel(), BorderLayout.NORTH);
        getContentPane().add(getScrollPane(), BorderLayout.CENTER);

    }
    
    public ScoreSearchDB(MyInterMain main) {
        this();
        this.main = main;
    }
    
    public void select() {
        String f = findStr.getText();
        ScoreDto dto = new ScoreDto();
        Vector<Vector> list = dto.select(f);
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);
        
        for(Vector v : list) {
            model.addRow(v);
        }
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
                    Integer serial = (Integer)table.getValueAt(row, 0);
                    ScoreDto dto = new ScoreDto();
                    ScoreVo vo = dto.SelectOne(serial);   
                    
                    if(main.sidb == null) {        // main에 midb가 없다면
                        main.sidb = new ScoreInputDB(main);   // main에 midb를 생성
                        main.getDesktopPane().add(main.sidb);
                    }
                        main.sidb.loadData(vo);
                        main.sidb.toFront();
                }
            });
            String[] header = {"번호","아이디","시험날짜","과목","점수"};
            DefaultTableModel model = new DefaultTableModel(null, header);
            table.setModel(model);
        }
        return table;
    }
}
