package atsumori.scene;

import java.awt.Color;

import densan.s.game.drawing.Drawer;
import densan.s.game.fps.FPS;
import densan.s.game.manager.GameManager;
import densan.s.game.sound.SoundManager;
/**
 * ゲームクリア画面
 * @author Taishin
 *
 */
public class ClearScene extends Scene{
	private int timer = 0;
	public ClearScene(SceneManager sceneManager) {
		super(sceneManager);
		// TODO 自動生成されたコンストラクター・スタブ
		SoundManager.playSE(SoundManager.loadSE("se/o_mori.wav"));
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		timer++;
		if(timer/FPS.DEFAULT_FPS>3)handle();
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.setFontSize(50);
		d.setColor(Color.BLACK);
		d.drawStringCenter("おめでとう", GameManager.getInstance().getFrameWidth()/2, 400);
	}

	@Override
	public void handle() {
		// TODO 自動生成されたメソッド・スタブ
		super.getSceneManager().setScene(new TitleScene(getSceneManager()));
	}

}
