package mindescape.view.enigmapuzzle.impl;

import javax.swing.*;
import java.awt.*;

/**
 * ImageButton is a custom JButton that allows setting an image to be displayed on the button.
 * It extends the JButton class and overrides the paintComponent method to draw the image.
 */
public class ImageButton extends JButton {

    private final static long serialVersionUID = 1L;

    private Image image;

    /**
     * Constructs an ImageButton object.
     * This constructor calls the superclass constructor to initialize the ImageButton.
     */
    public ImageButton() {
        super();
    }

    /**
     * Sets the image for this button and repaints the component.
     *
     * @param image the new image to be set
     */
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    /**
     * Overrides the paintComponent method to draw an image on the component.
     * 
     * @param g the Graphics object used for drawing the image
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
