package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Formula 
{
    private List numberList = new ArrayList();//����
    private List operatorList = new ArrayList();//�����

    //�չ���
    public Formula() 
    {

    }

    //gei��set����
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

    //���ι��죬����r��Ȼ����Χ�ڵ�ʽ��
    public Formula(Integer r) 
    {
        //�ж����ɵ�ʽ���м��������
        Random random = new Random();
        Integer num = random.nextInt(3);
        StringBuffer formula = new StringBuffer("");
        //���������Ϊ1����ʽ��
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
        {//���������Ϊ2��ʽ��
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
        {//���������Ϊ3��ʽ��
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

    //����numberList��operatorList����һ��ʽ��
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

    //����ʽ�Ӵ�
    public Number getAnswser() 
    {
        //�ȶ�ʽ�ӵ�*�͡½��д���
        int i = 0;
        while (i < operatorList.size()) 
        {
            //������������������0���򷵻ظ÷���
            if (numberList.size()==1)
            {
                return (Number) numberList.get(0);
            }
            //���������*�͡µ�ʱ��
            if (operatorList.get(i).equals("*") || operatorList.get(i).equals("��")) {
                //ȡ��������������
                Number numberFront = (Number) numberList.get(i);
                Number numberAfter = (Number) numberList.get(i + 1);
                //��������������ֵ�ķ��Ӳ���
                int numberFrontMolecule = numberFront.getInteger() * numberFront.getDenominator() + numberFront.getMolecule();
                int numberAfterMolecule = numberAfter.getInteger() * numberAfter.getDenominator() + numberAfter.getMolecule();
                int endMolecule = 0;
                int endDenominator = 0;
                //���������˵ķ���ֵ�ͷ�ĸֵ
                if (operatorList.get(i).equals("*")) 
                {
                    endMolecule = numberFrontMolecule * numberAfterMolecule;
                    endDenominator = numberFront.getDenominator() * numberAfter.getDenominator();
                }
                if (operatorList.get(i).equals("��")) 
                {
                    endMolecule = numberFrontMolecule * numberAfter.getDenominator();
                    endDenominator = numberAfterMolecule * numberFront.getDenominator();
                }
                int endInteger = 0;//��ʼ���ӵ���������Ϊ0
                if (endMolecule > endDenominator)
                {
                    endInteger = endMolecule / endDenominator;
                    endMolecule = endMolecule % endDenominator;
                }
                //�����Լ��
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
                Number endNumber = new Number(endInteger, endMolecule, endDenominator);//Լ�ֺ��ʽ��
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

        //������*�´�������+-����
        while (operatorList.size()!=0)
        {
            //ȡ��������������
            Number numberFront = (Number) numberList.get(0);
            Number numberAfter = (Number) numberList.get(1);
            //��������������ֵ�ķ��Ӳ���
            int numberFrontMolecule = numberFront.getInteger() * numberFront.getDenominator() + numberFront.getMolecule();
            int numberAfterMolecule = numberAfter.getInteger() * numberAfter.getDenominator() + numberAfter.getMolecule();
            //������ʽ�ӵķ�ĸһ����һ������������ĸ���
            int endDenominator=numberFront.getDenominator()*numberAfter.getDenominator();
            //���Ϊ+�����ͽ���+��
            int allMolecule1=numberFrontMolecule*numberAfter.getDenominator();
            int allMolecule2=numberAfterMolecule*numberFront.getDenominator();
            int endMolecule=0;//����δԼ��ǰ�ķ��Ӳ���
            if (operatorList.get(0).equals("+"))
            {
                endMolecule=allMolecule1+allMolecule2;
            }
            if (operatorList.get(0).equals("-"))
            {
                endMolecule=allMolecule1-allMolecule2;
            }
            int endInteger = 0;//��ʼ���ӵ���������Ϊ0
            if (endMolecule > endDenominator) 
            {
                endInteger = endMolecule / endDenominator;
                endMolecule = endMolecule % endDenominator;
            }
            //�����Լ��
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
            Number endNumber = new Number(endInteger, endMolecule, endDenominator);//Լ�ֺ��ʽ��
            this.numberList.add(0, endNumber);
            this.numberList.remove(1);
            this.numberList.remove(1);
            this.operatorList.remove(0);
        }
        return (Number) numberList.get(0);
    }
}

