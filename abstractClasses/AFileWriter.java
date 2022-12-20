package base.abstractClasses;

import java.io.FileWriter;

import base.classes.workWithFile.CFileCreator;
import base.classes.workWithFile.CFindTheSameFileName;
import base.interfaces.IWriteToFile;

public abstract class AFileWriter implements IWriteToFile {
    protected FileWriter fileWriter;
    protected CFileCreator fileCreator;
    protected CFindTheSameFileName findTheSameFileName;
}
