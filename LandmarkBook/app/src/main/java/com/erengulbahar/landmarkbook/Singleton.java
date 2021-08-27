package com.erengulbahar.landmarkbook;

public class Singleton
{
    private LandMark sentLanmark;
    private static Singleton singleton;

    private Singleton()
    {

    }

    public LandMark getSentLanmark()
    {
        return sentLanmark;
    }

    public void setSentLanmark(LandMark sentLanmark)
    {
        this.sentLanmark=sentLanmark;
    }

    public static Singleton getInstance()
    {
        if(singleton==null)
        {
            singleton=new Singleton();
        }

        return singleton;
    }
}
