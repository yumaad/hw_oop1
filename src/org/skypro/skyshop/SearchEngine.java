package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables;


    public SearchEngine(int capacity) {
        this.searchables = new ArrayList<>(capacity);
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> findBestMatch(String search) throws BestResultNotFound {
        List<Searchable> matches = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(search.toLowerCase())) {
                matches.add(searchable);
            }
        }
        if (matches.isEmpty()) {
            throw new BestResultNotFound("No matching result found for: " + search);
        }
        return matches;
    }
}
