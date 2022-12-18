package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import jdbc.DBConn;

public class SelectBox extends JInternalFrame {
    private JPanel panel;
    private JTextField tfSql;
    private JButton btnNewButton;
    private JScrollPane scrollPane;
    private JTable table;
    private JLabel lblNewLabel;
    MyInterMain main;
    Connection conn;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SelectBox frame = new SelectBox();
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
    public SelectBox() {
        super("SelectBox", true, true, true, true);
        setVisible(true);
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                main.sb = null;
            }
        });
        setBounds(100, 100, 646, 425);
        getContentPane().add(getPanel(), BorderLayout.NORTH);
        getContentPane().add(getScrollPane(), BorderLayout.CENTER);

    }
    public SelectBox(MyInterMain main) {
        this();
        this.main = main;
    }
    
    public void select(){
        Vector<String> header = new Vector();
        Vector list = new Vector();
        
        try {    
        String sql = tfSql.getText();
        conn = new DBConn().getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData meta = rs.getMetaData();
        header.add("NO");
        for(int i=1; i<=meta.getColumnCount(); i++) {
            header.add(meta.getColumnName(i));
            
        }
        int no = 1;
        while(rs.next()) {
            Vector v = new Vector();    //1개의 행을 집에넣기 위한 벡터
            v.add(no);
            for(int i=1; i<meta.getColumnCount(); i++) {
                String cn = meta.getColumnName(i);
                v.add(rs.getString(cn));
            }
            list.add(v);
            no++;
        }
        DefaultTableModel model = new DefaultTableModel(list, header);
        table.setModel(model);
        
        } catch (SQLException e) {

            e.printStackTrace();
        }


    }
    public JPanel getPanel() {
        if (panel == null) {
        	panel = new JPanel();
        	panel.setPreferredSize(new Dimension(10, 30));
        	panel.setLayout(new BorderLayout(0, 0));
        	panel.add(getTfSql(), BorderLayout.CENTER);
        	panel.add(getBtnNewButton(), BorderLayout.EAST);
        	panel.add(getLblNewLabel(), BorderLayout.WEST);
        }
        return panel;
    }
    public JTextField getTfSql() {
        if (tfSql == null) {
        	tfSql = new JTextField();
        	tfSql.addKeyListener(new KeyAdapter() {
        	    @Override
        	    public void keyReleased(KeyEvent e) {      //tfSql에서 sql문장을 치고 엔터를 눌러도 실행버튼과 똑같은 상황이 되도록 하기 위해
        	        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        	            try {
                            select();
                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
        	        }
        	    }
        	});
        	tfSql.setColumns(10);
        }
        return tfSql;
    }
    public JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("실행");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	      try {
                    select();
                } catch (Exception e1) {
                   
                    e1.printStackTrace();
                }
        	        
        	    }
        	});
        }
        return btnNewButton;
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
        }
        return table;
    }
    public JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("SQL");
        }
        return lblNewLabel;
    }
}
