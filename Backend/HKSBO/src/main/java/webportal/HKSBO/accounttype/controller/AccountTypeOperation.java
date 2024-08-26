package webportal.HKSBO.accounttype.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import webportal.HKSBO.accounttype.model.AccountTypeResponse;

public interface AccountTypeOperation {
  @GetMapping(value = "/accounttype")
  List<AccountTypeResponse> countAccountType();
}
