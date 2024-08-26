package webportal.HKSBO2.fundmarketvalue.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webportal.HKSBO2.fundmarketvalue.model.FundMarketValueResponse;

public interface FundMarketValueOperation {
  @GetMapping(value = "/fundmarketvalue")
  List<FundMarketValueResponse> getFundMarketValueByDate(
      @RequestParam(value = "startdate", required = false) String startdate,
      @RequestParam(value = "enddate", required = false) String enddate);
}
