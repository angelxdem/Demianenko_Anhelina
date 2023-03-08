package ex01;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Calc;
/** Уиконує тестування розроблених класів.
 * @author xone
 * @version 1.0
 */
public class MainTest {
/** Перевірка основної функціональності класу {@linkplain Calc} */
@Test
public void testCalc() {
 Calc calc = new Calc();
 calc.init(0.0, 0.0);
 assertEquals(0.0, calc.getResult().getY(), .1e-10);
 calc.init(90.0, 45.0);
 assertEquals(1.0, calc.getResult().getY(), .1e-10);
 calc.init(180.0, 100.0);
 assertEquals(0.0, calc.getResult().getY(), .1e-10);
 calc.init(270.0, 200.0);
 assertEquals(-1.0, calc.getResult().getY(), .1e-10);
 calc.init(360.0, 300.0);
 assertEquals(0.0, calc.getResult().getY(), .1e-10);
}
/** Перевірка серіалізації. Корректність відновлення даних. */
@Test
public void testRestore() {
 Calc calc = new Calc();
 double x, y;
 for(int ctr = 0; ctr < 1000; ctr++) {
 x = Math.random() * 360.0;
 y = Math.random() * 360.0;
 y = calc.init(x, y);
 try {
 calc.save();
 } catch (IOException e) {
 Assert.fail(e.getMessage());
 }
 calc.init(Math.random() * 360, Math.random() * 360);
 try {
 calc.restore();
 } catch (Exception e) {
 Assert.fail(e.getMessage());
 }
 assertEquals(y, calc.getResult().getRadius(), .1e-10);

 assertEquals(x, calc.getResult().getSqr(), .1e-10);
 }
}
}