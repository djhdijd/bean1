package menu;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.MainFrame;

public class History extends JDialog
{
	MainFrame mainFrame;
	JTextArea area=new JTextArea();
	
	public History(MainFrame mainFrame)
	{
		this.mainFrame=mainFrame;
		init();
		this.setSize(new Dimension(400, 100));//无须设置默认关闭
		this.setLocationRelativeTo(mainFrame);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}
	
	public void init()
	{
		JPanel panel=new JPanel();
		this.add(panel);
		
		//将文件中的成绩
		File gradeFile = new File("file/Grade.txt");
		try
		{
			FileReader gradeRD=new FileReader(gradeFile);
			BufferedReader gradeBw = new BufferedReader(gradeRD);
			String thisLine="";
			while ((thisLine = gradeBw.readLine()) != null) 
			{
				area.append(thisLine+"\r\n");
			}
			gradeBw.close();
			gradeRD.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}	
		
		panel.add(area);
	}

}
