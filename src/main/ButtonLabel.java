package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;

//��label��ʵ��һ����ť����
public class ButtonLabel extends JLabel
{
	public ButtonLabel(String text) 
	{
		super(text);
		this.setFont(new Font("����", Font.BOLD, 16));// ���壬��ʽ����С/��
		this.setForeground(Color.black);// ���ñ�����ɫ
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));// �������͵Ĺ��
	}

}
