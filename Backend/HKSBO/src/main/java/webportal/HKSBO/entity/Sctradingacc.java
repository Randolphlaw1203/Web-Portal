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
@Table(name = "sctradingacc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Sctradingacc {
  @Id
  @Column(name = "clientid")
  private String ClientId;

  @Column(name = "tradingaccseq")
  private Integer TradingaccSeq;

  @Column(name = "subaccountid")
  private String SubaccountId;

  @Column(name = "subaccountname")
  private String SubaccountName;

  @Column(name = "investoryypeid")
  private String InvestorTypeId;

  @Column(name = "acopendate")
  private String AcOpenDate;

}