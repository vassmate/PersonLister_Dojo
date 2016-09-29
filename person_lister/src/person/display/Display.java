package person.display;

import java.util.ArrayList;

import person.Person;
import person.load.Load;

public class Display {

	public enum Language {
		HU, EN
	}

	private Language lang;
	private Load loadPersons = new Load();
	private ArrayList<Person> personList;

	public Display() {
		setPersonList(getLoadPersons().getPersonList());
	}

	public void setLang(Language lang) {
		this.lang = lang;
	}

	private ArrayList<Person> getPersonList() {
		return personList;
	}

	private void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}

	private Load getLoadPersons() {
		return loadPersons;
	}

	private StringBuffer getPrintablePersons() {
		StringBuffer personSB = new StringBuffer();
		ArrayList<Person> persons = getPersonList();

		switch (lang) {
		case HU:
			for (Person person : persons) {
				personSB.append("\n" + huFormat(person));
			}
			return personSB;
		case EN:
			for (Person person : persons) {
				personSB.append("\n" + enFormat(person));
			}
			return personSB;
		default:
			for (Person person : persons) {
				personSB.append("\n" + enFormat(person));
			}
			return personSB;
		}
	}

	private String enFormat(Person person) {
		return "FirstName: " + person.getFirstName() + " LastName: " + person.getLastName();
	}

	private String huFormat(Person person) {
		return "LastName: " + person.getLastName() + " FirstName: " + person.getFirstName();
	}

	@Override
	public String toString() {
		return getPrintablePersons().toString();
	}
}
