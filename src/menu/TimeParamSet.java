package menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import param.Param;
import main.MainFrame;

public class TimeParamSet extends JDialog
{
	MainFrame mainFrame;
	JLabel time = new JLabel(Param.timeConfig);//时间设置
	
	JTextField timeText=new JTextField(15);//时间输入框
	
	JButton button=new JButton(Param.determine);//确定按钮
	
	public TimeParamSet(MainFrame mainFrame)
	{
		this.mainFrame=mainFrame;
		init();
		this.setSize(new Dimension(200, 180));//无须设置默认关闭
		this.setLocationRelativeTo(mainFrame);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}
	
	public void init()
	{
		JPanel panel=new JPanel();
		this.add(panel);
		
		panel.add(time);
		panel.add(timeText);
		
		button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				Param.time=Integer.valueOf(timeText.getText());
				mainFrame.repaint();
				dispose();
			}
			
		});
		
		panel.add(button);
		
		this.add(panel);
	}
}