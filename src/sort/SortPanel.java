package sort;

import static sort.Sleep.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class SortPanel extends JPanel {
    private static final int WIDTH = 1160;
    private static final int HEIGHT = 720;
    private static final int SIZE = 8;
    private static final int LENGTH = WIDTH / SIZE;
    private int speed;
    private int[] array;
    private int[] color;
    private boolean start = false;
    private boolean lineEnable = false;
    public SortPanel() {
        array = new int[LENGTH];
        color = new int[LENGTH];
        setBackground(new Color(34, 34, 34));
    }
    public void Generation()
    {
        for (int i = 0; i < LENGTH; i++) {
            array[i] = i;
            color[i] = 0; //set at first index
        }
    }
    public void shuffleElement()
    {
        Random rand = new Random();
        for (int i = 0; i < getArraySize(); i++) {
            int index = rand.nextInt(getArraySize() - 1);
            swap(i, index);
        }
    }
    public void swap(int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
        color[first] = 70;
        color[second] = 70;
        repaint();
        /*
            This method is more consistency
         */
        sleepFor(millisecondsToNano(speed)); //Use this instead of Thread
    }
    public int getArrayIndex(int index) {
        return array[index];
    }
    public void setArray(int[] array) {
        this.array = array;
    }
    public int getArraySize() {
        return array.length;
    }
    public void setLineEnable(boolean lineEnable) {
        this.lineEnable = lineEnable;
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setStartSorting(boolean start) {
        this.start = start;
    }
    public void resetColor()
    {
        for (int i = 0; i < getArraySize(); i++) {
            color[i] = 0;
        }
        repaint();
    }
    public void colorCoverUp()
    {
        for (int i = 0; i < getArraySize(); i++) {
            getCoverUp(i, getArrayIndex(i));
        }
    }
    private void getCoverUp(int index, int value) {
        array[index] = value;
        color[index] = 70;
        repaint();
        sleepFor(millisecondsToNano(5));
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < LENGTH; i++) {
            int bar_height = array[i] * 4;
            int x = i + (SIZE - 1) * i;
            int y = HEIGHT - bar_height;
            g2d.setColor(new Color(255, 255, 255));
            g2d.fillRect(x, y, SIZE, bar_height);

            int value = color[i] * 2;
            if(lineEnable) {
                g2d.setColor(new Color(0, 191, 103));
                g2d.drawLine(x, y, SIZE, bar_height);
            }
            if(start) {
                g2d.setColor(new Color(255 - value, 255, 255 - value));
                g2d.fillRect(x, y, SIZE, bar_height);
            }
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x, y, SIZE, bar_height);
            if(color[i] > 0)
                color[i] -= 10;
        }
    }
}
