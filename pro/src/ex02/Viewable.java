package ex02;

/**
 * Creator (шаблон проектування Factory Method)<br>
 * Об'являє метод, "фабрикующий" об'єкти
 * 
 * @author xone
 * @version 1.0
 * @see Viewable#getView()
 */
public interface Viewable {
	/** Створює об'єкт, реалізуючий {@linkplain View} */
	public View getView();

}