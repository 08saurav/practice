package GoogleDoc;

import GoogleDoc.models.Document;
import GoogleDoc.repositories.DocumentRepository;
import GoogleDoc.services.DocumentService;

public class Client {
    public static void main(String[] args) {
        DocumentRepository repository = new DocumentRepository();
        DocumentService service = new DocumentService(repository);

        // Create and insert documents
        Document doc1 = new Document();
        Document doc2 = new Document();
        service.insertDocument("doc1", doc1);
        service.insertDocument("doc2", doc2);

        // Test appendText
        service.appendText("Hello World!", "doc1");
        System.out.println("Doc1 Text: " + service.getDocumentById("doc1").getText()); // Output: Hello World!

        service.appendText("Java Programming", "doc2");
        System.out.println("Doc2 Text: " + service.getDocumentById("doc2").getText()); // Output: Java Programming

        // Test replaceText
        service.replaceText("New Document", "Hello World!", "doc1");
        System.out.println("Doc1 After Replace: " + service.getDocumentById("doc1").getText()); // Output: New Document

        // Test cursor movement
        service.moveCursor("doc1", "left");
        System.out.println("Doc1 Cursor Position: " + service.getDocumentById("doc1").getCursorPosition());

        service.movePage("doc2", "pagedown");
        System.out.println("Doc2 Cursor Position After Page Down: " + service.getDocumentById("doc2").getCursorPosition());
    }
}
