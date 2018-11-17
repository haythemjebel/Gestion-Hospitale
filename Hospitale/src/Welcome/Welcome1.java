package Welcome;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.Font;

public class Welcome1 extends JFrame {

	private JPanel contentPane;
	java.util.Date date1 = new java.util.Date();
	JLabel lblHorloge;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome1 frame = new Welcome1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Welcome1() {
		setTitle("Welcome to APP");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 764, 483);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/PROXIMEDIA/Desktop/img/hospital-icon.png"));
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
		JMenuItem mntmNewMenuItem = new JMenuItem("about_us");
		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				About apro = new About();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Quit");
		mnNewMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mnNewMenu.add(mntmNewMenuItem_1);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doc doc = new Doc();

			}
		});
		btnNewButton.setIcon(
				new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\Doctor.png"));
		btnNewButton.setBounds(217, 331, 89, 65);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RH Infer = new RH();
			}
		});
		btnNewButton_1.setIcon(
				new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\icon_re.png"));
		btnNewButton_1.setBounds(416, 183, 89, 65);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nurse Infer = new Nurse();
			}
		});
		btnNewButton_2.setIcon(
				new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\Doctor2.png"));
		btnNewButton_2.setBounds(314, 257, 89, 65);
		contentPane.add(btnNewButton_2);
		DateFormat df = new SimpleDateFormat("EEEE d MMMM yyyy HH:mm:ss");
		JLabel lblHorloge = new JLabel();
		lblHorloge.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblHorloge.setBounds(39, 25, 286, 37);
		contentPane.add(lblHorloge);
		Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
            	lblHorloge.setText(df.format(new Date()));
            }
        }, 0, 1000);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\PROXIMEDIA\\Desktop\\img\\Dollarphotoclub_61408582.png"));
		label.setBounds(0, 0, 779, 679);
		contentPane.add(label);
		JPasswordField pf = new JPasswordField();
		int okCxl = JOptionPane.showConfirmDialog(this, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		String password = new String(pf.getPassword());
		if (okCxl == JOptionPane.OK_OPTION && password.equals("java")) {
			JOptionPane.showMessageDialog(this, "Welcome !", "Our JAVA App", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Error !", "Sorry", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}
