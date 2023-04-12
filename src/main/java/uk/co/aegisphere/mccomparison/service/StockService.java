package uk.co.aegisphere.mccomparison.service;

import org.springframework.stereotype.Service;
import uk.co.aegisphere.mccomparison.utility.StockGetter;

@Service
public class StockService {

  private final StockGetter stockGetter;

  public StockService(StockGetter stockGetter) {
    this.stockGetter = stockGetter;
  }

  public String getStockInfo(String symbol) {
    stockGetter.setSymbol(symbol);
    return stockGetter.getAPI_ENDPOINT() + "\n" + stockGetter.getStockInfo();
  }
}
