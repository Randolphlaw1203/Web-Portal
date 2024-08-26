package webportal.HKSBO2.dailynav.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webportal.HKSBO2.dailynav.controller.DailyNavOperation;
import webportal.HKSBO2.dailynav.model.DailyNavResponse;
import webportal.HKSBO2.dailynav.repository.DailyNavRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/webportal/api/v1")
public class DailyNavController implements DailyNavOperation {
  @Autowired
  private DailyNavRepository dailyNavRepository;

  @Override
  public List<DailyNavResponse> getDailyNav(String startdate, String enddate) {
    List<Object[]> results = dailyNavRepository.getDailyNav(startdate, enddate);
    List<DailyNavResponse> responseList = new ArrayList<>();

    for (Object[] row : results) {
      DailyNavResponse response = new DailyNavResponse();
      response.setTradeDate((String) row[0]);
      response.setAEID((String) row[1]);
      response.setLedgerBal((BigDecimal) row[2]);
      response.setMarketValueHKEX((BigDecimal) row[3]);
      response.setMarketValueMAMK((BigDecimal) row[4]);
      response.setMarketValueSZMK((BigDecimal) row[5]);
      response.setMarketValueUSEX((BigDecimal) row[6]);
      response.setMarketValueFUND((BigDecimal) row[7]);
      response.setMarketValueOther((BigDecimal) row[8]);
      response.setTotalMarketValue((BigDecimal) row[9]);
      response.setNetEquity((BigDecimal) row[10]);
      responseList.add(response);
    }
    return responseList;
  }

}