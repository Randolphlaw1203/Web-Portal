package webportal.HKSBO.clientposition.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webportal.HKSBO.clientposition.model.ClientPositionResponse;

public interface ClientPositionOperation {

  @GetMapping(value = "/clientposition")
  List<ClientPositionResponse> getClientPositionById(
      @RequestParam(value = "tradingid", required = false) List<String> tradingid);
}
