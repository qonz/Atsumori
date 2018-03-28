package atsumori.object;

import atsumori.visitor.Accepter;
import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;
import densan.s.game.object.ImageObjectBase;
/**
 * ゲーム内のモノ全般
 * 各物体はこのクラスを継承
 * @author Taishin
 *
 */
public abstract class GameObject extends ImageObjectBase implements Accepter{
	
	//重力定数
	public static final double GRAVITY = 0.7;
	//接触判定 要らないかもしれない
	private boolean hit = false;

	public GameObject(double x, double y, String imageName) {
		super(x, y, ImageLoader.load(imageName));
	}

	public void update(){
		//各オブジェクトで決めてください...
	}

	public void draw(Drawer d, int offsetX, int offsetY) {
		//同上
	}
	
	public boolean getHit(){
		return hit;
	}
	
	public void setHit(boolean hit){
		this.hit = hit;
	}
}
