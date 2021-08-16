package com.example.school.repository.mongo;

import java.util.Collections;
import java.util.List;

import org.bson.Document;

import com.example.school.model.Student;
import com.example.school.repository.StudentRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

public class StudentMongoRepository implements StudentRepository {

	private static final String STUDENT_COLLECTION_NAME = "student";
	private static final String SCHOOL_DB_NAME = "school";
	private MongoCollection<Document> studentCollection;

	public StudentMongoRepository(MongoClient client) {
		studentCollection = client.getDatabase(SCHOOL_DB_NAME).getCollection(STUDENT_COLLECTION_NAME);
	}

	@Override
	public List<Student> findAll() {
		return Collections.emptyList();
	}

	@Override
	public Student findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String studentId) {
		// TODO Auto-generated method stub

	}

}
