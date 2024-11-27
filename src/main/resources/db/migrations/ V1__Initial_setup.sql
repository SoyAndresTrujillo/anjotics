CREATE TABLE users (
    "id_user" SERIAL PRIMARY KEY,
    "id_number" INTEGER NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "image_profile_url" VARCHAR(512),
    "area" VARCHAR(255),
    "profile_url" VARCHAR(512),
    "office" VARCHAR(255),
    "tags" TEXT[],
    "position_name" VARCHAR(255),
    "id_parent" INTEGER
);