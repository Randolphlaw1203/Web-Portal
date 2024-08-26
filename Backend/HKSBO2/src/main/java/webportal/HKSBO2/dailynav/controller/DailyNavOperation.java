package webportal.HKSBO2.dailynav.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webportal.HKSBO2.dailynav.model.DailyNavResponse;

public interface DailyNavOperation {
  @GetMapping(value = "/dailynav")
  List<DailyNavResponse> getDailyNav(
      @RequestParam(value = "startdate", required = false) String startdate,
      @RequestParam(value = "enddate", required = false) String enddate);
}
