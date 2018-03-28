import atsumori.scene.SceneManager;
import densan.s.game.manager.GameManager;
/**
 * さぁ、君も今日から熱盛だ
 * @author Ho-do-stati(ここで文字が途切れている…)
 *
 */
public class Main {
	public static void main(String[] args) {
		GameManager gm = densan.s.game.manager.GameManager.getInstance();
		gm.createFrame(1200,800,"熱盛ィ!!!");
		gm.setUpdatable(new SceneManager());
	}

}
