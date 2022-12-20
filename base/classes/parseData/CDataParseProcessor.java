package base.classes.parseData;

import base.abstractClasses.ADataParseProcessor;
import base.exceptions.FullNameReadFromDataException;
import base.exceptions.GetDataArrayException;
import base.exceptions.ParseDataException;
import base.exceptions.ParseDataToIntegerException;

public class CDataParseProcessor extends ADataParseProcessor {

    private String data;
    private String[] dataArray;
    private final String[] fullName;
    private String birthday;
    private long phoneNumber;
    private String sex;

    public CDataParseProcessor() {
        this.data = "";
        this.fullName = new String[3];
        this.birthday = "";
        this.phoneNumber = 0;
        this.sex = "";
    }

    @Override
    public String[] getFullName() {
        return this.fullName;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String getSex() {
        return this.sex;
    }

    @Override
    public String[] getInfoToWrite() {
        String[] infoArray = new String[2];
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(this.fullName[0]).append(">").append("<").append(this.fullName[1]).append(">");
        sb.append("<").append(this.fullName[2]).append(">").append("<").append(this.birthday).append(">");
        sb.append("<").append(this.phoneNumber).append(">").append("<").append(this.sex).append(">");

        infoArray[0] = this.fullName[0];
        infoArray[1] = sb.toString();
        sb = new StringBuilder();
        return infoArray;
    }

    @Override
    public void parseData(String data) {
        this.data = data;
        this.dataArray = this.data.split(" ");

        try {
            for (int i = 0; i < dataArray.length; i++) {
                if (this.dataArray[i].length() == 1)
                    this.sex = this.dataArray[i];
                else if ((Character.isDigit(this.dataArray[i].charAt(0))) && this.dataArray[i].contains("."))
                    this.birthday = this.dataArray[i];
                else if ((Character.isDigit(this.dataArray[i].charAt(0))) && !(this.dataArray[i].contains(".")))
                    try {
                        this.phoneNumber = Integer.parseInt(this.dataArray[i]);
                    } catch (NumberFormatException e) {
                        throw new ParseDataToIntegerException(e.getMessage());
                    }
                else {
                    try {
                        this.fullName[0] = this.dataArray[i];
                        this.fullName[1] = this.dataArray[i + 1];
                        this.fullName[2] = this.dataArray[i + 2];
                        i += 2;
                    } catch (IndexOutOfBoundsException e) {
                        throw new FullNameReadFromDataException(e.getMessage());
                    }
                }
            }
        } catch (RuntimeException e) {
            throw new ParseDataException(e.getMessage());
        }
    }

    public String[] getDataArray() {
        if (dataArray == null)
            throw new GetDataArrayException();
        return dataArray;
    }
}
