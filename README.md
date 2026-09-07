# order-service

Test fixture for BITO-14304 indexing-mode verification.

Exposes `/api/orders` and calls the user service in
[`utkarshbito/testing-bito`](https://github.com/utkarshbito/testing-bito)
at `/api/users`, so it produces real cross-repository edges in both
directions rather than an empty index.
