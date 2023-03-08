package ex02;

/**
 * ConcreteCreator (шаблон проектування Factory Method)<br>
 * Об'являє метод, "фабрикующий" об'єкти
 * 
 * @author xone
 * @version 1.0
 * @see Viewable
 * @see ViewableResult#getView()
 */
public class ViewableResult implements Viewable {
	/** Створює відображення об'єкту {@linkplain ViewResult} */
	@Override
	public View getView() {
		return new ViewResult();
	}

}
