package iostream;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class Editor extends JInternalFrame {
    private JScrollPane scrollPane;
    private JTextArea textArea;
    String fileName = "noname.txt";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        this.setTitle(fileName);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Editor frame = new Editor();
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
    public Editor() {
        super("noname.txt",true,true,true,true);
        
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                MyTextEditor.target = Editor.this;      
                // new Editor를 하지 않기 위해 target을 static으로 선언하였다.
                // Editor.this(Editor 자기자신) 를 하지 않고 그냥 this를 하게 되면 InternalFrameEvent e를 지칭하게 된다.
                
                //test
                String temp = MyTextEditor.target.getTextArea().getText();
                System.out.println(temp);
            }
        });
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout(0, 0));
        getContentPane().add(getScrollPane(), BorderLayout.CENTER);
        setVisible(true);

    }

    public JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
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
