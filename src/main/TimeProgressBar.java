package main;
 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import param.Param;
 
public class TimeProgressBar extends JProgressBar implements ActionListener
{
    public int maxTime = Param.time;// 设置最大时间
    private Timer timer = new Timer(1000, this);// 计时器，int
                                                // delay一秒减少一次和ActionListener监听器
    public MainFrame mainFrame;
 
    public TimeProgressBar(MainFrame mainFrame) 
    {
        this.mainFrame = mainFrame;
        // mouseEvent();
        this.setMaximum(maxTime);
        this.setValue(maxTime);
        this.setBackground(Color.gray);
        this.setStringPainted(true);// 设置 stringPainted
                                    // 属性的值，该属性确定进度条是否应该呈现进度字符串。
        this.setString(maxTime + "秒");
    }
     
    @Override
    public void actionPerformed(ActionEvent arg0) 
    {
            // TODO Auto-generated method stub
            maxTime--;
            this.setValue(maxTime);
            this.setString(maxTime + "秒");
             
            //时间一到，计时停下来，不然会进入负数
            if(maxTime==0){
                this.stop();
                mainFrame.answerArea.setEditable(false);
            }
         
    }
    /**
     * 开始
     */
    public void start() {
        timer.start();
    }
 
    /**
     * 暂停
     */
    public void stop() {
        timer.stop();
    }
    /**
     * 重新开始
     */
    public void restart() {
        maxTime = Param.time;
        this.setMaximum(maxTime);// 重新设置JProgress的最大值
        this.setValue(maxTime);
        this.setString(maxTime + "秒");
        timer.start();
    }
}