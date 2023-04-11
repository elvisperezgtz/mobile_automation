package femsa.api;

import femsa.utils.jsons.Load;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class Login {

    public static Performable byService() {
        return Task.where("{0} logs in by service",
                Post.to("/").with(
                        query -> {
                            query.contentType(ContentType.JSON);
                            return query.body(Load.credentialsFromJsonTemplate("src/test/resources/data/api/query.json"));
                        }
                )
        );
    }

}
