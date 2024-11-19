
package busbooking;
import java.sql.*;
import javax.swing.*;

public class AddAdmin extends javax.swing.JInternalFrame {

    public AddAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        t2 = new javax.swing.JPasswordField();
        t1 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(740, 340));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 27));
        jLabel1.setText("Add Admin");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel3.setText("Password");

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18));
        jButton1.setText("Add");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        t2.setFont(new java.awt.Font("Verdana", 0, 18));
        t1.setFont(new java.awt.Font("Verdana", 0, 18));

        // Layout setup
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(215, 215, 215)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addGap(110, 110, 110)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(t1)
                        .addComponent(t2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(282, 282, 282)
                    .addComponent(jLabel1))
                .addGroup(layout.createSequentialGroup()
                    .addGap(316, 316, 316)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jLabel1)
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(104, 104, 104))
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
            String s = "INSERT INTO admin (username, password) VALUES('" + t1.getText() + "','" + t2.getText() + "')";
            st.executeUpdate(s);
            JOptionPane.showMessageDialog(this, "Admin added successfully!");
            t1.setText("");
            t2.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // Main method to demonstrate the internal frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Add Admin");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);
            frame.setLocationRelativeTo(null); // Center the frame on the screen

            JDesktopPane desktopPane = new JDesktopPane();
            AddAdmin addAdmin = new AddAdmin();
            desktopPane.add(addAdmin);
            addAdmin.setVisible(true); // Set the internal frame visible

            frame.add(desktopPane, java.awt.BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField t2;
    private javax.swing.JTextField t1;
}