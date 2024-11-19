package busbooking;

import java.sql.*;
import javax.swing.*;

public class EditAdmin extends javax.swing.JInternalFrame {

    public EditAdmin(String username) {
        initComponents();
        jLabel3.setText(username);
        loadAdminData(username);
    }

    private void loadAdminData(String username) {
        String url = "jdbc:mysql://localhost:3306/busmanage";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM admin WHERE Username='" + username + "'")) {

            if (rs.next()) {
                jTextField1.setText(rs.getString("Password"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading admin data: " + e.getMessage(),
                                          "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(750, 350));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 27));
        jLabel1.setText("Edit Admin");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 20));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel4.setText("Old Password");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel5.setText("New Password");

        jTextField1.setFont(new java.awt.Font("Verdana", 0, 18));

        jPasswordField2.setFont(new java.awt.Font("Verdana", 0, 18));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18));
        jButton1.setText("Save");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(180, 180, 180)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(125, 125, 125)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jPasswordField2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jButton1)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(110, 110, 110)))
                    .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGap(33, 33, 33)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jButton1)
                    .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        String url = "jdbc:mysql://localhost:3306/busmanage";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String newPassword = jPasswordField2.getText();
            String oldPassword = jTextField1.getText();
            String query = "UPDATE admin SET Password=? WHERE Password=?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, newPassword);
                pst.setString(2, oldPassword);
                int affectedRows = pst.executeUpdate();
                
                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(this, "Password updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Old password is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            jTextField1.setText(newPassword);
            jPasswordField2.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating password: " + e.getMessage(),
                                          "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration

    // Main method to demonstrate the EditAdmin window
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Edit Admin");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);
            EditAdmin editAdminFrame = new EditAdmin("admin_username"); // Replace with actual username
            frame.getContentPane().add(editAdminFrame);
            frame.setVisible(true);
            editAdminFrame.setVisible(true);
        });
    }
}