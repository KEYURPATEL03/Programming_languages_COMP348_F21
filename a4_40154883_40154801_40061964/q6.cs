using System;
using System.IO;

public delegate void ReadHandler(string line);

public sealed class TextFileProcessor
{
    public static event ReadHandler LineRead;   

    public void Read(string file)
    {
        string text = File.ReadAllText(@file);    
        string[] lines = text.Split("\n");     //split the line with \n
        foreach (string line in lines)
        {
            LineRead(line);    //fired when line is read in read method
        }
    }
}