package runner;

import person.Person;
import person.display.Display;
import person.save.Save;

public class Runner {

	public static void main(String[] args) {
		Save saveP = new Save();
		saveP.addPersonToList(new Person("Laci", "Toldi"));
		saveP.addPersonToList(new Person("Laci", "Lakatos"));
		saveP.addPersonToList(new Person("Laci", "Valami"));
		saveP.addPersonToList(new Person("Laci", "Akarki"));
		saveP.addPersonToList(new Person("Laci", "Mittomen"));
		saveP.savePersonList();

		Display displayP = new Display();
		displayP.setLang(Display.Language.HU);
		System.out.println(displayP.toString());
	}
}
