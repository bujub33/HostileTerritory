package com.hostileterritory.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

/**
 * @author created by Agbai Iroha on 11/22/16
 */

public class HostileTerritory extends Game{

	
	public SpriteBatch batch;
    //public BitmapFont font;

    public static final int V_WIDTH = 800;
    public static final int V_HEIGHT = 480;
    public static final float PPM = 32;




    public static AssetManager assetManager;

    public void create () {

        batch = new SpriteBatch();
        assetManager = new AssetManager();
        //assetManager.load("audio/music/Call-of-Duty-Black-Ops-2-Zombie - Theme-Song (Mp3FB.com).mp3", Music.class);
        //assetManager.load("audio/sounds/pirateJump.wav", Sound.class);
        assetManager.finishLoading();
        this.setScreen(new StartScreen(this));

    }

    public void render(){

        super.render();

        //assetManager.dispose();
        //batch.dispose();

    }


}
