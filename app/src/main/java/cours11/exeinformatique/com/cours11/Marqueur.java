package cours11.exeinformatique.com.cours11;

import android.graphics.Bitmap;

public class Marqueur implements PlanViewDisplayable {
    private float positionX = 0;
    private float positionY = 0;
    private Bitmap marqueur;

    public Marqueur(Bitmap marqueur, int posX, int posY) {
        this.marqueur = marqueur;
        positionX = posX - (marqueur.getWidth() / 2);
        positionY = posY - marqueur.getHeight();
    }

    @Override
    public float getPositionX() {
        return positionX;
    }

    @Override
    public float getPositionY() {
        return positionY;
    }

    @Override
    public Bitmap getBitmap() {
        return marqueur;
    }

    @Override
    public float getHeight() {
        return marqueur.getHeight();
    }

    @Override
    public float getWidth() {
        return marqueur.getWidth();
    }
}
