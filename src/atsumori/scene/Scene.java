package atsumori.scene;

import densan.s.game.manager.Updatable;
/**
 * 画面（シーン）クラス
 * 各画面はこのクラスを継承する
 * @author Taishin
 *
 */
public abstract class Scene implements Updatable{
	
	private SceneManager sceneManager;
	
	protected SceneManager getSceneManager(){
		return sceneManager;
	}
	
	public Scene(SceneManager sceneManager){
		this.sceneManager = sceneManager;
	}
	
	public abstract void handle();

}
