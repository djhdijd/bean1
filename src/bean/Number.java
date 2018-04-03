package bean;

import java.util.Random;

public class Number 
{
    private Integer integer;//带分数的整数部分
    private Integer molecule;//分子部分
    private Integer denominator;//分母部分
    //空构造函
    public Number()
    {

    }
    //三个参数的get和set方法
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

    //带参构
    public Number(Integer integer, Integer molecule, Integer denominator) {
        this.integer = integer;
        this.molecule = molecule;
        this.denominator = denominator;
    }

    //带参构函数，传入一个整数，生成小于该整数的分数对象
    public Number(int upperLimit)
    {
        Random random=new Random();
        Integer integer=random.nextInt(upperLimit);//因为生成部分的分数部分小?，所以整数部分应该是生成自然数上?1
        this.setInteger(integer);
        Integer denominator=random.nextInt(upperLimit)+1;//随机数生成的?~upperLimit，为了排除分母为0的情况?
        this.setDenominator(denominator);
        Integer molecule=random.nextInt(denominator)+1;//随机生成分子，同分母?，排数分子为0的情况?
        this.setMolecule(molecule);
    }

    //重写toString方法
    public String toString()
    {
        //判断整数部分,如果为0，就以真分数形式输出
        if (this.getInteger()==0)
        {
            //如果分子分母
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
