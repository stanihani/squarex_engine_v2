package Engine.Scene_components;

import java.awt.*;

public class Entity {

    public int     x;
    public int     y;
    public int     w;
    public int     h;
    public Color   color;

    // constructor
    public Entity(){
        setDefaults();
    }

    public Entity(int _x,int _y,int _w,int _h,Color _c){
        this.x = _x;
        this.y = _y;
        this.h = _w;
        this.w = _h;
        this.color = _c;
    }

    // private methods
    private void setDefaults(){
        this.x = 10;
        this.y = 10;
        this.h = 100;
        this.w = 100;
        this.color = new Color(50,50,0);

    }

    // methods
    public void moveTo(int _posX, int _posY){
        this.x = _posX;
        this.y = _posY;
    }
}
