package com.main;

import com.javagamemaker.javagameengine.JavaGameEngine;
import com.javagamemaker.javagameengine.Scene;
import com.javagamemaker.javagameengine.components.Component;
import com.javagamemaker.javagameengine.components.Sprite;

import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main extends JavaGameEngine {


    public static void main(String[] args){

        Scene scene1 = new Scene(){
            @Override
            public void load() {
                try {
                    FileInputStream fos = new FileInputStream("filename");
                    ObjectInputStream oos = new ObjectInputStream(fos);

                    Component c;
                    for(Iterator var3 = ((LinkedList)oos.readObject()).iterator(); var3.hasNext();
                        add(c)) {
                        c = (Component)var3.next();
                        if (c.getClass() == Sprite.class) {
                            LinkedList<Rectangle[]> oldTiles = ((Sprite)c).tiles;
                            ((Sprite)c).tiles = new LinkedList();
                            ((Sprite)c).animations = new ArrayList();
                            ((Sprite)c).animations1 = new ArrayList();
                            Iterator var6 = oldTiles.iterator();

                            while(var6.hasNext()) {
                                Rectangle[] animation = (Rectangle[])var6.next();
                                ((Sprite)c).loadAnimation(animation, ((Sprite)c).spriteSheetString);
                            }

                        }
                    }

                    fos.close();
                } catch (Exception var8) {
                    var8.printStackTrace();
                }
            }
        };
        scene1.load();
        scene1.setDebugMode(false);
        scene1.add(new Player());

        setSelectedScene(scene1);
        start();

    }

    static class Tile extends Sprite{

    }


}
