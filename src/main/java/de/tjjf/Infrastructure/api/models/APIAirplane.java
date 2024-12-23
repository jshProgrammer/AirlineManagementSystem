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
