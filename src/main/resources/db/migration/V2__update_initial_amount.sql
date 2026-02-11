ALTER TABLE cash_register
  ALTER COLUMN initial_amount SET DEFAULT 0;

UPDATE cash_register
  SET initial_amount = 0
WHERE initial_amount IS NULL;

ALTER TABLE cash_register
  ALTER COLUMN initial_amount SET NOT NULL;
