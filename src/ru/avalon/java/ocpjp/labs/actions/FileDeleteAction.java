package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;

public class FileDeleteAction implements Action {
    private File needFile;


    public FileDeleteAction(String fileName) {
        this.needFile = new File(fileName);
    }


    @Override
    public void run() {
        if (needFile.delete()) {
            System.out.println("Файл успешно удален.");
        } else {
            System.out.println("Файл не был удален.");
        }
    }


    @Override
    public void close() throws Exception {
        //Nothing
    }
}

