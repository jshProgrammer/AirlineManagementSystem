package de.tjjf.Infrastructure.api.InputModels;

public class APIAirplaneInput implements APIModelInput {

    private int serialNum;

    private String belongingAirlineName;

    private boolean isOperable;

    public APIAirplaneInput() {}

    public APIAirplaneInput(int serialNum, String belongingAirline, boolean operable) {
        this.serialNum=serialNum;
        this.belongingAirlineName=belongingAirline;
        this.isOperable=operable;
    }

    public String getBelongingAirlineName() {
        return belongingAirlineName;
    }

    public boolean getIsOperable() {
        return isOperable;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setBelongingAirlineName(String belongingAirlineName) {
        this.belongingAirlineName = belongingAirlineName;
    }

    public void setIsOperable(boolean operable) {
        isOperable = operable;
    }
}
