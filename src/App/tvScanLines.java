package App;

import Engine.Engine;
import Engine.Scene_components.Entity;
import Engine.Scene_components.Scene;

import java.awt.*;

public class tvScanLines extends Scene {

    public tvScanLines(Engine _engine){
        super(_engine);
        createScanLines();
    }

    @Override
    public void updateScene() {
        updateScanLines();
    }

    // internal methods
    private void createScanLines(){

        int amount = 100;
        int size = 2;
        int w = 200;

        for(int i = 0;i<amount;i++){
            int h = 8;//(int)Math.ceil(Math.random()*size);
            int y = (int)Math.floor(Math.random()*(engine.getResY()-h));

            // color
            Color c = new Color(
                    (int)Math.floor(Math.random()*256),
                    (int)Math.floor(Math.random()*256),
                    (int)Math.floor(Math.random()*256)
            );

            entities.add(new Entity(0,y,300,h,c));
        }
    }

    private void updateScanLines(){
        for(Entity i:entities){
            i.y = (int)Math.floor(Math.random()*(engine.getResY()-i.h));
        }
    }


}
