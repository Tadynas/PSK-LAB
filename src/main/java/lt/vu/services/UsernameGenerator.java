package lt.vu.services;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public interface UsernameGenerator {
    String generateUsername() throws Exception;
}

@lt.vu.qualifiers.StandardUsername
class StandardUsername implements UsernameGenerator {
    @Override
    public String generateUsername() throws Exception{
        return getRandomUsernameFromAPI();
    }

    public String getRandomUsernameFromAPI() throws Exception
    {
        URLConnection connection = new URL("https://randomuser.me/api/").openConnection();

        try(Scanner scanner = new Scanner(connection.getInputStream());)
        {
            String response = scanner.useDelimiter("\\A").next();
            JsonArray results = jsonFromString(response).get("results").asJsonArray();
            JsonObject login = results.get(0).asJsonObject().get("login").asJsonObject();
            String username = login.get("username").toString();
            return username.substring(1, username.length()-1);
        }
    }

    private static JsonObject jsonFromString(String jsonObjectStr) {

        JsonReader jsonReader = Json.createReader(new StringReader(jsonObjectStr));
        JsonObject object = jsonReader.readObject();
        jsonReader.close();

        return object;
    }
}

@Alternative
class TestingUsername implements UsernameGenerator {
    public String generateUsername() {
        return "Test";
    }
}

@Specializes
@lt.vu.qualifiers.ExhaustiveUsername
class ExhaustiveUsername extends StandardUsername {
    @Override
    public String generateUsername() throws Exception{
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        return getRandomUsernameFromAPI();
    }
}

@Decorator
class PremiumUsername implements UsernameGenerator {

    @Inject
    @Delegate
    @Any
    UsernameGenerator usernameGenerator;

    public String generateUsername() throws Exception{
        return "Mr. " + usernameGenerator.generateUsername();
    }
}