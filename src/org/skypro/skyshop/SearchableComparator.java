package org.skypro.skyshop;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable>{
    @Override
    public int compare(Searchable o1, Searchable o2) {
        // Сначала сравниваем по длине имени (от большего к меньшему)
        int lengthComparison = Integer.compare(o2.getName().length(), o1.getName().length());
        if (lengthComparison != 0) {
            return lengthComparison;
        }
        // Если длины равны, сортируем в натуральном порядке
        return o1.getName().compareTo(o2.getName());
    }
}
