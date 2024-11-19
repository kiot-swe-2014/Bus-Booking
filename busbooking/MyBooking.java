package busbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class MyBooking extends javax.swing.JInternalFrame {

    public MyBooking(String username) {
        initComponents();
        jLabel2.setText(username);
        loadData(username);
    }

    private void loadData(String username) {
        String url = "jdbc:mysql://localhost:3306/busmanage";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM bus_booking WHERE User='" + username + "'")) {

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("User"),
                    rs.getString("Bus_No"),
                    rs.getString("Paid"),
                    rs.getString("Seats"), // Ensure this matches your database column
                    rs.getString("Name")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(),
                                          "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(650, 280));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 27));
        jLabel1.setText("My Booking");

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14));
        jTable1.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"User", "Bus No.", "Paid", "Seats", "Name"} // Updated column name
        ) {
            boolean[] canEdit = new boolean[] {true, true, false, true, true};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(242, 242, 242)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addGap(36, 36, 36))
        );

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bus Booking System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 400);
            frame.setLocationRelativeTo(null); // Center the window

            // Create an instance of MyBooking with a sample username
            MyBooking myBookingFrame = new MyBooking("SampleUser");
            frame.getContentPane().add(myBookingFrame);
            myBookingFrame.setVisible(true);
            frame.setVisible(true);
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}