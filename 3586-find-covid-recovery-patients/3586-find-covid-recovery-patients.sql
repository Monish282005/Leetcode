with temp as(
    select 
        c.patient_id as p_id,
        (select 
            min(c1.test_date)
            from covid_tests c1
            where c1.patient_id = c.patient_id
            and c1.result = 'Positive'
            ) as first_pos,
        (select
            min(c1.test_date)
            from covid_tests c1
            where c1.patient_id = c.patient_id
            and c1.result = 'Negative'
            and c1.test_date > first_pos
        ) as first_neg
        from covid_tests c
        group by c.patient_id
)


select 
    t.p_id as patient_id,
    p.patient_name,
    p.age,
    datediff(t.first_neg, t.first_pos) as recovery_time
    from temp t
    join patients p
    on p.patient_id = t.p_id
    where t.first_pos is not null
    and t.first_neg is not null
    order by recovery_time asc, patient_name asc;

-- select * from temp where first_pos is not null and first_neg is not null;