package oopjava;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;



public class Quiz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Vector<String> selectedOptions = new Vector<>();
    Vector<String> answers = new Vector<>();
    public String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz frame = new Quiz();
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
	public Quiz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 10, 850, 500);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(700, 900));
		
		JLabel lblNewLabel = new JLabel("JAVA QUIZ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(324, 10, 180, 54);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1. Who invented Java Programming?");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(21, 104, 742, 47);
		panel.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Guido van Rossum");
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setBounds(21, 140, 112, 21);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("James Gosling");
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		rdbtnNewRadioButton_1.setBounds(21, 157, 113, 21);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Dennis Ritchie");
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_2.setBounds(21, 175, 103, 21);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Bjarne Stroustrup");
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		rdbtnNewRadioButton_3.setBounds(21, 192, 103, 21);
		panel.add(rdbtnNewRadioButton_3);
		
		 ButtonGroup group1 = new ButtonGroup();
	        group1.add(rdbtnNewRadioButton);
	        group1.add(rdbtnNewRadioButton_1);
	        group1.add(rdbtnNewRadioButton_2);
	        group1.add(rdbtnNewRadioButton_3);
	        
	     // Disable focus painting for the radio buttons
	        rdbtnNewRadioButton.setFocusPainted(false);
	        rdbtnNewRadioButton_1.setFocusPainted(false);
	        rdbtnNewRadioButton_2.setFocusPainted(false);
	        rdbtnNewRadioButton_3.setFocusPainted(false);
	        
	        JLabel lblNewLabel_2 = new JLabel("2. Which statement is true about Java?");
	        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	        lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
	        lblNewLabel_2.setBounds(21, 247, 742, 36);
	        panel.add(lblNewLabel_2);
	        
	        JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Java is a sequence-dependent programming language");
	        rdbtnNewRadioButton_4.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_4.setBounds(21, 278, 263, 21);
	        panel.add(rdbtnNewRadioButton_4);
	        
	        JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Java is a code dependent programming language");
	        rdbtnNewRadioButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_5.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_5.setBounds(21, 299, 263, 21);
	        panel.add(rdbtnNewRadioButton_5);
	        
	        JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Java is a platform-dependent programming language");
	        rdbtnNewRadioButton_6.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_6.setBounds(21, 317, 263, 21);
	        panel.add(rdbtnNewRadioButton_6);
	        
	        JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Java is a platform-independent programming language");
	        rdbtnNewRadioButton_7.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_7.setBounds(21, 337, 263, 21);
	        panel.add(rdbtnNewRadioButton_7);
	        
	        ButtonGroup group2 = new ButtonGroup();
	        group2.add(rdbtnNewRadioButton_4);
	        group2.add(rdbtnNewRadioButton_5);
	        group2.add(rdbtnNewRadioButton_6);
	        group2.add(rdbtnNewRadioButton_7);
	        
	     // Disable focus painting for the radio buttons
	        rdbtnNewRadioButton_4.setFocusPainted(false);
	        rdbtnNewRadioButton_5.setFocusPainted(false);
	        rdbtnNewRadioButton_6.setFocusPainted(false);
	        rdbtnNewRadioButton_7.setFocusPainted(false);
	        
	        JLabel lblNewLabel_3 = new JLabel("3. Which component is used to compile, debug and execute the java programs?");
	        lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
	        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	        lblNewLabel_3.setBounds(21, 393, 742, 36);
	        panel.add(lblNewLabel_3);
	        
	        JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("JRE");
	        rdbtnNewRadioButton_8.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_8.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_8.setBounds(21, 424, 103, 21);
	        panel.add(rdbtnNewRadioButton_8);
	        
	        JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("JDK");
	        rdbtnNewRadioButton_9.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_9.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_9.setBounds(21, 461, 103, 21);
	        panel.add(rdbtnNewRadioButton_9);
	        
	        JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("JIT");
	        rdbtnNewRadioButton_10.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_10.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_10.setBounds(21, 443, 103, 21);
	        panel.add(rdbtnNewRadioButton_10);
	        
	        JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("JVM");
	        rdbtnNewRadioButton_11.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_11.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_11.setBounds(21, 481, 103, 21);
	        panel.add(rdbtnNewRadioButton_11);
	        
	        ButtonGroup group3 = new ButtonGroup();
	        group3.add(rdbtnNewRadioButton_8);
	        group3.add(rdbtnNewRadioButton_9);
	        group3.add(rdbtnNewRadioButton_10);
	        group3.add(rdbtnNewRadioButton_11);
	        
	     // Disable focus painting for the radio buttons
	        rdbtnNewRadioButton_8.setFocusPainted(false);
	        rdbtnNewRadioButton_9.setFocusPainted(false);
	        rdbtnNewRadioButton_10.setFocusPainted(false);
	        rdbtnNewRadioButton_11.setFocusPainted(false);
	        
	        JLabel lblNewLabel_4 = new JLabel("4. Which one of the following is not a Java feature?");
	        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	        lblNewLabel_4.setBounds(21, 529, 742, 36);
	        panel.add(lblNewLabel_4);
	        
	        JRadioButton rdbtnNewRadioButton_12 = new JRadioButton("Object-oriented");
	        rdbtnNewRadioButton_12.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_12.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_12.setBounds(21, 560, 103, 21);
	        panel.add(rdbtnNewRadioButton_12);
	        
	        JRadioButton rdbtnNewRadioButton_13 = new JRadioButton("Use of pointers");
	        rdbtnNewRadioButton_13.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_13.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_13.setBounds(21, 580, 103, 21);
	        panel.add(rdbtnNewRadioButton_13);
	        
	        JRadioButton rdbtnNewRadioButton_14 = new JRadioButton("Portable");
	        rdbtnNewRadioButton_14.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_14.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_14.setBounds(21, 598, 103, 21);
	        panel.add(rdbtnNewRadioButton_14);
	        
	        JRadioButton rdbtnNewRadioButton_15 = new JRadioButton("Dynamic and Extensible");
	        rdbtnNewRadioButton_15.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_15.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_15.setBounds(21, 615, 139, 21);
	        panel.add(rdbtnNewRadioButton_15);
	        
	        
	        ButtonGroup group4 = new ButtonGroup();
	        group4.add(rdbtnNewRadioButton_12);
	        group4.add(rdbtnNewRadioButton_13);
	        group4.add(rdbtnNewRadioButton_14);
	        group4.add(rdbtnNewRadioButton_15);
	        
	     // Disable focus painting for the radio buttons
	        rdbtnNewRadioButton_12.setFocusPainted(false);
	        rdbtnNewRadioButton_13.setFocusPainted(false);
	        rdbtnNewRadioButton_14.setFocusPainted(false);
	        rdbtnNewRadioButton_15.setFocusPainted(false);
	        
	        JLabel lblNewLabel_5 = new JLabel("5. Which of these cannot be used for a variable name in Java?");
	        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	        lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
	        lblNewLabel_5.setBounds(21, 668, 742, 36);
	        panel.add(lblNewLabel_5);
	        
	        JRadioButton rdbtnNewRadioButton_16 = new JRadioButton("Identifier & Keyword");
	        rdbtnNewRadioButton_16.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_16.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_16.setBounds(21, 701, 139, 21);
	        panel.add(rdbtnNewRadioButton_16);
	        
	        JRadioButton rdbtnNewRadioButton_17 = new JRadioButton("Identifier");
	        rdbtnNewRadioButton_17.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_17.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_17.setBounds(21, 720, 103, 21);
	        panel.add(rdbtnNewRadioButton_17);
	        
	        JRadioButton rdbtnNewRadioButton_18 = new JRadioButton("Keyword");
	        rdbtnNewRadioButton_18.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_18.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_18.setBounds(21, 737, 103, 21);
	        panel.add(rdbtnNewRadioButton_18);
	        
	        JRadioButton rdbtnNewRadioButton_19 = new JRadioButton("None of the mentioned");
	        rdbtnNewRadioButton_19.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        rdbtnNewRadioButton_19.setHorizontalAlignment(SwingConstants.LEFT);
	        rdbtnNewRadioButton_19.setBounds(21, 754, 139, 21);
	        panel.add(rdbtnNewRadioButton_19);
	        
	        ButtonGroup group5 = new ButtonGroup();
	        group5.add(rdbtnNewRadioButton_16);
	        group5.add(rdbtnNewRadioButton_17);
	        group5.add(rdbtnNewRadioButton_18);
	        group5.add(rdbtnNewRadioButton_19);
	        
	     // Disable focus painting for the radio buttons
	        rdbtnNewRadioButton_16.setFocusPainted(false);
	        rdbtnNewRadioButton_17.setFocusPainted(false);
	        rdbtnNewRadioButton_18.setFocusPainted(false);
	        rdbtnNewRadioButton_19.setFocusPainted(false);
	        
	        JButton btnNewButton = new JButton("Submit");
	        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        btnNewButton.setBounds(31, 781, 85, 21);
	        panel.add(btnNewButton);
	        
	        
	        
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Iterate through radio button groups
	                ButtonGroup[] groups = {group1, group2, group3, group4, group5};
	                for (ButtonGroup group : groups) {
	                    String selectedOption = getSelectedButtonText(group);
	                    if (selectedOption == null) {
	                        selectedOption = ""; // Save empty string if no option is selected
	                    }
	                    selectedOptions.add(selectedOption);
	                }
	                
	                // Print or use the selected options
	                //System.out.println("Selected options: " + selectedOptions);
	                //populateRadioButtons();
	                retrieveAnswersFromMongoDB();
	            }
	        });
	    }
	
	    //public String 
	    public Quiz(String username) {
		// TODO Auto-generated constructor 
	    	super();
	    	this.username = username;
	}

		// Helper method to get the selected radio button's text
	    public String getSelectedButtonText(ButtonGroup group) {
	        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();
	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }
	        return null; // Return null if no button is selected
	}
	    
	    public void retrieveAnswersFromMongoDB() {
	        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
	            // Access the database
	            MongoDatabase database = mongoClient.getDatabase("JAVA");

	            // Access the collection
	            MongoCollection<Document> collection = database.getCollection("ANSWERS");

	            // Query the document
	            Document query = new Document();
	            query.append("_id", new org.bson.types.ObjectId("660f92345d1a9b3829646238")); // Assuming you know the ObjectID of the document

	            // Execute the query
	            MongoCursor<Document> cursor = collection.find(query).iterator();

	            // Process the result
	            if (cursor.hasNext()) {
	                Document document = cursor.next();
	                try {
	                    @SuppressWarnings("unchecked")
						Vector<String> answers = new Vector<>((ArrayList<String>) document.get("answers"));
	                    // Now you can use the 'answers' vector as needed
	                    // For example, you can pass it to another method to populate the radio buttons
	                    populateRadioButtons(answers, selectedOptions);
	                } catch (ClassCastException e) {
	                    // Handle the ClassCastException
	                    System.err.println("Error casting document.get(\"answers\") to ArrayList<String>: " + e.getMessage());
	                    // Handle the situation where the cast fails, perhaps provide a default value or notify the user
	                    // For example, you might initialize 'answers' with an empty vector or show an error message to the user
	                    // You might also choose to  the exception or handle it differently based on your application's needs
	                }
	            } else {
	                System.out.println("Document not found");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    private void populateRadioButtons(Vector<String> answers,Vector<String> selectedOptions) {
	        int score = 0;
	        for (int i = 0; i < answers.size(); i++) {
	            if (answers.get(i).equals((String)selectedOptions.get(i))) {
	                score++;
	            }
	        }
	        displayScore(score); // Call the displayScore method to show the score
	    }
	    
	    public void setUsername(String username) {
			// TODO Auto-generated method stub
			this.username = username;	
		}
	    
	    
	    // Display the score in a message window
	    private void displayScore(int score) {
	        // Update the document with the user's score
	        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
	            // Access the database
	            MongoDatabase database = mongoClient.getDatabase("JAVA");

	            // Access the collection
	            MongoCollection<Document> collection = database.getCollection("USERS");

	            // Query the document based on the 
	            Document query = new Document();
	            query.append("user", javamongo.getUsername());

	            // Update the document
	            Document update = new Document();
	            update.append("$set", new Document("score", score));

	            // Perform the update operation
	            collection.updateOne(query, update);

	            // Display the score in a message window
	            JOptionPane.showMessageDialog(this, "\nScore: " + score, "Quiz Result", JOptionPane.INFORMATION_MESSAGE);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	     // Close the current frame (optional)
            dispose();
	    }

		

}
