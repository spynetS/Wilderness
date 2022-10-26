package com.main;

import com.javagamemaker.javagameengine.JavaGameEngine;
import com.javagamemaker.javagameengine.components.*;
import com.javagamemaker.javagameengine.input.Input;
import com.javagamemaker.javagameengine.input.Keys;
import com.javagamemaker.javagameengine.msc.Vector2;
import jdk.jfr.Unsigned;

import java.awt.*;
import java.math.BigInteger;

public class Player extends Sprite {

    public Player(){

        //add(new Collider());
       // add(new PhysicsBody());
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
            setPosition(getPosition().add(Vector2.right));
        }
        if(Input.isKeyDown(Keys.A)){
            animationIndex = 3;
            setPosition(getPosition().add(Vector2.left));
        }
        if(Input.isKeyDown(Keys.W)){
            animationIndex = 0;
            setPosition(getPosition().add(Vector2.up));
        }
        if(Input.isKeyDown(Keys.S)){
            animationIndex = 1;
            setPosition(getPosition().add(Vector2.down));
        }
        JavaGameEngine.getSelectedScene().getCamera().setPosition(this.getFirstParent().getPosition().multiply(-1.0F).add(JavaGameEngine.getWindowSize().divide(2)));

    }
}
