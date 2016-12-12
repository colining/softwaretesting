package ui;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import ui.MenuPanel;

import common.ConstantData;

public class MainFrame extends JFrame{	
	private static final long serialVersionUID = 1L;
	MenuPanel menuPanel;
	JPanel panel;
	GamePlay gamePlay;
	//Overlose overlose;
	private CardLayout layout;

	public MainFrame(){
		//���ô���
		setTitle("planet vs zombie");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		//���������е������panel�������棩,�˵�����ڣ�panel,��Ϸpanel����Ϸ���棩
		panel = new JPanel();		
		menuPanel = new MenuPanel(this);
		gamePlay = new GamePlay(); 
		layout = new CardLayout();
		//overlose = new Overlose();
		//���ô��岼��
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel,BorderLayout.CENTER);
		//����������panel����
		panel.setLayout(layout);
		panel.setPreferredSize(new Dimension(ConstantData.WIDTH, ConstantData.HEIGHT));  //����panel����ĸߣ���
		panel.add(menuPanel,"menu");      //����������Ƭ
		panel.add(gamePlay,"play");
		//panel.add(overlose,"over");
		//�õ���Ļ�ĳߴ�
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		setLocation((dim.width - ConstantData.WIDTH) / 2, (dim.height - ConstantData.HEIGHT) / 2);
		pack();		
		setVisible(true);
		
	}
		
	public void switchToGame(){
		layout.show(panel, "play");     //��ʾ��Ϸ���棨�ڶ�����Ƭ�� Ҳ��layout.next(panel);		
		//layout.show(overlose,"over");
		gamePlay.startGame();
	}
//	public void golose(){
//		layout.show(overlose,"over");
//		overlose.switchToGame();
//	}
	
	public static void main(String[] args){
		new MainFrame();
	}
}
