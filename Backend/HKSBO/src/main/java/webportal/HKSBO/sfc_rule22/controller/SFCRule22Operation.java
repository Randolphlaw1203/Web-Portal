package webportal.HKSBO.sfc_rule22.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webportal.HKSBO.sfc_rule22.model.SFCRule22Response;

public interface SFCRule22Operation {
  @GetMapping(value = "/sfcrule22")
  List<SFCRule22Response> getSCFRule22ByInstrumentId(
      @RequestParam(value = "instrumentid", required = false) List<String> instrumentid);
}
