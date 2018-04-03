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
    JMenu menuSet = new JMenu(Param.set);// 设置按钮
    JMenuItem menuHistory = new JMenuItem(Param.history);// 查看历史情况
    JMenuItem paramSet = new JMenuItem(Param.paramSet);// 参数设置
    JMenuItem timeSet = new JMenuItem(Param.timeSet);// 时间设置
    JMenu languageSet = new JMenu(Param.languageSet);// 语言设置
 
    public MainMenuBar(MainFrame mainFrame) 
    {
        this.mainFrame = mainFrame;
        init();
        mouseEvent();
    }
 
    // 初始化
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
        //历史成绩按钮
        menuHistory.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                // TODO Auto-generated method stub
                new History(mainFrame);
            }
             
        });
        //参数设置
        paramSet.addActionListener(new ActionListener() 
        {
 
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                // TODO Auto-generated method stub
                new ParamSet(mainFrame);
            }
 
        });
 
        //时间设置
        timeSet.addActionListener(new ActionListener() 
        {
 
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                // TODO Auto-generated method stub
                new TimeParamSet(mainFrame);
            }
 
        });
 
        //语言设置
        ButtonGroup languageGroup = new ButtonGroup();
        Set<String> lgSet = new HashSet<String>();
        languageSet.add(Param.chinese);
        languageSet.add(Param.english);
        for (String str : lgSet) {
            final JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(
                    str);
            languageGroup.add(checkBoxMenuItem);
            languageSet.add(checkBoxMenuItem);
            if (str.equals("中文") || str.equals("chinese")) 
            {
                checkBoxMenuItem.setSelected(true);
                checkBoxMenuItem.addActionListener(new ActionListener() {
 
                    @Override
                    public void actionPerformed(ActionEvent arg0) 
                    {
                        // TODO Auto-generated method stub
                        Param.exNumber = "生成题目数";
                        Param.exRange = "数字范围";
                        Param.timeConfig = "时间设置(秒)";
                        Param.determine = "确定";
                        Param.remaind = "请输入正整数";
                        Param.title = "四则运算器";
                        Param.generatingItem = "生成题目";
                        Param.begin = "开始";
                        Param.submit = "提交答案";
                        Param.set = "设置";
                        Param.history = "历史情况";
                        Param.timeSet = "时间设置";
                        Param.paramSet = "参数设置";
                        Param.languageSet = "语言设置";
                        Param.chinese = "中文";
                        Param.english = "英文";
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
                        Param.title = "四则运算器";
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