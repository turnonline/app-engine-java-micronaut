package biz.turnonline.ecosystem;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@Controller
public class Home
{
    @View( "home" )
    @Get
    public Map<String, Object> get()
    {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( "messages" );
        Map<String, Object> ftlModel = new HashMap<>();
        ftlModel.put( "messages", resourceBundle );
        return ftlModel;
    }
}
