package Engine.Scene_components;

import Engine.Engine;
import Modules.console;
import com.sun.tools.jconsole.JConsoleContext;

import java.awt.*;

public class defaultScene extends Scene{

    public defaultScene(Engine _engine) {
        super(_engine);
        createEntities();
    }

    private void createEntities(){
        int maxSize = 8;
        int amount = 100000;
        for(int i = 0;i<amount;i++){
            // Size
            int w = 2;//(int)Math.ceil(Math.random()*maxSize);
            int h = w;

            // pos
            int x = (int)Math.floor((Math.random()*(engine.getResX()-w)));
            int y = (int)Math.floor((Math.random()*(engine.getResY()-h)));

            // color
            Color c = new Color(
                    (int)Math.floor(Math.random()*256),
                    (int)Math.floor(Math.random()*256),
                    (int)Math.floor(Math.random()*256)
            );

            // add Entity to entities
            entities.add(new Entity(x,y,w,h,c));
        }
    }

    @Override
    public void updateScene(){
        updatePosB();

        // color
        Color c = new Color(
                (int)Math.floor(Math.random()*40),
                (int)Math.floor(Math.random()*40),
                (int)Math.floor(Math.random()*40 )
        );

        //world.setColor(new Color(255,255,255));

    }

    private void updatePosA(){
        for(Entity i:entities){

            // pos
            int x = (int)Math.floor((Math.random()*(engine.getResX()-i.w)));
            int y = (int)Math.floor((Math.random()*(engine.getResY()-i.h)));

            // place at new pos
            i.moveTo(x,y);

        }
    }

    private void updatePosB(){
        for(Entity i:entities){

            // pos
            i.x = (int)Math.floor((Math.random()*(engine.getResX()-i.w)));
            i.y = (int)Math.floor((Math.random()*(engine.getResY()-i.h)));

        }
    }
}
