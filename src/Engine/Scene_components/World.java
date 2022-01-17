package Engine.Scene_components;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class World {

    // attributes
    public Color color;

    // consturctor
    public World(){
        setDefaults();
    }

    // private methods
    private void setDefaults(){
        this.color = new Color(0,0,0);
    }

    // methods
    public void setColor(Color _color){
        this.color = _color;
    }




}
