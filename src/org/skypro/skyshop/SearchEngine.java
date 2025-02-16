package org.skypro.skyshop;

public class SearchEngine {
    private final Searchable[] searchables;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size++] = searchable;
        } else {
            System.out.println("SearchEngine is full. Cannot add more items.");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results[count++] = searchable;
                if (count == 5) {
                    break;
                }
            }
        }

        return results;
    }
}
