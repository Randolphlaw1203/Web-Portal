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
@Table(name = "psbclienttrade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Psbclienttrade {
  @Id
  @Column(name = "tradeid")
  private String TradeId;

  @Column(name = "instrumentid")
  private String InstrumentId;

  @Column(name = "tradedate")
  private String TranDate;

  @Column(name = "bs")
  private String BS;
}
