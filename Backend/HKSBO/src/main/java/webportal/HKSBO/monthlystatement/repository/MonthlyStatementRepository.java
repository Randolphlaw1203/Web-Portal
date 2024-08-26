package webportal.HKSBO.monthlystatement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import webportal.HKSBO.entity.Xsrptclientstatementmonthly_count;

@Repository
public interface MonthlyStatementRepository extends JpaRepository<Xsrptclientstatementmonthly_count, String> {
  @Query(value = "SELECT " +
      " RTRIM(CLIENTID), CLIENTNAME, CLIENTCHINESENAME, RTRIM(ADDRESSLINE7), VARCHAR_FORMAT(STATEMENTDATE, 'DD/MM/YYYY') " +
      " FROM XSRPTCLIENTSTATEMENTMONTHLY_COUNT " +
      " WHERE SENDMETHODTYPE = 'E'", nativeQuery = true)
  List<Object[]> getMonthlyStatement();
}
