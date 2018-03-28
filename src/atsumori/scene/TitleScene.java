package atsumori.scene;

import java.awt.Color;
import java.awt.event.KeyEvent;

import atsumori.object.ObjectManager;
import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;
import densan.s.game.input.KeyInput;
import densan.s.game.manager.GameManager;
/**
 * タイトル画面
 * @author Taishin
 *
 */
public class TitleScene extends Scene {

	public TitleScene(SceneManager sceneManager) {
		super(sceneManager);
		// TODO 自動生成されたコンストラクター・スタブ
		ObjectManager.getInstance().clear();
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		if(KeyInput.isPress(KeyEvent.VK_SPACE))
			handle();
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.setColor(Color.BLACK);
		d.setFontSize(90);
		//d.drawString("熱盛ィィィィィ！！！！！！", 0, 300);
		d.drawString("失礼致しました、", 200, 200);
		d.drawImage(ImageLoader.load("pic/red.png"), 200, 200);
		d.drawString("と出てしまいました", 200, 600);
		d.setFontSize(40);
		d.drawStringCenter("スペースキーでスタート", GameManager.getInstance().getFrameWidth()/2, 700);
	}

	@Override
	public void handle() {
		// TODO 自動生成されたメソッド・スタブ
		super.getSceneManager().setScene(new GameScene(getSceneManager()));
	}

}
