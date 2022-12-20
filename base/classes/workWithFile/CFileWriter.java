package base.classes.workWithFile;

import java.io.FileWriter;
import java.io.IOException;

import base.abstractClasses.AFileWriter;
import base.exceptions.FileCreateException;
import base.exceptions.MyFileCreateException;
import base.exceptions.TheSameFileWritingException;

public class CFileWriter extends AFileWriter {
    private final String folderPath;

    public CFileWriter(CFileCreator fileCreator, CFindTheSameFileName findTheSameFileName, String folderPath) {
        super.fileCreator = fileCreator;
        super.findTheSameFileName = findTheSameFileName;
        this.folderPath = folderPath;
    }

    @Override
    public boolean writeToFile(String[] infoToWrite) throws TheSameFileWritingException, MyFileCreateException {
        String path = this.folderPath + infoToWrite[0] + ".txt";

        if (findTheSameFileName.findTheSameFileName(infoToWrite[0], this.folderPath)) {
            System.out.println("Found the same last name");
            try {
                super.fileWriter = new FileWriter(path, true);
                super.fileWriter.write(infoToWrite[1] + "\n");
                super.fileWriter.close();
                System.out.println("The data wrote");
            } catch (IOException e) {
                throw new TheSameFileWritingException(e.getMessage());
            }
        } else {
            try {
                fileCreator.createFile(path);
                System.out.println("New file created");
            } catch (FileCreateException e) {
                throw new MyFileCreateException(e.getMessage());
            }
            try {
                super.fileWriter = new FileWriter(path, true);
                super.fileWriter.write(infoToWrite[1] + "\n");
                super.fileWriter.close();
                System.out.println("The data wrote");
            } catch (IOException e) {
                throw new TheSameFileWritingException(e.getMessage());
            }
        }
        return true;
    }
}