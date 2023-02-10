package yeni;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class mapGenerator {

    public int brickWidth;
    public int brickHeight;
    public int karakterX;
    public int karakterY;
    public int font;
    
    public int total_sayisi;
    public int gizli_sayisi;
    public int altin_sayisi;
    public int count;

    
    public mapGenerator(int row, int col) { 
        brickWidth = 1100 / col;
        brickHeight = 500 / row;
        karakterX = 550 / col;
        karakterY = 250 / row;
        font = 1100 / (col*3);
    }

    public void draw(Graphics2D g, int[][] map,int[] konumA, int[] konumB, int[] konumC, int[] konumD) {
        g.setFont(new Font("Tahoma", Font.PLAIN, font));
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    g.setColor(Color.lightGray);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);  
                }
                else if(map[i][j] > 0){
                    g.setColor(Color.yellow);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    g.drawString(Integer.toString(map[i][j]), j * brickWidth + 82, i * brickHeight + 70);
                }
                else if(map[i][j] < 0){
                    g.setColor(Color.red);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight); 
                    g.drawString(Integer.toString(-map[i][j]), j * brickWidth + 82, i * brickHeight + 70);
                }
                if(konumA[0]== i && konumA[1] == j){
                    g.setColor(Color.blue);
                    g.fillRect(j * brickWidth + 92, i * brickHeight + 53, brickWidth-25, brickHeight-6);
                }
                else if(konumB[0]== i && konumB[1] == j){
                    g.setColor(Color.green);
                    g.fillRect(j * brickWidth + 92, i * brickHeight + 53, brickWidth-25, brickHeight-6);
                }
                else if(konumC[0]== i && konumC[1] == j){
                    g.setColor(Color.magenta);
                    g.fillRect(j * brickWidth + 92, i * brickHeight + 53, brickWidth-25, brickHeight-6);
                }
                else if(konumD[0]== i && konumD[1] == j){
                    g.setColor(Color.black);
                    g.fillRect(j * brickWidth + 92, i * brickHeight + 53, brickWidth-25, brickHeight-6);
                }
            }
        }
    }
}
