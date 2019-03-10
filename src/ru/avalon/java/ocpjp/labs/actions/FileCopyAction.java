package ru.avalon.java.ocpjp.labs.actions;

import java.io.*;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    /**
     * {@inheritDoc}
     */
    private File sourceFile;
    private File colyLocationFile;
    private FileInputStream reader;
    private FileOutputStream writer;


    public FileCopyAction(String sourceFile, String colyLocationFile) {
        this.sourceFile = new File(sourceFile);
        this.colyLocationFile = new  File(colyLocationFile);
    }


    @Override
    public void run() {
        try {
            reader = new FileInputStream(sourceFile);
            writer = new FileOutputStream(colyLocationFile);

            int temp = reader.read();

            do {
                writer.write(temp);
                temp = reader.read();
            } while (temp != -1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        reader.close();
        reader = null;
        writer.close();
        writer = null;
    }

}