package yeni;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class oyunEkrani extends javax.swing.JFrame {
    
    public static JFrame obj = null;
    public oyunEkrani() {
        initComponents();
    }
    public static void oyunabasla(int m, int n, int altinY, int gAltinY){
        obj = new JFrame();
        gameplay oyun = new gameplay(m, n, altinY, gAltinY);
        obj.setBounds(10, 10, 1280, 720);
        obj.setTitle("Altin Oyunu");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(oyun);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anaEkran = new javax.swing.JPanel();
        altinYuzdesiField = new javax.swing.JTextField();
        gAltinYuzdesiField = new javax.swing.JTextField();
        tahtaBoyutuField = new javax.swing.JTextField();
        adimSayisiField = new javax.swing.JTextField();
        baslangicAltiniField = new javax.swing.JTextField();
        hhMaliyetleri = new javax.swing.JTextField();
        aOyuncuField = new javax.swing.JTextField();
        bOyuncuField = new javax.swing.JTextField();
        cOyuncuField = new javax.swing.JTextField();
        dOyuncuField = new javax.swing.JTextField();
        setAltinYuzdesi = new javax.swing.JTextField();
        setgAltinYuzdesi = new javax.swing.JTextField();
        setTahta_m = new javax.swing.JTextField();
        setTahta_n = new javax.swing.JTextField();
        setAdimSayisi = new javax.swing.JTextField();
        setBaslangicAltini = new javax.swing.JTextField();
        setA_hamle = new javax.swing.JTextField();
        setA_hedef = new javax.swing.JTextField();
        setB_hamle = new javax.swing.JTextField();
        setB_hedef = new javax.swing.JTextField();
        setC_hamle = new javax.swing.JTextField();
        setC_hedef = new javax.swing.JTextField();
        setD_hamle = new javax.swing.JTextField();
        setD_hedef = new javax.swing.JTextField();
        baslamaButtonu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AYARLAR EKRANI");
        setMinimumSize(new java.awt.Dimension(1280, 720));

        anaEkran.setMinimumSize(new java.awt.Dimension(1280, 720));
        anaEkran.setLayout(null);

        altinYuzdesiField.setEditable(false);
        altinYuzdesiField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        altinYuzdesiField.setText("Altin Yuzdesi");
        anaEkran.add(altinYuzdesiField);
        altinYuzdesiField.setBounds(120, 140, 170, 50);

        gAltinYuzdesiField.setEditable(false);
        gAltinYuzdesiField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gAltinYuzdesiField.setText("Gizli Altin Yuzdesi");
        gAltinYuzdesiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gAltinYuzdesiFieldActionPerformed(evt);
            }
        });
        anaEkran.add(gAltinYuzdesiField);
        gAltinYuzdesiField.setBounds(120, 210, 170, 50);

        tahtaBoyutuField.setEditable(false);
        tahtaBoyutuField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tahtaBoyutuField.setText("Tahta Boyutu");
        anaEkran.add(tahtaBoyutuField);
        tahtaBoyutuField.setBounds(120, 280, 170, 50);

        adimSayisiField.setEditable(false);
        adimSayisiField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        adimSayisiField.setText("Adim Sayisi");
        anaEkran.add(adimSayisiField);
        adimSayisiField.setBounds(120, 350, 170, 50);

        baslangicAltiniField.setEditable(false);
        baslangicAltiniField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        baslangicAltiniField.setText("Baslangic Altini");
        anaEkran.add(baslangicAltiniField);
        baslangicAltiniField.setBounds(120, 420, 170, 50);

        hhMaliyetleri.setEditable(false);
        hhMaliyetleri.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hhMaliyetleri.setText("Oyuncularin Hamle-Hedef Maliyeti");
        anaEkran.add(hhMaliyetleri);
        hhMaliyetleri.setBounds(790, 140, 330, 50);

        aOyuncuField.setEditable(false);
        aOyuncuField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        aOyuncuField.setText("A Oyuncusu");
        aOyuncuField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aOyuncuFieldActionPerformed(evt);
            }
        });
        anaEkran.add(aOyuncuField);
        aOyuncuField.setBounds(790, 210, 130, 50);

        bOyuncuField.setEditable(false);
        bOyuncuField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bOyuncuField.setText("B Oyuncusu");
        anaEkran.add(bOyuncuField);
        bOyuncuField.setBounds(790, 280, 130, 50);

        cOyuncuField.setEditable(false);
        cOyuncuField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cOyuncuField.setText("C Oyuncusu");
        anaEkran.add(cOyuncuField);
        cOyuncuField.setBounds(790, 350, 130, 50);

        dOyuncuField.setEditable(false);
        dOyuncuField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dOyuncuField.setText("D Oyuncusu");
        anaEkran.add(dOyuncuField);
        dOyuncuField.setBounds(790, 420, 130, 50);

        setAltinYuzdesi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setAltinYuzdesi.setText("20");
        setAltinYuzdesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAltinYuzdesiActionPerformed(evt);
            }
        });
        anaEkran.add(setAltinYuzdesi);
        setAltinYuzdesi.setBounds(320, 140, 80, 50);

        setgAltinYuzdesi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setgAltinYuzdesi.setText("10");
        setgAltinYuzdesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setgAltinYuzdesiActionPerformed(evt);
            }
        });
        anaEkran.add(setgAltinYuzdesi);
        setgAltinYuzdesi.setBounds(320, 210, 80, 50);

        setTahta_m.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setTahta_m.setText("20");
        setTahta_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTahta_mActionPerformed(evt);
            }
        });
        anaEkran.add(setTahta_m);
        setTahta_m.setBounds(320, 280, 80, 50);

        setTahta_n.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setTahta_n.setText("20");
        setTahta_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTahta_nActionPerformed(evt);
            }
        });
        anaEkran.add(setTahta_n);
        setTahta_n.setBounds(420, 280, 80, 50);

        setAdimSayisi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setAdimSayisi.setText("3");
        setAdimSayisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAdimSayisiActionPerformed(evt);
            }
        });
        anaEkran.add(setAdimSayisi);
        setAdimSayisi.setBounds(320, 350, 80, 50);

        setBaslangicAltini.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setBaslangicAltini.setText("200");
        setBaslangicAltini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setBaslangicAltiniActionPerformed(evt);
            }
        });
        anaEkran.add(setBaslangicAltini);
        setBaslangicAltini.setBounds(320, 420, 80, 50);

        setA_hamle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setA_hamle.setText("5");
        setA_hamle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setA_hamleActionPerformed(evt);
            }
        });
        anaEkran.add(setA_hamle);
        setA_hamle.setBounds(940, 210, 80, 50);

        setA_hedef.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setA_hedef.setText("5");
        setA_hedef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setA_hedefActionPerformed(evt);
            }
        });
        anaEkran.add(setA_hedef);
        setA_hedef.setBounds(1040, 210, 80, 50);

        setB_hamle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setB_hamle.setText("5");
        setB_hamle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setB_hamleActionPerformed(evt);
            }
        });
        anaEkran.add(setB_hamle);
        setB_hamle.setBounds(940, 280, 80, 50);

        setB_hedef.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setB_hedef.setText("10");
        setB_hedef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setB_hedefActionPerformed(evt);
            }
        });
        anaEkran.add(setB_hedef);
        setB_hedef.setBounds(1040, 280, 80, 50);

        setC_hamle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setC_hamle.setText("5");
        setC_hamle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setC_hamleActionPerformed(evt);
            }
        });
        anaEkran.add(setC_hamle);
        setC_hamle.setBounds(940, 350, 80, 50);

        setC_hedef.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setC_hedef.setText("15");
        setC_hedef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setC_hedefActionPerformed(evt);
            }
        });
        anaEkran.add(setC_hedef);
        setC_hedef.setBounds(1040, 350, 80, 50);

        setD_hamle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setD_hamle.setText("5");
        setD_hamle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setD_hamleActionPerformed(evt);
            }
        });
        anaEkran.add(setD_hamle);
        setD_hamle.setBounds(940, 420, 80, 50);

        setD_hedef.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setD_hedef.setText("20");
        setD_hedef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setD_hedefActionPerformed(evt);
            }
        });
        anaEkran.add(setD_hedef);
        setD_hedef.setBounds(1040, 420, 80, 50);

        baslamaButtonu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        baslamaButtonu.setText("OYUNA BASLA");
        baslamaButtonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baslamaButtonuActionPerformed(evt);
            }
        });
        anaEkran.add(baslamaButtonu);
        baslamaButtonu.setBounds(500, 540, 250, 100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anaEkran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anaEkran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gAltinYuzdesiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gAltinYuzdesiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gAltinYuzdesiFieldActionPerformed

    private void aOyuncuFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aOyuncuFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aOyuncuFieldActionPerformed

    private void setD_hedefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setD_hedefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setD_hedefActionPerformed

    private void setAltinYuzdesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setAltinYuzdesiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setAltinYuzdesiActionPerformed

    private void setgAltinYuzdesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setgAltinYuzdesiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setgAltinYuzdesiActionPerformed

    private void setTahta_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTahta_mActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setTahta_mActionPerformed

    private void setTahta_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTahta_nActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setTahta_nActionPerformed

    private void setAdimSayisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setAdimSayisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setAdimSayisiActionPerformed

    private void setBaslangicAltiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setBaslangicAltiniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setBaslangicAltiniActionPerformed

    private void setA_hamleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setA_hamleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setA_hamleActionPerformed

    private void setA_hedefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setA_hedefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setA_hedefActionPerformed

    private void setB_hamleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setB_hamleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setB_hamleActionPerformed

    private void setB_hedefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setB_hedefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setB_hedefActionPerformed

    private void setC_hamleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setC_hamleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setC_hamleActionPerformed

    private void setC_hedefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setC_hedefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setC_hedefActionPerformed

    private void setD_hamleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setD_hamleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setD_hamleActionPerformed

    private void baslamaButtonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baslamaButtonuActionPerformed

        try {
            int altinYuzdesi = Integer.parseInt(setAltinYuzdesi.getText());
            int galtinYuzdesi = Integer.parseInt(setgAltinYuzdesi.getText());
            int tahtaBoyutuM = Integer.parseInt(setTahta_m.getText());
            int tahtaBoyutuN = Integer.parseInt(setTahta_n.getText());
            int adimSayisi = Integer.parseInt(setAdimSayisi.getText());
            int baslangicAltini = Integer.parseInt(setBaslangicAltini.getText());
            int aHamle = Integer.parseInt(setA_hamle.getText());
            int aHedef = Integer.parseInt(setA_hedef.getText());
            int bHamle = Integer.parseInt(setB_hamle.getText());
            int bHedef = Integer.parseInt(setB_hedef.getText());
            int cHamle = Integer.parseInt(setC_hamle.getText());
            int cHedef = Integer.parseInt(setC_hedef.getText());
            int dHamle = Integer.parseInt(setD_hamle.getText());
            int dHedef = Integer.parseInt(setD_hedef.getText());
            boolean hataliGiris = false;
            if (altinYuzdesi <= 0 || altinYuzdesi >= 100) {
                hataliGiris = true;
            }
            if (galtinYuzdesi <= 0 || galtinYuzdesi >= 100) {
                hataliGiris = true;
            }
            if (tahtaBoyutuM <= 2 || tahtaBoyutuM > 100) {
                hataliGiris = true;
            }
            if (tahtaBoyutuN <= 2 || tahtaBoyutuN > 100) {
                hataliGiris = true;
            }
            if (adimSayisi <= 0) {
                hataliGiris = true;
            }
            if (baslangicAltini <= 0) {
                hataliGiris = true;
            }
            if (aHamle <= 0) {
                hataliGiris = true;
            }
            if (aHedef <= 0) {
                hataliGiris = true;
            }
            if (bHamle <= 0) {
                hataliGiris = true;
            }
            if (bHedef <= 0) {
                hataliGiris = true;
            }
            if (cHamle <= 0) {
                hataliGiris = true;
            }
            if (cHedef <= 0) {
                hataliGiris = true;
            }
            if (dHamle <= 0) {
                hataliGiris = true;
            }
            if (dHedef <= 0) {
                hataliGiris = true;
            }
            if (hataliGiris) {
                JOptionPane.showMessageDialog(this, "Negatif deger, cok buyuk deger veya tahta boyutuna 3ten kucuk girilemez.");
            }
            else{
                this.setVisible(false);
                oyuncuA.adim = adimSayisi;
                oyuncuB.adim = adimSayisi;
                oyuncuC.adim = adimSayisi;
                oyuncuD.adim = adimSayisi;
                oyuncuA.altin = baslangicAltini;
                oyuncuB.altin = baslangicAltini;
                oyuncuC.altin = baslangicAltini;
                oyuncuD.altin = baslangicAltini;
                oyuncuA.hamleMaliyeti = aHamle;
                oyuncuB.hamleMaliyeti = bHamle;
                oyuncuC.hamleMaliyeti = cHamle;
                oyuncuD.hamleMaliyeti = dHamle;
                oyuncuA.hedefMaliyeti = aHedef;
                oyuncuB.hedefMaliyeti = bHedef;
                oyuncuC.hedefMaliyeti = cHedef;
                oyuncuD.hedefMaliyeti = dHedef;
                oyunabasla(tahtaBoyutuM, tahtaBoyutuN, altinYuzdesi, galtinYuzdesi);
                
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Lutfen gecerli degerler giriniz.");
        }
    }//GEN-LAST:event_baslamaButtonuActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(oyunEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(oyunEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(oyunEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(oyunEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new oyunEkrani().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aOyuncuField;
    private javax.swing.JTextField adimSayisiField;
    private javax.swing.JTextField altinYuzdesiField;
    private javax.swing.JPanel anaEkran;
    private javax.swing.JTextField bOyuncuField;
    private javax.swing.JButton baslamaButtonu;
    private javax.swing.JTextField baslangicAltiniField;
    private javax.swing.JTextField cOyuncuField;
    private javax.swing.JTextField dOyuncuField;
    private javax.swing.JTextField gAltinYuzdesiField;
    private javax.swing.JTextField hhMaliyetleri;
    private javax.swing.JTextField setA_hamle;
    private javax.swing.JTextField setA_hedef;
    private javax.swing.JTextField setAdimSayisi;
    private javax.swing.JTextField setAltinYuzdesi;
    private javax.swing.JTextField setB_hamle;
    private javax.swing.JTextField setB_hedef;
    private javax.swing.JTextField setBaslangicAltini;
    private javax.swing.JTextField setC_hamle;
    private javax.swing.JTextField setC_hedef;
    private javax.swing.JTextField setD_hamle;
    private javax.swing.JTextField setD_hedef;
    private javax.swing.JTextField setTahta_m;
    private javax.swing.JTextField setTahta_n;
    private javax.swing.JTextField setgAltinYuzdesi;
    private javax.swing.JTextField tahtaBoyutuField;
    // End of variables declaration//GEN-END:variables
}
