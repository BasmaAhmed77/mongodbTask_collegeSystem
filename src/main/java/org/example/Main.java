package org.example;

import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MongoClient mongoClient= MongoClients.create("mongodb+srv://BasmaAhmed:basma0000@cluster0.2dxr7tg.mongodb.net/?appName=Cluster0");

        MongoDatabase db= mongoClient.getDatabase("collegeSystem");

        MongoCollection<Document> collection= db.getCollection("Students");
        ArrayList<Student> students= new ArrayList<>();
        students.add(new Student("Basma", 20, "Cairo", "100000000000",2));
        students.add(new Student("Habiba", 22, "Giza", "999999",1));
        students.add(new Student("Salma", 23, "Alex", "87887878",3));


        for(Student student:students)
        {
            Document stud= new Document("Name",student.getName())
                    .append("Age",student.getAge())
                    .append("Governate",student.getGovernate())
                    .append("PhoneNo",student.getPhoneNo())
                    .append("Level",student.getLevel());
            collection.insertOne(stud);
        }

        FindIterable <Document> docCursor= collection.find();

        for (Document doc:docCursor)
        {
            System.out.println(doc.toJson());
        }

        collection.updateOne(
                Filters.eq("Name","Salma"),
                Updates.set("Age",31)
        );

        Document doc1= collection.find(Filters.eq("Name","Salma")).first();

        if(doc1 != null) System.out.println("The updated doc: \n"+doc1.toJson());

        collection.deleteOne(Filters.eq("Name","Salma"));

        Document doc2= collection.find(Filters.eq("Name","Salma")).first();
        if(doc2 == null) System.out.println("Deleted Successfully");

        for (Document doc:docCursor)
        {
            System.out.println(doc.toJson());
        }
        collection.drop();
    }
}