package base.classes.workWithFile;

import java.io.File;
import java.io.IOException;

import base.abstractClasses.AFileCreator;
import base.exceptions.FileCreateException;

public class CFileCreator extends AFileCreator {

    @Override
    public boolean createFile(String path) throws FileCreateException {
        super.file = new File(path);
        try {
            return super.file.createNewFile();
        } catch (IOException e) {
            throw new FileCreateException(e.getMessage());
        }
    }
}