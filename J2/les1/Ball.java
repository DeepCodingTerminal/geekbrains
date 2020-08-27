package J2.les1;

import java.awt.*;

public class Ball extends Sprite {
    private final Color color;
    private float vX;
    private float vY;

    Ball() {
        halfWidth = 20 + (float) (Math.random() * 50f);
        halfHeight = halfWidth;
        color = new Color (
                (int)(Math.random() * 255), //r
                (int)(Math.random() * 255), //g
                (int)(Math.random() * 255)  //b
        );
        vX = (float)(100f + (Math.random() * 200f));
        vY = (float)(100f + (Math.random() * 200f));
    }

    @Override
    public void update(GameCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;
        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }
}
