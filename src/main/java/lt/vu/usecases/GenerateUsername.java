package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.UsernameGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateUsername implements Serializable {
    @Inject
    UsernameGenerator usernameGenerator;

    private CompletableFuture<String> usernameGenerationTask = null;

    @LoggedInvocation
    public String generate() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        usernameGenerationTask = CompletableFuture.supplyAsync(() -> usernameGenerator.generateUsername());

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
