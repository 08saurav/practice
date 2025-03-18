package GoogleDoc.services;

import GoogleDoc.models.Document;
import GoogleDoc.repositories.DocumentRepository;

public class DocumentService {
    private DocumentRepository documentRepository;
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    public void appendText(String text, String fileName) {
        documentRepository.getDocumentById(fileName).appendText(text);
    }
    public void replaceText(String newText, String oldText ,String fileName) {
        documentRepository.getDocumentById(fileName).replaceText(newText, oldText);
    }
    public void insertDocument(String fileName, Document document) {
        documentRepository.addDocument(document, fileName);
    }
    public Document getDocumentById(String fileName) {
        return documentRepository.getDocumentById(fileName);
    }
    public void moveCursor(String fileName, String direction) {
        documentRepository.getDocumentById(fileName).moveCursor(direction);
    }
    public void movePage(String fileName, String direction) {
        documentRepository.getDocumentById(fileName).movePage(direction);
    }
}
