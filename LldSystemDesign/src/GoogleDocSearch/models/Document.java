package GoogleDocSearch.models;

import java.util.HashMap;
import java.util.Map;

public class Document {
    private String documentId;
    private String content;
    private Map<String, Integer> wordFrequency; // Store word counts for fast lookup
    public Document(String documentId, String content) {
        this.documentId = documentId;
        this.content = content;
        this.wordFrequency = new HashMap<>();
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }

    public void setWordFrequency(Map<String, Integer> wordFrequency) {
        this.wordFrequency = wordFrequency;
    }

    public void processWordFrequency() {
        for(String word : content.toLowerCase().split("\\s+")) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word,0)+1);
        }
    }
    public int getKeywordFrequency(String keyword) {
        return wordFrequency.getOrDefault(keyword.toLowerCase(), 0);
    }
    public int getWordCount() {
        return wordFrequency.size();
    }

}
