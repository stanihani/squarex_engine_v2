package Engine.Scene_components;

import Engine.Engine;

import java.util.ArrayList;

public class Scene {

    // required parts
    public World world;
    public ArrayList<Entity> entities;
    public Engine engine;
    public Overlay overlay;

    // constructor
    public Scene(Engine _engine){

        // bind Engine
        engine = _engine;

        // create required Scene Elements
        world = new World();
        entities =  new ArrayList<Entity>();

    }

    // private methods
    public void updateScene(){
        // here comes the Scene macgic
    }


}
