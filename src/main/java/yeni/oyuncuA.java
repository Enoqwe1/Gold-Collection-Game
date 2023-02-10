package yeni;

import java.util.*;

public class oyuncuA {

    public static int altin;
    public static int adim;
    public static int hamleMaliyeti;
    public static int hedefMaliyeti;
    public static int[] oncekihedef = {-1, -1};
    public static int[] konum = new int[2];

    public oyuncuA() {
    }

    public int[][] hareketEt(int[] hedef, int[][] tahta, int[] konum) {
        int i = hedef[0] - konum[0];
        int j = hedef[1] - konum[1];
        int count = 0;
        if (gameplay.A.adim >= Math.abs(i) + Math.abs(j)) {
            while (i != count) {  // x ekseni uzerinde hareket
                if (i < 0) {
                    count--;
                } else {
                    count++;
                }

                if (tahta[konum[0] + count][konum[1]] > 0) {
                    gameplay.A.altin += tahta[konum[0] + count][konum[1]];
                    tahta[konum[0] + count][konum[1]] = 0;
                } else if (tahta[konum[0] + count][konum[1]] < 0) {
                    tahta[konum[0] + count][konum[1]] = Math.abs(tahta[konum[0] + count][konum[1]]);
                }

            }
            gameplay.A.adim = gameplay.A.adim - Math.abs(count);
            count = 0;
            konum[0] = hedef[0];
            while (j != count) {     // y ekseni uzerinde hareket
                if (j < 0) {
                    count--;
                } else {
                    count++;
                }

                if (tahta[konum[0]][konum[1] + count] > 0) {
                    gameplay.A.altin += tahta[konum[0]][konum[1] + count];
                    tahta[konum[0]][konum[1] + count] = 0;
                } else if (tahta[konum[0]][konum[1] + count] < 0) {
                    tahta[konum[0]][konum[1] + count] = Math.abs(tahta[konum[0]][konum[1] + count]);
                }
            }
            gameplay.A.adim = gameplay.A.adim - Math.abs(count);
            konum[1] = hedef[1];
            gameplay.A.konum[0] = hedef[0];
            gameplay.A.konum[1] = hedef[1];
            return tahta;
        } else {
            count = 0;
            while (i != count) {
                if (i < 0) {
                    count--;
                } else {
                    count++;
                }

                if (tahta[konum[0] + count][konum[1]] > 0) {
                    gameplay.A.altin += tahta[konum[0] + count][konum[1]];
                    tahta[konum[0] + count][konum[1]] = 0;
                } else if (tahta[konum[0] + count][konum[1]] < 0) {
                    tahta[konum[0] + count][konum[1]] = Math.abs(tahta[konum[0] + count][konum[1]]);
                }
                if (gameplay.A.adim == Math.abs(count)) {
                    gameplay.A.konum[0] = konum[0] + count;
                    gameplay.A.adim = gameplay.A.adim - Math.abs(count);
                    return tahta;
                }
            }

            konum[0] = hedef[0];
            gameplay.A.adim = gameplay.A.adim - Math.abs(count);
            count = 0;
            while (j != count) {
                if (j < 0) {
                    count--;
                } else {
                    count++;
                }

                if (tahta[konum[0]][konum[1] + count] > 0) {
                    gameplay.A.altin += tahta[konum[0]][konum[1] + count];
                    tahta[konum[0]][konum[1] + count] = 0;
                } else if (tahta[konum[0]][konum[1] + count] < 0) {
                    tahta[konum[0]][konum[1] + count] = Math.abs(tahta[konum[0]][konum[1] + count]);
                }
                if (gameplay.A.adim == Math.abs(count)) {
                    gameplay.A.konum[0] = konum[0];
                    gameplay.A.konum[1] = konum[1] + count;
                    gameplay.A.adim = gameplay.A.adim - Math.abs(count);
                    return tahta;
                }
            }
        }
        return tahta;
    }

    public void arama() {
        if ((oncekihedef[0] != -1 && oncekihedef[1] != -1) && (gameplay.tahta[oncekihedef[0]][oncekihedef[1]] == 0)) {
            oncekihedef[0] = -1;
            oncekihedef[1] = -1;
        } else if ((oncekihedef[0] != -1 && oncekihedef[1] != -1)) {
            gameplay.tahta = gameplay.A.hareketEt(oncekihedef, gameplay.tahta, gameplay.A.konum);
            if (gameplay.A.adim > 0) {
                oncekihedef[0] = -1;
                oncekihedef[1] = -1;
            } else {
                if (oncekihedef[0] == gameplay.A.konum[0] && oncekihedef[1] == gameplay.A.konum[1]) {
                    oncekihedef[0] = -1;
                    oncekihedef[1] = -1;
                    return;
                }
                return;
            }
        }
        if (gameplay.A.altin > gameplay.A.hedefMaliyeti) {
            gameplay.A.altin -= gameplay.A.hedefMaliyeti;
            gameplay.totalHarcananA += gameplay.A.hedefMaliyeti;
            int[] hedef = altin_bul(gameplay.A.konum, gameplay.tahta);
            gameplay.tahta = gameplay.A.hareketEt(hedef, gameplay.tahta, gameplay.A.konum);
            if (gameplay.A.adim == 0) {
                if (hedef[0] == gameplay.A.konum[0] && hedef[1] == gameplay.A.konum[1]) {
                    return;
                } else {
                    oncekihedef[0] = hedef[0];
                }
                oncekihedef[1] = hedef[1];
            } else {
                if (gameplay.altinSayisi() == 0) {
                    gameplay.oyunDevam = false;
                    return;
                }

                gameplay.A.arama();
            }
        }
        else
            return;

    }

    public static int[] altin_bul(int[] konum, int[][] tahta) {
        ArrayList<Integer> satir = new ArrayList<Integer>();
        ArrayList<Integer> sutun = new ArrayList<Integer>();
        int enYakin = 999;
        for (int i = 0; i < tahta.length; i++) {
            for (int j = 0; j < tahta[0].length; j++) {
                if (tahta[i][j] > 0) {
                    satir.add(i);
                    sutun.add(j);
                }
            }
        }

        int[] altinKonum = new int[2];
        for (int i = 0; i < satir.size(); i++) {
            int yeniEnYakin = Math.abs(konum[0] - satir.get(i)) + Math.abs(konum[1] - sutun.get(i));
            if (yeniEnYakin < enYakin) {

                enYakin = yeniEnYakin;
                altinKonum[0] = satir.get(i);
                altinKonum[1] = sutun.get(i);

            }
        }

        if (altinKonum[0] == 0 && altinKonum[1] == 0) {
            return konum;
        }
        return altinKonum;
    }
}
