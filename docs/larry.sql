SELECT donor.id AS donor_id,
       donor.first_name,
       donor.last_name,
       donor.address1,
       donor.address2,
       donor.city,
       donor.zip_code,
       donor.phone,
       donor.email
FROM nu.donors donor
WHERE donor.address1 = ''
    and donor.email is not null or donor.phone is not null
;



SELECT donor.id AS donor_id,
       donor.first_name,
       donor.last_name,
       count(donation.donor_id) as num_donations,
       SUM(donation.amount) as total_donation
FROM donors donor
         INNER JOIN nu.donations donation ON donor.id = donation.donor_id
WHERE YEAR(donation.created_at) = YEAR(CURRENT_DATE)
GROUP BY donor.id
;



