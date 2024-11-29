-- Add unique constraint to id_number column
ALTER TABLE users
  ADD CONSTRAINT unique_id_number UNIQUE (id_number);
