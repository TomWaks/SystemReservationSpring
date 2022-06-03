# Getting Started

### Run Application in Local Machine

```bash
git clone https://github.com/TomWaks/SystemReservationSpring.git
cd SystemReservationSpring
mvn spring-boot:run
```

### Example cURLs
```bash
curl -X GET http://localhost:8080/reservations

curl -X GET http://localhost:8080/reservations?tenant_name=Barbara

curl -X GET http://localhost:8080/reservations?flat_name=Flat1

curl -X GET http://localhost:8080/reservations?flat_name=Flat1&tenant_name=Barbara


curl -X POST 'http://localhost:8080/reservations/' --header 'Content-Type: application/json' --data-raw '{
    "rentalFrom": "2022-05-01",
    "rentalTo": "2022-05-05",
    "hostId": 1,
    "flatId": 2,
    "tenantId": 2
}'

curl -X PUT 'http://localhost:8080/reservations/1' --header 'Content-Type: application/json' --data-raw '{
    "rentalFrom": "2022-06-01",
    "rentalTo": "2022-06-05",
    "hostId": 4,
    "flatId": 3,
    "tenantId": 6
}'



```
