package person.load;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import person.Person;

public class Load {

	private final File saveFile = new File("persons_save.txt");
	private ArrayList<Person> personList = new ArrayList<>();
	private FileInputStream fileInStream;
	private ObjectInputStream objectInStream;

	public Load() {
		try {
			setFileInStream(new FileInputStream(getSaveFile()));
			setObjectInStream(new ObjectInputStream(getFileInStream()));
			loadPersons();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Person> getPersonList() {
		return personList;
	}

	private void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}

	private FileInputStream getFileInStream() {
		return fileInStream;
	}

	private void setFileInStream(FileInputStream fileInStream) {
		this.fileInStream = fileInStream;
	}

	private ObjectInputStream getObjectInStream() {
		return objectInStream;
	}

	private void setObjectInStream(ObjectInputStream objectInStream) {
		this.objectInStream = objectInStream;
	}

	private File getSaveFile() {
		return saveFile;
	}

	@SuppressWarnings("unchecked")
	private void loadPersons() {
		try {
			setPersonList((ArrayList<Person>) getObjectInStream().readObject());
			closeStreams();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeStreams() {
		try {
			getObjectInStream().close();
			getFileInStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
