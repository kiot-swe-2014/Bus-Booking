package busbooking;

import java.awt.GridLayout;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class NewBooking extends javax.swing.JInternalFrame {
    int index;
    Connection con; // Declare connection at the class level

    public NewBooking(String u) {
        initComponents();
        jLabel2.setText(u);
        loadUserBookings(); // Load bookings for the user on initialization
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cb2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(810, 350));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 27));
        jLabel6.setText("Add Booking ");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14));
        jLabel3.setText("Source");

        cb1.setFont(new java.awt.Font("Verdana", 0, 14));
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{" ", "Bahirdar", "Adama", "Dessie", "AA", "Kombolcha", "Hawassa"}));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14));
        jLabel4.setText("Destination");

        cb2.setFont(new java.awt.Font("Verdana", 0, 14));
        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{" ", "Kombolcha", "Adama", "Dessie", "AA", "Hawassa"}));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 14));
        jButton1.setText("Search");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14));
        jLabel5.setText("Search Result ....");

        jTable6.setFont(new java.awt.Font("Verdana", 0, 14));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Username", "Bus No.", "Paid", "Seats", "Name"
                }
        ));
        jScrollPane6.setViewportView(jTable6);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14));
        jLabel1.setText("Your Booking ...");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Bus No.", "Source", "Destination", "Time", "Price", "Seats"
                }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(316, 316, 316)
                                                                .addComponent(jLabel6))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel3)
                                                                .addGap(19, 19, 19)
                                                                .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(jLabel4)
                                                                .addGap(30, 30, 30)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jButton1)
                                                                        .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }

    private void loadUserBookings() {
        Statement stt;
        ResultSet rss;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanage", "root", "");
            stt = con.createStatement();
            String ss = "SELECT * FROM bus_booking WHERE User='" + jLabel2.getText() + "'";
            rss = stt.executeQuery(ss);
            DefaultTableModel model2 = (DefaultTableModel) jTable6.getModel();
            while (rss.next()) {
                model2.addRow(new Object[]{rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4), rss.getString(5)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel model0 = (DefaultTableModel) jTable4.getModel();
        int x = model0.getRowCount();
        if (x != 0) {
            for (int i = 0; i < x; i++) {
                model0.removeRow(0);
            }
        }
        Statement st;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanage", "root", "");
            String s = "SELECT * FROM bus_detail WHERE Source='" + cb1.getSelectedItem() + "' AND Destination='" + cb2.getSelectedItem() + "'";
            st = con.createStatement();
            rs = st.executeQuery(s);
            DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {
    index = jTable4.getSelectedRow();
    DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
    String bus_no = (String) model.getValueAt(index, 0);
    String source = (String) model.getValueAt(index, 1);
    String dest = (String) model.getValueAt(index, 2);
    String time = (String) model.getValueAt(index, 3);
    String price = (String) model.getValueAt(index, 4);
    String avail_seat = (String) model.getValueAt(index, 5);

    // Create the booking form dialog
    BookingFormFrame = new JFrame();
    BookingFormPanel = new JPanel();
    GridLayout gl = new GridLayout(0, 4);
    
    JLabel l1 = new JLabel("Bus No");
    JLabel l11 = new JLabel(bus_no);
    JLabel l3 = new JLabel("Source");
    JLabel l13 = new JLabel(source);
    JLabel l4 = new JLabel("Dest");
    JLabel l14 = new JLabel(dest);
    JLabel l6 = new JLabel("Time");
    JLabel l16 = new JLabel(time);
    JLabel l7 = new JLabel("Price per Seat");
    JLabel l17 = new JLabel(price); // Show price per seat
    JLabel l8 = new JLabel("Available Seat");
    JLabel l18 = new JLabel(avail_seat);
    JLabel seatnoL = new JLabel("Seats");
    JLabel fnameL = new JLabel("First Name");
    JTextField t1 = new JTextField(20); // Input for number of seats
    JTextField t3 = new JTextField(20); // Input for first name

    BookingFormFrame.getContentPane().add(BookingFormPanel);
    BookingFormPanel.setLayout(gl);

    // Add labels and fields to the panel
    BookingFormPanel.add(l1);
    BookingFormPanel.add(l11);
    BookingFormPanel.add(l3);
    BookingFormPanel.add(l13);
    BookingFormPanel.add(l4);
    BookingFormPanel.add(l14);
    BookingFormPanel.add(l6);
    BookingFormPanel.add(l16);
    BookingFormPanel.add(l7);
    BookingFormPanel.add(l17);
    BookingFormPanel.add(l8);
    BookingFormPanel.add(l18);
    BookingFormPanel.add(seatnoL);
    BookingFormPanel.add(t1);
    BookingFormPanel.add(fnameL);
    BookingFormPanel.add(t3);

    int result = JOptionPane.showConfirmDialog(BookingFormFrame, BookingFormPanel, "Booking Form", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
        String booking_user = jLabel2.getText();
        String seatno = t1.getText(); // This is the number of seats to book
        String first_tname = t3.getText();

        int numberOfSeats = Integer.parseInt(seatno);
        int pricePerSeat = Integer.parseInt(price); // The price for one seat

        // Set Paid to be equal to the price for one seat
        int paidAmount = pricePerSeat; // Assuming you want to charge for one seat only

        int remaining_seat = Integer.parseInt(avail_seat) - numberOfSeats;

        // Insert booking into the database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanage", "root", "");
            Statement st = con.createStatement();

            // Insert the booking with the paid amount set to the price of one seat
            String insertQuery = "INSERT INTO bus_booking (User, Bus_no, Paid, Seats, Name) VALUES ('" + booking_user + "', '" + bus_no + "', '" + paidAmount + "', '" + seatno + "', '" + first_tname + "')";
            int i = st.executeUpdate(insertQuery);
            if (i == 1) {
                // Update available seats in bus_detail
                String updateQuery = "UPDATE bus_detail SET Seats='" + remaining_seat + "' WHERE Bus_no='" + bus_no + "'";
                int j = st.executeUpdate(updateQuery);
                if (j == 1) {
                    JOptionPane.showMessageDialog(null, "Booking Done. Total Paid: " + paidAmount);
                    reloadUserBookings(); // Refresh user bookings after successful booking
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

    private void reloadUserBookings() {
        DefaultTableModel model0 = (DefaultTableModel) jTable6.getModel();
        model0.setRowCount(0); // Clear existing rows
        loadUserBookings(); // Reload bookings for the user
    }

    public static void main(String[] args) {
        String username = "YourUsername"; // Change this to the actual username you want to use
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bus Booking System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);
            frame.setLocationRelativeTo(null);

            NewBooking newBookingFrame = new NewBooking(username); // Pass the username here
            frame.getContentPane().add(newBookingFrame);
            frame.setVisible(true);
            newBookingFrame.setVisible(true);
        });
    }

    GridLayout gl;
    public JFrame BookingFormFrame;
    public JPanel BookingFormPanel;

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable6;
    // End of variables declaration
}