package webportal.HKSBO.emailcontact.model;

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
    "SubAccountId",
    "Email"
})
public class EmailContactResponse {
  @JsonProperty("clientId")
  private String ClientId;

  @JsonProperty("subAccountId")
  private String SubAccountId;

  @JsonProperty("email")
  private String Email;
}
