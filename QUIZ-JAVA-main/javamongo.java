package oopjava;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class javamongo {
	public static MongoClient mongoClient;
	public static String username;
    public static void main( String[] args ) {
    	
    	 
        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("JAVA");
            MongoCollection<Document> collection = database.getCollection("USERS");

            Document doc = collection.find(eq("user", "admin")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
    
    public static MongoCollection<Document> getUsersCollection() {
        // Make sure to adjust the database and collection names according to your application
        MongoDatabase database = getDatabase();
        return database.getCollection("USERS");
    }

    private static MongoDatabase getDatabase() {
        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb://localhost:27017";
        MongoClient mongoClient = MongoClients.create(uri);
        return mongoClient.getDatabase("JAVA");
    }
    
    public static void setUsername(String user) {
    	username=user;
    }
    
    public static String getUsername() {
    	return username;
    }
    
    public static void saveUserDetails(String username, String email, String password) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("JAVA");
        MongoCollection<Document> collection = database.getCollection("USERS");

        Document userDocument = new Document("user", username)
                .append("gmail", email)
                .append("password", password);

        collection.insertOne(userDocument);

        mongoClient.close();
    }
	
}