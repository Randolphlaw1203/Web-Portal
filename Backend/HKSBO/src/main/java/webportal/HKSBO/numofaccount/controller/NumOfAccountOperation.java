package webportal.HKSBO.numofaccount.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import webportal.HKSBO.numofaccount.model.NumOfAccountResponse;

public interface NumOfAccountOperation {
    @GetMapping(value = "/numofaccount")
  List<NumOfAccountResponse> countNumOfAccount();
}
