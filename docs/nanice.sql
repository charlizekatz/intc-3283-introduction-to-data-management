SELECT
    dn.donor_id AS donor_id,
    d.first_name,
    d.last_name,
    d.address1,
    d.address2,
    d.city,
    d.state,
    d.zip_code,
    SUM(dn.amount) as total_donated
FROM
    donors d
        LEFT JOIN donations dn ON dn.donor_id = d.id
WHERE
    dn.amount > 5
GROUP by
    dn.donor_id

