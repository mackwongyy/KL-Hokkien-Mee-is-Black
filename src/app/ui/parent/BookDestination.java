/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.ui.parent;

import app.ui.educator.*;
import app.ui.*;
import javax.swing.JOptionPane;
import repositories.StudentRepository;
import services.StudentService;
import java.sql.*;
import app.ui.parent.BookingTimeSlot; // Import the BookingTimeSlotFrame class



/**
 *
 * @author x
 */
public class BookDestination extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private final StudentService studentService;
    private static String selectedChild;
    
    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }

        public void calculateAndDisplayDistances(String parentUsername) {
            try {
                // Establish database connection
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ds_assignment?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Wdhjbhgq@17@MySQL");

                // Prepare statement to fetch parent's location
                PreparedStatement parentStmt = con.prepareStatement("SELECT location_X, location_Y FROM parents WHERE username = ?");
                parentStmt.setString(1, parentUsername);
                ResultSet parentResult = parentStmt.executeQuery();

                // Fetch parent's location
                double parentX = 0, parentY = 0;
                if (parentResult.next()) {
                    parentX = parentResult.getDouble("location_X");
                    parentY = parentResult.getDouble("location_Y");
                }

                // Prepare statement to fetch destinations
                Statement destStmt = con.createStatement();
                ResultSet destResult = destStmt.executeQuery("SELECT destination_name, coordinate_X, coordinate_Y FROM destination_list");

                // Loop through destinations and calculate distances
                int index = 1;
                while (destResult.next() && index <= 9) {
                    // Fetch destination's coordinates
                    double destX = destResult.getDouble("coordinate_X");
                    double destY = destResult.getDouble("coordinate_Y");

                    // Calculate Euclidean distance
                    double distance = calculateEuclideanDistance(parentX, parentY, destX, destY);

                    // Fetch destination name
                    String destinationName = destResult.getString("destination_name");

                    // Display destination name and distance in kilometers from L1 to L9
                    switch (index) {
                        case 1: L1.setText(destinationName + ": " + String.format("%.2f km", distance));
                                break;
                        case 2: L2.setText(destinationName + ": " + String.format("%.2f km", distance));
                                break;
                        case 3: L3.setText(destinationName + ": " + String.format("%.2f km", distance));
                                break;
                        case 4: L4.setText(destinationName + ": " + String.format("%.2f km", distance));
                                break;
                        case 5: L5.setText(destinationName + ": " + String.format("%.2f km", distance));
                                break;
                        case 6: L6.setText(destinationName + ": " + String.format("%.2f km", distance));
                                break;
                        case 7: L7.setText(destinationName + ": " + String.format("%.2f km", distance));
                                break;
                        case 8: L8.setText(destinationName + ": " + String.format("%.2f km", distance));
                                break;
                        case 9: L9.setText(destinationName + ": " + String.format("%.2f km", distance));
                                break;
                    }

                    index++;
                }

                // Close database connection
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        private void openBookingTimeSlotFrame(String destinationName, String selectedChild) {
            BookingTimeSlot bookingTimeSlot = new BookingTimeSlot(destinationName, selectedChild);
            bookingTimeSlot.setVisible(true);
        }



    public BookDestination(String selectedChild) {
        initComponents();
        this.studentService = new StudentRepository();
        calculateAndDisplayDistances("TanChinPeng");
        this.selectedChild = selectedChild;
    }


    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        B1 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        L4 = new javax.swing.JLabel();
        L1 = new javax.swing.JLabel();
        L2 = new javax.swing.JLabel();
        L3 = new javax.swing.JLabel();
        B5 = new javax.swing.JButton();
        L5 = new javax.swing.JLabel();
        L6 = new javax.swing.JLabel();
        B6 = new javax.swing.JButton();
        L7 = new javax.swing.JLabel();
        B7 = new javax.swing.JButton();
        B8 = new javax.swing.JButton();
        L8 = new javax.swing.JLabel();
        L9 = new javax.swing.JLabel();
        B9 = new javax.swing.JButton();
        parentHomeButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 360));

        jPanel1.setMaximumSize(new java.awt.Dimension(4000, 3000));
        jPanel1.setMinimumSize(new java.awt.Dimension(4000, 3000));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(4000, 3000));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Booking Page");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 580, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255, 80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        B1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        B1.setText("1");
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });
        jPanel2.add(B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 42));

        B2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        B2.setText("2");
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });
        jPanel2.add(B2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 42));

        B3.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        B3.setText("3");
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });
        jPanel2.add(B3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 42));

        B4.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        B4.setText("4");
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });
        jPanel2.add(B4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, 42));

        L4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        L4.setText("jLabel1");
        jPanel2.add(L4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 510, 40));

        L1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        L1.setText("jLabel1");
        jPanel2.add(L1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 500, 40));

        L2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        L2.setText("jLabel1");
        jPanel2.add(L2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 500, 40));

        L3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        L3.setText("jLabel1");
        jPanel2.add(L3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 510, 40));

        B5.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        B5.setText("5");
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });
        jPanel2.add(B5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, 42));

        L5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        L5.setText("jLabel1");
        jPanel2.add(L5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 510, 40));

        L6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        L6.setText("jLabel1");
        jPanel2.add(L6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 690, 40));

        B6.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        B6.setText("6");
        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });
        jPanel2.add(B6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, 42));

        L7.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        L7.setText("jLabel1");
        jPanel2.add(L7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 690, 40));

        B7.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        B7.setText("7");
        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });
        jPanel2.add(B7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, -1, 42));

        B8.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        B8.setText("8");
        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });
        jPanel2.add(B8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, 42));

        L8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        L8.setText("jLabel1");
        jPanel2.add(L8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 690, 40));

        L9.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        L9.setText("jLabel1");
        jPanel2.add(L9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 700, 40));

        B9.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        B9.setText("9");
        B9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B9ActionPerformed(evt);
            }
        });
        jPanel2.add(B9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, -1, 42));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 1350, 530));

        parentHomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/ui/parent/homeButton1.jpg"))); // NOI18N
        parentHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parentHomeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(parentHomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 740, 50, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/ui/booking1.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -180, 1760, 1260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 2257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 557, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2491, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        // TODO add your handling code here:
        openBookingTimeSlotFrame(L1.getText().split(": ")[0], selectedChild);
    }//GEN-LAST:event_B1ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        // TODO add your handling code here:
        openBookingTimeSlotFrame(L2.getText().split(": ")[0], selectedChild);
    }//GEN-LAST:event_B2ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        // TODO add your handling code here:
        openBookingTimeSlotFrame(L3.getText().split(": ")[0], selectedChild);
    }//GEN-LAST:event_B3ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        // TODO add your handling code here:
        openBookingTimeSlotFrame(L4.getText().split(": ")[0], selectedChild);
    }//GEN-LAST:event_B4ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        // TODO add your handling code here:
        openBookingTimeSlotFrame(L5.getText().split(": ")[0], selectedChild);
    }//GEN-LAST:event_B5ActionPerformed

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B6ActionPerformed
        // TODO add your handling code here:
        openBookingTimeSlotFrame(L6.getText().split(": ")[0], selectedChild);
    }//GEN-LAST:event_B6ActionPerformed

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B7ActionPerformed
        // TODO add your handling code here:
        openBookingTimeSlotFrame(L7.getText().split(": ")[0], selectedChild);
    }//GEN-LAST:event_B7ActionPerformed

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B8ActionPerformed
        // TODO add your handling code here:
        openBookingTimeSlotFrame(L8.getText().split(": ")[0], selectedChild);
    }//GEN-LAST:event_B8ActionPerformed

    private void B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B9ActionPerformed
        // TODO add your handling code here:
        openBookingTimeSlotFrame(L9.getText().split(": ")[0], selectedChild);
    }//GEN-LAST:event_B9ActionPerformed

    private void parentHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parentHomeButtonActionPerformed
        // TODO add your handling code here:
        ParentHomeFrame parentHomeFrame = new ParentHomeFrame();
        // Make the BookingForm frame visible
        parentHomeFrame.setVisible(true);

        // Optionally, dispose of the current frame if you want to close it
        dispose();
    }//GEN-LAST:event_parentHomeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    // Set the Nimbus look and feel
    // Your existing code
    
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new BookDestination("selectedChild").setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JButton B6;
    private javax.swing.JButton B7;
    private javax.swing.JButton B8;
    private javax.swing.JButton B9;
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel L5;
    private javax.swing.JLabel L6;
    private javax.swing.JLabel L7;
    private javax.swing.JLabel L8;
    private javax.swing.JLabel L9;
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton parentHomeButton;
    // End of variables declaration//GEN-END:variables
}
