package com.example.school.repository.mongo;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.InetSocketAddress;

import org.bson.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.school.repository.StudentRepository;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;

class StudentMongoRepositoryTest {

	private static final String STUDENT_COLLECTION_NAME = "student";
	private static final String SCHOOL_DB_NAME = "school";
	private static MongoServer server;
	private static InetSocketAddress serverAddress;
	private MongoCollection<Document> studentCollection;
	private MongoClient client;
	private StudentRepository studentRepository;
	
	@BeforeAll
	static void setupServer() {
		server = new MongoServer(new MemoryBackend());
		serverAddress = server.bind();	
	}
	
	@BeforeEach
	void setup() {
		client = new MongoClient(new ServerAddress(serverAddress));
		studentRepository = new StudentMongoRepository(client);
		MongoDatabase database = client.getDatabase(SCHOOL_DB_NAME);
		database.drop();
		studentCollection = database.getCollection(STUDENT_COLLECTION_NAME);
		
	}

	@Test
	void findAllWhenDatabaseIsEmpty() {
		
		assertThat(studentRepository.findAll()).isEmpty();
	}
	
}
