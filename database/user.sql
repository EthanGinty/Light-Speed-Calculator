-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER myproject_owner WITH PASSWORD 'myproject_owner1';

GRANT ALL 
ON ALL TABLES IN SCHEMA public
TO myproject_owner;

GRANT ALL 
ON ALL SEQUENCES IN SCHEMA public
TO myproject_owner; 

CREATE USER myproject_appuser WITH PASSWORD 'myproject_appuser1';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO myproject_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO myproject_appuser; 