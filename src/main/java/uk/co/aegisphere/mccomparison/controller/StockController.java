package uk.co.aegisphere.mccomparison.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.aegisphere.mccomparison.service.StockService;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

  private final StockService stockService;

  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @GetMapping("/{ticker}")
  public String getStockInfo(@PathVariable String ticker) {
    return stockService.getStockInfo(ticker);
  }
}
