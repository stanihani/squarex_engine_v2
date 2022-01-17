package Engine;

import App.tvScanLines;
import Engine.Scene_components.Entity;
import Engine.Scene_components.Scene;
import Engine.Scene_components.defaultScene;
import Modules.console;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class Engine {

    // engine state
    public boolean          isEngineReady;

    // Engine Settings
    private int             resX;
    private int             resY;
    private String          title;
    private int             maxFPS;

    // Components
    JFrame                  frame;
    JPanel                  panel;
    InputHandler            input;
    Scene                   scene;
    public EngineStats      stats;

    // Cycle Components
    Timer                   timer;
    TimerTask               cycleTask;

    // constructor --> Overloaded
    public Engine(){

        setDefaultSettings();
        createRunnableEngineThread();

    }

    public Engine(int _resX, int _resY){

        setDefaultSettings();

        this.resX = _resX;
        this.resY = _resY;

        createRunnableEngineThread();
    }

    public Engine(int _resX, int _resY,String _title){

        setDefaultSettings();

        this.resX = _resX;
        this.resY = _resY;
        this.title = _title;

        createRunnableEngineThread();
    }

    // internal methods
    private void createRunnableEngineThread(){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createEnvironment();
            }
        });
    }

    private void createEnvironment(){

        // create frame
        frame = new JFrame();
        frame.setTitle(this.title);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);

        // create panel
        panel =  new JPanel(true){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);

                // update size
                resX = panel.getWidth();
                resY = panel.getHeight();

                // paint world
                g.setColor(scene.world.color);
                g.fillRect(0,0,resX,resY);

                // paint Entities
                for(Entity i: scene.entities){
                    g.setColor(i.color);
                    g.fillRect(i.x,i.y,i.w,i.h);
                };

                // paint overlay


                // debugger
                g.setColor(new Color(0, 0, 0, 205));
                g.fillRect(0,0, resX, 150);

                g.setColor(new Color(255, 255, 255));
                g.drawString("System Millis: "+ System.currentTimeMillis(),20,20);
                g.drawString("KeyMap: "+ input.KeyMap.toString(),20,40);
                g.drawString("MouseMap: "+ input.MouseMap.toString(),20,60);
                g.drawString("MousePos: "+ input.MousePos.toString(),20,80);
                g.drawString("Panel Resolution: "+panel.getWidth()+" x "+panel.getHeight(),20,100);
                g.drawString("Frame Resolution: "+frame.getWidth()+" x "+frame.getHeight(),20,120);



            }
        };
        panel.setPreferredSize(new Dimension(this.resX,this.resY));

        // set Size of panel
        frame.add(panel);
        frame.pack();

        // bind inputHandler
        input = new InputHandler(frame);

        // initialize Engine Stats
        stats = new EngineStats();

    }

    private void setDefaultSettings(){

        // set screen size
        this.resX = 640;
        this.resY = 480;
        this.maxFPS = 60;
        this.title = "Squarex Egine";

    }

    // public Methods
    public void startEngine(){

        // check if engine is ready
        long stime = System.currentTimeMillis();
        while(this.panel == null){
            console.print("Engine not ready...");
        }
        console.print("Engine ready after: "+(System.currentTimeMillis()-stime)+"ms");

        // load default scene
        loadScene(new tvScanLines(this));

        // prepare Cycle
        timer = new Timer();
        cycleTask =  new TimerTask() {
            @Override
            public void run() {
                nextFrame();
            }
        };

        // start cycle
        timer.schedule(cycleTask,0,20);

    }

    // render frame
    public void nextFrame(){
        // start measuring
        long stime = System.currentTimeMillis();

        // updateScene
        scene.updateScene();

        // paint new frame
        panel.repaint();

        // show frametime
        console.print("Frametime: "+(System.currentTimeMillis()-stime));
    }

    // load scene
    public void loadScene(Scene _scene){
        this.scene = _scene;
    }

    // setters
    public void setMaxFPS(int _maxFPS){

    }

    // getters
    public int getResX(){
        return panel.getWidth();
    }

    public int getResY(){
        return panel.getHeight();
    }

}
