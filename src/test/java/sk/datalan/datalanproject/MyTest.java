package sk.datalan.datalanproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import sk.datalan.datalanproject.data.addess.Address;
import sk.datalan.datalanproject.data.city.City;
import sk.datalan.datalanproject.data.employee.Employee;
import sk.datalan.datalanproject.data.state.State;
import sk.datalan.datalanproject.data.utils.Gender;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 *
 *  @author matus
 *
 *  Keby testujem naozaj, spravil by som si aj testy na prijate data, pravdepodobne by som ich ulozil do file-u spravil si nejaky comparator priamo na pozadovane data
 *  Takto len testujem ci request bol uspesny a response je 200 OK
 *  Bohuzial som si zle vyclenil cas preto som nestihol implementovat plnohodnotne testy aj s implementovanim compare-u dat
 *
 */
public class MyTest {

    @BeforeClass
    public static void initData() throws Exception {
        System.out.println("Initing test");


        State state = addState("Slovakia", "11", 1);
        City city = addCity("Bratislava", "111", 1);
        Address address = addAddress(state, city, 1, "street", "02054");

        addEmployee(address, "Jozef", "Mak", Gender.MALE, 25);

        city = addCity("Puchov", "112", 2);
        address = addAddress(state, city, 2, "STREET", "02054");

        addEmployee(address, "Andrej", "Vrabel", Gender.MALE, 20);

        state = addState("Czechia", "22", 2);
        city = addCity("Prague", "221", 3);
        address = addAddress(state, city, 3, "ulica", "02054");

        addEmployee(address, "Andrea", "Janickova", Gender.FEMALE, 19);
    }

    @Test
    public void getEmployeesByGender() throws IOException {
        HttpGet httpGet = new HttpGet("http://localhost:9955/employee/gender/MALE");
        httpGet.setHeader("Content-type", "application/json");

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(httpGet);

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

        System.out.println(responseBody);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IOException("Nastala chyba : ERROR " + response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void sortEmployeesByAge() throws Exception {
        HttpGet httpGet = new HttpGet("http://localhost:9955/employee/sort/age");
        httpGet.setHeader("Content-type", "application/json");

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(httpGet);

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

        System.out.println(responseBody);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IOException("Nastala chyba : ERROR " + response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void getEmployeesByCity() throws Exception {
        HttpGet httpGet = new HttpGet("http://localhost:9955/employee/city/111");
        httpGet.setHeader("Content-type", "application/json");

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(httpGet);

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

        System.out.println(responseBody);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IOException("Nastala chyba : ERROR " + response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void getActiveEmployees() throws Exception {
        HttpGet httpGet = new HttpGet("http://localhost:9955/employee/active");
        httpGet.setHeader("Content-type", "application/json");

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(httpGet);

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

        System.out.println(responseBody);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IOException("Nastala chyba : ERROR " + response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void printEmployees() throws Exception {
        HttpGet httpGet = new HttpGet("http://localhost:9955/employee/print");
        httpGet.setHeader("Content-type", "application/json");

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(httpGet);

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

        System.out.println(responseBody);



        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IOException("Nastala chyba : ERROR " + response.getStatusLine().getStatusCode());
        }
    }


    private static City addCity(String name, String code, int id) throws Exception {
        City city = new City();
        city.setId(id);
        city.setName(name);
        city.setCode(code);

        return city;
    }

    private static State addState(String name, String code, int id) throws Exception {
        State state = new State();
        state.setId(id);
        state.setName(name);
        state.setCode(code);

        return state;
    }


    private static Address addAddress(State state, City city, int id, String streetName, String zip) throws Exception {
        HttpPost httpPost = new HttpPost("http://localhost:9955/address");
        httpPost.setHeader("Content-type", "application/json");

        Address address = new Address();
        address.setId(id);
        address.setStreet(streetName);
        address.setZip(zip);
        address.setState(state);
        address.setCity(city);

        StringEntity stringEntity = new StringEntity(objectToString(address));
        httpPost.setEntity(stringEntity);

        HttpClient httpclient = new DefaultHttpClient();
        httpclient.execute(httpPost);

        return address;
    }

    private static Employee addEmployee(Address address, String name, String surname, Gender gender, int age) throws Exception {
        HttpPost httpPost = new HttpPost("http://localhost:9955/employee");
        httpPost.setHeader("Content-type", "application/json");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setGender(gender);
        employee.setAge(age);
        employee.setAddress(address);
        employee.setEmployeeFrom(new Date());

        StringEntity stringEntity = new StringEntity(objectToString(employee));
        httpPost.setEntity(stringEntity);

        HttpClient httpclient = new DefaultHttpClient();
        httpclient.execute(httpPost);

        return employee;
    }

    static String objectToString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
