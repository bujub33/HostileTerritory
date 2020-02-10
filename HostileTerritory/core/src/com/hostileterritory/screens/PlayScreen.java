package com.hostileterritory.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hostileterrotory.Box2D.Hud;

public class PlayScreen implements Screen{
	final com.hostileterritory.screens.HostileTerritory game;
	private OrthographicCamera gameCam;
	private Viewport gamePort;
	private Hud hud;
	private World world;
	private HostileTerritory hero;
	Box2DDebugRenderer b2dr;
	//-------------------------------------------
	
	

	public PlayScreen(final HostileTerritory hostileTerritory) {
		this.game = hostileTerritory;
		gameCam = new OrthographicCamera();
		gamePort = new com.badlogic.gdx.utils.viewport.FitViewport(HostileTerritory.V_WIDTH / HostileTerritory.PPM, HostileTerritory.V_HEIGHT / HostileTerritory.PPM,  gameCam);
		hud = new Hud(game.batch);
		//renderer = new OrthoganalMapRenderer(map, 1/ HostileTerritory.PPM);
		gameCam.position.set(gamePort.getScreenWidth() / 2, gamePort.getScreenHeight() / 2, 0);
		world = new World(new Vector2(0,0), true);
		b2dr = new Box2DDebugRenderer();
		
		//-----------------------------------------------------------------
		rbg = new ParallaxBackground(new ParallaxLayer[]{
	            new ParallaxLayer(atlas.findRegion("bg1"),new Vector2(),new Vector2(0, 0)),
	            new ParallaxLayer(atlas.findRegion("bg2"),new Vector2(1.0f,1.0f),new Vector2(0, 500)),
	            new ParallaxLayer(atlas.findRegion("bg3"),new Vector2(0.1f,0),new Vector2(0,Constants.HEIGHT-200),new Vector2(0, 0)),
	      }, 800, 480,new Vector2(150,0));
		//MOve into own class------------------------------------------------------------------
		world = new World(new Vector2(0, -98f), true);
		BodyDef bodyDef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fixdef = new FixtureDef();
		Body body;
		
		for (MapObject object : "map".getLayers().get(0).getObjects().getByType(RectangleMapObject.class)){
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        
        //bodyDef.position.set("map".getX() + "map".getWidth() / 2) / HostileTerritory.PPM, ("map".getY() + "map".getHeight() / 2) / HostileTerritory.PPM;
        
        // Create the body in the world
        body = world.createBody(bodyDef);
        
        //shape.setAsBox(hero.getWidth() /2 / HostileTerritory.PPM, hero.getHeight() /2 / HostileTerritory.PPM);
        
        fixdef.shape = shape;
        body.createFixture(fixdef);
		}
		hero = new HostileTerritory(world);
		//getWorldWidth..
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}
	public void update(float dt){
		HandleInput(dt);
		//renderer.setView(gameCam);
		
		//sets world time, velocity, position
		world.step(1/60f, 6, 2);
		
		//Updates game after changes
		gameCam.update();
	}

	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(255,255,255,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		b2dr.render(world, gameCam.combined);
		rbg.render(delta);
		
		game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
		hud.stage.draw();
		game.batch.begin();

		game.batch.end();

	}

	@Override
	public void resize(int width, int height) {
		gamePort.update(width, height);

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		map.dispose();
		renderer.dispose();
		world.dispose();
		bs2r.dispose();
		hud.dispose();

	}


}
