-- Change the type of the id_user column to UUID
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

ALTER TABLE users
  ALTER COLUMN id_user DROP DEFAULT,
  ALTER COLUMN id_user TYPE UUID USING uuid_generate_v4(),
  ALTER COLUMN id_user SET DEFAULT uuid_generate_v4();