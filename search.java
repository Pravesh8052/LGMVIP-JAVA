import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class search {
    private Map<String, List<String>> index;

    public search() {
        index = new HashMap<>();
    }

    public void indexDocument(String documentId, String content) {
        String[] words = content.split("\\s+");
        for (String word : words) {
            word = word.toLowerCase();
            if (!index.containsKey(word)) {
                index.put(word, new ArrayList<>());
            }
            index.get(word).add(documentId);
        }
    }

    public List<String> search(String query) {
        List<String> results = new ArrayList<>();
        String[] words = query.split("\\s+");
        for (String word : words) {
            word = word.toLowerCase();
            if (index.containsKey(word)) {
                results.addAll(index.get(word));
            }
        }
        return results;
    }
}
