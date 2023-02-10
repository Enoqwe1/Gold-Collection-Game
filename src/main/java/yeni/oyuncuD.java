package yeni;

import java.util.ArrayList;

public class oyuncuD {

    public static int altin;
    public static int adim;
    public static int hamleMaliyeti;
    public static int hedefMaliyeti;
    public static int[] oncekihedef = {-1, -1};
    public static int[] konum = {0, 0};

    public oyuncuD() {
    }

    public int[][] hareketEt(int[] hedef, int[][] tahta, int[] konum) {
        int i = hedef[0] - konum[0];
        int j = hedef[1] - konum[1];
        int count = 0;
        if (gameplay.D.adim >= Math.abs(i) + Math.abs(j)) {
            while (i != count) {  // x ekseni uzerinde hareket
                if (i < 0) {
                    count--;
                } else {
                    count++;
                }

                if (tahta[konum[0] + count][konum[1]] > 0) {
                    gameplay.D.altin += tahta[konum[0] + count][konum[1]];
                    tahta[konum[0] + count][konum[1]] = 0;
                } else if (tahta[konum[0] + count][konum[1]] < 0) {
                    tahta[konum[0] + count][konum[1]] = Math.abs(tahta[konum[0] + count][konum[1]]);
                }

            }
            gameplay.D.adim = gameplay.D.adim - Math.abs(count);
            count = 0;
            konum[0] = hedef[0];
            while (j != count) {     // y ekseni uzerinde hareket
                if (j < 0) {
                    count--;
                } else {
                    count++;
                }

                if (tahta[konum[0]][konum[1] + count] > 0) {
                    gameplay.D.altin += tahta[konum[0]][konum[1] + count];
                    tahta[konum[0]][konum[1] + count] = 0;
                } else if (tahta[konum[0]][konum[1] + count] < 0) {
                    tahta[konum[0]][konum[1] + count] = Math.abs(tahta[konum[0]][konum[1] + count]);
                }
            }
            gameplay.D.adim = gameplay.D.adim - Math.abs(count);
            konum[1] = hedef[1];
            gameplay.D.konum[0] = hedef[0];
            gameplay.D.konum[1] = hedef[1];
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
                    gameplay.D.altin += tahta[konum[0] + count][konum[1]];
                    tahta[konum[0] + count][konum[1]] = 0;
                } else if (tahta[konum[0] + count][konum[1]] < 0) {
                    tahta[konum[0] + count][konum[1]] = Math.abs(tahta[konum[0] + count][konum[1]]);
                }
                if (gameplay.D.adim == Math.abs(count)) {
                    gameplay.D.konum[0] = konum[0] + count;
                    gameplay.D.adim = gameplay.D.adim - Math.abs(count);
                    return tahta;
                }
            }

            konum[0] = hedef[0];
            gameplay.D.adim = gameplay.D.adim - Math.abs(count);
            count = 0;
            while (j != count) {
                if (j < 0) {
                    count--;
                } else {
                    count++;
                }

                if (tahta[konum[0]][konum[1] + count] > 0) {
                    gameplay.D.altin += tahta[konum[0]][konum[1] + count];
                    tahta[konum[0]][konum[1] + count] = 0;
                } else if (tahta[konum[0]][konum[1] + count] < 0) {
                    tahta[konum[0]][konum[1] + count] = Math.abs(tahta[konum[0]][konum[1] + count]);
                }
                if (gameplay.D.adim == Math.abs(count)) {
                    gameplay.D.konum[0] = konum[0];
                    gameplay.D.konum[1] = konum[1] + count;
                    gameplay.D.adim = gameplay.D.adim - Math.abs(count);
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
            gameplay.tahta = gameplay.D.hareketEt(oncekihedef, gameplay.tahta, gameplay.D.konum);
            if (gameplay.D.adim > 0) {
                oncekihedef[0] = -1;
                oncekihedef[1] = -1;
            } else {
                if (oncekihedef[0] == gameplay.D.konum[0] && oncekihedef[1] == gameplay.D.konum[1]) {
                    oncekihedef[0] = -1;
                    oncekihedef[1] = -1;
                    return;
                }
                return;
            }
        }
        if (gameplay.D.altin > gameplay.D.hedefMaliyeti) {
            gameplay.D.altin -= gameplay.D.hedefMaliyeti;
            gameplay.totalHarcananD += gameplay.D.hedefMaliyeti;
            int[] hedef = altin_bul(gameplay.D.konum, gameplay.tahta);
            gameplay.tahta = gameplay.D.hareketEt(hedef, gameplay.tahta, gameplay.D.konum);
            if (gameplay.D.adim == 0) {
                if (hedef[0] == gameplay.D.konum[0] && hedef[1] == gameplay.D.konum[1]) {
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
                gameplay.D.arama();
            }
        } else {
            return;
        }

    }

    public int[] altin_bul(int[] konum, int[][] tahta) {
        ArrayList<Integer> satir = new ArrayList<Integer>();
        ArrayList<Integer> sutun = new ArrayList<Integer>();
        float enKarli = -999999;
        for (int i = 0; i < tahta.length; i++) {
            for (int j = 0; j < tahta[0].length; j++) {
                if (tahta[i][j] > 0) {
                    int[] altinKonum = new int[2];
                    altinKonum[0] = i;
                    altinKonum[1] = j;
                    if ((karsilastir(gameplay.A.oncekihedef, altinKonum, gameplay.A.konum, gameplay.A.altin_bul(gameplay.A.konum, gameplay.tahta)))
                            && (karsilastir(gameplay.B.oncekihedef, altinKonum, gameplay.B.konum, gameplay.B.altin_bul(gameplay.B.konum, gameplay.tahta)))
                            && (karsilastir(gameplay.C.oncekihedef, altinKonum, gameplay.C.konum, gameplay.C.altin_bul(gameplay.C.konum, gameplay.tahta, false)))) {
                        satir.add(i);
                        sutun.add(j);
                    }
                }
            }
        }

        int[] altinKonum = new int[2];
        for (int i = 0; i < satir.size(); i++) {
            float uzaklik = (Math.abs(konum[0] - satir.get(i)) + Math.abs(konum[1] - sutun.get(i)));
            if (uzaklik < 1) {
                uzaklik = 2;
            }
            float maliyet = (float) Math.ceil(uzaklik / gameplay.A.adim) * gameplay.D.hamleMaliyeti + gameplay.D.hedefMaliyeti;
            float hesap = (tahta[satir.get(i)][sutun.get(i)] - maliyet); 
            if (hesap > enKarli) {
                enKarli = hesap;
                altinKonum[0] = satir.get(i);
                altinKonum[1] = sutun.get(i);
                
            }
        }
        if (altinKonum[0] == 0 && altinKonum[1] == 0) {
            return konum;
        }
        return altinKonum;
    }

    public boolean karsilastir(int[] oncekihedef, int[] altin, int[] konum, int[] hedef) {
        int hedefUzaklik, uzaklik;
        if (konum[0] == -1 && konum[1] == -1) {
            return true;
        }
        if (oncekihedef[0] == altin[0] && oncekihedef[1] == altin[1]) {
            hedefUzaklik = (int) Math.ceil((Math.abs(oncekihedef[0] - konum[0]) + Math.abs(oncekihedef[1] - konum[1])) / gameplay.A.adim);
            uzaklik = (int) Math.ceil((Math.abs(oncekihedef[0] - gameplay.D.konum[0]) + Math.abs(oncekihedef[1] - gameplay.D.konum[1])) / gameplay.A.adim);
            if (uzaklik <= hedefUzaklik) {
                return true;
            }
            return false;
        } else if (hedef[0] == altin[0] && hedef[1] == altin[1]) {
            hedefUzaklik = (int) Math.ceil((Math.abs(hedef[0] - konum[0]) + Math.abs(hedef[1] - konum[1])) / gameplay.A.adim);
            uzaklik = (int) Math.ceil((Math.abs(hedef[0] - gameplay.D.konum[0]) + Math.abs(hedef[1] - gameplay.D.konum[1])) / gameplay.A.adim);
            if (uzaklik <= hedefUzaklik) {
                return true;
            }
            return false;
        }
        return true;
    }
}
