package iostream;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;

public class MyTextEditor extends JFrame {
    protected static Editor target;     
//  정적형 멤버 Editor 추가 (클릭 된 창이 target이 되도록 함.) 
//  Editor를 MyTextEditor e = new Editor(); 처럼 객체로 선언하지 않고 사용할 수 있기 때문 - 메모리에 또 남음..
//  static을 사용하지 않으면 myTextEditor에 인스턴스를 항상 가지고 다녀야 함  
//  e.target != frame.target  
    
    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu mnNewMenu;
    private JMenuItem mntmNewMenuItem;
    private JMenuItem mntmNewMenuItem_1;
    private JMenuItem mntmNewMenuItem_2;
    private JMenuItem mntmNewMenuItem_3;
    private JDesktopPane desktopPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyTextEditor frame = new MyTextEditor();
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
    
    public void fileSave() {
     try {   
        String data = target.getTextArea().getText();
        byte[] bytes = data.getBytes();
        File file = new File(target.getFileName());
        OutputStream os = new FileOutputStream(file);
        os.write(bytes);
        os.close();
    }catch(Exception ex) {
        JOptionPane.showMessageDialog(MyTextEditor.this, ex.getMessage());
    }
}   
    
    
       
    public MyTextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 763, 421);
        setJMenuBar(getMenuBar_1());
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(getDesktopPane_1(), BorderLayout.CENTER);
    }
    public JMenuBar getMenuBar_1() {
        if (menuBar == null) {
        	menuBar = new JMenuBar();
        	menuBar.add(getMnNewMenu());
        }
        return menuBar;
    }
    public JMenu getMnNewMenu() {
        if (mnNewMenu == null) {
        	mnNewMenu = new JMenu("File");
        	mnNewMenu.add(getMntmNewMenuItem());
        	mnNewMenu.add(getMntmNewMenuItem_1());
        	mnNewMenu.add(getMntmNewMenuItem_2());
        	mnNewMenu.add(getMntmNewMenuItem_3());
        }
        return mnNewMenu;
    }
    public JMenuItem getMntmNewMenuItem() {
        if (mntmNewMenuItem == null) {
        	mntmNewMenuItem = new JMenuItem("새 파일");
        	mntmNewMenuItem.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        JInternalFrame editor = new Editor();      //부모 editor = new 자식() : 부모객체를 자식객체에 넣을 수 있다(다형성)
        	        desktopPane.add(editor);
        	        desktopPane.updateUI();
        	        editor.toFront();
        	        target = (Editor)editor;
        	    }
        	});
        }
        return mntmNewMenuItem;
    }
    public JMenuItem getMntmNewMenuItem_1() {
        if (mntmNewMenuItem_1 == null) {
        	mntmNewMenuItem_1 = new JMenuItem("열기");
        	mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	     try {   
        	        JFileChooser fc = new JFileChooser();      //JFileChooser 열기를 누르면 선택할 파일 목록을 불러오게 해 주는 클래스
        	        int flag = fc.showOpenDialog(MyTextEditor.this);
        	        if(flag == JFileChooser.APPROVE_OPTION) {  // 열기버튼을 클릭한 경우(클릭한 것이 참이라면)
        	            File f = fc.getSelectedFile();
        	            StringBuffer sb = new StringBuffer();      // 선택한 데이터를 저장하는 StringBuffer (sb = sb+new String()보다 200~400배 빠름)
        	            int readCnt = -1;  // readCnt = byte를 읽은 크기를 말함
        	            byte[] bytes = new byte[4096];
        	            InputStream is = new FileInputStream(f);
        	            while((readCnt = is.read(bytes)) != -1) {      // 읽은 byte 수가 readCnt에 저장됨.(쓰레기 파일을 만들지 않기 위해)
        	                sb.append(new String(bytes, 0, readCnt));  // StringBuffer에 bytes를 0부터 읽은 크기까지 넣음   
        	            }
        	            Editor editor = new Editor();
        	            editor.setFileName(f.getPath());   // f.getPath() :file은 filename+경로(저장된위치)로 구성되어 있는데 getPath는 경로를 불러와줌
        	            editor.getTextArea().setText(sb.toString());
        	            
        	            desktopPane.add(editor);
        	            desktopPane.updateUI();
        	            editor.toFront();
        	            
        	            target = editor;
        	        }
        	    }catch(Exception ex) {
        	        JOptionPane.showMessageDialog(MyTextEditor.this, ex.getMessage());
        	    }
        	  }
           });
        }
        return mntmNewMenuItem_1;
    }
    public JMenuItem getMntmNewMenuItem_2() {
        if (mntmNewMenuItem_2 == null) {
        	mntmNewMenuItem_2 = new JMenuItem("저장");
        	mntmNewMenuItem_2.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {       //저장 버튼을 누르면
        	        // 파일명이 noname인지 확인
        	        String fn = target.getFileName();         // 타겟의 이름을 가져온다
        	        if(fn.equals("noname.txt")) {             // 타겟의 이름이 noname.txt면(이름이 없으면)
        	            JFileChooser fc = new JFileChooser();      
        	            int flag = fc.showSaveDialog(MyTextEditor.this);   
        	            if(flag == JFileChooser.APPROVE_OPTION) { //확인버튼을 클릭한 경우
        	                File f = fc.getSelectedFile();    //f = fc에서 선택한 파일이다
        	                target.setFileName(f.getPath());  // 타겟의 이름을 지정한다(경로와 함께)
        	                fileSave();    //파일을 저장함.
        	            
        	        }
        	    }
        	        else {
        	            fileSave();    //(noname이 아닐 때 파일을 저장한다)
        	        }
       	     }
        });
      }
        return mntmNewMenuItem_2;
    }
    public JMenuItem getMntmNewMenuItem_3() {
        if (mntmNewMenuItem_3 == null) {
        	mntmNewMenuItem_3 = new JMenuItem("새 이름으로");
        	mntmNewMenuItem_3.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        JFileChooser fc = new JFileChooser();      
                    int flag = fc.showSaveDialog(MyTextEditor.this);   
                    if(flag == JFileChooser.APPROVE_OPTION) { //확인버튼을 클릭한 경우
                        File f = fc.getSelectedFile();    //f = fc에서 선택한 파일이다
                        target.setFileName(f.getPath());  // 타겟의 이름을 지정한다(경로와 함께)
                        fileSave();    
                    }
        	    }
        	});
        }
        return mntmNewMenuItem_3;
    }
    public JDesktopPane getDesktopPane_1() {
        if (desktopPane == null) {
        	desktopPane = new JDesktopPane();
        }
        return desktopPane;
    }
}
