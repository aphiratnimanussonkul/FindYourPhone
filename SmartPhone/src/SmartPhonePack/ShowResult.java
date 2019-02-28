/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartPhonePack;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.rdf.model.RDFNode;
import static edu.stanford.smi.protegex.owl.swrl.util.P3OWLUtil.getClass;
import java.awt.Image;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;

/**
 *
 * @author Thain
 */
public class ShowResult extends javax.swing.JFrame {
    String [] PHONENAME = new String[999];
    static String chooseType;
    static String OS;
    static String fcam;
    static String rcam;
    static String display;
    static String ram;
    static String mem;
    static String cpu;
    static String price;
    public ArrayList<String> ListComponent = new ArrayList<String>();  // for name list
    public ArrayList<String> ListNames = new ArrayList<String>();  // for name list
    String[] phoneName = new String[9999];

    ShowImage si = new ShowImage();
    
    public void setNullPhoneName(){
        for(int j = 0; j < this.PHONENAME.length; j++)
            this.PHONENAME[j] = null;
    }
    
    public ShowResult() {
        int i = 0;
        initComponents();
        setNullPhoneName();
        System.out.println(ShowResult.chooseType);
        System.out.println(ShowResult.OS);
        System.out.println(ShowResult.fcam);
        System.out.println(ShowResult.rcam);
        System.out.println(ShowResult.ram);
        System.out.println(ShowResult.mem);
        System.out.println(ShowResult.display);
        System.out.println(ShowResult.cpu);

        if (ShowResult.chooseType.contains("CameraPhone")) {
            try {
                String[] tableColumnsName = {"Smart Phone Spec"};
                DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                aModel.setColumnIdentifiers(tableColumnsName);
                aModel.setRowCount(0);

                System.out.println("Get Component");
                String queryString;
                queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                        + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                        + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX ex: <http://localhost/smartphone#>"
                        + "SELECT (str(?x) as ?Component) (str(?ram) as ?RAM) (str(?rom) as ?ROM) (str(?os) as ?OS) (str(?fcam) as ?FCAM) (str(?rcam) as ?RCAM) (str(?price) as ?PRICE) (str(?namePhone) as ?NAMEPHONE)"  
                        + "	WHERE { ?x rdf:type ex:Camera_Phone ;"
                        + "     ex:name ?namePhone ;"
                        + "     ex:hasRAM ?ram;"
                        + "     ex:hasROM ?rom;"
                        + "     ex:hasOS ?os;"
                        + "     ex:hasFrontCamera ?fcam;"
                        + "     ex:hasRearCamera ?rcam;"
                        + "     ex:hasPrice ?price."
                        + "     ?price ex:name \"" + ShowResult.price + "\"."
                        + "     ?ram ex:name \"" + ShowResult.ram + "\"."
                        + "     ?rom ex:name \"" + ShowResult.mem + "\"."
                        + "     ?fcam ex:name \"" + ShowResult.fcam + "\"."
                        + "     ?rcam ex:name \"" + ShowResult.rcam + "\"."
                        + "     ?os ex:name \"" + ShowResult.OS + "\"."
                        + "}";
                System.out.println(queryString);
                com.hp.hpl.jena.query.ResultSet results = OpenOWL.ExecSparQl(queryString); 

                while (results.hasNext()) {
                    QuerySolution soln = results.nextSolution();
                    String Component = soln.getLiteral("Component").getString();
                    String RAM = soln.getLiteral("RAM").getString();
                    String ROM = soln.getLiteral("ROM").getString();
                    String FCAM = soln.getLiteral("FCAM").getString();
                    String RCAM = soln.getLiteral("RCAM").getString();
                    String OperatingSystem = soln.getLiteral("OS").getString();
                    String price = soln.getLiteral("PRICE").getString();
                    String phoneNames = soln.getLiteral("NAMEPHONE").getString();
                    //GetText
                    int start, stop;
                    start = Component.toString().indexOf("#") + 1;
                    stop = Component.toString().length();
                    String phoneName = Component.toString().substring(start, stop);
                    this.PHONENAME[i++] = phoneName;

                    start = RAM.toString().indexOf("#") + 1;
                    stop = RAM.toString().length();
                    String ram = RAM.toString().substring(start, stop);

                    start = ROM.toString().indexOf("#") + 1;
                    stop = ROM.toString().length();
                    String rom = ROM.toString().substring(start, stop);

                    start = FCAM.toString().indexOf("#") + 1;
                    stop = FCAM.toString().length();
                    String fcam = FCAM.toString().substring(start, stop);

                    start = RCAM.toString().indexOf("#") + 1;
                    stop = RCAM.toString().length();
                    String rcam = RCAM.toString().substring(start, stop);

                    start = OperatingSystem.toString().indexOf("#") + 1;
                    stop = OperatingSystem.toString().length();
                    String os = OperatingSystem.toString().substring(start, stop);

                    start = price.toString().indexOf("#") + 1;
                    stop = price.toString().length();
                    String prices = price.toString().substring(start, stop);
                    ////
                    RDFNode Name = soln.get("Component");
                    RDFNode RAMs = soln.get("RAM");
                    RDFNode ROMs = soln.get("ROM");
                    RDFNode FCAMs = soln.get("FCAM");
                    RDFNode RCAMs = soln.get("RCAM");
                    RDFNode OSs = soln.get("OS");
                    RDFNode PRICEs = soln.get("PRICE");
                    RDFNode phoneNamess = soln.get("NAMEPHONE");

                    System.out.println(Component.toString());
                    System.out.println(RAM.toString());
                    System.out.println(ROM.toString());
                    System.out.println(FCAM.toString());
                    System.out.println(RCAM.toString());
                    System.out.println(OperatingSystem.toString());
                    System.out.println(price.toString());
                    System.out.println(phoneNames.toString());
                    aModel.addRow(new Object[]{phoneNames.toString()});
                    jTable1.setModel(aModel);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ShowResult.chooseType.contains("GamingPhone")) {
            try {
                String[] tableColumnsName = {"Smart Phone Spec"};
                DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                aModel.setColumnIdentifiers(tableColumnsName);
                aModel.setRowCount(0);
                System.out.println("Get Component");
                String queryString;
                queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                        + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                        + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX ex: <http://localhost/smartphone#>"
                        + "SELECT (str(?x) as ?Component) (str(?ram) as ?RAM) (str(?rom) as ?ROM) (str(?os) as ?OS) (str(?cpu) as ?CPU) (str(?price) as ?PRICE) (str(?namePhone) as ?NAMEPHONE)" 
                        + "	WHERE { ?x rdf:type ex:Gaming_Phone ;"
                        + "     ex:name ?namePhone ;"
                        + "     ex:hasRAM ?ram;"
                        + "     ex:hasROM ?rom;"
                        + "     ex:hasOS ?os;"
                        + "     ex:hasCPU ?cpu;"
                        + "     ex:hasPrice ?price."
                        + "     ?price ex:name \"" + ShowResult.price + "\"."
                        + "     ?ram ex:name \"" + ShowResult.ram + "\"."
                        + "     ?rom ex:name \"" + ShowResult.mem + "\"."
                        + "     ?cpu ex:name \"" + ShowResult.cpu + "\"."
                        + "     ?os ex:name \"" + ShowResult.OS + "\"."
                        + "}";
                System.out.println(queryString);
                com.hp.hpl.jena.query.ResultSet results = OpenOWL.ExecSparQl(queryString); //all method ExecSparQl from OpenOWL class

                while (results.hasNext()) {
                    QuerySolution soln = results.nextSolution();
                    String Component = soln.getLiteral("Component").getString();
                    String RAM = soln.getLiteral("RAM").getString();
                    String ROM = soln.getLiteral("ROM").getString();
                    String CPU = soln.getLiteral("CPU").getString();
                    String OperatingSystem = soln.getLiteral("OS").getString();
                    String price = soln.getLiteral("PRICE").getString();
                    String phoneNames = soln.getLiteral("NAMEPHONE").getString();
                    //GetText
                    int start, stop;
                    start = Component.toString().indexOf("#") + 1;
                    stop = Component.toString().length();
                    String phoneName = Component.toString().substring(start, stop);
                    this.PHONENAME[i++] = phoneName;

                    start = RAM.toString().indexOf("#") + 1;
                    stop = RAM.toString().length();
                    String ram = RAM.toString().substring(start, stop);

                    start = ROM.toString().indexOf("#") + 1;
                    stop = ROM.toString().length();
                    String rom = ROM.toString().substring(start, stop);

                    start = CPU.toString().indexOf("#") + 1;
                    stop = CPU.toString().length();
                    String cpu = CPU.toString().substring(start, stop);

                    start = OperatingSystem.toString().indexOf("#") + 1;
                    stop = OperatingSystem.toString().length();
                    String os = OperatingSystem.toString().substring(start, stop);

                    start = price.toString().indexOf("#") + 1;
                    stop = price.toString().length();
                    String prices = price.toString().substring(start, stop);
                    ////
                    RDFNode Name = soln.get("Component");
                    RDFNode RAMs = soln.get("RAM");
                    RDFNode ROMs = soln.get("ROM");
                    RDFNode CPUs = soln.get("CPU");;
                    RDFNode OSs = soln.get("OS");
                    RDFNode PRICEs = soln.get("PRICE");

                    System.out.println(Component.toString());
                    System.out.println(RAM.toString());
                    System.out.println(ROM.toString());
                    System.out.println(CPU.toString());
                    System.out.println(OperatingSystem.toString());
                    System.out.println(price.toString());

                    aModel.addRow(new Object[]{phoneNames.toString()});
                    jTable1.setModel(aModel);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ShowResult.chooseType.contains("Phablet")) {
            try {

                String[] tableColumnsName = {"Smart Phone Spec"};
                DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                aModel.setColumnIdentifiers(tableColumnsName);
                aModel.setRowCount(0);

                System.out.println("Get Component");
                String queryString;
                queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                        + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                        + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX ex: <http://localhost/smartphone#>"
                        + "SELECT (str(?x) as ?Component) (str(?ram) as ?RAM) (str(?rom) as ?ROM) (str(?os) as ?OS) (str(?dis) as ?DISPLAY) (str(?price) as ?PRICE) (str(?namePhone) as ?NAMEPHONE)"
                        + "	WHERE { ?x rdf:type ex:Phablet;"
                        + "     ex:name ?namePhone;"
                        + "     ex:hasRAM ?ram;"
                        + "     ex:hasROM ?rom;"
                        + "     ex:hasDisplay ?dis;"
                        + "     ex:hasOS ?os;"
                        + "     ex:hasPrice ?price."
                        + "     ?price ex:name \"" + ShowResult.price + "\"."
                        + "     ?ram ex:name \"" + ShowResult.ram + "\"."
                        + "     ?rom ex:name \"" + ShowResult.mem + "\"."
                        + "     ?dis ex:name \"" + ShowResult.display + "\"."
                        + "     ?os ex:name \"" + ShowResult.OS + "\"."
                        + "}";
                System.out.println(queryString);
                com.hp.hpl.jena.query.ResultSet results = OpenOWL.ExecSparQl(queryString); //all method ExecSparQl from OpenOWL class

                while (results.hasNext()) {
                    QuerySolution soln = results.nextSolution();
                    String Component = soln.getLiteral("Component").getString();
                    String RAM = soln.getLiteral("RAM").getString();
                    String ROM = soln.getLiteral("ROM").getString();
                    String display = soln.getLiteral("DISPLAY").getString();
                    String OperatingSystem = soln.getLiteral("OS").getString();
                    String price = soln.getLiteral("PRICE").getString();
                    String phoneNames = soln.getLiteral("NAMEPHONE").getString();
                    //GetText
                    int start, stop;
                    start = Component.toString().indexOf("#") + 1;
                    stop = Component.toString().length();
                    String phoneName = Component.toString().substring(start, stop);
                    this.PHONENAME[i++] = phoneName;

                    start = RAM.toString().indexOf("#") + 1;
                    stop = RAM.toString().length();
                    String ram = RAM.toString().substring(start, stop);

                    start = ROM.toString().indexOf("#") + 1;
                    stop = ROM.toString().length();
                    String rom = ROM.toString().substring(start, stop);

                    start = OperatingSystem.toString().indexOf("#") + 1;
                    stop = OperatingSystem.toString().length();
                    String os = OperatingSystem.toString().substring(start, stop);

                    start = display.toString().indexOf("#") + 1;
                    stop = display.toString().length();
                    String dis = display.toString().substring(start, stop);

                    start = price.toString().indexOf("#") + 1;
                    stop = price.toString().length();
                    String prices = price.toString().substring(start, stop);
                    ////
                    RDFNode Name = soln.get("Component");
                    RDFNode RAMs = soln.get("RAM");
                    RDFNode ROMs = soln.get("ROM");
                    RDFNode Displays = soln.get("DISPLAY");
                    RDFNode OSs = soln.get("OS");
                    RDFNode PRICEs = soln.get("PRICE");

                    System.out.println(Component.toString());
                    System.out.println(RAM.toString());
                    System.out.println(ROM.toString());
                    System.out.println(OperatingSystem.toString());
                    System.out.println(display.toString());
                    System.out.println(price.toString());
                    
                    aModel.addRow(new Object[]{phoneNames.toString()});
                    jTable1.setModel(aModel);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ShowResult.chooseType.contains("GeneralPhone")) {
            try {
                String[] tableColumnsName = {"Smart Phone Spec"};
                DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
                aModel.setColumnIdentifiers(tableColumnsName);
                aModel.setRowCount(0);
                System.out.println("Get Component");
                String queryString;
                queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                        + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                        + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX ex: <http://localhost/smartphone#>"
                        + "SELECT (str(?x) as ?Component) (str(?ram) as ?RAM) (str(?rom) as ?ROM) (str(?os) as ?OS) (str(?price) as ?PRICE) (str(?namePhone) as ?NAMEPHONE)"
                        //(str(?os) as ?OS)  
                        + "	WHERE { ?x rdf:type ex:General_Phone ;"
                        + "     ex:name ?namePhone ;"
                        + "     ex:hasRAM ?ram;"
                        + "     ex:hasROM ?rom;"
                        + "     ex:hasOS ?os;"
                        + "     ex:hasPrice ?price."
                        + "     ?price ex:name \"" + ShowResult.price + "\"."
                        + "     ?ram ex:name \"" + ShowResult.ram + "\"."
                        + "     ?rom ex:name \"" + ShowResult.mem + "\"."
                        + "     ?os ex:name \"" + ShowResult.OS + "\"."
                        + "}";
                System.out.println(queryString);
                com.hp.hpl.jena.query.ResultSet results = OpenOWL.ExecSparQl(queryString); //all method ExecSparQl from OpenOWL class

                while (results.hasNext()) {
                    QuerySolution soln = results.nextSolution();
                    String Component = soln.getLiteral("Component").getString();
                    String RAM = soln.getLiteral("RAM").getString();
                    String ROM = soln.getLiteral("ROM").getString();
                    String OperatingSystem = soln.getLiteral("OS").getString();
                    String price = soln.getLiteral("PRICE").getString();
                    String phoneNames = soln.getLiteral("NAMEPHONE").getString();
                    //GetText
                    int start, stop;
                    start = Component.toString().indexOf("#") + 1;
                    stop = Component.toString().length();
                    String phoneName = Component.toString().substring(start, stop);
                    this.PHONENAME[i++] = phoneName;

                    start = RAM.toString().indexOf("#") + 1;
                    stop = RAM.toString().length();
                    String ram = RAM.toString().substring(start, stop);

                    start = ROM.toString().indexOf("#") + 1;
                    stop = ROM.toString().length();
                    String rom = ROM.toString().substring(start, stop);

                    start = OperatingSystem.toString().indexOf("#") + 1;
                    stop = OperatingSystem.toString().length();
                    String os = OperatingSystem.toString().substring(start, stop);

                    start = price.toString().indexOf("#") + 1;
                    stop = price.toString().length();
                    String prices = price.toString().substring(start, stop);
                    ////
                    RDFNode Name = soln.get("Component");
                    RDFNode RAMs = soln.get("RAM");
                    RDFNode ROMs = soln.get("ROM");
                    RDFNode OSs = soln.get("OS");
                    RDFNode PRICEs = soln.get("PRICE");

                    System.out.println(Component.toString());
                    System.out.println(RAM.toString());
                    System.out.println(ROM.toString());
                    System.out.println(OperatingSystem.toString());
                    System.out.println(price.toString());

                    aModel.addRow(new Object[]{phoneNames.toString()});
                    jTable1.setModel(aModel);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Your Phone");

        jPanel1.setBackground(new java.awt.Color(0, 153, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("TH SarabunPSK", 3, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAlignmentX(3.0F);
        jTable1.setAlignmentY(1.0F);
        jTable1.setRowHeight(28);
        jTable1.setRowMargin(2);
        jTable1.setSelectionBackground(new java.awt.Color(153, 102, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 710, 400));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmartPhonePack/HomeButton.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 530, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmartPhonePack/yourPhone.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        System.out.println("index = " + index);
        TableModel model = jTable1.getModel();
        //String phoneName = model.getValueAt(index, 0).toString();
        
        System.out.println("Phone Name = " + this.PHONENAME[index] );
        si.setVisible(true);
        si.pack();
        si.setLocationRelativeTo(null);
        si.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageIcon icon = new ImageIcon(getClass().getResource(this.PHONENAME[index] +".png"));
        Image img = icon.getImage().getScaledInstance(si.lableImage.getWidth(), si.lableImage.getHeight(), Image.SCALE_SMOOTH);
        si.lableImage.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        ShowResult.OS = null;
        ShowResult.chooseType = null;
        ShowResult.fcam = null;
        ShowResult.rcam = null;
        ShowResult.cpu = null;
        ShowResult.display = null;
        ShowResult.price = null;
        ShowResult.mem = null;
        ShowResult.ram = null;
        Home h = new Home();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(ShowResult.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowResult.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowResult.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowResult.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
