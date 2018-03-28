package atsumori.object;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import atsumori.visitor.Visitor;
import densan.s.game.drawing.Drawer;
/**
 * ゲーム内のモノ全般を操作するクラス
 * @author Taishin
 *
 */
public class ObjectManager implements Visitor{

	private List<GameObject> objectList = new LinkedList<GameObject>();
	private List<GameObject> additionalList = new LinkedList<GameObject>();
	
	//Singleton
	private static ObjectManager instance = new ObjectManager();
	public static ObjectManager getInstance(){
		return instance;	
	}
	
	private ObjectManager() {
	}

	public void addObject(GameObject object) {
		additionalList.add(object);
	}
	
	public void update(){
		Iterator<GameObject> itr = objectList.iterator();
		GameObject gameObject;
		while(itr.hasNext()){
			gameObject = itr.next();
			gameObject.update(this);
		}
		for(GameObject from : getObjectList()){
			for(GameObject to : getObjectList()){
				//Calcクラスに誤りがあったためコピペして訂正
				if(!(Math.abs(from.getCenterX() - to.getCenterX())  < from.getWidth()/2 + to.getWidth()/2 //横の接触判定
						&& Math.abs(from.getCenterY() - to.getCenterY()) < from.getHeight()/2 + to.getHeight()/2)) //縦の接触判定
					continue;
				if(from instanceof Atsumori){ //Atsumoriクラスと
					if(to instanceof Player){ //Playerクラスとの接触
						System.out.println("hit");
						to.setHit(true); //当たったらPlayerクラスhitをtrueにする
						}
					}
				}
			}
		joinList();
	}
	
	public void draw(Drawer d, int offsetX, int offsetY) {
		for(GameObject gameObject : objectList){
			gameObject.draw(d, offsetX, offsetY);
		}
	}
	
	private void joinList(){
		objectList.addAll(additionalList);
		additionalList.clear();
	}

	@Override
	public List<GameObject> getObjectList() {
		return objectList;
	}
	
	@Override
	public GameObject getPlayer() {
		for (GameObject o: objectList) {
			if (o instanceof Player) return o;
		}
		return null;
	}
	
	public void clear(){
		objectList.clear();
		additionalList.clear();
	}

}
