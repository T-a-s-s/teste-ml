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
        Thread thread4 = new Thread(runnable);
        thread4.start();
        Thread thread5 = new Thread(runnable);
        thread5.start();
        Thread thread6 = new Thread(runnable);
        thread6.start();
        Thread thread7 = new Thread(runnable);
        thread7.start();
        Thread thread8 = new Thread(runnable);
        thread8.start();
        Thread thread9 = new Thread(runnable);
        thread9.start();
        Thread thread10 = new Thread(runnable);
        thread10.start();
        Thread thread11 = new Thread(runnable);
        thread11.start();
        Thread thread12 = new Thread(runnable);
        thread12.start();
        Thread thread13 = new Thread(runnable);
        thread13.start();
        Thread thread14 = new Thread(runnable);
        thread14.start();
        Thread thread15 = new Thread(runnable);
        thread15.start();
        Thread thread16 = new Thread(runnable);
        thread16.start();
        Thread thread17 = new Thread(runnable);
        thread17.start();
        Thread thread18 = new Thread(runnable);
        thread18.start();
        Thread thread19 = new Thread(runnable);
        thread19.start();
        Thread thread20 = new Thread(runnable);
        thread20.start();
        Thread thread21 = new Thread(runnable);
        thread21.start();
        Thread thread22 = new Thread(runnable);
        thread22.start();
        Thread thread23 = new Thread(runnable);
        thread23.start();
        Thread thread24 = new Thread(runnable);
        thread24.start();
        Thread thread25 = new Thread(runnable);
        thread25.start();
        Thread thread26 = new Thread(runnable);
        thread26.start();
        Thread thread27 = new Thread(runnable);
        thread27.start();
        Thread thread28 = new Thread(runnable);
        thread28.start();
        Thread thread29 = new Thread(runnable);
        thread29.start();
        Thread thread30 = new Thread(runnable);
        thread30.start();
        Thread thread31 = new Thread(runnable);
        thread31.start();
        Thread thread32 = new Thread(runnable);
        thread32.start();
        Thread thread33 = new Thread(runnable);
        thread33.start();
        Thread thread34 = new Thread(runnable);
        thread34.start();
        Thread thread35 = new Thread(runnable);
        thread35.start();
        Thread thread36 = new Thread(runnable);
        thread36.start();
        Thread thread37 = new Thread(runnable);
        thread37.start();
        Thread thread38 = new Thread(runnable);
        thread38.start();
        Thread thread39 = new Thread(runnable);
        thread39.start();
        Thread thread40 = new Thread(runnable);
        thread40.start();

    }

}
