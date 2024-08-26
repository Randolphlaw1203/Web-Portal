package webportal.HKSBO.accounttype.model;

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
    "Margin",
    "Cash",
    "DVP"
})
public class AccountTypeResponse {
  @JsonProperty("margin")
  private Integer Margin;

  @JsonProperty("cash")
  private Integer Cash;

  @JsonProperty("dvp")
  private Integer DVP;
}
