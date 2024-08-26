package webportal.HKSBO2.omdc.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webportal.HKSBO2.omdc.model.OMDCResponse;

public interface OMDCOperation {
  @GetMapping(value = "/omdc")
  List<OMDCResponse> getOMDC(
      @RequestParam(value = "startdate", required = false) String startdate,
      @RequestParam(value = "enddate", required = false) String enddate);
}
