
package busbooking;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Detail extends javax.swing.JInternalFrame {

    public Detail() {
        initComponents();
        loadData();
    }

    private void loadData() {
        String url = "jdbc:mysql://localhost:3306/busmanage";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT User, Bus_No, Paid, Seats, Name FROM bus_booking")) {

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("User"),
                    rs.getString("Bus_No"),
                    rs.getString("Paid"),
                    rs.getString("Seats"),
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(745, 345));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 27));
        jLabel1.setText("ORDERS");

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14));
        jTable1.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"User", "Bus No.", "Paid", "Seats", "Name"}
        ) {
            boolean[] canEdit = new boolean[] {true, true, false, true, true};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(302, 302, 302)
                    .addComponent(jLabel1)
                    .addContainerGap(312, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bus Booking Detail");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            
            Detail detailFrame = new Detail();
            frame.getContentPane().add(detailFrame);
            detailFrame.setVisible(true);
            frame.setVisible(true);
        });
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
}