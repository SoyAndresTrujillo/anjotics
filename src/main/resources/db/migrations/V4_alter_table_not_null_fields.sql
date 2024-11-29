-- V4_alter_table_not_null_fields
ALTER TABLE users
  ALTER COLUMN area SET NOT NULL,
  ALTER COLUMN office SET NOT NULL,
  ALTER COLUMN profile_url SET NOT NULL,
  ALTER COLUMN position_name SET NOT NULL,
  ALTER COLUMN image_profile_url SET NOT NULL;
