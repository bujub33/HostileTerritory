package com.hostileterritory;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hostileterritory.screens.AboutScreen;
import com.hostileterritory.screens.InstructionScreen;
import com.hostileterritory.screens.PlayScreen;
import com.hostileterritory.screens.StartScreen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class HostileTerritory extends ApplicationAdapter {
	public static float V_WIDTH = 400;
	public static float V_HEIGHT = 208;
	public SpriteBatch batch;
	public static final float PPM = 100;
	
	
	public static AssetManager assetManager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
		
		
		assetManager = new AssetManager();
        //assetManager.load("audio/music/Call-of-Duty-Black-Ops-2-Zombie - Theme-Song (Mp3FB.com).mp3", Music.class);
        assetManager.finishLoading();
        //this.setScreen(new StartScreen(this));
        
	}


	public void setScreen(StartScreen startScreen) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void render () {
	super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}


	public void setScreen(InstructionScreen instructionScren) {
		// TODO Auto-generated method stub
		
	}


	public void setScreen(AboutScreen aboutScreen) {
		// TODO Auto-generated method stub
		
	}

}
