package com.main;

import com.javagamemaker.javagameengine.components.GameObject;
import com.javagamemaker.javagameengine.components.Sprite;
import com.javagamemaker.javagameengine.input.Input;
import com.javagamemaker.javagameengine.input.Keys;

import java.awt.*;

public class Player extends Sprite {

    public Player(){

        Rectangle[] up = new Rectangle[2];
        up[0] = new Rectangle(24,24,24,24);
        up[1] = new Rectangle(24,0,24,24);
        loadAnimation(up,"/ACharUp.png");

        up[0] = new Rectangle(24,24,24,24);
        up[1] = new Rectangle(24,0,24,24);
        loadAnimation(up,"/ACharDown.png");

        up[0] = new Rectangle(0,24,24,24);
        up[1] = new Rectangle(24,0,24,24);
        loadAnimation(up,"/ACgarRight.png");

        up[0] = new Rectangle(0,24,24,24);
        up[1] = new Rectangle(24,0,24,24);
        loadAnimation(up,"/ACharLeft.png");
        setTimer(20);
    }

    @Override
    public void update() {
        super.update();
        if(Input.isKeyDown(Keys.D)){
            animationIndex = 2;
        }
        if(Input.isKeyDown(Keys.A)){
            animationIndex = 3;
        }
        if(Input.isKeyDown(Keys.W)){
            animationIndex = 0;
        }
        if(Input.isKeyDown(Keys.S)){
            animationIndex = 1;
        }
    }
}
