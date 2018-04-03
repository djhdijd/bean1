package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;

//用label来实现一个按钮功能
public class ButtonLabel extends JLabel
{
	public ButtonLabel(String text) 
	{
		super(text);
		this.setFont(new Font("黑体", Font.BOLD, 16));// 字体，样式，大小/磅
		this.setForeground(Color.black);// 设置背景颜色
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));// 设置手型的光标
	}

}
