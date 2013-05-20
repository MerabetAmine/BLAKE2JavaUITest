package blake2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class BLAKE2bUI {

	private JFrame frame;
	private JTextField inputBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BLAKE2bUI window = new BLAKE2bUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BLAKE2bUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inputBox = new JTextField();
		frame.getContentPane().add(inputBox, BorderLayout.NORTH);
		inputBox.setColumns(10);
		
		final JLabel outputLabel = new JLabel("null");
		frame.getContentPane().add(outputLabel, BorderLayout.WEST);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputString = null;
				String outputString = null;
				byte[] inputBytes = null;
				byte[] outputBytes = null;
				
				inputString = inputBox.getText();
				inputBytes = inputString.getBytes();
				
				BLAKE2BHasher hasher = new BLAKE2BHasher();
				
				try {
					outputBytes = hasher.ComputeHash(inputBytes);
					//outputString = hasher.toString();
					outputString = BLAKE2bAlgorithm.bytesToHex(outputBytes);
					//outputString += outputString.length();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				outputLabel.setText(outputString);
				hasher.Reset();
				hasher = null;
				
			}
		});
		frame.getContentPane().add(calculateButton, BorderLayout.SOUTH);
	}

}
