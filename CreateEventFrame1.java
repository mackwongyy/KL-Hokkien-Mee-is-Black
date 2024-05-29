import javax.swing.*;
//GroupLayout, LayoutStyle

public class CreateEventFrame1 extends javax.swing.JFrame {
    public CreateEventFrame1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField(); // Venue
        jTextField5 = new javax.swing.JTextField(); // Date
        jTextField6 = new javax.swing.JTextField(); // Time
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); 
        jLabel2.setText("Create Event");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); 
        jLabel4.setText("Title:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); 
        jLabel5.setText("Description:");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 24)); 
        jLabel6.setText("Venue:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 24)); 
        jLabel7.setText("Date:");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); 
        jLabel8.setText("Time:");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 24)); 

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jButton1.setText("Next");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homeButton1.jpg"))); 
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/event1.jpg"))); 

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(350, 350, 350)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(130, 130, 130)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                                .addComponent(jTextField3)
                                .addComponent(jTextField4)
                                .addComponent(jTextField5)
                                .addComponent(jTextField6)
                                .addComponent(jButton1))))
                    .addContainerGap(80, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton5)
                    .addGap(1360, 1360, 1360))
                .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 2160, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(jLabel2)
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addComponent(jButton1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5)
                    .addGap(50, 50, 50))
                .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CreateEventFrame1().setVisible(true);
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
}