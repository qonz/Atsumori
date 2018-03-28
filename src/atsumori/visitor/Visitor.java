package atsumori.visitor;

import java.util.List;

import atsumori.object.GameObject;
/**
 * Visitorインタフェース
 * @author Taishin
 *
 */
public interface Visitor {
	public void addObject(GameObject object);
	public List<GameObject> getObjectList();
	public GameObject getPlayer();
}
