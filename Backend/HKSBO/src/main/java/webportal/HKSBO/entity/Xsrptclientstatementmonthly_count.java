package webportal.HKSBO.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "xsrptclientstatementmonthly_count")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Xsrptclientstatementmonthly_count {
  @Id
  @Column(name = "clientid")
  private String ClientId;

  @Column(name = "clientname")
  private String ClientName;

  @Column(name = "clientchinesename")
  private String ClientChineseName;

  @Column(name = "addressline7")
  private String AddressLine7;

  @Column(name = "statementdate")
  private String StatementDate;

  @Column(name = "sendmethodtype")
  private String SendMethodType;

}
