import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import org.json.JSONException;

public class Main extends JFrame {

	public String loc1, loc2;
	private JTextField textField0 = new JTextField("인원 수를 입력하세요(8인 이하)", 30);

	private JButton button0 = new JButton("인원");
//	private ImageIcon satelliteButtonImg = new ImageIcon("satellite.png");
//	private ImageIcon PsatelliteButtonImg = new ImageIcon("satellite_clicked.png");
	private JToggleButton satellite_button = new JToggleButton("위성 모드");

	private JPanel panel = new JPanel();

	private GoogleAPI googleAPI = new GoogleAPI();
	private String location = "서울";
	private JLabel googleMAP = new JLabel();
	private JLabel jl;
	Image image = null;

	private Vector<JTextField> textFieldVector = new Vector<JTextField>();
	private Vector<JButton> buttonVector = new Vector<JButton>();

	private JTextField tf;
	private JButton bt;

	private int peopleNum = 0;
	private int vectorCount = 0;

	public String location0, location1, location2, location3, location4, location5, location6, location7;

	public Float lat_mean = 0f;
	public Float lng_mean = 0f;

	public class Event0 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			if (textField0.getText().equals("2") | textField0.getText().equals("3") | textField0.getText().equals("4")
					| textField0.getText().equals("5") | textField0.getText().equals("6")
					| textField0.getText().equals("7") | textField0.getText().equals("8")) {
				peopleNum = Integer.valueOf(textField0.getText());

				remove(jl);
				panel.removeAll();

				for (int i = 0; i < peopleNum; i++) {
					vectorCount = i;
					tf = new JTextField("위치를 입력하세요", 10);
					bt = new JButton("검색");
					textFieldVector.add(tf);
					buttonVector.add(bt);
					panel.add(tf);
					panel.add(bt);
				}
				bt = new JButton("결과 보기");
				buttonVector.add(bt);
				panel.add(bt);
				panel.add(satellite_button);
				satellite_button.addMouseListener(new SatelliteEvent());
				panel.revalidate();
				panel.repaint();
				if (peopleNum == 2) {
					buttonVector.get(0).addMouseListener(new Event1());
					buttonVector.get(1).addMouseListener(new Event2());
					buttonVector.get(2).addMouseListener(new Event10());

				} else if (peopleNum == 3) {
					buttonVector.get(0).addMouseListener(new Event1());
					buttonVector.get(1).addMouseListener(new Event2());
					buttonVector.get(2).addMouseListener(new Event3());
					buttonVector.get(3).addMouseListener(new Event10());
				} else if (peopleNum == 4) {
					buttonVector.get(0).addMouseListener(new Event1());
					buttonVector.get(1).addMouseListener(new Event2());
					buttonVector.get(2).addMouseListener(new Event3());
					buttonVector.get(3).addMouseListener(new Event4());
					buttonVector.get(4).addMouseListener(new Event10());
				} else if (peopleNum == 5) {
					buttonVector.get(0).addMouseListener(new Event1());
					buttonVector.get(1).addMouseListener(new Event2());
					buttonVector.get(2).addMouseListener(new Event3());
					buttonVector.get(3).addMouseListener(new Event4());
					buttonVector.get(4).addMouseListener(new Event5());
					buttonVector.get(5).addMouseListener(new Event10());
				} else if (peopleNum == 6) {
					buttonVector.get(0).addMouseListener(new Event1());
					buttonVector.get(1).addMouseListener(new Event2());
					buttonVector.get(2).addMouseListener(new Event3());
					buttonVector.get(3).addMouseListener(new Event4());
					buttonVector.get(4).addMouseListener(new Event5());
					buttonVector.get(5).addMouseListener(new Event6());
					buttonVector.get(6).addMouseListener(new Event10());
				} else if (peopleNum == 7) {
					buttonVector.get(0).addMouseListener(new Event1());
					buttonVector.get(1).addMouseListener(new Event2());
					buttonVector.get(2).addMouseListener(new Event3());
					buttonVector.get(3).addMouseListener(new Event4());
					buttonVector.get(4).addMouseListener(new Event5());
					buttonVector.get(5).addMouseListener(new Event6());
					buttonVector.get(6).addMouseListener(new Event7());
					buttonVector.get(7).addMouseListener(new Event10());
				} else if (peopleNum == 8) {
					buttonVector.get(0).addMouseListener(new Event1());
					buttonVector.get(1).addMouseListener(new Event2());
					buttonVector.get(2).addMouseListener(new Event3());
					buttonVector.get(3).addMouseListener(new Event4());
					buttonVector.get(4).addMouseListener(new Event5());
					buttonVector.get(5).addMouseListener(new Event6());
					buttonVector.get(6).addMouseListener(new Event7());
					buttonVector.get(7).addMouseListener(new Event8());
					buttonVector.get(8).addMouseListener(new Event10());
				}
			} else {
				Toast t = new Toast("8 이하의 숫자를 입력 해 주세요!", 520, 60);
				t.showtoast();
			}

//			buttonVector.get(0).addMouseListener(new Event1());
//			buttonVector.get(1).addMouseListener(new Event2());
//			buttonVector.get(2).addMouseListener(new Event3());
//			buttonVector.get(3).addMouseListener(new Event4());
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

	public class Event1 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			try {
				setMap(textFieldVector.get(0).getText(), 1);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			location0 = textFieldVector.get(0).getText();
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

	public class Event2 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				setMap(textFieldVector.get(1).getText(), 2);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			location1 = textFieldVector.get(1).getText();

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

	public class Event3 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				setMap(textFieldVector.get(2).getText(), 3);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			location2 = textFieldVector.get(2).getText();

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

	public class Event4 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				setMap(textFieldVector.get(3).getText(), 4);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			location3 = textFieldVector.get(3).getText();

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

	public class Event5 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				setMap(textFieldVector.get(4).getText(), 5);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			location4 = textFieldVector.get(4).getText();

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

	public class Event6 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				setMap(textFieldVector.get(5).getText(), 6);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			location5 = textFieldVector.get(5).getText();

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

	public class Event7 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				setMap(textFieldVector.get(6).getText(), 7);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			location6 = textFieldVector.get(6).getText();

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

	public class Event8 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				setMap(textFieldVector.get(7).getText(), 8);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			location6 = textFieldVector.get(7).getText();

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

	String loc;

	public class Event10 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			float lat_temp = 0;
			float lng_temp = 0;
			for (int i = 1; i < 9; i++) {
				lat_temp += googleAPI.lat_array[i];
				lng_temp += googleAPI.lng_array[i];
			}
			// googleAPI.lat = googleAPI.lat/googleAPI.InputCount;
			// googleAPI.lng = googleAPI.lng/googleAPI.InputCount;
			lat_temp /= googleAPI.InputCount;
			lng_temp /= googleAPI.InputCount;
			googleAPI.InputCount--;

			// String loc = googleAPI.lat.toString() + "," + googleAPI.lng.toString();

			loc = Float.toString(lat_temp) + "," + Float.toString(lng_temp);
			try {
				setMap(loc, 10);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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

	boolean SatelliteToggle = false;

	public class SatelliteEvent implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			SatelliteToggle = !SatelliteToggle;
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

	public void setMap(String location, int num) throws JSONException, IOException {
		if (location.equals("위치를 입력하세요")) {
			Toast t = new Toast("올바른 위치를 입력해 주세요!", 520, 60);
			t.showtoast();
		} else {
			googleAPI.downloadmap(location, SatelliteToggle, num);
			googleMAP.setIcon(googleAPI.getMap(location));
			googleAPI.fileDelete(location);
			// System.out.println(location);
			googleAPI.GetLocation(location, num);
			if (num == 10) {
				Toast t = new Toast(googleAPI.Address, 400, 500);
				t.showtoast();
			}
			add(BorderLayout.CENTER, googleMAP);
			pack();
		}
	}

	public Main() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setTitle("Rendezvous");
		setVisible(true);
		try {
			FileInputStream fis = new FileInputStream("./image.jpg");
			BufferedInputStream bis = new BufferedInputStream(fis);
			File sourceimage = new File("./image1.jpg");
			FileOutputStream fos = new FileOutputStream(sourceimage);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int data = bis.read();
			while (data != -1) {
				bos.write(data);
				data = bis.read();
			}
			image = ImageIO.read(sourceimage);
			bis.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		panel.setPreferredSize(new Dimension(500,50));

		panel.setPreferredSize(new Dimension(800, 70));
		panel.add(textField0);
		panel.add(button0);
		button0.addMouseListener(new Event0());

		// button1.addMouseListner(new Event ~~()) // 결과 보기
		googleAPI.downloadmap(location, SatelliteToggle, 0);

		googleMAP = new JLabel(googleAPI.getMap(location));
		googleAPI.fileDelete(location);

		add(BorderLayout.NORTH, panel);
		pack();

		jl = new JLabel(new ImageIcon(image));
		add(jl, BorderLayout.CENTER);
		pack();
	}

}
