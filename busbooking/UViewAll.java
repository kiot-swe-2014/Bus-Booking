package busbooking;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UViewAll extends javax.swing.JInternalFrame {

    public UViewAll() {
        initComponents();
        loadUserData();
    }

    private void loadUserData() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanage", "root", "");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM user")) {

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                });
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(755, 355));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 27));
        jLabel1.setText("Users");

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14));
        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Name", "Address", "Gender", "Category", "Username", "Password"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(298, 298, 298)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String[] args) {
        // Set the look and feel to the system's default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create the main application frame
        JFrame mainFrame = new JFrame("Bus Booking System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        mainFrame.setLocationRelativeTo(null);

        // Create an instance of UViewAll
        UViewAll uViewAll = new UViewAll();

        // Add the internal frame to a JDesktopPane
        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.add(uViewAll);
        mainFrame.add(desktopPane);

        // Show the internal frame
        uViewAll.setVisible(true);

        // Set the main frame visible
        mainFrame.setVisible(true);
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}