package src.utils;

import src.lib.interfaces.ISearchWithCondition;

public class SearchWithCondition<T> implements ISearchWithCondition<T> {

    public SearchWithCondition(String choice, String type, String condition, T value) {
        switch (choice) {
            case "author":
                searchAuthorWithCondition(type, condition, value);
                break;
            case "book":
                searchBookWithCondition(type, condition, value);
                break;
            default:
                break;
        }
    }

    @Override
    public void searchBookWithCondition(String type, String condition, T value) {
        
    }

    @Override
    public void searchAuthorWithCondition(String type, String condition, T value) {

    }
}
