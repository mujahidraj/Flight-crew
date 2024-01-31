import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentForm implements ActionListener {

    private JFrame frame;
    private JTextField passengerName;
    private JTextField fromField;
    private JTextField toField;
    private JTextField priceField;
    private JTextField timeField;
    private JTextField dateOfJourneyField;
    private JTextField additionalField1;
    private JTextField additionalField2;
    private JButton bookButton;
    private JButton backButton;
    private JButton logoutButton;
    private JButton dashboardButton;

    public AppointmentForm(String selectedFrom, String selectedTo, double selectedPrice, String selectedTime) {
        frame = new JFrame("Flight Booking Form");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(12, 2));
        frame.getContentPane().setBackground(new Color(0x1D1A31));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        

        Font font = new Font("JetBrains Mono", Font.PLAIN, 20);
        Color lightColor = new Color(0xF5F5F5);

        JLabel titleLabel = new JLabel("Booking Form");
        titleLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 30));
        titleLabel.setForeground(lightColor);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        frame.add(titleLabel);

        // Empty JLabel for alignment
        frame.add(new JLabel());

        JLabel nameLabel = new JLabel("Passenger Name:");
        nameLabel.setFont(font);
        nameLabel.setForeground(lightColor);
        passengerName = new JTextField();

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setFont(font);
        fromLabel.setForeground(lightColor);
        fromField = new JTextField(selectedFrom);
        fromField.setEditable(false);

        JLabel toLabel = new JLabel("To:");
        toLabel.setFont(font);
        toLabel.setForeground(lightColor);
        toField = new JTextField(selectedTo);
        toField.setEditable(false);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(font);
        priceLabel.setForeground(lightColor);
        priceField = new JTextField(Double.toString(selectedPrice));
        priceField.setEditable(false);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setFont(font);
        timeLabel.setForeground(lightColor);
        timeField = new JTextField(selectedTime);
        timeField.setEditable(false);

        JLabel dateOfJourneyLabel = new JLabel("Date Of Journey:");
        dateOfJourneyLabel.setFont(font);
        dateOfJourneyLabel.setForeground(lightColor);
        dateOfJourneyField = new JTextField();

        JLabel additionalLabel1 = new JLabel("Email/Phone No:");
        additionalLabel1.setFont(font);
        additionalLabel1.setForeground(lightColor);
        additionalField1 = new JTextField();

        JLabel additionalLabel2 = new JLabel("PassportNo:");
        additionalLabel2.setFont(font);
        additionalLabel2.setForeground(lightColor);
        additionalField2 = new JTextField();

        bookButton = new JButton("Book Now");
        bookButton.addActionListener(this);
        bookButton.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
        bookButton.setBackground(new Color(0x1D1A31));
        bookButton.setForeground(new Color(0xFFFBFC));
        bookButton.setFocusPainted(false);
        bookButton.setBorder(BorderFactory.createLineBorder(new Color(0xFFFBFC), 2));
        bookButton.setMargin(new Insets(10, 10, 10, 10));

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
        backButton.setBackground(new Color(0x1D1A31));
        backButton.setForeground(new Color(0xFFFBFC));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(new Color(0xFFFBFC), 2));
        backButton.setMargin(new Insets(10, 10, 10, 10));

        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(this);
        logoutButton.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
        logoutButton.setBackground(new Color(0x1D1A31));
        logoutButton.setForeground(new Color(0xFFFBFC));
        logoutButton.setFocusPainted(false);
        logoutButton.setBorder(BorderFactory.createLineBorder(new Color(0xFFFBFC), 2));
        logoutButton.setMargin(new Insets(10, 10, 10, 10));

        dashboardButton = new JButton("Dashboard");
        dashboardButton.addActionListener(this);
        dashboardButton.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
        dashboardButton.setBackground(new Color(0x1D1A31));
        dashboardButton.setForeground(new Color(0xFFFBFC));
        dashboardButton.setFocusPainted(false);
        dashboardButton.setBorder(BorderFactory.createLineBorder(new Color(0xFFFBFC), 2));
        dashboardButton.setMargin(new Insets(10, 10, 10, 10));

        frame.add(nameLabel);
        frame.add(passengerName);
        frame.add(fromLabel);
        frame.add(fromField);
        frame.add(toLabel);
        frame.add(toField);
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(timeLabel);
        frame.add(timeField);
        frame.add(dateOfJourneyLabel);
        frame.add(dateOfJourneyField);
        frame.add(additionalLabel1);
        frame.add(additionalField1);
        frame.add(additionalLabel2);
        frame.add(additionalField2);

        frame.add(backButton);
        frame.add(bookButton);
        frame.add(logoutButton);
        frame.add(dashboardButton);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton) {
            String passenger = passengerName.getText();
            String from = fromField.getText();
            String to = toField.getText();
            double price = Double.parseDouble(priceField.getText());
            String time = timeField.getText();
            String dateOfJourney = dateOfJourneyField.getText();
            String additional1 = additionalField1.getText();
            String additional2 = additionalField2.getText();

            JOptionPane.showMessageDialog(null,
                    "Booking Details:\nPassenger: " + passenger + "\nFrom: " + from + "\nTo: " + to +
                            "\nPrice: $" + price + "\nTime: " + time +
                            "\nDate Of Journey: " + dateOfJourney +
                            "\nEmail/Phone No: " + additional1 +
                            "\nPassport No: " + additional2,
                    "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);

                    frame.setVisible(false);
                    new Payment();
        } else if (e.getSource() == backButton) {
            frame.setVisible(false);
            new TestTableSortFilter();
        } else if (e.getSource() == logoutButton) {
            frame.dispose(); // Close the current form
        } else if (e.getSource() == dashboardButton) {
            frame.setVisible(false);
            // Assuming you have a Dashboard class to go back to the Dashboard form
            new Dashboard();
        }
    }

    public static void main(String[] args) {
        String selectedFrom = "Dhaka";
        String selectedTo = "Bali";
        double selectedPrice = 21900.0;
        String selectedTime = "06:20";
        SwingUtilities.invokeLater(() -> new AppointmentForm(selectedFrom, selectedTo, selectedPrice, selectedTime));
    }
}
