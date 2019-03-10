package ru.avalon.java.ocpjp.labs.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileCreateAction implements Action {
    private String fileName;


    public FileCreateAction(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void run() {
        File temp = new File(fileName + ".txt");
        Date date = new Date();

        try (BufferedWriter out = new BufferedWriter(new FileWriter(temp))) {
            out.write(String.format("Дата создания файла: %tc", date));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void close() throws Exception {
        //Nothing
    }
}