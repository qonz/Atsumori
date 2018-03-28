package atsumori.scene;

import densan.s.game.drawing.Drawer;
import densan.s.game.manager.Updatable;
/**
 * 画面を操作するクラス（シーン転換やupdate）
 * @author Taishin
 *
 */
public class SceneManager implements Updatable{
	private Scene currentScene;
	private Scene nextScene;
	
	protected Scene getcurrentScene(){
		return currentScene;
	}
	
	public SceneManager(){
		setScene(new TitleScene(this));
	}
	
	public void setScene(Scene scene){
		nextScene = scene;
	}
	
	public void update(){
		if(nextScene != null){
			currentScene = nextScene;
			nextScene = null;
		}
		currentScene.update();
	}
	
	public void draw(Drawer d){
		currentScene.draw(d);
	}

}
