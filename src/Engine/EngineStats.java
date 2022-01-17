package Engine;

import java.util.ArrayList;

public class EngineStats {

    // Attributes
    public long FrameCount;
    public long lastFrameTime;
    public double avgFrameTime;
    public double avgFPS;
    public int minFPS;
    public int maxFPS;
    public double engineLoad;
    public boolean isEngineReady;

    // settings
    public int AvgMeasureRangeInMillis = 1000;

    // Maps & Arrays
    ArrayList<ArrayList<Object>> framesArr;

    // constructor
    public EngineStats(){

        // set values
        this.FrameCount = 0;
        this.lastFrameTime = System.currentTimeMillis();
        this.isEngineReady =  false;

        // create Array
        framesArr =  new ArrayList<ArrayList<Object>>();

    }

    // internal Methods
    private void calculateAvgFPS(){

    }


    // public Methods
    public void addFrameStats(int _frameTime,long _timeStamp){

        framesArr.add(
                new ArrayList<Object>(){{
                    add(_timeStamp);
                    add(_frameTime);
                }}
        );

        // check if range reached


    }
}
