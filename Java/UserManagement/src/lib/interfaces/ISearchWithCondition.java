package src.lib.interfaces;

public interface ISearchWithCondition<T> {
    void searchBookWithCondition(String type, String condition, T value);

    void searchAuthorWithCondition(String type, String condition, T value);
}
