/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hachem
 */
public class Book {
    private String bookName;
    private int recommendedAge;

    public Book(String bookName, int recommendedAge) {
        this.bookName = bookName;
        this.recommendedAge = recommendedAge;
    }

    public String getBookName() {
        return bookName;
    }

    public int getRecommendedAge() {
        return recommendedAge;
    }

    @Override
    public String toString() {
        return getBookName() + " (recommended for " + getRecommendedAge() + " year-olds or older)";
    }
}
