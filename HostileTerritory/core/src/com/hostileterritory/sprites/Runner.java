package com.hostileterritory.sprites;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.hostileterritory.HostileTerritory;

/**
 * @author Elishua Brown on 11/22/16
 */
public class Runner extends ApplicationAdapter {
	TextureAtlas textureAtlas;
	//private Texture texture;
	Sprite hero;
	SpriteBatch batch;
	float elapsedTime = 0;
	private Animation animation;
	
	public World world;
	public Body b2body;

	public Runner(World world){
		this.world = world;
		defineRunner();
	}
	public void defineRunner(){
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(32/ HostileTerritory.PPM, 32/ HostileTerritory.PPM);
		bodyDef.type = BodyDef.BodyType.KinematicBody;
		b2body = world.createBody(bodyDef);
		
		FixtureDef fixDef = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(5/ HostileTerritory.PPM);
		
		fixDef.shape = shape;
		b2body.createFixture(fixDef);
		
		
}

	@Override
	public void create() {        
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("running.atlas"));
		animation = new Animation(1/15f, textureAtlas.getRegions());
		/*
		world = new World(new Vector2(0, -98f), true);
		BodyDef bodyDef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fixdef = new FixtureDef();
		Body body;
		
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(hero.getX(), hero.getY());
        
        // Create the body in the world
        body = world.createBody(bodyDef);
        
        shape.setAsBox(hero.getWidth() /2, hero.getHeight() /2 );
        fixdef.shape = shape;
        body.createFixture(fixdef);
        */
	}

	@Override
	public void dispose() {
		batch.dispose();
		textureAtlas.dispose();
	}

	@Override
	public void render() {        
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//b2dr.render(world, gameCam.combined);

		/*if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			//smaller jump
			hero.b2body.applyLinearImpulse(new Vector2(0, 4f), hero.b2body.getWorldCenter(), true);
			
			textureAtlas = new TextureAtlas(Gdx.files.internal("jumping.atlas"));
			animation = new Animation(1/15f, textureAtlas.getRegions());
			
			if(Gdx.input.isKeyPressed(Input.Keys.UP))
				//Float until limit reached
				hero.b2body.applyAngularImpulse(new Vector2(0, 4f), hero.b2body.getWorldCenter(), true);
								//Add sprite that shows when key is held-- 


		}
		else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			batch.draw(animation.getKeyFrame(elapsedTime, true), 0, 0);
			//Roll if pressed				
			textureAtlas = new TextureAtlas(Gdx.files.internal("dying.atlas"));

			if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
				//Crawl if held
				//Add sprite that shows when key is held-- 

				
			animation = new Animation(1/15f, textureAtlas.getRegions());
		}
		else{
			textureAtlas = new TextureAtlas(Gdx.files.internal("running.atlas"));
			animation = new Animation(1/15f, textureAtlas.getRegions());
		}*/


		batch.begin();
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(elapsedTime, true), 0, 0);
		batch.end();
	}
}

