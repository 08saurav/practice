package GoogleDocSearch.repositories;

import GoogleDocSearch.models.Document;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DocumentRepository {
    Map<String, Document> documents;
    public DocumentRepository() {
        documents = new HashMap<>();
    }
    public Document getDocument(String id) {
        return documents.get(id);
    }
    public void addDocument(Document document) {
        documents.put(document.getDocumentId(), document);
    }
    public Collection<Document> getAllDocuments() {
        return documents.values();
    }
    public void removeDocument(String id) {
        documents.remove(id);
    }
}
