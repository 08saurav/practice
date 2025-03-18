package GoogleDocSearch.services;

import GoogleDocSearch.repositories.DocumentRepository;
import GoogleDocSearch.models.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SerchEngineService {
    private DocumentRepository documentRepository;
    public SerchEngineService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    public List<Document> search(String query,String sortBy) {
        List<Document> documents = new ArrayList<>();
        for(Document doc : documentRepository.getAllDocuments()){
            doc.processWordFrequency();
            if(doc.getWordFrequency().get(query.toLowerCase()) != null ){
                documents.add(doc);
//                System.out.println(doc.getContent());
            }
        }
        if(sortBy.equals("size")){
            documents.sort((a,b) -> b.getWordCount() - a.getWordCount());
        }
        else if(sortBy.equals("frequency")){
            documents.sort((a,b) -> b.getKeywordFrequency(query)- a.getKeywordFrequency(query));
        }
        return documents;
    }
}
