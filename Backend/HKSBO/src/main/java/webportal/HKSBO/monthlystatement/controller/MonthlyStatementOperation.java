package webportal.HKSBO.monthlystatement.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import webportal.HKSBO.monthlystatement.model.MonthlyStatementResponse;

public interface MonthlyStatementOperation {
    @GetMapping(value = "/monthlystatement")
  List<MonthlyStatementResponse> listMonthlyStatement();
}
