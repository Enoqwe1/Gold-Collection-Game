package yeni;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.Timer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class gameplay extends JPanel implements KeyListener, ActionListener {

    Random rand = new Random();
    private int m;
    private int n;
    private int altinY;
    private int gAltinY;
    private boolean play = false;
    private mapGenerator map;
    private Timer timer;
    private int delay = 200;
    public static int[][] tahta;
    public static oyuncuA A = new oyuncuA();
    public static oyuncuB B = new oyuncuB();
    public static oyuncuC C = new oyuncuC();
    public static oyuncuD D = new oyuncuD();
    public int sira = 0;
    public static boolean oyunDevam = true;
    public int i = 0;
    public File dosyaA = null;
    public File dosyaB = null;
    public File dosyaC = null;
    public File dosyaD = null;
    public FileWriter writerA = null;
    public FileWriter writerB = null;
    public FileWriter writerC = null;
    public FileWriter writerD = null;
    public static int totalAdimA = 0, totalAdimB = 0, totalAdimC = 0, totalAdimD = 0;
    public static int totalHarcananA = 0, totalHarcananB = 0, totalHarcananC = 0, totalHarcananD = 0;
    public static int baslangicAltini = A.altin;
    public int xa= 0;
    public gameplay(int m, int n, int altinY, int gAltinY) {
        try {
            dosyaA = new File("dosyaA.txt");
            dosyaA.createNewFile();
            dosyaB = new File("dosyaB.txt");
            dosyaB.createNewFile();
            dosyaC = new File("dosyaC.txt");
            dosyaC.createNewFile();
            dosyaD = new File("dosyaD.txt");
            dosyaD.createNewFile();
            writerA = new FileWriter(dosyaA);
            writerB = new FileWriter(dosyaB);
            writerC = new FileWriter(dosyaC);
            writerD = new FileWriter(dosyaD);
        } catch (IOException e) {
        }
        tahta = tahtaOlustur(m, n, altinY, gAltinY);

        this.m = m;

        this.n = n;

        this.altinY = altinY;

        this.gAltinY = gAltinY;
        oyuncuA.konum[0] = 0;
        oyuncuA.konum[1] = 0;
        oyuncuB.konum[0] = 0;
        oyuncuB.konum[1] = n - 1;
        oyuncuC.konum[0] = m - 1;
        oyuncuC.konum[1] = 0;
        oyuncuD.konum[0] = m - 1;
        oyuncuD.konum[1] = n - 1;
        map = new mapGenerator(m, n);

        addKeyListener(
                this);
        setFocusable(
                true);
        setFocusTraversalKeysEnabled(
                false);
        timer = new Timer(delay, this);

        timer.start();

    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public int[][] tahtaOlustur(int m, int n, int altinY, int gAltinY) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        int total_sayisi = (int) Math.ceil(m * n * altinY / 100);
        int gizli_sayisi = (int) Math.ceil(total_sayisi * gAltinY / 100);
        int altin_sayisi = total_sayisi - gizli_sayisi;
        if (gizli_sayisi == 0) {
            gizli_sayisi++;
            altin_sayisi--;
        }
        int count = 0;
        int[][] rand_konum = new int[altin_sayisi + 4][2];
        // koseler
        rand_konum[0][0] = m - 1;
        rand_konum[0][1] = n - 1;
        rand_konum[1][0] = 0;
        rand_konum[1][1] = 0;
        rand_konum[2][0] = 0;
        rand_konum[2][1] = n - 1;
        rand_konum[3][0] = m - 1;
        rand_konum[3][1] = 0;

        while (count != altin_sayisi) {
            int i = rand.nextInt(m);
            int j = rand.nextInt(n);
            int miktar = (int) (Math.random() * 4) * 5 + 5;
            boolean kontrol = false;
            for (int x = 0; x < count + 4; x++) {
                if (rand_konum[x][0] == i && rand_konum[x][1] == j) {
                    kontrol = true;
                }
            }
            if (!kontrol) {
                matrix[i][j] = miktar;
                rand_konum[count + 4][0] = i;
                rand_konum[count + 4][1] = j;
                count++;
            }
        }

        count = 0;
        int[][] rand_konum_gizli = new int[gizli_sayisi][2];
        while (count != gizli_sayisi) {
            boolean kontrol = false;
            int i = rand.nextInt(m);
            int j = rand.nextInt(n);
            int miktar = (int) (Math.random() * 4) * 5 + 5;
            for (int x = 0; x < rand_konum.length; x++) {
                if (rand_konum[x][0] == i && rand_konum[x][1] == j) {
                    kontrol = true;
                    break;
                }
            }
            for (int x = 0; x < count; x++) {
                if (rand_konum_gizli[x][0] == i && rand_konum_gizli[x][1] == j) {
                    kontrol = true;
                    break;
                }
            }
            if (!kontrol) {
                matrix[i][j] = (-miktar);
                rand_konum_gizli[count][0] = i;
                rand_konum_gizli[count][1] = j;
                count++;
            }
        }

        return matrix;
    }

    public void paint(Graphics g) {
        //arka plan
        g.setColor(Color.white);
        g.fillRect(1, 1, 1272, 712);
        map.draw((Graphics2D) g, tahta, A.konum, B.konum, C.konum, D.konum);
        g.setFont(new Font("Tahoma", Font.PLAIN, 26));
        g.drawString("A(mavi) : " + Integer.toString(A.altin), 240, 620);
        g.drawString("B(yesil) : " + Integer.toString(B.altin), 440, 620);
        g.drawString("C(pembe) : " + Integer.toString(C.altin), 640, 620);
        g.drawString("D(siyah) : " + Integer.toString(D.altin), 840, 620);
        g.dispose();
    }

    public void oyna() throws IOException {
        if (sira == 0 && altinTesti(A.altin, A.hamleMaliyeti)) {
            if (A.altin > A.hedefMaliyeti) {
                A.altin -= A.hamleMaliyeti;
                totalHarcananA += A.hamleMaliyeti;
                writerA.write("("+A.konum[0]+","+A.konum[1]+") -> ");
                A.arama();
                writerA.write("("+A.konum[0]+","+A.konum[1]+")\n");
                totalAdimA++;
            }
            else{
                A.oncekihedef[0] = -1;
                A.oncekihedef[1] = -1;
                A.konum[0] = -1;
                A.konum[1] = -1;
            }
            A.adim = B.adim;
        } else if (sira == 1 && altinTesti(B.altin, B.hamleMaliyeti)) {
            if (B.altin > B.hedefMaliyeti) {
                B.altin -= B.hamleMaliyeti;
                totalHarcananB += B.hamleMaliyeti;
                writerB.write("("+B.konum[0]+","+B.konum[1]+") -> ");
                B.arama();
                writerB.write("("+B.konum[0]+","+B.konum[1]+")\n");
                totalAdimB++;
            }
            else{
                B.oncekihedef[0] = -1;
                B.oncekihedef[1] = -1;
                B.konum[0] = -1;
                B.konum[1] = -1;
            }
            B.adim = C.adim;
        } else if (sira == 2 && altinTesti(C.altin, C.hamleMaliyeti)) {
            if (C.altin > C.hedefMaliyeti) {
                C.altin -= C.hamleMaliyeti;
                totalHarcananC += C.hamleMaliyeti;
                writerC.write("("+C.konum[0]+","+C.konum[1]+") -> ");
                C.arama();
                writerC.write("("+C.konum[0]+","+C.konum[1]+")\n");
                totalAdimC++;
            }
            else{
                C.oncekihedef[0] = -1;
                C.oncekihedef[1] = -1;
                C.konum[0] = -1;
                C.konum[1] = -1;
            }
            C.adim = D.adim;
        } else if (sira == 3 && altinTesti(D.altin, D.hamleMaliyeti)) {
            if (D.altin > D.hedefMaliyeti) {
                D.altin -= D.hamleMaliyeti;
                totalHarcananD += D.hamleMaliyeti;
                writerD.write("("+D.konum[0]+","+D.konum[1]+") -> ");
                D.arama();
                writerD.write("("+D.konum[0]+","+D.konum[1]+")\n");
                totalAdimD++;
            }
            else{
                D.oncekihedef[0] = -1;
                D.oncekihedef[1] = -1;
                D.konum[0] = -1;
                D.konum[1] = -1;
            }
            D.adim = A.adim;
        }

    }

    public boolean altinTesti(int test, int maliyet) {
        if (sira < 3) {
            sira++;
        } else {
            sira = 0;
        }

        if (test >= maliyet) {
            return true;
        } else {
            return false;
        }
    }

    public static int altinSayisi() {
        int altin = 0;
        for (int i = 0; i < tahta.length; i++) {
            for (int j = 0; j < tahta[0].length; j++) {
                if (tahta[i][j] > 0) {
                    altin++;
                }
            }
        }
        return altin;
    }

    public static boolean oyuncuVarmi(int id, int[] kontrol) {
        if (id == 1) {
            if ((B.konum[0] == kontrol[0]) && (B.konum[1] == kontrol[1])) {
                return true;
            }
            if ((C.konum[0] == kontrol[0]) && (C.konum[1] == kontrol[1])) {
                return true;
            }
            if ((D.konum[0] == kontrol[0]) && (D.konum[1] == kontrol[1])) {
                return true;
            }
        }
        if (id == 2) {
            if ((A.konum[0] == kontrol[0]) && (A.konum[1] == kontrol[1])) {
                return true;
            }
            if ((C.konum[0] == kontrol[0]) && (C.konum[1] == kontrol[1])) {
                return true;
            }
            if ((D.konum[0] == kontrol[0]) && (D.konum[1] == kontrol[1])) {
                return true;
            }
        }
        if (id == 3) {
            if ((A.konum[0] == kontrol[0]) && (A.konum[1] == kontrol[1])) {
                return true;
            }
            if ((B.konum[0] == kontrol[0]) && (B.konum[1] == kontrol[1])) {
                return true;
            }
            if ((D.konum[0] == kontrol[0]) && (D.konum[1] == kontrol[1])) {
                return true;
            }
        }
        if (id == 4) {
            if ((A.konum[0] == kontrol[0]) && (A.konum[1] == kontrol[1])) {
                return true;
            }
            if ((B.konum[0] == kontrol[0]) && (B.konum[1] == kontrol[1])) {
                return true;
            }
            if ((C.konum[0] == kontrol[0]) && (C.konum[1] == kontrol[1])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        xa++;
        if (oyunDevam && (A.altin>A.hamleMaliyeti+A.hedefMaliyeti || B.altin>B.hamleMaliyeti+B.hedefMaliyeti || C.altin>C.hamleMaliyeti+C.hedefMaliyeti || D.altin>D.hamleMaliyeti+D.hedefMaliyeti) ) {
            try {
                oyna();
            } catch (IOException ex) {
                Logger.getLogger(gameplay.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                writerA.close();
                writerB.close();
                writerC.close();
                writerD.close();
            } catch (IOException ex) {
                Logger.getLogger(gameplay.class.getName()).log(Level.SEVERE, null, ex);
            }
            timer.stop();
            oyunEkrani.obj.setVisible(false);
            skorTablosu tablo = new skorTablosu();
            tablo.setVisible(true);
            tablo.a1.setText(String.valueOf(totalAdimA*A.adim));
            tablo.b1.setText(String.valueOf(totalAdimB*A.adim));
            tablo.c1.setText(String.valueOf(totalAdimC*A.adim));
            tablo.d1.setText(String.valueOf(totalAdimD*A.adim));
            
            tablo.a2.setText(String.valueOf(totalHarcananA));
            tablo.b2.setText(String.valueOf(totalHarcananB));
            tablo.c2.setText(String.valueOf(totalHarcananC));
            tablo.d2.setText(String.valueOf(totalHarcananD));
            
            tablo.a3.setText(String.valueOf(A.altin));
            tablo.b3.setText(String.valueOf(B.altin));
            tablo.c3.setText(String.valueOf(C.altin));
            tablo.d3.setText(String.valueOf(D.altin));
            
            tablo.a4.setText(String.valueOf(A.altin+totalHarcananA-baslangicAltini));
            tablo.b4.setText(String.valueOf(B.altin+totalHarcananB-baslangicAltini));
            tablo.c4.setText(String.valueOf(C.altin+totalHarcananC-baslangicAltini));
            tablo.d4.setText(String.valueOf(D.altin+totalHarcananD-baslangicAltini));
        }
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
