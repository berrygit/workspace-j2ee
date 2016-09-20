//: enumerated/menu/TypeOfFood.java
package enumerated.menu;
import enumerated.menu.Food.Appetizer;
import enumerated.menu.Food.Coffee;
import enumerated.menu.Food.Dessert;
import enumerated.menu.Food.MainCourse;

public class TypeOfFood {
	public static void main(String[] args) {
		Food food = Appetizer.SALAD;
		food = MainCourse.LASAGNE;
		food = Dessert.GELATO;
		food = Coffee.CAPPUCCINO;
	}
} /// :~
