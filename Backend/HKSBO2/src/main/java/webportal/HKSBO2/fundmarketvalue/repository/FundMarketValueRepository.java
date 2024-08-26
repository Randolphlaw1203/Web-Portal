package webportal.HKSBO2.fundmarketvalue.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import webportal.HKSBO2.entity.Vsbtradingacc;

@Repository
public interface FundMarketValueRepository extends JpaRepository<Vsbtradingacc, String> {

  @Query(value = "SELECT " +
      "VARCHAR_FORMAT(tradedate,'yyyy-mm-dd'), " +
      "clientid, " +
      "SUM(marketvalue * TOBASECURRENCYEXCHANGERATE), " +
      "instrumentid, " +
      "RTRIM(instrumentname), " +
      "RTRIM(instrumentchinesename) " +
      "FROM vsbtradingacc " +
      "WHERE marketid = 'FUND' AND marketvalue <> 0 " +
      "GROUP BY instrumentid, instrumentname, instrumentchinesename, clientid, tradedate " +
      "HAVING tradedate BETWEEN :startdate AND :enddate " +
      "ORDER BY tradedate, clientid", nativeQuery = true)
  List<Object[]> getFundMarketValueByDate(@Param("startdate") String startdate, @Param("enddate") String enddate);
}