package atsumori.object;

import java.awt.Color;
import java.awt.event.KeyEvent;

import atsumori.visitor.Visitor;
import densan.s.game.drawing.Drawer;
import densan.s.game.input.KeyInput;
import densan.s.game.manager.GameManager;
/**
 * 実際に操作するプレイヤークラス
 * @author Taishin
 *
 */
public class Player extends GameObject {
	//横移動の速さ
	private int speed = 15;
	//ジャンプの速さ
	private final int JUMP_SPEED = 25;
	//地面にいるかどうかの真偽値 (trueで地上、falseで空中)
	private boolean isOnGround = true;

	public Player(double x, double y) {
		super(x, y, "pic/csgIcon.png");
		this.addX(-getWidth()/2);
	}
	
	@Override
	public void update(Visitor visitor) {
		this.setVx(0); //念のため移動速をリセット
		speed = 15;
		
		if(isOnGround)  //接地中は遅い 
			speed = speed*3/5;
		
		if(KeyInput.isPressing(KeyEvent.VK_RIGHT)) //右を押している間,右にSPEEDの速さで移動
			this.setVx(speed);
		if(KeyInput.isPressing(KeyEvent.VK_LEFT))  //左を押している間,左に-SPEEDの速さで移動
			this.setVx(-speed);
		
		if(KeyInput.isPress(KeyEvent.VK_UP) && isOnGround){ //地面にいるときに上を押すと,
			this.setVy(-JUMP_SPEED);  //上にJUMP_SPEEDの速さでジャンプ
			isOnGround = false; //空中
		}
		
		this.addVy(GameObject.GRAVITY);  //Y軸方向にGRAVITY(GameObjectクラスのstatic変数)の速度がかかり続ける
		
		this.move(); //上記を実行
		
		//                以下 簡単な位置調整
		
		if(this.getMaxY()>=GameManager.getInstance().getFrameHeight()*15/16){
			this.setMaxY(GameManager.getInstance().getFrameHeight()*15/16);
			isOnGround = true;	
		}
		if(this.getMaxX()>GameManager.getInstance().getFrameWidth())
			this.setMaxX(GameManager.getInstance().getFrameWidth());
		if(this.getX()<0)
			this.setX(0);
	}
	

	public void draw(Drawer d, int offsetX, int offsetY) {
		d.setColor(Color.BLACK);
		//d.drawString("X : "+ this.getCenterX() + ",Y : "+ this.getCenterY(), 100, 100);
		d.drawImage(getImage(), getX()+offsetX, getY()+offsetX);
	}

}
