package webportal.HKSBO.marketvalue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import webportal.HKSBO.entity.Vsbtradingacc;

@Repository
public interface MarketValueRepository extends JpaRepository<Vsbtradingacc, String> {
  @Query(value = "SELECT" +
      " MARKETID," +
      " CAST(SUM(MARKETVALUE*TOBASECURRENCYEXCHANGERATE)AS DECIMAL(18, 2))" +
      " FROM VSBTRADINGACC" +
      " GROUP BY MARKETID", nativeQuery = true)
  List<Object[]> getMarketValue();
}
