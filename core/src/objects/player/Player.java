package objects.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import static helper.Constants.PPM;

public class Player extends GameEntity{

    private int jumpCounter = 0;
    private static boolean voidStarted;
    Texture image;

    public Player(float width, float height, Body body) {
        super(width, height, body);
        this.speed = 10f;
        image = new Texture("player.png");
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;

        checkUserInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image,getX(),getY(),getWidth(),getHeight());
    }

    private void checkUserInput(){
        velX = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            velX = 1;
            if(!voidStarted) voidStarted = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            velX = -1;
            if(!voidStarted) voidStarted = true;
        }

        if((Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isKeyJustPressed(Input.Keys.W))&& jumpCounter < 1){
            float force = body.getMass() * 11;
            body.applyLinearImpulse(new Vector2(0, force), body.getPosition(), true);
            jumpCounter++;
        }

        //reset jumpcounter
        if(body.getLinearVelocity().y==0) jumpCounter = 0;

        body.setLinearVelocity(velX * speed, body.getLinearVelocity().y);
    }

    public static boolean isVoidStarted() {
        return voidStarted;
    }
}
