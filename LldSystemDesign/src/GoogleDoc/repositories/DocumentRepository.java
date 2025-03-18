package GoogleDoc.repositories;

import GoogleDoc.models.Document;

import java.util.HashMap;
import java.util.Map;

public class DocumentRepository {
    Map<String,Document> documentRepo;
    public DocumentRepository() {
        documentRepo = new HashMap<>();
    }
    public Document getDocumentById(String id) {
        return documentRepo.get(id);
    }
    public void addDocument(Document document,String docId) {
        documentRepo.put(docId,document);
    }
    public void removeDocument(String docId) {
        documentRepo.remove(docId);
    }
}
