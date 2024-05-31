/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.ui;

import javax.swing.JOptionPane;
import repositories.StudentRepository;
import services.StudentService;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.User;
import app.ui.parent.ParentHomeFrame;
import app.ui.student.StudentHomeFrame;
import app.ui.educator.EducatorHomeFrame;
import services.ParentService;
import repositories.ParentRepository;
import services.EducatorService;
import repositories.EducatorRepository;

/**
 *
 * @author x
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private final StudentService studentService;
    private final EducatorService educatorService;
    private final ParentService parentService;

    public LoginFrame() {
        initComponents();
        this.studentService = new StudentRepository();
        this.educatorService = new EducatorRepository();
        this.parentService = new ParentRepository();
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
        loginButton = new javax.swing.JButton();
        loginButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox<>();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 360));

        jPanel1.setMaximumSize(new java.awt.Dimension(4000, 3000));
        jPanel1.setMinimumSize(new java.awt.Dimension(4000, 3000));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(4000, 3000));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginButton.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/ui/returnIcon3.png"))); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 40, 40));

        loginButton1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        loginButton1.setText("Login");
        loginButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 610, 120, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 54)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 233, 125));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username/ Email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 400, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 190, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Role");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 168, -1));

        username.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 300, 320, 50));

        password.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 390, 320, 50));

        jComboBox1.setEditable(true);
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Parent", "Educator" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 470, 320, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/ui/login mountain1.jpg"))); // NOI18N
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

    private void loginButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButton1ActionPerformed
        
        System.out.println("Login button clicked.");
        
        String enteredUsername = username.getText().trim();
        String enteredPassword = String.valueOf(password.getPassword()).trim();
        String selectedRole = (String) jComboBox1.getSelectedItem();
        
        System.out.println(enteredUsername+" "+enteredPassword+" "+selectedRole);
        
        switch (selectedRole){
            case "Student":
                boolean StudentLoginSuccessful = studentService.getLogin(enteredUsername, enteredPassword);
                System.out.println("Student Login Successful: "+StudentLoginSuccessful);
                if(StudentLoginSuccessful){
                    System.out.println("Login success");
                    JOptionPane.showMessageDialog(this, "Login Successful! Welcome "+enteredUsername);
                    new StudentHomeFrame().setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Login failed. Invalid username or password.");
                }
                break;
            case "Parent":
                boolean ParentLoginSuccessful = parentService.getLogin(enteredUsername, enteredPassword);
                System.out.println("Parent Login Successful: "+ParentLoginSuccessful);
                if(ParentLoginSuccessful){
                    // System.out.println("Login success");
                    JOptionPane.showMessageDialog(this, "Login Successful! Welcome "+enteredUsername);
                    new ParentHomeFrame().setVisible(true);
                    this.dispose();    
                }
                else{
                    //System.out.println("Login failed");
                    JOptionPane.showMessageDialog(this, "Login failed. Invalid username or password.");
                }
                break;
            case "Educator":
                boolean EducatorLoginSuccessful = educatorService.getLogin(enteredUsername, enteredPassword);
                System.out.println("Educator Login Successful: "+EducatorLoginSuccessful);
                if(EducatorLoginSuccessful){
                    //System.out.println("Login success");
                    JOptionPane.showMessageDialog(this, "Login Successful! Welcome "+ enteredUsername);
                    new EducatorHomeFrame().setVisible(true);
                    this.dispose();           
                }
                else{
                    System.out.println("Login failed");
                    JOptionPane.showMessageDialog(this, "Login failed. Invalid username or password.");
                }
                break;
            default:
                JOptionPane.showMessageDialog(this, "Please select a valid role.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        //boolean StudentLoginSuccessful = studentService.getLogin(enteredUsername, enteredPassword);
        //boolean EducatorLoginSuccessful = educatorService.getLogin(enteredUsername, enteredPassword);
        
        /*if(StudentLoginSuccessful){
            JOptionPane.showMessageDialog(this, "Login Successful!");
            new StudentHomeFrame().setVisible(true);
            this.dispose();
            // Redirect user based on the role
            switch(selectedRole){
                case "Student": 
                    // redirect to student homepage
                    new StudentHomeFrame().setVisible(true);
                    break;
                case "Parent":
                    // redirect to parent homepage
                    new ParentHomeFrame().setVisible(true);
                    break;
                case "Educator":
                    // redirect to eudcator homepage
                    new EducatorHomeFrame().setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Please enter correct username or password.", "ERROR", JOptionPane.ERROR_MESSAGE);;
            }
            this.dispose();
        }
        else if(ParentLoginSuccessful){
            JOptionPane.showMessageDialog(this, "Login Successful!");
            new ParentHomeFrame().setVisible(true);
            this.dispose();
        }
        else if(EducatorLoginSuccessful){
            JOptionPane.showMessageDialog(this, "Login Successful! Welcome "+ enteredUsername);
            new EducatorHomeFrame().setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Login failed. Invalid username or password.");
        }
        */
    }//GEN-LAST:event_loginButton1ActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton loginButton1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
