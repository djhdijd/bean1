package menu;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
 
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
 
import param.Param;
import main.MainFrame;
 
public class MainMenuBar extends JMenuBar 
{
    MainFrame mainFrame;
    JMenu menuSet = new JMenu(Param.set);// ���ð�ť
    JMenuItem menuHistory = new JMenuItem(Param.history);// �鿴��ʷ���
    JMenuItem paramSet = new JMenuItem(Param.paramSet);// ��������
    JMenuItem timeSet = new JMenuItem(Param.timeSet);// ʱ������
    JMenu languageSet = new JMenu(Param.languageSet);// ��������
 
    public MainMenuBar(MainFrame mainFrame) 
    {
        this.mainFrame = mainFrame;
        init();
        mouseEvent();
    }
 
    // ��ʼ��
    public void init() 
    {
        menuSet.add(paramSet);
        menuSet.add(timeSet);
        menuSet.add(languageSet);
        menuSet.add(menuHistory);
 
        this.add(menuSet);
    }
 
    public void mouseEvent() 
    {
        //��ʷ�ɼ���ť
        menuHistory.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                // TODO Auto-generated method stub
                new History(mainFrame);
            }
             
        });
        //��������
        paramSet.addActionListener(new ActionListener() 
        {
 
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                // TODO Auto-generated method stub
                new ParamSet(mainFrame);
            }
 
        });
 
        //ʱ������
        timeSet.addActionListener(new ActionListener() 
        {
 
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                // TODO Auto-generated method stub
                new TimeParamSet(mainFrame);
            }
 
        });
 
        //��������
        ButtonGroup languageGroup = new ButtonGroup();
        Set<String> lgSet = new HashSet<String>();
        languageSet.add(Param.chinese);
        languageSet.add(Param.english);
        for (String str : lgSet) {
            final JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(
                    str);
            languageGroup.add(checkBoxMenuItem);
            languageSet.add(checkBoxMenuItem);
            if (str.equals("����") || str.equals("chinese")) 
            {
                checkBoxMenuItem.setSelected(true);
                checkBoxMenuItem.addActionListener(new ActionListener() {
 
                    @Override
                    public void actionPerformed(ActionEvent arg0) 
                    {
                        // TODO Auto-generated method stub
                        Param.exNumber = "������Ŀ��";
                        Param.exRange = "���ַ�Χ";
                        Param.timeConfig = "ʱ������(��)";
                        Param.determine = "ȷ��";
                        Param.remaind = "������������";
                        Param.title = "����������";
                        Param.generatingItem = "������Ŀ";
                        Param.begin = "��ʼ";
                        Param.submit = "�ύ��";
                        Param.set = "����";
                        Param.history = "��ʷ���";
                        Param.timeSet = "ʱ������";
                        Param.paramSet = "��������";
                        Param.languageSet = "��������";
                        Param.chinese = "����";
                        Param.english = "Ӣ��";
                        mainFrame.repaint();
                    }
 
                });
            } 
            else 
            {
                checkBoxMenuItem.setSelected(true);
                checkBoxMenuItem.addActionListener(new ActionListener() {
 
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        // TODO Auto-generated method stub
                        Param.exNumber = "Number of items";
                        Param.exRange = "range";
                        Param.timeConfig = "TimeSet(s)";
                        Param.determine = "determine";
                        Param.remaind = "Please enter a positive integer";
                        Param.title = "����������";
                        Param.generatingItem = "generating Item";
                        Param.begin = "begin";
                        Param.submit = "submit";
                        Param.set = "Set";
                        Param.history = "History";
                        Param.timeSet = "TimeSet";
                        Param.paramSet = "ParamSet";
                        Param.languageSet = "LanguageSet";
                        Param.chinese = "Chinese";
                        Param.english = "English";
                        mainFrame.repaint();
                    }
 
                });
            }
        }
 
    }
 
}