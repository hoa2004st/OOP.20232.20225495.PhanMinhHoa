package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();
    public Book(int id, String title, String category, float cost, String author) {
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.addAuthor(author);
    }

    public void addAuthor(String... authorsName) {
        for (String authorName : authorsName) {
            if (!this.authors.contains(authorName)){
                this.authors.add(authorName);
                System.out.println("Author has been added to the authors list of this book");
            }
            else{
                System.out.println("This author is already in the authors list of this book");
            }
        }
    }

    public void removeAuthor(String... authorsName) {
        for (String authorName : authorsName) {
            if (this.authors.contains(authorName)){
                this.authors.remove(authorName);
                System.out.println("Author has been removed out of the authors list of this book");
            }
            System.out.println("This author is not in the authors list of this book");
        }
    }
    public String toString(){
        return "Book - " + getTitle() + " - " + getCategory() + " - " + getCost() + "$";
    }
}
