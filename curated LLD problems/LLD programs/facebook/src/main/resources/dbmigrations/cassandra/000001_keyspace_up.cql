CREATE KEYSPACE IF NOT EXISTS facebook
WITH durable_writes = true AND replication = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };