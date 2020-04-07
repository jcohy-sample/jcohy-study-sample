package com.jcohy.sample.designpattern.command;

import javax.swing.*;
import java.awt.event.*;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jcohy on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
// tag::code[]
/**
 * 简单的绘图软件，移动鼠标时自动绘制一个红点，按下clear 清除所有
 * @author jcohy
 */
public class Client extends JFrame implements ActionListener,MouseMotionListener,WindowListener{


	private MacroCommand history = new MacroCommand();//绘制记录

	private DrawCanvas drawCanvas = new DrawCanvas(400, 400, history);//绘制区域

	private JButton cleanButton = new JButton("clear");//删除键

	public Client(String title) {
		super(title);
		this.addWindowListener(this);
		drawCanvas.addMouseMotionListener(this);
		cleanButton.addActionListener(this);

		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(cleanButton);

		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(drawCanvas);
		getContentPane().add(mainBox);

		pack();

		setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Command cmd = new DrawCommand(drawCanvas,e.getPoint());

		history.append(cmd);

		cmd.execute();

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cleanButton) {
			history.clear();
			drawCanvas.repaint();
		}
	}
	public static void main(String[] args) {
		new Client("Command Pattern Sample");
	}
}
// end::code[]