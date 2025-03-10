package org.skypro.skyshop;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine(int capacity) {
        this.searchables = new HashSet<>(capacity);
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> matches = new HashSet<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                matches.add(searchable);
            }
        }
        return matches;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int count = countOccurrences(searchable.getSearchTerm(), search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("No matching result found for: " + search);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String substring) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}
