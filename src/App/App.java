package App;

import Engine.Engine;
import Engine.Scene_components.defaultScene;
import Modules.console;

import java.util.Timer;
import java.util.TimerTask;

public class App {

    // app settings
    int resX = 600;
    int resY = 400;

    // Required parts
    Engine engine;

    void start(){

        // prepare engine
        engine =  new Engine();
        engine.startEngine();

        // load scene
        engine.loadScene(new defaultScene(engine));

        // load initial scene
        //engine.loadScene(new defaultScene(engine));



    }

    public static void main(String[] args){
        new App().start();
    }
}
