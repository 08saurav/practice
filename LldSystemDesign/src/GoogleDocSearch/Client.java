package GoogleDocSearch;

import GoogleDocSearch.models.Document;
import GoogleDocSearch.repositories.DocumentRepository;
import GoogleDocSearch.services.SerchEngineService;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        DocumentRepository documentRepository = new DocumentRepository();
        documentRepository.addDocument(new Document("doc1", "Java is a programming language. Java is widely used."));
        documentRepository.addDocument(new Document("doc2", "Python is great for data science. Python is easy to learn."));
        documentRepository.addDocument(new Document("doc3", "Java and Python are both popular programming languages."));

        SerchEngineService serchEngineService = new SerchEngineService(documentRepository);
//        for(Document doc : documentRepository.getAllDocuments()){
//            System.out.println(doc.getContent());
//        }
//        System.out.println(documentRepository.getAllDocuments());
        // Search for "Java" sorted by frequency
        List<Document> result = serchEngineService.search("Java", "frequency");
        System.out.println("Search Results (Sorted by Frequency): with keyword 'Java'");
        for (Document doc : result) {
            System.out.println(doc.getDocumentId() + " - Occurrences: " + doc.getKeywordFrequency("Java"));
        }

        // Search for "Python" sorted by document size
        result = serchEngineService.search("Python", "size");
        System.out.println("\nSearch Results (Sorted by Size): with keyword 'Python'");
        for (Document doc : result) {
            System.out.println(doc.getDocumentId() + " - Word Count: " + doc.getWordCount());
        }
    }
}
