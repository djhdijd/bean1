package bean;

import java.util.Random;

public class Operator 
{
    private String operator;
    //空构造,生成随机符号
    public  Operator()
    {
        Random random=new Random();
        Integer num=random.nextInt(4);
        switch (num)
        {
            case 0:this.setOperator("+");break;
            case 1:this.setOperator("-");break;
            case 2:this.setOperator("*");break;
            case 3:this.setOperator("÷");break;
        }
    }
    //get和set方法
    public String getOperator() 
    {
        return operator;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }
}
