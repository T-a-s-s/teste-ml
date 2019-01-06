package br.com.mercadolivre;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class LoadTestRunnable implements Runnable {

    static Random r = new Random();

    public void run(){
        System.out.println("=========== Thread iniciando trabalho ============");
        for (int i=0; i < 1000000; i++) {
            String url = "http://mutant-dev.us-west-2.elasticbeanstalk.com/v1/mutants";
            StringBuilder requestJson = new StringBuilder();
            requestJson
                    .append("{ \"dna\" : [")
                    .append("\"")
                    .append(getRandom6CharString())
                    .append("\", ")
                    .append("\"")
                    .append(getRandom6CharString())
                    .append("\", ")
                    .append("\"")
                    .append(getRandom6CharString())
                    .append("\", ")
                    .append("\"")
                    .append(getRandom6CharString())
                    .append("\", ")
                    .append("\"")
                    .append(getRandom6CharString())
                    .append("\", ")
                    .append("\"")
                    .append(getRandom6CharString())
                    .append("\" ] }");
//            System.out.println(requestJson.toString());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(requestJson.toString(),headers);
            RestTemplate restTemplate = new RestTemplate();
            try {
                String answer = restTemplate.postForObject(url, entity, String.class);
                System.out.println(answer);
            } catch(HttpClientErrorException e) {
                //segue com o teste caso o dna não seja humano
            }
        }
    }

    private static String getRandom6CharString() {
        char[] choices = ("ACGT").toCharArray();
        StringBuilder salt = new StringBuilder();
        for (int i = 0; i<6; ++i)
            salt.append(choices[r.nextInt(choices.length)]);
        return salt.toString();
    }
}
