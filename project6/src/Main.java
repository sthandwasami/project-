import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

// Main class - Entry point of the application
public class Main {
    public static void main(String[] args) {
        // Start the application by showing the login frame
        javax.swing.SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}

// LoginFrame class - Manages user login functionality
class LoginFrame extends JFrame {
    private UserManager userManager;

    public LoginFrame() {
        userManager = new UserManager(); // Initialize UserManager to manage user data

        // Set up the frame properties
        setTitle("Secure Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Align buttons in a row
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        // Add buttons to the button panel
        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);

        // Panel to hold login components
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.WHITE); // White background for the login panel
        loginPanel.setLayout(new GridLayout(2, 2)); // 2 rows, 2 columns

        // UI components for username and password input
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        // Add components to the login panel
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);

        // Action listener for login button
        loginButton.addActionListener(e -> handleLogin(usernameField.getText(), new String(passwordField.getPassword())));
        // Action listener for sign-up button
        signupButton.addActionListener(e -> new SignupFrame(userManager).setVisible(true));

        // Add the button panel and login panel to the frame
        add(buttonPanel, BorderLayout.NORTH);
        add(loginPanel, BorderLayout.CENTER);
        add(new JLabel(new ImageIcon("resources/bubble_animation.gif")), BorderLayout.SOUTH); // Bubble animation
    }

    private void handleLogin(String username, String password) {
        // Check if the user credentials are valid
        if (userManager.validateUser(username, password)) {
            // Show user information frame on successful login
            new UserInfoFrame(username, "H230487B").setVisible(true);
            dispose(); // Close the login frame
        } else {
            JOptionPane.showMessageDialog(this, "Login failed. Please try again.");
        }
    }
}

// SignupFrame class - Manages user registration functionality
class SignupFrame extends JFrame {
    private UserManager userManager;

    public SignupFrame(UserManager userManager) {
        this.userManager = userManager; // Reference to UserManager for user operations

        // Set up the frame properties
        setTitle("Secure Sign Up");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // UI components for username and password input
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton signupButton = new JButton("Sign Up");

        // Add components to the frame
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(signupButton);

        // Action listener for sign-up button
        signupButton.addActionListener(e -> {
            if (userManager.registerUser(usernameField.getText(), new String(passwordField.getPassword()))) {
                JOptionPane.showMessageDialog(this, "Registration successful!");
                dispose(); // Close signup frame after successful registration
            } else {
                JOptionPane.showMessageDialog(this, "Username already exists. Please choose another.");
            }
        });
    }
}

// UserManager class - Handles user registration and authentication
class UserManager {
    private Map<String, String> users; // Storage for user credentials

    public UserManager() {
        users = new HashMap<>(); // Initialize the user storage
    }

    // Validate user credentials
    public boolean validateUser(String username, String password) {
        String storedPassword = users.get(username); // Retrieve stored password
        return storedPassword != null && storedPassword.equals(password); // Check password match
    }

    // Register a new user
    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        users.put(username, password); // Store username and password
        return true; // Registration successful
    }
}

// UserInfoFrame class - Displays user information after successful login
class UserInfoFrame extends JFrame {
    public UserInfoFrame(String username, String regNumber) {
        setTitle("User Info");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        add(new JLabel("Welcome, " + username + "!", SwingConstants.CENTER));
        add(new JLabel("Registration Number: " + regNumber, SwingConstants.CENTER));
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> dispose());
        add(logoutButton);
    }
}