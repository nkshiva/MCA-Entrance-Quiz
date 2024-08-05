package oopjava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import javax.swing.JPasswordField;

import org.bson.Document;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;


public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField password;
	public String username ; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("Welcome To Quiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(378, 22, 128, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(310, 75, 101, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(310, 128, 101, 36);
		contentPane.add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setBounds(440, 137, 222, 19);
		contentPane.add(password);
		password.setColumns(10);
		
		uname = new JTextField();
		uname.setBounds(440, 87, 222, 19);
		contentPane.add(uname);
		uname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New User ? Click on register");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(310, 278, 352, 36);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(310, 340, 101, 29);
		btnNewButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Open registration interface when register button is clicked
		        Register register = new Register();
		        register.setVisible(true);
		        dispose(); // Close the current login window
		    }
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Perform login authentication here
                username = uname.getText();
                String pwd = new String(password.getPassword());
                // Add your authentication logic here
                MongoCollection<Document> collection = javamongo.getUsersCollection();

                Document user = collection.find(Filters.and(Filters.eq("user", username), Filters.eq("password", pwd)))
                                          .projection(Projections.include("_id")).first();
                
                if (user != null) {
                	login.this.username = username;
                	javamongo.setUsername(username);
                    // Display a message window for 10 seconds
                    JOptionPane.showMessageDialog(contentPane, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Timer timer = new Timer(10000, new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            dispose(); // Close the current login window
                            // Open the next interface/frame here
                            Welcome welcomeFrame = new Welcome();
                            welcomeFrame.setVisible(true);
                            //Quiz quizFrame = new Quiz(username);
                        }
                    });
                    timer.setRepeats(false); // Only execute once
                    timer.start();
                } else {
                    // Display an error message if authentication fails
                    JOptionPane.showMessageDialog(contentPane, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(440, 179, 101, 36);
		contentPane.add(btnNewButton_1);
		
		
	}
}
