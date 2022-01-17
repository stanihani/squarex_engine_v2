package Engine;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class InputHandler {

    // Attributes
    public HashMap<Integer,Integer> KeyMap;
    public HashMap<String, Integer> MousePos;
    public HashMap<Integer,Integer> MouseMap;

    // constructor
    public InputHandler(JFrame _frame){

        // bind HashMaps
        bindKeyListener(_frame);
        bindMouseKeyListener(_frame);
        bindMousePosListener(_frame);
    }

    // internal methods
    private void bindKeyListener(JFrame _frame){

        // prepare Hashmap
        KeyMap = new HashMap<Integer,Integer>();

        // bind listener
        _frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // not needed
            }

            @Override
            public void keyPressed(KeyEvent e) {
                KeyMap.put(e.getKeyCode(),1);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyMap.put(e.getKeyCode(),0);
            }
        });
    }

    private void bindMousePosListener(JFrame _frame){
        // prepare HashMap
        MousePos = new HashMap<String,Integer>();
        MousePos.put("x",(int) Math.floor(_frame.getWidth()/2));
        MousePos.put("y",(int) Math.floor(_frame.getHeight()/2));

        // bind listener
        _frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                MousePos.put("x",e.getX());
                MousePos.put("y",e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                MousePos.put("x",e.getX());
                MousePos.put("y",e.getY());
            }
        });
    }

    private void bindMouseKeyListener(JFrame _frame){
        // prepare HashMap
        MouseMap = new HashMap<Integer,Integer>();

        // bind listener
        _frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // not needed
            }

            @Override
            public void mousePressed(MouseEvent e) {
                MouseMap.put(e.getButton(),1);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                MouseMap.put(e.getButton(),0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // not needed
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //not needed
            }
        });
    }

}
