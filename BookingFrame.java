import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingFrame implements ActionListener {
    private JTextField fromField, toField, priceField, timeField;
    private JTextField nameField, emailField;  // Example personal info fields

    JFrame frame;
 
    public BookingFrame(String from, String to, double price, String time) {
        // Set up the booking frame
        frame = new JFrame();
        frame.setTitle("Booking Form");
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // Create components
        fromField = new JTextField(from);
        toField = new JTextField(to);
        priceField = new JTextField(String.valueOf(price));
        timeField = new JTextField(time);
        nameField = new JTextField();
        emailField = new JTextField();

        // Set up the layout
        frame.setLayout(new GridLayout(6, 2));
        frame.add(new JLabel("From:"));
        frame.add(fromField);
        frame.add(new JLabel("To:"));
        frame.add(toField);
        frame.add(new JLabel("Price:"));
        frame.add(priceField);
        frame.add(new JLabel("Time:"));
        frame.add(timeField);
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Email:"));
        frame.add(emailField);

        // Add a button or any other components for the booking process if needed
        // ...

        // You can add action listeners or methods here to handle the booking process
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
