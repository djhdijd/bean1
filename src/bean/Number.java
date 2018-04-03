package bean;

import java.util.Random;

public class Number 
{
    private Integer integer;//����������������
    private Integer molecule;//���Ӳ���
    private Integer denominator;//��ĸ����
    //�չ��캯
    public Number()
    {

    }
    //����������get��set����
    public Integer getInteger() 
    {
        return integer;
    }

    public void setInteger(Integer integer) 
    {
        this.integer = integer;
    }

    public Integer getMolecule() 
    {
        return molecule;
    }

    public void setMolecule(Integer molecule) 
    {
        this.molecule = molecule;
    }

    public Integer getDenominator() 
    {
        return denominator;
    }

    public void setDenominator(Integer denominator) 
    {
        this.denominator = denominator;
    }

    //���ι�
    public Number(Integer integer, Integer molecule, Integer denominator) {
        this.integer = integer;
        this.molecule = molecule;
        this.denominator = denominator;
    }

    //���ι�����������һ������������С�ڸ������ķ�������
    public Number(int upperLimit)
    {
        Random random=new Random();
        Integer integer=random.nextInt(upperLimit);//��Ϊ���ɲ��ֵķ�������С?��������������Ӧ����������Ȼ����?1
        this.setInteger(integer);
        Integer denominator=random.nextInt(upperLimit)+1;//��������ɵ�?~upperLimit��Ϊ���ų���ĸΪ0�����?
        this.setDenominator(denominator);
        Integer molecule=random.nextInt(denominator)+1;//������ɷ��ӣ�ͬ��ĸ?����������Ϊ0�����?
        this.setMolecule(molecule);
    }

    //��дtoString����
    public String toString()
    {
        //�ж���������,���Ϊ0�������������ʽ���
        if (this.getInteger()==0)
        {
            //������ӷ�ĸ
            if (this.getMolecule().equals(this.getDenominator()))
            {
                return Integer.toString(this.getInteger()+1);
            }
            return this.getMolecule()+"/"+this.getDenominator();
        }
        if (this.getMolecule().equals(this.getDenominator()))
        {
            return Integer.toString(this.getInteger()+1);
        }
        
        if (this.getMolecule()==0)
        {
            return Integer.toString(this.getInteger());
        }
        return this.getInteger()+"'"+this.getMolecule()+"/"+this.getDenominator();
    }
}
