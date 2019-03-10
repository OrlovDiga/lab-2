package ru.avalon.java.ocpjp.labs.actions;

import java.io.IOException;
import java.nio.file.*;


/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    /**
     * {@inheritDoc}
     */
    String source;
    String target;


    public FileMoveAction(String source, String target) {
        this.source = source;
        this.target = target;
    }


    @Override
    public void run() {
        try {
            Files.move(Paths.get(source), Paths.get(target), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        //Nothing
    }
}

