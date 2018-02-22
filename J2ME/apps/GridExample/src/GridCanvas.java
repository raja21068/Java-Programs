import javax.microedition.lcdui.game.*;
import javax.microedition.lcdui.*;

public class GridCanvas extends Canvas {

    int highlightedRow = 0;
    int highlightedColumn = 0;
    Image[][] normalImageMat;
    Image[][] highlightedImageMat;
    Image[][] imageMat;
    int gridColumnNo;
    int gridRowNo;

    /**
     * constructor
     */
    public GridCanvas() {
        gridColumnNo = 2;
        gridRowNo = 2;

        normalImageMat = new Image[gridRowNo][gridColumnNo];
        highlightedImageMat = new Image[gridRowNo][gridColumnNo];
        imageMat = new Image[gridRowNo][gridColumnNo];

        try {

            for (int i = 0; i < gridRowNo; i++) {
                for (int j = 0; j < gridColumnNo; j++) {
                    normalImageMat[i][j] = Image.createImage("/hello/normalImage" + i + j + ".png");
                }
            }

            for (int i = 0; i < gridRowNo; i++) {
                for (int j = 0; j < gridColumnNo; j++) {
                    highlightedImageMat[i][j] = Image.createImage("/hello/highlightedImage" + i + j + ".png");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * paint
     */
    public void paint(Graphics g) {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < gridRowNo; i++) {
            System.arraycopy(normalImageMat[i], 0, imageMat[i], 0, 2);
        }
        imageMat[highlightedRow][highlightedColumn] = highlightedImageMat[highlightedRow][highlightedColumn];


        int width = 0;
        int height = 0;
        for (int i = 0; i < gridRowNo; i++) {
            for (int j = 0; j < gridColumnNo; j++) {
                g.drawImage(imageMat[i][j], width, height, 0);
                width = width + imageMat[i][j].getWidth();
            }
            width = 0;
            height = height + imageMat[0][0].getHeight();
        }

    }

    /**
     * Called when a key is pressed.
     */
    protected void keyPressed(int keyCode) {
        int gameAction = this.getGameAction(keyCode);
        if (gameAction == RIGHT) {
            highlightedColumn = Math.min(highlightedColumn + 1, gridColumnNo - 1);
        } else if (gameAction == LEFT) {
            highlightedColumn = Math.max(highlightedColumn - 1, 0);
        } else if (gameAction == UP) {
            highlightedRow = Math.max(0, highlightedRow - 1);
        } else if (gameAction == DOWN) {
            highlightedRow = Math.min(gridRowNo - 1, highlightedRow + 1);
        }
        repaint();
    }
} 