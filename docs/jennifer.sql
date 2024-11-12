SELECT month(donation.created_at) as month,
       year(donation.created_at) as year,
       sum(donation.amount) as total,
FROM nu.donations donation
GROUP BY year, month
;

SELECT year(donation.created_at) as year,
       sum(donation.amount) as total
FROM nu.donations donations
GROUP BY year
;
SELECT week(donation.created_at) as week,
       sum(donation.amount) as total
FROM nu.donations donations
GROUP BY week
;

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



