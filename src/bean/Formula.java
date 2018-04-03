package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Formula 
{
    private List numberList = new ArrayList();//数列
    private List operatorList = new ArrayList();//算符列

    //空构造
    public Formula() 
    {

    }

    //gei与set方法
    public List getNumberList() 
    {
        return numberList;
    }

    public void setNumberList(List numberList) 
    {
        this.numberList = numberList;
    }

    public List getOperatorList() 
    {
        return operatorList;
    }

    public void setOperatorList(List operatorList) 
    {
        this.operatorList = operatorList;
    }

    //带参构造，生成r自然数范围内的式子
    public Formula(Integer r) 
    {
        //判断生成的式子有几个运算符
        Random random = new Random();
        Integer num = random.nextInt(3);
        StringBuffer formula = new StringBuffer("");
        //生成运算符为1个的式子
        if (num == 0) 
        {
            Number number1 = new Number(r);
            this.numberList.add(number1);
            Operator operator1 = new Operator();
            this.operatorList.add(operator1.getOperator());
            Number number2 = new Number(r);
            this.numberList.add(number2);
        } 
        else if (num == 1)
        {//生成运算符为2的式子
            Number number1 = new Number(r);
            this.numberList.add(number1);
            Operator operator1 = new Operator();
            this.operatorList.add(operator1.getOperator());
            Number number2 = new Number(r);
            this.numberList.add(number2);
            Operator operator2 = new Operator();
            this.operatorList.add(operator2.getOperator());
            Number number3 = new Number(r);
            this.numberList.add(number3);
        } 
        else 
        {//生成运算符为3的式子
            Number number1 = new Number(r);
            this.numberList.add(number1);
            Operator operator1 = new Operator();
            this.operatorList.add(operator1.getOperator());
            Number number2 = new Number(r);
            this.numberList.add(number2);
            Operator operator2 = new Operator();
            this.operatorList.add(operator2.getOperator());
            Number number3 = new Number(r);
            this.numberList.add(number3);
            Operator operator3 = new Operator();
            this.operatorList.add(operator3.getOperator());
            Number number4 = new Number(r);
            this.numberList.add(number4);
        }
    }

    //根据numberList和operatorList生成一个式子
    public String getAFormula() 
    {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append(numberList.get(0));
        for (int i = 0; i < operatorList.size(); i++) 
        {
            stringBuffer.append(operatorList.get(i));
            stringBuffer.append(numberList.get(i + 1));
        }
        return stringBuffer.toString();
    }

    //生成式子答案
    public Number getAnswser() 
    {
        //先对式子的*和÷进行处理
        int i = 0;
        while (i < operatorList.size()) 
        {
            //如果数列里的数个数是0，则返回该方法
            if (numberList.size()==1)
            {
                return (Number) numberList.get(0);
            }
            //当算符出现*和÷的时候
            if (operatorList.get(i).equals("*") || operatorList.get(i).equals("÷")) {
                //取得运算符两侧的数
                Number numberFront = (Number) numberList.get(i);
                Number numberAfter = (Number) numberList.get(i + 1);
                //求得运算符两侧数值的分子部分
                int numberFrontMolecule = numberFront.getInteger() * numberFront.getDenominator() + numberFront.getMolecule();
                int numberAfterMolecule = numberAfter.getInteger() * numberAfter.getDenominator() + numberAfter.getMolecule();
                int endMolecule = 0;
                int endDenominator = 0;
                //算得两数相乘的分子值和分母值
                if (operatorList.get(i).equals("*")) 
                {
                    endMolecule = numberFrontMolecule * numberAfterMolecule;
                    endDenominator = numberFront.getDenominator() * numberAfter.getDenominator();
                }
                if (operatorList.get(i).equals("÷")) 
                {
                    endMolecule = numberFrontMolecule * numberAfter.getDenominator();
                    endDenominator = numberAfterMolecule * numberFront.getDenominator();
                }
                int endInteger = 0;//初始分子的整数部分为0
                if (endMolecule > endDenominator)
                {
                    endInteger = endMolecule / endDenominator;
                    endMolecule = endMolecule % endDenominator;
                }
                //求最大公约数
                int smaller = endMolecule > endDenominator ? endMolecule : endDenominator;
                int maxCommonFactor = 1;
                for (int j = 1; j <= smaller; j++)
                {
                    if (endMolecule % j == 0 && endDenominator % j == 0)
                    {
                        maxCommonFactor = j;
                    }
                }
                endMolecule = endMolecule / maxCommonFactor;
                endDenominator = endDenominator / maxCommonFactor;
                Number endNumber = new Number(endInteger, endMolecule, endDenominator);//约分后的式子
                this.numberList.add(i, endNumber);
                this.numberList.remove(i + 1);
                this.numberList.remove(i + 1);
                this.operatorList.remove(i);
            }
            else 
            {
                i++;
            }
        }

        //进行完*÷处理后进行+-处理
        while (operatorList.size()!=0)
        {
            //取得运算符两侧的数
            Number numberFront = (Number) numberList.get(0);
            Number numberAfter = (Number) numberList.get(1);
            //求得运算符两侧数值的分子部分
            int numberFrontMolecule = numberFront.getInteger() * numberFront.getDenominator() + numberFront.getMolecule();
            int numberAfterMolecule = numberAfter.getInteger() * numberAfter.getDenominator() + numberAfter.getMolecule();
            //不管两式子的分母一样或不一样，都把两分母相乘
            int endDenominator=numberFront.getDenominator()*numberAfter.getDenominator();
            //如果为+符，就进行+算
            int allMolecule1=numberFrontMolecule*numberAfter.getDenominator();
            int allMolecule2=numberAfterMolecule*numberFront.getDenominator();
            int endMolecule=0;//定义未约分前的分子部分
            if (operatorList.get(0).equals("+"))
            {
                endMolecule=allMolecule1+allMolecule2;
            }
            if (operatorList.get(0).equals("-"))
            {
                endMolecule=allMolecule1-allMolecule2;
            }
            int endInteger = 0;//初始分子的整数部分为0
            if (endMolecule > endDenominator) 
            {
                endInteger = endMolecule / endDenominator;
                endMolecule = endMolecule % endDenominator;
            }
            //求最大公约数
            int smaller = endMolecule > endDenominator ? endMolecule : endDenominator;
            int maxCommonFactor = 1;
            for (int j = 1; j <= smaller; j++) 
            {
                if (endMolecule % j == 0 && endDenominator % j == 0) 
                {
                    maxCommonFactor = j;
                }
            }
            endMolecule = endMolecule / maxCommonFactor;
            endDenominator = endDenominator / maxCommonFactor;
            Number endNumber = new Number(endInteger, endMolecule, endDenominator);//约分后的式子
            this.numberList.add(0, endNumber);
            this.numberList.remove(1);
            this.numberList.remove(1);
            this.operatorList.remove(0);
        }
        return (Number) numberList.get(0);
    }
}

