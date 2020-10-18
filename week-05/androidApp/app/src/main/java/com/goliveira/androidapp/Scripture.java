package com.goliveira.androidapp;


import java.io.Serializable;

public class Scripture implements Serializable {
    private String Book;
    private int Chapter;
    private int Verse;

    public Scripture()
    {
    }

    public Scripture(String book, int chapter, int verse)
    {
        Book = book;
        Chapter = chapter;
        Verse = verse;
    }

    public String getBook() {
        return Book;
    }

    public void setBook(String book) {
        Book = book;
    }

    public int getChapter() {
        return Chapter;
    }

    public void setChapter(int chapter) {
        Chapter = chapter;
    }

    public int getVerse() {
        return Verse;
    }

    public void setVerse(int verse) {
        Verse = verse;
    }

    @Override
    public String toString() {
        return Book + ' ' + Chapter + ":" + Verse;
    }
}
