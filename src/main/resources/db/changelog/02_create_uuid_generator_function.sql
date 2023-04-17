CREATE OR REPLACE FUNCTION generate_uuid() RETURNS uuid
	AS $$ SELECT md5(random()::text || clock_timestamp()::text)::uuid; $$
LANGUAGE SQL;