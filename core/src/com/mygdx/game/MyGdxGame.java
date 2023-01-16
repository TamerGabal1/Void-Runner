package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Gdx;

public class MyGdxGame extends Game {

	public static MyGdxGame instance;
	private int screenWidth, screenHeight;
	private OrthographicCamera orthographicCamera;

	public MyGdxGame(){
		instance = this;
	}

	@Override
	public void create() {
		this.screenHeight = Gdx.graphics.getHeight();
		this.screenWidth = Gdx.graphics.getWidth();
		this.orthographicCamera = new OrthographicCamera();
		this.orthographicCamera.setToOrtho(false, screenWidth, screenHeight);
		setScreen(new GameScreen(orthographicCamera));
	}
}
