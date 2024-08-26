package webportal.HKSBO.monthlystatement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonPropertyOrder({
    "ClientId",
    "ClientName",
    "ClientChineseName",
    "AddressLine7",
    "StatementDate"
})
public class MonthlyStatementResponse {
  @JsonProperty("clientId")
  private String ClientId;

  @JsonProperty("clientName")
  private String ClientName;

  @JsonProperty("clientChineseName")
  private String ClientChineseName;

  @JsonProperty("addressLine7")
  private String AddressLine7;

  @JsonProperty("statementDate")
  private String StatementDate;
}
