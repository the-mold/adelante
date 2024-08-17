# Grafana

Purpose: monitoring
Chain: Django->Redis->DjangoQ->rabbitmq->telegraf->influxDB->Chronograf->grafana

1. Django saves items in redis
2. Every n seconds items are retrieved from redis, grouped and staged in DjangoQ for sending to messenger. Redis is cleaned up after it.
3. Telegraf is configured to consume events from rabittmq constantly and save it in influx DB.
4. Use Chronograf to prototype InfluxDB queries.
5. Use the constructed queries in grafana.
