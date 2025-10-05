CREATE DATABASE hikerzuser;
CREATE DATABASE hikerzactivity;

\c hikerzactivity
CREATE EXTENSION IF NOT EXISTS postgis;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

\c hikerzuser
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";