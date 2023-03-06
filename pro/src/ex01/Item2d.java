package ex01;
import java.io.Serializable;
/** Зберігає вихідні дані і результати обрахунків.
 * @author xone
 * @version 1.0
 */
public class Item2d implements Serializable {
/** Аргумент обрахунокої функції. */
// transient
private double x;

/** Результат обрахунків функції. */
private double y;
private String radius;
private String sqr;


/** Автоматично сгенерована константа */
private static final long serialVersionUID = 1L;
/** Ініціалізує поля {@linkplain Item2d#x}, {@linkplain Item2d#y} */
public Item2d() {
 x = .0;
 y = .0;
 radius = " ";
 sqr = " ";
}
/** Встановлення значення полів: аргумента
 * і результата обчислення функції.
 * @param x - значення для ініціалізації поля {@linkplain Item2d#x}
 * @param y - значення для ініціалізації поля {@linkplain Item2d#y}
 */
public Item2d(double x, double y) {
 this.x = x;
 this.y = y;
}
/** Установка значення поля {@linkplain Item2d#x}
 * @param x - значення для {@linkplain Item2d#x}
 * @return Значення {@linkplain Item2d#x}
 */
public double setX(double x) {
 return this.x = x;
}
/** Отримання значення поля {@linkplain Item2d#x}
 * @return Значення {@linkplain Item2d#x}
 */
public double getX() {
 return x;
}
/** Встановлення значення поля {@linkplain Item2d#y}
 * @param y - значення для {@linkplain Item2d#y}
 * @return Значення {@linkplain Item2d#y}
 */
public double setY(double y) {
 return this.y = y;
}
/** Отримання значення поля {@linkplain Item2d#y}
 * @return значення {@linkplain Item2d#y}
 */
public double getY() {
 return y;
}

public String setSqr(String Sqr) {
	return this.sqr = Sqr;
}

public String getSqr() {
	return sqr;
}
public String setRadius(String Radius) {
	return this.radius = Radius;
}

public String getRadius() {
	return radius;
}
/** Встановлення значення {@linkplain Item2d#x} та {@linkplain Item2d#y}
 * @param x - значення для {@linkplain Item2d#x}
 * @param y - значення для {@linkplain Item2d#y}
 * @return this
 */
public Item2d setXY(double x, double y) {
 this.x = x;
 this.y = y;
 return this;
}
/** Представляє результат обчислення в вигляді строки.<br>{@inheritDoc} */
@Override
public String toString() {
 return "x = " + x + ", y = " + y +", Square = "+sqr + ", Radius ="+radius;
}
/** Автоматично сгенерований метод.<br>{@inheritDoc} */
@Override
public boolean equals(Object obj) {
 if (this == obj)
 return true;
 if (obj == null)
 return false;
 if (getClass() != obj.getClass())
 return false;

 Item2d other = (Item2d) obj;
 if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
 return false;
 if (Math.abs(Math.abs(y) - Math.abs(other.y)) > .1e-10)
 return false;
 return true;
}
}