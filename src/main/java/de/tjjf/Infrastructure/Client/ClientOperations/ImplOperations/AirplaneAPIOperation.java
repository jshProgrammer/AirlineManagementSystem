package de.tjjf.Infrastructure.Client.ClientOperations.ImplOperations;

import de.tjjf.Infrastructure.Client.ClientOperations.AbstractOperations.AbstractAPIOperation;
import de.tjjf.Infrastructure.api.InputModels.APIAirplaneInput;
import de.tjjf.Infrastructure.api.models.APIAirplane;

import java.io.IOException;
import java.net.URISyntaxException;

public class AirplaneAPIOperation extends AbstractAPIOperation {

   /* public void createAirplane(APIAirplaneInput airplaneInput){
        execute("{\"query\": \"mutation { createAirplane( airplane: { serialNum: " + airplaneInput.getSerialNum() + ", belongingAirlineName: \\\"" + airplaneInput.getBelongingAirline() + "\\\", isOperable: " + airplaneInput.isOperable() + "}) }\"}", "createAirplane", APIAirplane.class);
    }*/

    public void createAirplane(APIAirplaneInput airplaneInput) throws URISyntaxException, IOException, InterruptedException {

        String query = """
            {
                "query": "mutation {
                    createAirplane(airplane: {
                        serialNum: %d,
                        belongingAirlineName: \\"%s\\",
                        isOperable: %b
                    })
                }"
            }
            """.formatted(
                airplaneInput.getSerialNum(),
                airplaneInput.getBelongingAirline(),
                airplaneInput.isOperable()
        );
        execute(query, "createAirplane", APIAirplane.class);
    }

   /* public APIAirplane readAirplaneBySerialNum(int serialNum){
        return execute("{ \"query\": \"{ readAirplaneBySerialNum( serialNum: " + serialNum + ") { " + "serialNum belongingAirlineName isOperable" + "} }\" }", "readAirplaneBySerialNum", APIAirplane.class);
    }*/

    public APIAirplane readAirplaneBySerialNum(int serialNum) throws URISyntaxException, IOException, InterruptedException {

        String query = """
            {
                "query": "{
                    readAirplaneBySerialNum(serialNum: %d) {
                        serialNum
                        belongingAirlineName
                        isOperable
                    }
                }"
            }
            """.formatted(serialNum);
        return execute(query, "readAirplaneBySerialNum", APIAirplane.class);
    }

   /* public void setOperable(int serialNum, boolean isOperable){
        execute("{\"query\": \" mutation { setOperable( serialNum: " + serialNum + ", isOperable: " + isOperable + ") }\"}", "setOperable", APIAirplane.class);
    }*/

    public void setOperable(int serialNum, boolean isOperable) throws URISyntaxException, IOException, InterruptedException {

        String query = """
            {
                "query": "mutation {
                    setOperable(serialNum: %d, isOperable: %b)
                }"
            }
            """.formatted(serialNum, isOperable);
        execute(query, "setOperable", APIAirplane.class);
    }
}
