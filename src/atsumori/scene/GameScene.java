package atsumori.scene;

import java.awt.Color;

import atsumori.object.Atsumori;
import atsumori.object.ObjectManager;
import atsumori.object.Player;
import densan.s.game.drawing.Drawer;
import densan.s.game.fps.FPS;
import densan.s.game.manager.GameManager;
import densan.s.game.sound.SoundManager;
/**
 * ゲーム画面
 * @author Taishin
 *
 */
public class GameScene extends Scene {
	private int width = GameManager.getInstance().getFrameWidth();
	private int height = GameManager.getInstance().getFrameHeight();
	
	//タイマー
	private float timer = 0;
	//難易度 (値が小さくなるほど難しくなる)
	private int level = 100;
	
	public GameScene(SceneManager sceneManager) {
		super(sceneManager);
		// TODO 自動生成されたコンストラクター・スタブ
		ObjectManager.getInstance().addObject(new Player(width/2,height));
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		ObjectManager.getInstance().update();
		timer++;
		
		if(timer/FPS.DEFAULT_FPS>105)
			handle();
		
		if(timer%level==0)
			ObjectManager.getInstance().addObject(new Atsumori());
		
		if(timer%(FPS.DEFAULT_FPS*10)==0)
			level-=10;
		
		if(level<0)
			level = 0;
		
		if(ObjectManager.getInstance().getPlayer().getHit()){
			SoundManager.stopAllSE();
			super.getSceneManager().setScene(new GameOverScene(getSceneManager()));
		}
		
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		ObjectManager.getInstance().draw(d,0,0);
		int nando = 10-level/10;
		d.setColor(Color.BLACK);
		d.setFontSize(40);
		//d.drawString(""+timer/FPS.DEFAULT_FPS, 10, 30);
		
		if(nando>=9)
			d.drawString("当たるぞ", 500, Math.random()*2+500);
		else if(nando>=8)
			d.drawString("ここまで来たら暇人", 653, Math.random()*2+400);
		else if(nando>=7)
			d.drawString("そろそろうるさい", 103, Math.random()*2+200);
		else if(nando>=6)
			d.drawString("くぁwせdrftgyふじこlp", 283, Math.random()*2+100);
		else if(nando>=5)
			d.drawString("強請るな、勝ち取れ", 513, Math.random()*2+500);
		else if(nando>=4)
			d.drawString("集中...集中...", 483, Math.random()*2+300);
		else if(nando>=3)
			d.drawString("そうあまり飛ぶでない", 333, Math.random()*2+700);
		else if(nando>=2)
			d.drawString("今日から君は富士山だ", 483, Math.random()*2+300);
		else if(nando>=1)
			d.drawString("リステリンで大胆になれるか", 183, Math.random()*2+200);
		
		d.setFontSize(30);
		if(nando<10)d.drawString("難易度:"+nando, 20, 100);
	}

	@Override
	public void handle() {
		// TODO 自動生成されたメソッド・スタブ
		super.getSceneManager().setScene(new ClearScene(getSceneManager()));
	}

}
