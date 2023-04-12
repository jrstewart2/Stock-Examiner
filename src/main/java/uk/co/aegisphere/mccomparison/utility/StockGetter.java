package uk.co.aegisphere.mccomparison.utility;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.nimbusds.oauth2.sdk.http.HTTPRequest.Method;
import org.springframework.stereotype.Service;

@Service
public class StockGetter {

  private String baseURL = "https://www.alphavantage.co/query?function=OVERVIEW&symbol=";
  private String symbol;
  private String apiKey;
  private String API_ENDPOINT;
  //private final ReqResLogger logger = new ReqResLogger();
  private final Properties properties;

  public StockGetter(Properties properties) {this.properties = properties;}

  public StockGetter(String symbol, Properties properties) {
    this.symbol = symbol;
    this.properties = properties;
    this.apiKey = "&apikey=" + properties.getApiKey();
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getStockInfo() {
    API_ENDPOINT = baseURL + symbol + apiKey;
    System.out.println(API_ENDPOINT);
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(API_ENDPOINT))
        .method(Method.GET.toString(), HttpRequest.BodyPublishers.noBody())
        .build();

    HttpResponse<String> response = null;

    try {
      response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String responseBody = response.body();

    return responseBody;
  }

  public String getAPI_ENDPOINT() {
    return API_ENDPOINT;
  }


}
