package ui;

import java.awt.*;

public class MenuButton {

    private Rectangle bounds;
    private String text;
    private Font font;
    private Color color;

    public MenuButton(int x, int y, int width, int height, String text) {
        this.bounds = new Rectangle(x, y, width, height);
        this.text = text;
        this.font = new Font("Arial", Font.BOLD, 20);
        this.color = Color.WHITE;
    }

    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.setColor(Color.BLACK);
        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.setColor(color);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        int textX = bounds.x + (bounds.width - fm.stringWidth(text)) / 2;
        int textY = bounds.y + ((bounds.height - fm.getHeight()) / 2) + fm.getAscent();
        g.drawString(text, textX, textY);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
