
package busbooking;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DeleteBus extends javax.swing.JInternalFrame {

    public DeleteBus() {
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
        setPreferredSize(new java.awt.Dimension(750, 350));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 27));
        jLabel1.setText("Delete Bus");

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14));
        jTable1.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Bus No.", "Source", "Destination", "Time", "Price", "Seats"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addGap(282, 282, 282)
                    .addComponent(jLabel1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String busno = (String) model.getValueAt(index, 0);

        int result = JOptionPane.showConfirmDialog(null, "Want to Delete? ", "Sure !!!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            Connection con;
            Statement st;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanage", "root", "");
                String query = "DELETE FROM bus_detail WHERE bus_no='" + busno + "'";
                st = con.createStatement();
                int i = st.executeUpdate(query);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Deleted Successfully", "Done", JOptionPane.PLAIN_MESSAGE);
                    DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
                    model2.removeRow(index);
                }
                st.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    // Main method to demonstrate the internal frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Delete Bus");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);
            frame.setLocationRelativeTo(null); // Center the frame on the screen

            JDesktopPane desktopPane = new JDesktopPane();
            DeleteBus deleteBus = new DeleteBus();
            desktopPane.add(deleteBus);
            deleteBus.setVisible(true); // Set the internal frame visible

            frame.add(desktopPane);
            frame.setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}