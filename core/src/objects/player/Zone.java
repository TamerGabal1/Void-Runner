package objects.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

import static helper.Constants.PPM;

public class Zone extends GameEntity{
    private float speed;

    public Zone(float width, float height, Body body) {
        super(width, height, body);
        this.speed = 3f;
    }


    public void update(){
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
        if(Player.isVoidStarted()) {
            body.setLinearVelocity(speed, body.getLinearVelocity().y);
        }
    }

    @Override
    public void render(SpriteBatch batch) {

    }


    @Override
    public Body getBody() {
        return super.getBody();
    }
}