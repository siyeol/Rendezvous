import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Toast extends JFrame {

	String s;
	JWindow window;

	Toast(String s, int x, int y) {
		window = new JWindow();
		window.setBackground(new Color(0, 0, 0, 0));

		JPanel p = new JPanel() {
			public void paintComponent(Graphics g) {
				int width = g.getFontMetrics().stringWidth(s);
				int height = g.getFontMetrics().getHeight();

				g.setColor(Color.black);
				g.fillRect(10, 10, width + 30, height + 10);
				g.setColor(Color.black);
				g.drawRect(10, 10, width + 30, height + 10);

				g.setColor(new Color(255, 255, 255, 240));
				g.drawString(s, 25, 27);
				int t = 250;

				for (int i = 0; i < 4; i++) {
					t -= 60;
					g.setColor(new Color(0, 0, 0, t));
					g.drawRect(10 - i, 10 - i, width + 30 + i * 2, height + 10 + i * 2);
				}
			}
		};

		window.add(p);
		window.setLocation(x, y);
		window.setSize(300, 100);
	}

	// toast funtion using Thread!!
	void showtoast() {
		try {
			window.setOpacity(1);
			window.setVisible(true);

			Thread.sleep(2000);

			for (double d = 1.0; d > 0.2; d -= 0.1) {
				Thread.sleep(100);
				window.setOpacity((float) d);
			}

			window.setVisible(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}