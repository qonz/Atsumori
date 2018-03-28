package atsumori.visitor;

import densan.s.game.drawing.Drawer;
/**
 * visitorパターンのAccepterインタフェース
 * @author Taishin
 *
 */
public interface Accepter {
	public void update(Visitor visitor);
	public void draw(Drawer d);

}
