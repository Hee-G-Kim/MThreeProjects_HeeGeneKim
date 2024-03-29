package com.sg.classroster.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sg.classroster.dto.Student;

public class ClassRosterDaoFileImpl implements ClassRosterDao {

	private Map<String, Student> students = new HashMap<>();

	// Reading and writing to a file
	/*
	 * To start, we'll create two constants in our DAO — one for the name of the
	 * file that holds all the student data and one for the delimiter (two colons).
	 * Add the following constants near the top of your ClassRosterDaoFileImpl
	 * class:
	 */
	// public static final String ROSTER_FILE = "roster.txt";
	private final String ROSTER_FILE;
	public static final String DELIMITER = "::";

	public ClassRosterDaoFileImpl() {
		ROSTER_FILE = "roster.txt";
	}

	public ClassRosterDaoFileImpl(String rosterTextFile) {
		ROSTER_FILE = rosterTextFile;
	}

	// unmarshalling
	private Student unmarshallStudent(String studentAsText) {
		// studentAsText is expecting a line read in from our file.
		// For example, it might look like this:
		// 1234::Ada::Lovelace::Java-September1842
		//
		// We then split that line on our DELIMITER - which we are using as ::
		// Leaving us with an array of Strings, stored in studentTokens.
		// Which should look like this:
		// ______________________________________
		// | | | | |
		// |1234|Ada|Lovelace|Java-September1842|
		// | | | | |
		// --------------------------------------
		// [0] [1] [2] [3]
		String[] studentTokens = studentAsText.split(DELIMITER);
		// Given the pattern above, the student Id is in index 0 of the array.
		String studentId = studentTokens[0];
		// Which we can then use to create a new Student object to satisfy
		// the requirements of the Student constructor.
		Student studentFromFile = new Student(studentId);
		// However, there are 3 remaining tokens that need to be set into the
		// new student object. Do this manually by using the appropriate setters.
		// Index 1 - FirstName
		studentFromFile.setFirstName(studentTokens[1]);
		// Index 2 - LastName
		studentFromFile.setLastName(studentTokens[2]);
		// Index 3 - Cohort
		studentFromFile.setCohort(studentTokens[3]);
		// We have now created a student! Return it!
		return studentFromFile;
	}

	/*
	 * //create a method that reads the roster file into memory: This method will
	 * follow the algorithm described in the Data Marshaling and Unmarshaling
	 * lesson: 1. Open the file for reading. 2. For each line in the file, do the
	 * following: a. Read the line into a String variable. b. Pass the line to our
	 * unmarshallStudent method to parse it into Student c. Put the newly created
	 * and initialized Student object into the student map. 3. Close the 􀂦le.
	 */
	private void loadRoster() throws ClassRosterPersistenceException {
		Scanner scanner;
		try {
			// Create Scanner for reading the file
			System.out.println(new File(ROSTER_FILE).getAbsolutePath());
			scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
		} catch (FileNotFoundException e) {
			throw new ClassRosterPersistenceException("-_- Could not load roster data into memory.", e);
		}
		// currentLine holds the most recent line read from the file
		String currentLine;
		// currentStudent holds the most recent student unmarshalled
		Student currentStudent;
		// Go through ROSTER_FILE line by line, decoding each line into a
		// Student object by calling the unmarshallStudent method.
		// Process while we have more lines in the file
		while (scanner.hasNextLine()) {
			// get the next line in the file
			currentLine = scanner.nextLine();
			// unmarshall the line into a Student
			currentStudent = unmarshallStudent(currentLine);
			// We are going to use the student id as the map key for our student object.
			// Put currentStudent into the map using student id as the key
			students.put(currentStudent.getStudentId(), currentStudent);
		}
		// close scanner
		scanner.close();
	}

	// Marshalling
	private String marshallStudent(Student aStudent) {
		// We need to turn a Student object into a line of text for our file.
		// For example, we need an in memory object to end up like this:
		// 4321::Charles::Babbage::Java-September1842
		// It's not a complicated process. Just get out each property,
		// and concatenate with our DELIMITER as a kind of spacer.
		// Start with the student id, since that's supposed to be first.
		String studentAsText = aStudent.getStudentId() + DELIMITER;
		// add the rest of the properties in the correct order:
		// FirstName
		studentAsText += aStudent.getFirstName() + DELIMITER;
		// LastName
		studentAsText += aStudent.getLastName() + DELIMITER;
		// Cohort - don't forget to skip the DELIMITER here.
		studentAsText += aStudent.getCohort();
		// We have now turned a student to text! Return it!
		return studentAsText;
	}

	/*
	 * Writes all students in the roster out to a ROSTER_FILE. See loadRoster for
	 * file format.
	 *
	 * @throws ClassRosterDaoException if an error occurs writing to the file
	 */
	private void writeRoster() throws ClassRosterPersistenceException {
		// NOTE FOR APPRENTICES: We are not handling the IOException - but
		// we are translating it to an application specific exception and
		// then simple throwing it (i.e. 'reporting' it) to the code that
		// called us. It is the responsibility of the calling code to
		// handle any errors that occur.
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(ROSTER_FILE));
		} catch (IOException e) {
			throw new ClassRosterPersistenceException("Could not save student data.", e);
		}
		// Write out the Student objects to the roster file.
		// NOTE TO THE APPRENTICES: We could just grab the student map,
		// get the Collection of Students and iterate over them but we've
		// already created a method that gets a List of Students so
		// we'll reuse it.
		String studentAsText;
		List<Student> studentList = this.getAllStudents();
		for (Student currentStudent : studentList) {
			// turn a Student into a String
			studentAsText = marshallStudent(currentStudent);
			// write the Student object to the file
			out.println(studentAsText);
			// force PrintWriter to write line to the file
			out.flush();
		}
		// Clean up
		out.close();
	}

	// --------------------------------------------

	@Override
	public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
		loadRoster();
		Student newStudent = students.put(studentId, student);
		writeRoster();
		return newStudent;
	}

	/*
	 * @Override public Student addStudent(String studentId, Student student) { //
	 * *??? Student prevStudent = students.put(studentId, student); // ??is null
	 * System.out.println("prevStudent: " + prevStudent); // ??why return return
	 * prevStudent; }
	 */

	@Override
	public List<Student> getAllStudents() throws ClassRosterPersistenceException {
		loadRoster();
		return new ArrayList(students.values());
	}
	/*
	 * @Override public List<Student> getAllStudents() { // we get the hashmap
	 * values and return in an arraylist return new
	 * ArrayList<Student>(students.values()); }
	 */

	@Override
	public Student getStudent(String studentId) throws ClassRosterPersistenceException {
		loadRoster();
		return students.get(studentId);
	}
	/*
	 * @Override public Student getStudent(String studentId) { return
	 * students.get(studentId); }
	 */

	@Override
	public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
		loadRoster();
		Student removedStudent = students.remove(studentId);
		writeRoster();
		return removedStudent;
	}
	/*
	 * @Override public Student removeStudent(String studentId) { Student
	 * removedStudent = students.remove(studentId); return removedStudent; }
	 */

}
