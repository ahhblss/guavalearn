package com.lss.guava.basicUtilties;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import org.junit.Test;

/**
 * Created by Sean.liu on 2016/7/22.
 */
public class MoreObjectsDemo {

    @Test
    public void toStringTest()
    {
        Book book = new Book();
        book.title = "Guava";
        book.publisher = "ahhblss";
        book.isbn = "iso12542154";
        book.price = 23.5;

        System.out.println(book.toString());
    }

    @Test
    public void firstNotNullValueTest()
    {
        //返回第一个不为null的值
        System.out.println(MoreObjects.firstNonNull("helloFirst",null));
    }

    @Test
    public void hashCodeTest()
    {
        Book book = new Book();
        book.title = "Guava";
        book.publisher = "ahhblss";
        book.isbn = "iso12542154";
        book.price = 23.5;

        System.out.println(book.hashCode());
    }

    @Test
    public void compareToTest()
    {
        Book book = new Book();
        book.setPrice(24);
        Book book2 = new Book();
        book2.setPrice(25);

        System.out.println(book.compareTo(book2));
    }

    class Book implements Comparable<Book>
    {
        private String title;
        private String publisher;
        private String isbn;
        private double price;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).omitNullValues()
                    .add("title",title)
                    .add("publisher",publisher)
                    .add("isbin",isbn)
                    .add("price",null)
                    .toString();
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(title,publisher,isbn,price);
        }

        public int compareTo(Book o) {
            return ComparisonChain.start()
                    .compare(this.price,o.getPrice())
                    .result();
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
