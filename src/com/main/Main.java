package com.main;

import com.javagamemaker.javagameengine.JavaGameEngine;
import com.javagamemaker.javagameengine.Scene;
import com.javagamemaker.javagameengine.components.Sprite;

public class Main extends JavaGameEngine {


    public static void main(String[] args){

        Scene scene1 = new Scene();
        scene1.setDebugMode(false);
        scene1.add(new Player());

        setSelectedScene(scene1);
        start();

    }

    static class Tile extends Sprite{

    }


}
