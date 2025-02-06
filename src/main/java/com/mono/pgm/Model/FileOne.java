package com.mono.pgm.Model;

import java.io.InputStream;

public class FileOne
{
    private String title;
    private InputStream str;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InputStream getStr() {
        return str;
    }

    public void setStr(InputStream str) {
        this.str = str;
    }
}
