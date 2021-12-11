select sum(claimed_charge) as total
from document
where status = 'EXPORTED';

select insured_name, insured_address, claimed_charge
from batch b
         join document d
              on b.id = d.batch_id
where d.status = 'TO_REPRICE'
  and customer_id IN (1, 2);