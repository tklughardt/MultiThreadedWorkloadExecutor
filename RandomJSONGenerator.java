import java.util.Random;
import java.util.UUID;

public class RandomJSONGenerator {

    Random r;

    private String getActionType() {

        double val = r.nextDouble();

        if (val < .5)
            return "OrderCreated";
        if ( (.5 <= val) && (val < .75) )
            return "OrderReturned";
        else
            return "OrderCancelled";
    }

    private String getCustomer() {
        return "Customer" + r.nextInt();
    }

    private String getOrderID() {
        return UUID.randomUUID().toString();
    }

    public RandomJSONGenerator() {
        this.r = new Random();
    }

    public String generateRecordMetadata() {

        String metadadata = "{\n" +
                "  \"meta\":\n" +
                "    {\n" +
                "        \"offset\": 1,\n" +
                "        \"topic\": \"JSON_lab_topic\",\n" +
                "        \"partition\": 12,\n" +
                "        \"key\": \"" + System.currentTimeMillis() + "\",\n" +
                "        \"schema_id\": 123,\n" +
                "        \"CreateTime\": " + System.currentTimeMillis() + ",\n" +
                "        \"headers\":\n" +
                "        {\n" +
                "            \"name1\": \"value1\",\n" +
                "            \"name2\": \"value2\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        return metadadata;
    }

    public String generateRecordContent() {

        String actionType;
        String orderID;
        String customerName;


        String content = "{\n" +
                "  \"basicOrder\": {\n" +
                "    \"eventType\": \"" + getActionType() + "\",\n" +
                "    \"orderCreationDate\": 882435600000,\n" +
                "    \"orderId\": \"" + getOrderID() + "\"\n" +
                "  },\n" +
                "  \"customer\": {\n" +
                "    \"customerId\": \"" + getCustomer() + "\",\n" +
                "    \"dateOfBirth\": \"2000-01-01\",\n" +
                "    \"gender\": \"\",\n" +
                "    \"name\": \"Customer[name_here]\"\n" +
                "  },\n" +
                "  \"positions\": [\n" +
                "    {\n" +
                "      \"pos\": 0,\n" +
                "      \"pricePerUnit\": 5.898000000000000e+01,\n" +
                "      \"product\": {\n" +
                "        \"attributes\": [],\n" +
                "        \"description\": \"\",\n" +
                "        \"id\": \"10067\",\n" +
                "        \"name\": \"product[10067]\"\n" +
                "      },\n" +
                "      \"qty\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"pos\": 1,\n" +
                "      \"pricePerUnit\": 6.898000000000000e+01,\n" +
                "      \"product\": {\n" +
                "        \"attributes\": [],\n" +
                "        \"description\": \"\",\n" +
                "        \"id\": \"10069\",\n" +
                "        \"name\": \"product[10069]\"\n" +
                "      },\n" +
                "      \"qty\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"pos\": 2,\n" +
                "      \"pricePerUnit\": 9.798000000000000e+01,\n" +
                "      \"product\": {\n" +
                "        \"attributes\": [],\n" +
                "        \"description\": \"\",\n" +
                "        \"id\": \"10032\",\n" +
                "        \"name\": \"product[10032]\"\n" +
                "      },\n" +
                "      \"qty\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"pos\": 3,\n" +
                "      \"pricePerUnit\": 9.798000000000000e+01,\n" +
                "      \"product\": {\n" +
                "        \"attributes\": [],\n" +
                "        \"description\": \"\",\n" +
                "        \"id\": \"10011\",\n" +
                "        \"name\": \"product[10011]\"\n" +
                "      },\n" +
                "      \"qty\": 1\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        return content;
    }

    public String generateContentStorno() {

        String content = "{\n" +
                "  \"basicOrder\": {\n" +
                "    \"eventType\": \"OrderReturned\",\n" +
                "    \"orderCreationDate\": 882435600000,\n" +
                "    \"orderId\": \"6da9280a-c908-4584-a5cd-047710c3a470\"\n" +
                "  },\n" +
                "  \"customer\": {\n" +
                "    \"customerId\": \"Customer245\",\n" +
                "    \"dateOfBirth\": \"2000-01-01\",\n" +
                "    \"gender\": \"\",\n" +
                "    \"name\": \"Customer[Customer245]\"\n" +
                "  },\n" +
                "  \"positions\": [\n" +
                "    {\n" +
                "      \"pos\": 0,\n" +
                "      \"pricePerUnit\": 5.898000000000000e+01,\n" +
                "      \"product\": {\n" +
                "        \"attributes\": [],\n" +
                "        \"description\": \"\",\n" +
                "        \"id\": \"10067\",\n" +
                "        \"name\": \"product[10067]\"\n" +
                "      },\n" +
                "      \"qty\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"pos\": 1,\n" +
                "      \"pricePerUnit\": 6.898000000000000e+01,\n" +
                "      \"product\": {\n" +
                "        \"attributes\": [],\n" +
                "        \"description\": \"\",\n" +
                "        \"id\": \"10069\",\n" +
                "        \"name\": \"product[10069]\"\n" +
                "      },\n" +
                "      \"qty\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"pos\": 2,\n" +
                "      \"pricePerUnit\": 9.798000000000000e+01,\n" +
                "      \"product\": {\n" +
                "        \"attributes\": [],\n" +
                "        \"description\": \"\",\n" +
                "        \"id\": \"10032\",\n" +
                "        \"name\": \"product[10032]\"\n" +
                "      },\n" +
                "      \"qty\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"pos\": 3,\n" +
                "      \"pricePerUnit\": 9.798000000000000e+01,\n" +
                "      \"product\": {\n" +
                "        \"attributes\": [],\n" +
                "        \"description\": \"\",\n" +
                "        \"id\": \"10011\",\n" +
                "        \"name\": \"product[10011]\"\n" +
                "      },\n" +
                "      \"qty\": 1\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        return content;
    }

}
