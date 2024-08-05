package oopjava;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(349, 10, 209, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(306, 70, 101, 38);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(463, 81, 209, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(306, 160, 101, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("GMAIL");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(306, 118, 101, 32);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(463, 126, 209, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(463, 168, 209, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(463, 213, 130, 32);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve user input
                String user = textField.getText();
                String email = textField_1.getText();
                String password = textField_2.getText();
                
             // Check if any of the fields are empty
                if (user.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Stop further execution if any field is empty
                }


             // Save user details to MongoDB
                try {
                    javamongo.saveUserDetails(user, email, password);
                } catch (Exception ex) {
                    // Handle exceptions that occur during the save process
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(contentPane, "Error occurred while saving user details. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Stop further execution if an error occurs
                }

                // Optionally, show a message to indicate successful registration
                JOptionPane.showMessageDialog(contentPane, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                javamongo.setUsername(user);
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            Welcome welcomeFrame = new Welcome();
                            welcomeFrame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                
                // Close the current frame (optional)
                dispose();
            }
        });
	}

}
