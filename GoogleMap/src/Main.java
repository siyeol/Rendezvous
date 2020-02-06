import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame {

	private JTextField textField = new JTextField(30);
	private JButton button = new JButton("검색");
	private JPanel panel = new JPanel();
	
	private GoogleAPI googleAPI = new GoogleAPI();
	private String location = "서울";
	private JLabel googleMAP = new JLabel();
	
	public class Event implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			setMap(textField.getText());
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void setMap(String location) {
		googleAPI.downloadmap(location);
		googleMAP.setIcon(googleAPI.getMap(location));
		googleAPI.fileDelete(location);
		add(BorderLayout.SOUTH, googleMAP);
		pack();
		
	}
	
	
	public Main() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle ("Google Maps");
		setVisible(true);
		

		panel.add(textField);
		panel.add(button);
		button.addMouseListener(new Event());
		
		googleAPI.downloadmap(location);
		googleMAP = new JLabel(googleAPI.getMap(location));
		googleAPI.fileDelete(location);

	
		add(BorderLayout.NORTH, panel);
		pack();
	}


	
}
