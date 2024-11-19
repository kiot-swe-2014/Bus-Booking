package busbooking;

import java.sql.*;
import javax.swing.*;

public class AddBus extends javax.swing.JInternalFrame {

    public AddBus() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        t6 = new javax.swing.JTextField();
        cb1 = new javax.swing.JComboBox<>();
        cb2 = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(770, 370));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 27));
        jLabel1.setText("Add Bus Detail");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 19));
        jLabel2.setText("Bus No.");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 19));
        jLabel3.setText("Source");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 19));
        jLabel4.setText("Destination");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 19));
        jLabel5.setText("Time");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 19));
        jLabel6.setText("Price");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 19));
        jLabel7.setText("Seats");

        jButton1.setFont(new java.awt.Font("Verdana", 0, 19));
        jButton1.setText("Save");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 19));
        jButton2.setText("Reset");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        t1.setFont(new java.awt.Font("Verdana", 0, 18));
        t2.setFont(new java.awt.Font("Verdana", 0, 18));
        t5.setFont(new java.awt.Font("Verdana", 0, 18));
        t6.setFont(new java.awt.Font("Verdana", 0, 18));

        cb1.setFont(new java.awt.Font("Verdana", 0, 18));
        cb1.setModel(new DefaultComboBoxModel<>(new String[]{" ", "Bahirdar", "Dessie", "AA"})); // Add other locations as needed

        cb2.setFont(new java.awt.Font("Verdana", 0, 18));
        cb2.setModel(new DefaultComboBoxModel<>(new String[]{" ", "Bahirdar", "Dessie", "AA"})); // Add other locations as needed

        // Layout setup
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(232, 232, 232)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(188, 188, 188)
                    .addComponent(jButton1)
                    .addGap(134, 134, 134)
                    .addComponent(jButton2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3))
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(t5)
                                .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(93, 93, 93)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addGap(51, 51, 51)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(t2)
                        .addComponent(cb2, 0, 160, Short.MAX_VALUE)
                        .addComponent(t6))
                    .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addGap(51, 51, 51))
        );

        pack();
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Update driver for MySQL Connector/J 8.x
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanage", "root", "");
            st = con.createStatement();
            String s = "INSERT INTO bus_detail (bus_no, source, destination, time, price, seats) VALUES('"
                    + t1.getText() + "','"
                    + cb1.getSelectedItem() + "','"
                    + cb2.getSelectedItem() + "','"
                    + t2.getText() + "',"
                    + Integer.parseInt(t5.getText()) + ","
                    + Integer.parseInt(t6.getText()) + ")";
            int x = st.executeUpdate(s);
            if (x > 0) {
                JOptionPane.showMessageDialog(this, "Bus Added Successfully", "Alert", JOptionPane.PLAIN_MESSAGE);
                resetFields();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        resetFields();
    }

    private void resetFields() {
        t1.setText("");
        t2.setText("");
        cb1.setSelectedIndex(0);
        cb2.setSelectedIndex(0);
        t5.setText("");
        t6.setText("");
    }

    // Main method to demonstrate the internal frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Add Bus");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);
            frame.setLocationRelativeTo(null); // Center the frame on the screen

            JDesktopPane desktopPane = new JDesktopPane();
            AddBus addBus = new AddBus();
            desktopPane.add(addBus);
            addBus.setVisible(true); // Set the internal frame visible

            frame.add(desktopPane, java.awt.BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t5;
    private javax.swing.JTextField t6;
}