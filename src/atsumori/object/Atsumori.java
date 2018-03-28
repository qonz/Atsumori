package atsumori.object;

import atsumori.visitor.Visitor;
import densan.s.game.drawing.Drawer;
import densan.s.game.manager.GameManager;
import densan.s.game.sound.SoundManager;
/**
 * 熱盛 降ってくるヤツ
 * @author Taishin
 *
 */
public class Atsumori extends GameObject {
	
	private int se = SoundManager.loadSE("se/puchi_mori.wav");
	
	public Atsumori() {
		super(Math.random()*1100-100, -100, "pic/mini_red.png");
		SoundManager.playSE(se);
	}

	@Override
	public void update(Visitor visitor) {
		this.addVy((GRAVITY/100)*Math.random()*5);
		this.move();
		if(this.getCenterY()>GameManager.getInstance().getFrameHeight())remove();
	}

	public void draw(Drawer d, int offsetX, int offsetY) {
		d.drawImage(getImage(), getX()+offsetX, getY()+offsetX);
	}
}
