package webportal.HKSBO2.entity;

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
@Table(name = "scoperator")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Scoperator {
  @Id
  @Column(name = "operatorid")
  private String OperatorId;

  @Column(name = "operatorname")
  private String OperatorName;

  @Column(name = "marketid")
  private String MarketId;

  @Column(name = "tradedate")
  private String TradeDate;

  @Column(name = "creationtime")
  private String CreationTime;

  @Column(name = "operatorstatus")
  private String OperatorStatus;

  @Column(name = "lastmodifiedtime")
  private String LastModifiedTime;

}
