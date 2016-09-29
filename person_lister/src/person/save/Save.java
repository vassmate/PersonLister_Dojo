package person.save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import person.Person;

public class Save {

	private final File saveFile = new File("persons_save.txt");
	private ArrayList<Person> personList = new ArrayList<>();
	private FileOutputStream fileOutStream;
	private ObjectOutputStream objectOutStream;

	public Save() {
		try {
			setFileOutStream(new FileOutputStream(getSaveFile()));
			setObjectOutStream(new ObjectOutputStream(getFileOutStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public File getSaveFile() {
		return saveFile;
	}

	public ArrayList<Person> getPersonList() {
		return personList;
	}

	public void addPersonToList(Person person) {
		this.personList.add(person);
	}

	private FileOutputStream getFileOutStream() {
		return fileOutStream;
	}

	private void setFileOutStream(FileOutputStream fileOutStream) {
		this.fileOutStream = fileOutStream;
	}

	private ObjectOutputStream getObjectOutStream() {
		return objectOutStream;
	}

	private void setObjectOutStream(ObjectOutputStream objectOutStream) {
		this.objectOutStream = objectOutStream;
	}

	public void savePersonList() {
		try {
			getObjectOutStream().writeObject(getPersonList());
			closeStreams();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeStreams() {
		try {
			getObjectOutStream().flush();
			getObjectOutStream().close();

			getFileOutStream().flush();
			getFileOutStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
