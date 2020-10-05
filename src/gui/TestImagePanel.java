package gui;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import javax.swing.JPanel;public class TestImagePanel extends JPanel {
		 
		private static final long serialVersionUID = 1L;
		private Image img;
	 
		public TestImagePanel(String img) {
			this(new ImageIcon(img).getImage());
		}
	 
		public TestImagePanel(Image img) {
			this.img = img;
			//Dimension size = new Dimension(1500, 900);

		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);
		}
	 
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
		//-Djava.library.path=D:\\opencv\\build\\java\\x64

}
