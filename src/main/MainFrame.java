package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.UnsupportedLookAndFeelException;
import bean.Formula;
import param.Param;
import menu.MainMenuBar;
	  
public class MainFrame extends JFrame
{
  
	 	MainMenuBar mainMenuBar=new MainMenuBar(this);//�˵�
	 	ButtonLabel generatingItemButton=new ButtonLabel(Param.generatingItem);//���ɰ�ť
	 	ButtonLabel beginButton=new ButtonLabel(Param.begin);//��ʼ��ť
	    TimeProgressBar timeProgressBar=new TimeProgressBar(this);
	 	JTextArea subjectArea=new JTextArea();//��Ŀ��
	 	JTextArea answerArea=new JTextArea();//������
	    public ButtonLabel submitButton=new ButtonLabel(Param.submit);//�ύ��ť
	  
	 	//���캯��
	 	public MainFrame()
	 	{
	 		beginButton.setBounds(130, 20, 100, 30);
	 		this.add(beginButton);
	  
		//������
		timeProgressBar.setBounds(400, 20, 250, 30);
		this.add(timeProgressBar);
		
		
	 		subjectArea.setEditable(false);
	 		//���������ֹ�����
	 		JScrollPane jssubjectArea=new JScrollPane(subjectArea);
	 		jssubjectArea.setBounds(20, 100, 600, 150);
	 		this.add(jssubjectArea);
	  
		answerArea.setEditable(false);
	 		//���������������
	 		JScrollPane jsanswerArea=new JScrollPane(answerArea);
	 		jsanswerArea.setBounds(20, 300, 600, 150);
	 		generatingItemButton.addMouseListener(new MouseAdapter() {

	 			public void mousePressed(MouseEvent arg0) {				
				subjectArea.setText("");
				File answersFile = new File("file/Answers.txt");
				FileWriter answersFw;
	 				for(int i=0;i<Param.number;i++){
	 					Formula formula = new Formula(Param.range);
	 					String aFormula = formula.getAFormula();
	 					subjectArea.append((i+1)+"."+aFormula+"\r\n");
					//����д�뵽���ļ���
					try 
					{
						answersFw = new FileWriter(answersFile, true);
						BufferedWriter answersBw = new BufferedWriter(answersFw);			
						answersBw.write((i + 1) + "." + formula.getAnswser().toString());
	                    answersBw.newLine();
	                    answersBw.flush();
	                    answersBw.close();
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				//����Ŀд�뵽�ļ���
				File exercisesFile = new File("file/Exercises.txt");
				String stirng=subjectArea.getText();
				FileWriter exercisesFw;
				try 
				{
					exercisesFw = new FileWriter(exercisesFile, true);
					BufferedWriter exercisesBw = new BufferedWriter(exercisesFw);
					exercisesBw.write(stirng);
                    exercisesBw.flush();
                    exercisesBw.close();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
	 				}
				
	 			}
	 		});
	  
	 		beginButton.addMouseListener(new MouseAdapter(){
	 			@Override
	 			public void mousePressed(MouseEvent arg0) {				
				timeProgressBar.restart();
				answerArea.setEditable(true);
	 			}
	 		});
	 		submitButton.addMouseListener(new MouseAdapter(){
	 			@Override
	 			public void mousePressed(MouseEvent arg0) {
				File yourFile = new File("file/YourFile.txt");
				String string = answerArea.getText();
				FileWriter yourFileFw;
				try 
				{
					yourFileFw = new FileWriter(yourFile, true);
					BufferedWriter yourFileBw = new BufferedWriter(yourFileFw);
					yourFileBw.write(string);
					yourFileBw.flush();
					yourFileBw.close();
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				answerArea.setEditable(false);
				timeProgressBar.stop();
				
				//���Դ����д�뵽�ļ���
				//��ɾ���ļ�
				File gradeFile = new File("file/Grade.txt");
                if (gradeFile.exists()) 
                {
                    gradeFile.delete();
               }
            //������ļ��ʹ����ļ���������
                File answersFile = new File("file/Answers.txt");
                FileReader answersRd;
				try 
				{
					answersRd = new FileReader(answersFile);
					BufferedReader answersBufferRd = new BufferedReader(answersRd);
					FileReader yourFileRd = new FileReader(yourFile);
					BufferedReader yourFileBufferRd = new BufferedReader(yourFileRd);
					String thisLineAnswer = "";
	                String yourAnswer = "";
	                List<Integer> error = new ArrayList<Integer>();
	                List<Integer> right = new ArrayList<Integer>();
	                int num = 1;
	                while ((thisLineAnswer = answersBufferRd.readLine()) != null) {
	                    yourAnswer = yourFileBufferRd.readLine();
	                    if (yourAnswer.equals(thisLineAnswer)) 
	                    {
	                        right.add(num);
	                    } 
	                    else 
	                    {
	                        error.add(num);
	                    }
	                    num++;
	                }
	                answersBufferRd.close();
	                yourFileBufferRd.close();
	              //��������д�뵽Grade�ļ���
	                FileWriter gradeFw = new FileWriter(gradeFile, true);
	                BufferedWriter gradeBw = new BufferedWriter(gradeFw);
	                gradeBw.write("Correct:"+right.size()+"(");
	                for (int x=0;x<right.size();x++)
	                {
	                    gradeBw.write(right.get(x)+",");
	                }
	               
	                gradeBw.write(")");
	                gradeBw.newLine();
	                gradeBw.write("Wrong:"+error.size()+"(");
	                for (int y=0;y<error.size();y++)
	                {
	                    gradeBw.write(error.get(y)+",");
	                }
	                
	               
	                gradeBw.write(")");
	                gradeBw.newLine();
	                //�ر���
	                gradeBw.flush();
	                gradeBw.close();
				} catch (FileNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 			}
	 		});
	 	
	 	}
	 	public static void main(String[] args) 
	 	{
			// TODO Auto-generated method stub
			try 
			{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} 
			catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new MainFrame();
		}

	 	
}