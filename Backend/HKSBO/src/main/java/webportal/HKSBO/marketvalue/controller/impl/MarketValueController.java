package webportal.HKSBO.marketvalue.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webportal.HKSBO.marketvalue.controller.MarketValueOperation;
import webportal.HKSBO.marketvalue.model.MarketValueResponse;
import webportal.HKSBO.marketvalue.repository.MarketValueRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/webportal/api/v1")
public class MarketValueController implements MarketValueOperation{
  @Autowired
  private MarketValueRepository marketValueRepository;

  @Override
  public List<MarketValueResponse> countMarketValue() {
    List<Object[]> results = marketValueRepository.getMarketValue();
    List<MarketValueResponse> responseList = new ArrayList<>();

    for (Object[] row : results) {
      MarketValueResponse response = new MarketValueResponse();
      response.setMarketId((String) row[0]);
      response.setMarketValue_HKD((BigDecimal) row[1]);
      responseList.add(response);
    }
    return responseList;
  }
}
