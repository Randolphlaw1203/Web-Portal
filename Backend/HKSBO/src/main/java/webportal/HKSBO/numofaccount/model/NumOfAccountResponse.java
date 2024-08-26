package webportal.HKSBO.numofaccount.model;

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
    "Month",
    "NumOfAccounts"
})
public class NumOfAccountResponse {
  @JsonProperty("month")
  private String Month;

  @JsonProperty("numOfAccounts")
  private Integer NumOfAccounts;
}
