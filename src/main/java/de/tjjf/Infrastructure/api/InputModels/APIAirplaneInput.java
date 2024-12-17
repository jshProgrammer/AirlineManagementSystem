package de.tjjf.Infrastructure.api.InputModels;

public class APIAirplaneInput implements APIModelInput {

    private int serialNum;

    private String belongingAirlineName;

    private boolean isOperable;

    public String getBelongingAirline() {
        return belongingAirlineName;
    }

    public boolean isOperable() {
        return isOperable;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setBelongingAirline(String belongingAirlineName) {
        this.belongingAirlineName = belongingAirlineName;
    }

    public void setOperable(boolean operable) {
        isOperable = operable;
    }
}
