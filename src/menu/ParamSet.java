package menu;

import java.awt.Color;
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

public class ParamSet extends JDialog
{
	MainFrame mainFrame;
	JLabel exNumber = new JLabel(Param.exNumber);//����
	JLabel exRange=new JLabel(Param.exRange);//��Χ
	JLabel remindLabel=new JLabel(Param.remaind);//��ʾ
	
	JTextField exNumberText = new JTextField(15);
	JTextField exRangeText = new JTextField(15);
	
	JButton button=new JButton(Param.determine);//ȷ����ť
	//MainFrame mainFrame;

	public ParamSet(MainFrame mainFrame) 
	{
		this.mainFrame=mainFrame;
		init();
		this.setSize(new Dimension(200, 180));//��������Ĭ�Ϲر�
		this.setLocationRelativeTo(mainFrame);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);

	}
	public void init()
	{
		JPanel panel=new JPanel();
		this.add(panel);
		
		panel.add(exNumber);
		panel.add(exNumberText);
		
		panel.add(exRange);
		panel.add(exRangeText);
		
		remindLabel.setForeground(Color.red);
		panel.add(remindLabel);
		
		button.addActionListener(new myActionListener());
		panel.add(button);
		
		this.add(panel);
		
	}
	
	public class myActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			// TODO Auto-generated method stub
			Param.number=Integer.valueOf(exNumberText.getText());
			Param.range=Integer.valueOf(exRangeText.getText());
			dispose();
		}
		
	}
}

