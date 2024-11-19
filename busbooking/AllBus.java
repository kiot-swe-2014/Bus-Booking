package busbooking;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AllBus extends javax.swing.JInternalFrame {

    public AllBus() {
        initComponents();
        loadBusData();
    }

    private void loadBusData() {
        Connection con;
        Statement st;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Update driver for MySQL Connector/J 8.x
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanage", "root", "");
            String query = "SELECT * FROM bus_detail";
            st = con.createStatement();
            rs = st.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("bus_no"),
                    rs.getString("source"),
                    rs.getString("destination"),
                    rs.getString("time"),
                    rs.getString("price"),
                    rs.getString("seats")
                });
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
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
        jLabel1.setText("All Buses");

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14));
        jTable1.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Bus No.", "Source", "Destination", "Time", "Price", "Seats"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(301, 301, 301))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }

    // Main method to demonstrate the internal frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("All Buses");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);
            frame.setLocationRelativeTo(null); // Center the frame on the screen

            JDesktopPane desktopPane = new JDesktopPane();
            AllBus allBus = new AllBus();
            desktopPane.add(allBus);
            allBus.setVisible(true); // Set the internal frame visible

            frame.add(desktopPane, java.awt.BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}