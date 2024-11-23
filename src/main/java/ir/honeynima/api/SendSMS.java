package ir.honeynima.api;


import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Random;
import static ir.honeynima.privacy.SendSMSKeys.*;

public class SendSMS {

    public static String[] sendSms(String number) throws Exception {
        if (!isValidNumber(number)){
            throw new IllegalArgumentException("please enter valid number");
        }
        String randomCode = getRandomCode();
        String message = "Code: " + randomCode + "\u2028کد ورود به وبسایت عسل نیما honeynima.ir";
        HttpClient client = HttpClient.newHttpClient();
        String jsonPayload = """
                {
                    "lineNumber": "%s",
                    "MessageText": "%s",
                    "Mobiles": ["%s"]
                }
                """.formatted(LINE_NUMBER, message, number);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ENDPOINT))
                .header("X-API-KEY", API_KEY)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return new String[]{randomCode,String.valueOf(response.statusCode()),response.body()};
    }

    private static boolean isValidNumber(String number) {
        return number.startsWith("98") && number.length() == 12;
    }

    private static String getRandomCode() {
        return String.valueOf(new Random().nextInt(1_000_000));
    }
}
