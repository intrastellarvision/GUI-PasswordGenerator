import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GUI {
    private JFrame frame;
    private JTextField passwordField;
    private JTextField lengthField;
    private JButton generateButton;
    private JButton encryptButton;

    public GUI() {
        initializeFrame();
        initializeComponents();
        addComponentsToFrame();
        frame.setVisible(true);
    }

    private void initializeFrame() {
        frame = new JFrame("Password Generator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
    }

    private void initializeComponents() {
        passwordField = new JTextField(20);
        passwordField.setEditable(false);

        lengthField = new JTextField(5);
        lengthField.setText("12");

        generateButton = new JButton("Generate Password");
        generateButton.addActionListener(e -> generatePassword());

        encryptButton = new JButton("Encrypt Password");
        encryptButton.addActionListener(e -> encryptPassword());
    }

    private void addComponentsToFrame() {
        frame.add(new JLabel("Password Length: "));
        frame.add(lengthField);
        frame.add(passwordField);
        frame.add(generateButton);
        frame.add(encryptButton);
    }

    private void generatePassword() {
        try {
            int length = Integer.parseInt(lengthField.getText());
            PasswordGeneration generator = new PasswordGeneration();
            String password = generator.generatePassword(length);
            passwordField.setText(password);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number for password length.");
        }
    }

    private void encryptPassword() {
        String password = passwordField.getText();
        String encryptedPassword = EncryptPass.encrypt(password);
        passwordField.setText(encryptedPassword);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
