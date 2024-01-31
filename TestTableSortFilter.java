import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestTableSortFilter implements ActionListener {

    private String[] columnNames = {"From", "To", "Price", "Time"};
    private Object[][] data = {
             {"Dhaka", "Bali", "BDT 21,900", "06:20"},
        {"Dhaka", "Bangkok", "BDT 9,000", "20:45"},
        {"Dhaka", "Cairo", "BDT 12,500", "10:25"},
        {"Dhaka", "Cape Town", "BDT 22,400", "16:45"},
        {"Dhaka", "Chicago", "BDT 27,800", "06:30"},
        {"Dhaka", "Dubai", "BDT 18,400", "08:15"},
        {"Dhaka", "Frankfrut", "BDT 20,000", "06:50"},
        {"Dhaka", "Hongkong", "BDT 19,000", "12:00"},
        {"Dhaka", "Istanbul", "BDT 26,700", "10:45"},
        {"Dhaka", "London", "BDT 25,500", "14:35"},
        {"Dhaka" ,"Los Angeles", "BDT 47,300", "22:00"},
        {"Dhaka" ,"Melbourne", "BDT 34,300", "21:00"},
        {"Dhaka" ,"New York", "BDT 47,300", "23:00"},
        {"Dhaka" ,"Paris", "BDT 40,000", "19:30"},
        {"Dhaka" ,"Rome", "BDT 22,200", "08:00"},
        {"Dhaka" ,"San Francisco", "BDT 47,300", "23:40"},
        {"Dhaka" ,"Sanghai", "BDT 24,000", "10:15"},
        {"Dhaka" ,"Singapore", "BDT 10,000", "21:10"},
        {"Dhaka" ,"Sydney", "BDT 27,800", "12:00"},
        {"Dhaka" ,"Toronto", "BDT 35,100", "17:00"}
    };

    private DefaultTableModel model = new DefaultTableModel(data, columnNames);
    private JTable jTable = new JTable(model);

    private TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTable.getModel());
    private JTextField jtfFilter;
    private JButton jbtFilter;

    private JScrollPane sPane;

    private JFrame frame;

    private JTextArea search;
    private JButton back;

    private JButton economic;
    private JButton business;

    private JButton domestic;
    private JButton international;

    private JTextArea title;

    private JButton nextBtn;

    private String selectedFrom;
    private String selectedTo;
    private double selectedPrice;
    private String selectedTime;

    public TestTableSortFilter() {
        jTable.setRowSorter(rowSorter);

        frame = new JFrame();

        jbtFilter = new JButton("Filter");
        jbtFilter.setBounds(50, 300, 100, 30);
        jbtFilter.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        sPane = new JScrollPane(jTable);
        sPane.setBounds(200, 130, 500, 350);
        sPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        jtfFilter = new JTextField();
        jtfFilter.setBounds(430, 50, 300, 30);
        jtfFilter.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        search = new JTextArea();
        search.setText("Search Flights by Location");
        search.setBounds(150, 50, 300, 30);
        search.setFont(new Font("Jetbrains Mono", Font.PLAIN, 16));
        search.setForeground(new Color(0xF5F5F5));
        search.setBackground(null);
        search.setEditable(false);

        title = new JTextArea();
        title.setText("International Flights | Economic Class");
        title.setBounds(265, 100, 450, 30);
        title.setFont(new Font("Jetbrains Mono", Font.PLAIN, 16));
        title.setForeground(new Color(0xD4A017));
        title.setBackground(null);
        title.setEditable(false);

        back = new JButton();
        back.setText("Back");
        back.setBounds(780, 500, 100, 45);
        back.setBackground(new Color(0x1D1A31));
        back.setForeground(new Color(0xFFFBFC));
        back.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
        back.setBorder(null);
        back.setFocusable(false);
        back.addActionListener(this);

        nextBtn = new JButton();
        nextBtn.setText("Next");
        nextBtn.setBounds(670, 500, 100, 45);
        nextBtn.setBackground(new Color(0x1D1A31));
        nextBtn.setForeground(new Color(0xFFFBFC));
        nextBtn.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
        nextBtn.setBorder(null);
        nextBtn.setFocusable(false);
        nextBtn.addActionListener(this);

        economic = new JButton();
        economic.setText("Economic");
        economic.setBounds(65, 200, 100, 45);
        economic.setBackground(new Color(0xFFFBFC));
        economic.setForeground(new Color(0x1D1A31));
        economic.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
        economic.setBorder(null);
        economic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        economic.setFocusable(false);
        economic.addActionListener(this);

        business = new JButton();
        business.setText("Business");
        business.setBounds(65, 300, 100, 45);
        business.setBackground(new Color(0xFFFBFC));
        business.setForeground(new Color(0x1D1A31));
        business.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
        business.setBorder(null);
        business.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        business.setFocusable(false);
        business.addActionListener(this);

        domestic = new JButton();
        domestic.setText("Domestic");
        domestic.setBounds(750, 200, 100, 45);
        domestic.setBackground(new Color(0xFFFBFC));
        domestic.setForeground(new Color(0x1D1A31));
        domestic.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
        domestic.setBorder(null);
        domestic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        domestic.setFocusable(false);
        domestic.addActionListener(this);

        international = new JButton();
        international.setText("International");
        international.setBounds(750, 300, 100, 45);
        international.setBackground(new Color(0xFFFBFC));
        international.setForeground(new Color(0x1D1A31));
        international.setFont(new Font("JetBrains Mono", Font.PLAIN, 10));
        international.setBorder(null);
        international.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        international.setFocusable(false);
        international.addActionListener(this);

        frame.setSize(900, 600);
        frame.setTitle("Flight Crew");
        frame.getContentPane().setBackground(new Color(0x1D1A31));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(jtfFilter);
        frame.add(sPane);
        frame.add(search);
        frame.add(back);
        frame.add(economic);
        frame.add(business);
        frame.add(domestic);
        frame.add(international);
        frame.add(title);
        frame.add(nextBtn);
        
        jtfFilter.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = jTable.getSelectedRow();
                if (selectedRow != -1) {
                    selectedFrom = (String) jTable.getValueAt(selectedRow, 0);
                    selectedTo = (String) jTable.getValueAt(selectedRow, 1);
                    selectedPrice = Double.parseDouble(((String) jTable.getValueAt(selectedRow, 2)).replaceAll("[^\\d.]", ""));
                    selectedTime = (String) jTable.getValueAt(selectedRow, 3);
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            frame.setVisible(false);
            new AppointmentForm(selectedFrom, selectedTo, selectedPrice, selectedTime);
        }

        if (e.getSource() == economic) {
            frame.setVisible(false);
            new TestTableSortFilter();
        }

        if (e.getSource() == business) {
            frame.setVisible(false);
            new TestTableSortFilter2();
        }

        if (e.getSource() == domestic) {
            frame.setVisible(false);
            new TestTableSortFilter3();
        }

        if (e.getSource() == international) {
            frame.setVisible(false);
            new TestTableSortFilter();
        }

        if (e.getSource() == nextBtn) {
            if (selectedFrom != null && selectedTo != null && selectedTime != null) {
                new AppointmentForm(selectedFrom, selectedTo, selectedPrice, selectedTime);
                frame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a flight first.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestTableSortFilter();
            }
        });
    }
}
