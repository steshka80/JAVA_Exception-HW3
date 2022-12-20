
import java.io.IOException;

import base.classes.Presenter;
import base.classes.checkInputData.CCheckBirthday;
import base.classes.checkInputData.CCheckDataProcessor;
import base.classes.checkInputData.CCheckFullName;
import base.classes.checkInputData.CCheckQuantity;
import base.classes.checkInputData.CCheckSex;
import base.classes.parseData.CDataParseProcessor;
import base.classes.ui.CGetData;
import base.classes.workWithFile.CFileCreator;
import base.classes.workWithFile.CFileWriter;
import base.classes.workWithFile.CFindTheSameFileName;

public class Program {
    public static void main(String[] args) throws IOException {
        String infoPathFolder = "src/семинар3/data/";
        Presenter presenter = new Presenter(new CGetData(),
                new CDataParseProcessor(),
                new CCheckDataProcessor(new CCheckQuantity(),
                        new CCheckFullName(),
                        new CCheckBirthday(),
                        new CCheckSex()),
                new CFileWriter(new CFileCreator(),
                        new CFindTheSameFileName(),
                        infoPathFolder));
        presenter.run();
    }
}
