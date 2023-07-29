package biz.turnonline.ecosystem;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class HomeTest
{
    @Inject
    @Client( "/" )
    HttpClient client;

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks()
    {
        Assertions.assertTrue( application.isRunning() );
    }

    @Test
    public void testGet()
    {
        HttpRequest<String> request = HttpRequest.GET( "/" );
        String body = client.toBlocking().retrieve( request );

        assertNotNull( body );
    }
}
