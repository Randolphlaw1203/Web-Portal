package webportal.HKSBO.marketvalue.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import webportal.HKSBO.marketvalue.model.MarketValueResponse;

public interface MarketValueOperation {
  @GetMapping(value = "/marketvalue")
  List<MarketValueResponse> countMarketValue();
}
