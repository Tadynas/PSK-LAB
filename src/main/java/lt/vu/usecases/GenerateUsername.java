package lt.vu.usecases;
import lt.vu.qualifiers.ExhaustiveUsername;
import lt.vu.qualifiers.StandardUsername;
import lt.vu.services.UsernameGenerator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.Serializable;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
@Model
public class GenerateUsername implements Serializable {

    @Inject
    @StandardUsername
    UsernameGenerator usernameGenerator;

    private CompletableFuture<String> usernameGenerationTask = null;

    public String generate() throws Exception {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        usernameGenerationTask = CompletableFuture.supplyAsync(() -> {
            try {
                return usernameGenerator.generateUsername();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });

        return  "/signup.xhtml?faces-redirect=true";
    }

    public boolean isGenerating() {
        return usernameGenerationTask != null && !usernameGenerationTask.isDone();
    }

    public String getStatus() throws ExecutionException, InterruptedException {
        if (usernameGenerationTask == null) {
            return null;
        } else if (isGenerating()) {
            return "Username is being generated!";
        }
        return "Suggested username: " + usernameGenerationTask.get();
    }
}
