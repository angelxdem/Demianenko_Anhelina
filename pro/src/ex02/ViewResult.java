package ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ex01.Item2d;

/**
 * ConcreteProduct (Шаблон проектування Factory Method)<br>
 * Обчислення функції, збереження і відображення результатів
 * 
 * @author xone
 * @version 1.0
 * @see View
 */
public class ViewResult implements View {
	/** Ім'я файлу, використовується при серіалізації */
	private static final String FNAME = "items.bin";
	/** Визначити кількість значень для обчислення за змовчуванням */
	private static final int DEFAULT_NUM = 10;
	/** Колекція аргументів і результатів обчислень */
	private ArrayList<Item2d> items = new ArrayList<Item2d>();

	/**
	 * Викликає {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)} з
	 * параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
	 */
	public ViewResult() {
		this(DEFAULT_NUM);
	}

	/**
	 * Ініціалізує колекцію {@linkplain ViewResult#items}
	 * 
	 * @param n початкова кількість елементів
	 */
	public ViewResult(int n) {
		for (int ctr = 0; ctr < n; ctr++) {
			items.add(new Item2d());
		}
	}

	/**
	 * Отримати значення {@linkplain ViewResult#items}
	 * 
	 * @return ниншнє значення посилання на об'єкт {@linkplain ArrayList}
	 */
	public ArrayList<Item2d> getItems() {
		return items;
	}

	/**
	 * Обраховує значення функції
	 * 
	 * @param x аргумент обчисляємої функциії
	 * @return результат опчилюємої функції
	 */
	private String calc(double x, double y) {
		
		double radius = Math. sqrt(Math.pow(x,2)+Math.pow(y,2))/2;

		return (String)Integer.toBinaryString((int)(Math.PI*Math.pow(radius,2)));
		
	}

	private String calcR(double x, double y) {
		return (String)Integer.toHexString((int)(Math. sqrt(Math.pow(x,2)+Math.pow(y,2))/2));
	}

	/**
	 * Обраховує значення функції і зберігає результат в коллекції
	 * {@linkplain ViewResult#items}
	 * 
	 * @param stepX шаг припинення аргумента
	 */
	public void init(double stepX) {
		double x = 0.0;
		
		for (Item2d item : items) {
			double y = Math.sin(x * Math.PI / 180);
			item.setX(x);
			item.setY(y);
			item.setRadius(calcR(x,y));
			item.setSqr(calc(x,y));
			x += stepX;
		}
	}

	/**
	 * Викликає <b>init(double stepX)</b> з випадковими значеннями аргумента<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewInit() {
		init(Math.random() * 360.0);
	}

	/**
	 * Реалізація методу {@linkplain View#viewSave()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewSave() throws IOException {
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
		os.writeObject(items);
		os.flush();
		os.close();
	}

	/**
	 * Реалізація методу {@linkplain View#viewRestore()}<br>
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void viewRestore() throws Exception {
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
		items = (ArrayList<Item2d>) is.readObject();
		is.close();
	}

	/**
	 * Реалізація методу {@linkplain View#viewHeader()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewHeader() {
		System.out.println("Results:");
	}

	/**
	 * Реалізація методу {@linkplain View#viewBody()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewBody() {
		for (Item2d item : items) {
			System.out.printf("(%.0f; %.3f; %s; %s;) ", item.getX(), item.getY(), item.getRadius(), item.getSqr());
		}
		System.out.println();
	}

	/**
	 * Реалізація методу {@linkplain View#viewFooter()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewFooter() {
		System.out.println("End.");
	}

	/**
	 * Реалізація методу {@linkplain View#viewShow()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewShow() {
		viewHeader();
		viewBody();

		viewFooter();
	}
}