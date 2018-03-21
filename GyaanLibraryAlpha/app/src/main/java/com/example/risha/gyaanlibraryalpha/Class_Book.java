package com.example.risha.gyaanlibraryalpha;

/**
 * Created by risha on 2/27/2018.
 */

public class Class_Book {
    public int id;
    public int editionId;
    public String title;
    public String author;
    public String summary;
    public String publicationInfo;
    public String reviews;
    public int numAvailable;
    public int numCopies;

    public int Search(String key){
        int similarity = 0;
        if (title.contains(key) || author.contains(key)){
            similarity += 2;
        }
        String[] keyTokens = key.split(" ");
        for (int i = 0; i < keyTokens.length; i++){
            if (keyTokens[i].replaceAll(" ", "").length() > 0){
                if (title.contains(keyTokens[i])){
                    similarity++;
                }
                if (title.contains(keyTokens[i])){
                    similarity++;
                }
            }
        }
        return similarity;
    }
}
