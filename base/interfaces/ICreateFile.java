package base.interfaces;

import java.io.IOException;

import base.exceptions.FileCreateException;

public interface ICreateFile {
    public boolean createFile(String path) throws FileCreateException, FileCreateException;
}
