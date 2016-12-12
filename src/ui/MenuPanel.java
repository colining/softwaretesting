package ui;

import javax.swing.*;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import util.ImageUtil;


public class MenuPanel extends JPanel{	
	private static final long serialVersionUID = 1L;
	private Image bgImage;
	private Image startOverImg;
	private Image startLeaveImg;
	
	private MainFrame mainFrame;

	public MenuPanel(MainFrame mainFrame){
		super();
		this.mainFrame = mainFrame;		
		bgImage = ImageUtil.loadImage("menu.png");
		startOverImg = ImageUtil.loadImage("start_over.png");
		startLeaveImg = ImageUtil.loadImage("start_leave.png");	
		setLayout(null);
		Cursor cursor =
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);  //设置光标为手形

		JButton startBtn = new JButton();
		startBtn.setFocusable(false);
		startBtn.setBorder(null);
		startBtn.setCursor(cursor);
		startBtn.setIcon(new ImageIcon(startLeaveImg));
		startBtn.setRolloverIcon(new ImageIcon(startOverImg)); //当鼠标悬浮在按钮上方时即显示
		startBtn.setPressedIcon(new ImageIcon(startOverImg));//当鼠标按下时即显示
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchToGame();
			}
		});
		add(startBtn);
		startBtn.setBounds(246, 544, startOverImg.getWidth(null), startOverImg.getHeight(null));
	}
	public void switchToGame() {
		mainFrame.switchToGame();
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
	}
}
