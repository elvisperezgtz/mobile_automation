package femsa.api;

import femsa.models.User;
import femsa.utils.UserController;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.assertj.core.util.Files;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.nio.file.Paths;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


@RunWith(SerenityRunner.class)
@Narrative(text = {"As an user",
        "I want to be able to edit my personal information",
        "In order to get update my personal information"})
@WithTagValuesOf({"profile"})
public class GetName {

    private Actor actor;

    @Before
    public void setUp() {

        Cast cast = Cast.whereEveryoneCan(CallAnApi.at("https://apollo.b2b-qa.digitalfemsa.services"));
        actor = cast.actorNamed("Rest client");

    }


    @Test
    public void should_theUserInformationBeUpdate_when_changeTheValues() {
//            actor.attemptsTo(Post.to("/").with(
//                    query -> {
//                        query.contentType(ContentType.JSON);
//                        return query.body(Load.credentialsFromJsonTemplate("src/test/resources/data/api/query.json"));
//                    }
//            ));

        actor.attemptsTo(Login.byService());
        actor.should(seeThatResponse("stuff is returned",
                        validatableResponse -> {
                            validatableResponse.statusCode(200);
                        }
                )
        );
        actor.remember("token", SerenityRest.lastResponse().jsonPath().getString("data.login.accessToken"));
        actor.remember("idUser", SerenityRest.lastResponse().jsonPath().getString("data.login.idUser"));
        System.out.println(actor.recall("token").toString());

        UserController userController = new UserController();
        userController.loadUsersFromJson(Files.contentOf(
                Paths.get(this.getClass().
                        getResource("/data/api/templates/update_user_info_data.json")
                        .getPath()
                ).toFile(), "UTF-8")
        );

        User user = userController.getUserByKey("user_without_clabe");
        actor.attemptsTo(
//                Update.userInformation("Elvis")
                    Post.to("/")
                            .with(
                                    request -> {
                                        request.contentType(ContentType.JSON);
                                        request.header("Authorization", "Bearer ".concat(actor.recall("token")));
                                        String queryBody = Files.contentOf(
                                                Paths.get(this.getClass().getResource("/data/api/templates/update_user_info_template.json").getPath()).toFile(), "UTF-8");
                                        queryBody = queryBody.replace("{{idUser}}", actor.recall("idUser"));
                                        queryBody = queryBody.replace("{{lastName}}","Elvis");
                                        queryBody = queryBody.replace("{{name}}", "Perez Gutierrez");
                                        queryBody = queryBody.replace("{{email}}", "eperez@palo-it.com");
                                        System.out.println(actor.recall("idUser").toString());
                                        return request.body(queryBody);
                                    }
                            )
        );
        actor.should(seeThatResponse("stuff is returned", validatableResponse -> {
            validatableResponse.statusCode(200);
        }));
    }
}