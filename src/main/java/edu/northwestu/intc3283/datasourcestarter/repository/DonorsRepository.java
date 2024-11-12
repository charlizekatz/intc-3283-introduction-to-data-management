package edu.northwestu.intc3283.datasourcestarter.repository;

import edu.northwestu.intc3283.datasourcestarter.entity.Donor;
import edu.northwestu.intc3283.datasourcestarter.reports.JenniferQueryOneRow;
import edu.northwestu.intc3283.datasourcestarter.reports.TopDonationReportDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DonorsRepository extends CrudRepository<Donor, Long> {

    List<Donor>  findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

    List<Donor> findTop10ByOrderByCreatedAtDesc();

    @Query("""
            
                        SELECT
                              d.first_name AS firstName,
                              d.last_name AS lastName,
                              d.email AS email,
                              YEAR(dn.created_at) AS year,
                              MONTH(dn.created_at) AS month,
                              SUM(dn.amount) AS totalDonationAmount
                          FROM
                              donors d
                          JOIN
                              donations dn ON d.id = dn.donor_id
                          GROUP BY
                              d.id,
                              YEAR(dn.created_at),
                              MONTH(dn.created_At)
                          ORDER BY
                              YEAR(dn.created_at) DESC,
                              MONTH(dn.created_at) DESC,
                              SUM(dn.amount) DESC
                        LIMIT :limit
            """)
    List<TopDonationReportDTO> findTopDonors(Integer limit);


    @Query("""
SELECT d2.first_name,
       d2.last_name,
       year(d.created_at) as year_donated,
       month(d.created_at) as month_donated,
       sum(d.amount) as total
FROM donations d
         INNER JOIN donors d2 on d.donor_id = d2.id
WHERE year(d.created_at) = 2024 and
    month(d.created_at) = 10
GROUP BY year_donated, month_donated, d.donor_id
ORDER BY total DESC
limit 5
;
""")

    List<JenniferQueryOneRow> jenniferQueryOne();
}
