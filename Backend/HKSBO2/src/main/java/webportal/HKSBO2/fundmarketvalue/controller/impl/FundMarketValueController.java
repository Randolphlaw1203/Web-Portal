package webportal.HKSBO2.fundmarketvalue.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webportal.HKSBO2.fundmarketvalue.controller.FundMarketValueOperation;
import webportal.HKSBO2.fundmarketvalue.model.FundMarketValueResponse;
import webportal.HKSBO2.fundmarketvalue.repository.FundMarketValueRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/webportal/api/v1")
public class FundMarketValueController implements FundMarketValueOperation {
  @Autowired
  private FundMarketValueRepository fundMarketValueRepository;

  @Override
  public List<FundMarketValueResponse> getFundMarketValueByDate(String startdate, String enddate) {
    List<Object[]> results = fundMarketValueRepository.getFundMarketValueByDate(startdate, enddate);
    List<FundMarketValueResponse> responseList = new ArrayList<>();

    for (Object[] row : results) {
      FundMarketValueResponse response = new FundMarketValueResponse();
      response.setTradeDate((String) row[0]);
      response.setClientId((String) row[1]);
      response.setMarketValue((BigDecimal) row[2]);
      response.setInstrumentId((String) row[3]);
      response.setInstrumentName((String) row[4]);
      response.setInstrumentChineseName((String) row[5]);
      responseList.add(response);
    }
    return responseList;
  }

}
