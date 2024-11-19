package busbooking;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AViewAll extends javax.swing.JInternalFrame {

    public AViewAll() {
        initComponents();
        loadAdminData();
    }

    private void loadAdminData() {
        Connection con;
        Statement st;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Update driver for MySQL Connector/J 8.x
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanage", "root", "");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM admin");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2)});
            }
        } catch (Exception e) {
            System.out.println(e);
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
        setPreferredSize(new java.awt.Dimension(735, 335));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 36));
        jLabel1.setText("Admins");

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14));
        jTable1.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Password"}));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addGap(298, 298, 298)
                    .addComponent(jLabel1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    // Main method to demonstrate the internal frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Admin View");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);
            frame.setLocationRelativeTo(null); // Center the frame on the screen

            JDesktopPane desktopPane = new JDesktopPane();
            AViewAll viewAll = new AViewAll();
            desktopPane.add(viewAll);
            viewAll.setVisible(true); // Set the internal frame visible

            frame.add(desktopPane, java.awt.BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}