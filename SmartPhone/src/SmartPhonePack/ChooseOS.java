package SmartPhonePack;

public class ChooseOS extends javax.swing.JFrame {

    public ChooseOS() {
        this.setResizable(false);
        initComponents();
        this.setSize(1080, 720);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 240));

        jPanel1.setBackground(new java.awt.Color(0, 153, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmartPhonePack/แอปเปิล.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 153, 240));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmartPhonePack/แอนดรอย.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 241, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmartPhonePack/วินโด.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 280, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmartPhonePack/BackButton.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 530, -1, -1));

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 3, 54)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmartPhonePack/CHOOSEOS.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        ShowResult.OS = "IOS";
        if(ShowResult.chooseType.contains("CameraPhone")){
            ChooseCamera ca = new ChooseCamera();
            ca.setVisible(true);
        }
        else if(ShowResult.chooseType.contains("GamingPhone")){
            ChooseCPUIOS cpu = new ChooseCPUIOS();
            cpu.setVisible(true);
            
        }
        else if(ShowResult.chooseType.contains("Phablet")){
            ChooseDisplay dis = new ChooseDisplay();
            dis.setVisible(true);
            
        }
        else if(ShowResult.chooseType.contains("GeneralPhone")){
            ChooseMem mem = new ChooseMem();
            mem.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        ShowResult.OS = "Android";
        if(ShowResult.chooseType.contains("CameraPhone")){
            ChooseCamera ca = new ChooseCamera();
            ca.setVisible(true);
        }
        else if(ShowResult.chooseType.contains("GamingPhone")){
            ChooseCPUAndroid cpu = new ChooseCPUAndroid();
            cpu.setVisible(true);
            
        }
        else if(ShowResult.chooseType.contains("Phablet")){
            ChooseDisplay dis = new ChooseDisplay();
            dis.setVisible(true);
            
        }
        else if(ShowResult.chooseType.contains("GeneralPhone")){
            ChooseMem mem = new ChooseMem();
            mem.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        ShowResult.OS = "WindowsPhone";
        if(ShowResult.chooseType.contains("CameraPhone")){
            ChooseCamera ca = new ChooseCamera();
            ca.setVisible(true);
        }
        else if(ShowResult.chooseType.contains("GamingPhone")){
            ChooseCPUAndroid cpu = new ChooseCPUAndroid();
            cpu.setVisible(true);
            
        }
        else if(ShowResult.chooseType.contains("Phablet")){
            ChooseDisplay dis = new ChooseDisplay();
            dis.setVisible(true);
            
        }
        else if(ShowResult.chooseType.contains("GeneralPhone")){
            ChooseMem mem = new ChooseMem();
            mem.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Home h = new Home();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(ChooseOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
