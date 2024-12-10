package de.tjjf.Infrastructure.api.models;

public class APIAirplane implements APIModel {

    private int serialNum;

    private String belongingAirlineName;

    private boolean isOperable;

    public APIAirplane(){}

    public APIAirplane(int serialNum, String belongingAirlineName, boolean isOperable) {
        this.serialNum = serialNum;
        this.belongingAirlineName = belongingAirlineName;
        this.isOperable = isOperable;
    }

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
