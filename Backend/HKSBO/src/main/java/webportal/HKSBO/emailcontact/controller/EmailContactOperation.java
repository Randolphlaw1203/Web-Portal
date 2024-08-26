package webportal.HKSBO.emailcontact.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webportal.HKSBO.emailcontact.model.EmailContactResponse;

public interface EmailContactOperation {

  @GetMapping(value = "/emailcontact")
  List<EmailContactResponse> getEmailContactById(
      @RequestParam(value = "tradingid", required = false) List<String> tradingid);
}
