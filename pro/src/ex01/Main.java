package ex01;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/** Обрахунок і відображення результатів.
 * Включає реалізацію статичного методу main().
 * @author xone
 * @version 1.0
 * @see Main#main
 */
public class Main {
/** Об'єкт класу {@linkplain Calc}.<br>Вирішує задачу інд. завдання #3. */
private Calc calc = new Calc();

/** Відображає меню. */
private void menu() {
 String s = null;
 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 do {
 do {
 System.out.println("Enter command...");
 System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
 try {
 s = in.readLine();
 } catch(IOException e) {
 System.out.println("Error: " + e);
 System.exit(0);
 }
 } while (s.length() != 1);
 switch (s.charAt(0)) {
 case 'q':
 System.out.println("Exit.");
 break;
 case 'v':
 System.out.println("View current.");
 calc.show();
 break;
 case 'g':
 System.out.println("Random generation.");
 calc.init(Math.random() * 360.0,Math.random() * 360.0);
 calc.show();
 break;
 case 's':
 System.out.println("Save current.");
 try {
 calc.save();
 } catch (IOException e) {
 System.out.println("Serialization error: " + e);
 }
 calc.show();
 break;
 case 'r':
 System.out.println("Restore last saved.");
 try {
 calc.restore();
 } catch (Exception e) {

 System.out.println("Serialization error: " + e);
 }
 calc.show();
 break;
 default:
 System.out.print("Wrong command. ");
 }
 } while(s.charAt(0) != 'q');
}

/** Виконується під час запуску програми.
 * Обчислюються дані функції для різних аргументів.
 * Результат обрахунків виводятся на екран.
 * @param args - параметри запуску програми.
 */
public static void main(String[] args) {
 Main main = new Main();
 main.menu();
}
} 