package src.lib.interfaces;

public interface IBook {
    void get();

    long getISBN();

    String getAuthorID();

    int getPrice();

    String getTitle();

    void setAuthorID(String id);

    void setPrice(int price);

    void setTitle(String title);
}
