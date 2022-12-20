package base.classes;

import java.io.IOException;

import base.abstractClasses.ACheckDataProcessor;
import base.abstractClasses.AFileWriter;
import base.abstractClasses.APresenter;
import base.classes.parseData.CDataParseProcessor;
import base.classes.ui.CGetData;

public class Presenter extends APresenter {
    private final CGetData getData;
    private final CDataParseProcessor dataParseProcessor;

    private final ACheckDataProcessor dataProcessor;
    private final AFileWriter fileWriter;

    public Presenter(CGetData getData,
            CDataParseProcessor dataParseProcessor,
            ACheckDataProcessor dataProcessor,
            AFileWriter fileWriter) {
        this.getData = getData;
        this.dataParseProcessor = dataParseProcessor;
        this.dataProcessor = dataProcessor;
        this.fileWriter = fileWriter;
    }

    @Override
    public void run() throws IOException {
        dataParseProcessor.parseData(getData.getData());
        dataProcessor.checkQuantity(dataParseProcessor.getDataArray());
        dataProcessor.checkFullName(dataParseProcessor.getFullName());
        dataProcessor.checkBirthday(dataParseProcessor.getBirthday());
        dataProcessor.checkSex(dataParseProcessor.getSex());
        System.out.println("\nAll checks are OK!!!");
        fileWriter.writeToFile(dataParseProcessor.getInfoToWrite());
    }
}