import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import ink.onei.entity.Car;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: nekotako
 * @Description: CarTest
 * @Date: 18/12/2023 18:39 Monday
 */

public class CarTest {
    ObjectMapper objectMapper = null;
    Car car = null;
    Car[] cars = null;

    @Before
    public void before() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void m1() throws JsonProcessingException {
        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        car = objectMapper.readValue(carJson, Car.class);
        System.out.println(car);
    }

    @Test
    public void m2() throws IOException {
        InputStream inputStream = CarTest.class.getClassLoader().getResourceAsStream("car.json");
        car = objectMapper.readValue(inputStream, Car.class);
        System.out.println(car);
    }

    @Test
    public void m3() throws IOException {
        String jsonArray = "[{\"brand\":\"ford\",\"doors\":\"2\"}, {\"brand\":\"Fiat\",\"doors\":\"4\"}]";
        cars = objectMapper.readValue(jsonArray, Car[].class);
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void m4() throws IOException {
        car = new Car("BMW", 2);
        String json = objectMapper.writeValueAsString(car);
        System.out.println(json);

    }

    @Test
    public void m5() throws IOException {
        m3();
        String jsonArray = objectMapper.writeValueAsString(cars);
        System.out.println(jsonArray);

    }

    @Test
    public void m6() throws IOException {
        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(carJson);
        Car car = new Car();
        while (!parser.isClosed()) {
            JsonToken jsonToken = parser.nextToken();

            if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                String fieldName = parser.getCurrentName();
                jsonToken = parser.nextToken();

                if ("brand".equals(fieldName)) {
                    car.setBrand(parser.getValueAsString());
                } else if ("doors".equals(fieldName)) {
                    car.setDoors(parser.getValueAsInt());
                }
            }
        }
        System.out.println(car);
    }
}
