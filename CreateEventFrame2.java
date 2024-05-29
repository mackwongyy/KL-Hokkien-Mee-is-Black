import com.toedter.calendar.JDateChooser;
import com.raven.swing.TimePicker;
import javax.swing.*;
import java.awt.event.*;
//ActionEvent, ActionListerner
import org.netbeans.lib.awtextra.*;
//AbsoluteConstraints, AbsoluteLayout

public class CreateEventFrame2 extends javax.swing.JFrame {
    public CreateEventFrame2() {
        initComponents();
    }

    private void initComponents() {
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        timePicker1 = new TimePicker();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(4000, 3000));
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Venue:");
        getContentPane().add(jLabel7, new AbsoluteConstraints(290, 100, -1, -1));

        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        getContentPane().add(jTextField6, new AbsoluteConstraints(720, 100, 670, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Date:");
        getContentPane().add(jLabel8, new AbsoluteConstraints(290, 210, -1, -1));
        getContentPane().add(jDateChooser1, new AbsoluteConstraints(720, 230, 670, 50));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Time:");
        getContentPane().add(jLabel9, new AbsoluteConstraints(290, 340, -1, -1));

        timePicker1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        timePicker1.setMaximumSize(new java.awt.Dimension(200, 300));
        getContentPane().add(timePicker1, new AbsoluteConstraints(720, 340, 690, 340));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setText("Create");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new AbsoluteConstraints(680, 730, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homeButton1.jpg"))); // NOI18N
        getContentPane().add(jButton4, new AbsoluteConstraints(1360, 740, 50, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/event1.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new AbsoluteConstraints(0, -900, 3600, 2700));

        pack();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Implement the action to be taken when the button is clicked
        String venue = jTextField6.getText();
        java.util.Date date = jDateChooser1.getDate();
        String time = timePicker1.getSelectedTime();
        
        // Perform validation or any action you need
        System.out.println("Event Created: " + venue + " on " + date + " at " + time);
    }

    public static void main(String args[]) {
        try {
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch(Exception e) {
            java.util.logging.Logger.getLogger(CreateEventFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateEventFrame2().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton3, jButton4;
    private JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel7, jLabel8, jLabel9, jLabel10;
    private javax.swing.JTextField jTextField6;
    private TimePicker timePicker1;
}