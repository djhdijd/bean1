package main;
 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import param.Param;
 
public class TimeProgressBar extends JProgressBar implements ActionListener
{
    public int maxTime = Param.time;// �������ʱ��
    private Timer timer = new Timer(1000, this);// ��ʱ����int
                                                // delayһ�����һ�κ�ActionListener������
    public MainFrame mainFrame;
 
    public TimeProgressBar(MainFrame mainFrame) 
    {
        this.mainFrame = mainFrame;
        // mouseEvent();
        this.setMaximum(maxTime);
        this.setValue(maxTime);
        this.setBackground(Color.gray);
        this.setStringPainted(true);// ���� stringPainted
                                    // ���Ե�ֵ��������ȷ���������Ƿ�Ӧ�ó��ֽ����ַ�����
        this.setString(maxTime + "��");
    }
     
    @Override
    public void actionPerformed(ActionEvent arg0) 
    {
            // TODO Auto-generated method stub
            maxTime--;
            this.setValue(maxTime);
            this.setString(maxTime + "��");
             
            //ʱ��һ������ʱͣ��������Ȼ����븺��
            if(maxTime==0){
                this.stop();
                mainFrame.answerArea.setEditable(false);
            }
         
    }
    /**
     * ��ʼ
     */
    public void start() {
        timer.start();
    }
 
    /**
     * ��ͣ
     */
    public void stop() {
        timer.stop();
    }
    /**
     * ���¿�ʼ
     */
    public void restart() {
        maxTime = Param.time;
        this.setMaximum(maxTime);// ��������JProgress�����ֵ
        this.setValue(maxTime);
        this.setString(maxTime + "��");
        timer.start();
    }
}