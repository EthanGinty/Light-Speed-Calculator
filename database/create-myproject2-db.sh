#!/bin/bash
BASEDIR=$(dirname $0)
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres myproject2 &&
psql -U postgres -d myproject2 -f "$BASEDIR/schema.sql" &&
psql -U postgres -d myproject2 -f "$BASEDIR/user.sql" &&
psql -U postgres -d myproject2 -f "$BASEDIR/data.sql"