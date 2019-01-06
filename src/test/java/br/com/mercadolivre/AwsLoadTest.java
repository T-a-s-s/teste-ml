package br.com.mercadolivre;

import br.com.mercadolivre.api.exception.ForbiddenException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class AwsLoadTest {

    public static void main(String...args) {

        Runnable runnable = new LoadTestRunnable(); // or an anonymous class, or lambda...

        Thread thread = new Thread(runnable);
        thread.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread thread3 = new Thread(runnable);
        thread3.start();

    }

}
