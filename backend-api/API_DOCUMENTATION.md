# Spartan Marketplace API Documentation

## User API Endpoints
### Create Customer
```http
POST /api/users
Content-Type: application/json
{
    "username": "example",
    "email": "example@example.com",
    "password": "123456789",
    "phone_number": "000-000-0000"
}
```
### Update Customer
```http
PUT /api/users/{id}
Content-Type: application/json
{
    "username": "example",
    "email": "example@example.com",
    "password": "123456789",
    "phone_number": "000-000-0000"
}
```
### Get All Customer
```http
GET /api/users
```
### Get Customers
```http
GET /api/users/{id}
```
### Delete Customer
```http
DELETE /api/users/{id}
```

## Listings API Endpoints
### Create Listing
```http
POST /api/listings
Content-Type: application/json
{
  "user": { "id": 1 },
  "category": "example",
  "isActive": true
}
```
### Update Listing
```http
PUT /api/listings/{id}
Content-Type: application/json
{
  "category": "example",
  "isActive": false
}
```
### Delete Listing
```http
DELETE /api/listings/{id}
```
### Get Listing by ID
```http
GET /api/listings/{id}
```
### Get Listings from a User
```http
GET /api/listings/user/{userId}
```
### Get Active Listings from a User
```http
GET /api/listings/user/{userId}/active
```
### Get All Active Listings
```http
GET /api/listings/active
```
### Get All Active Listings by Category
```http
GET /api/listings/category/{category}
```

## Products API Endpoints
### Create Product
```http
POST /api/products
Content-Type: application/json
{
  "listing": {"id": 1},
  "user": {"id": 1},
  "title": "example",
  "description": "example",
  "price": 1.00
}
```
### Update Product
```http
PUT /api/products/{id}
Content-Type: application/json
{
  "listing": {"id": 1},
  "user": {"id": 1},
  "title": "example",
  "description": "example",
  "price": 1.00
}
```
### Delete Product
```http
DELETE /api/products/{id}
```
### Get Products of a User
```http
GET /api/products/user/{userId}
```
### Get Products of a Listing
```http
GET /api/products/listing/{listingId}
```
### Get All Active Products
```http
GET /api/products/active
```
### Get Products with a Query
```http
GET /api/products/search?q=example
```

## Transactions API Endpoints
### Create Transaction
```http
POST /api/transactions
Content-Type: application/json
{
  "user": {"id": 1},
  "product": {"id": 1}
}
```
### Get Transaction by ID
```http
GET /api/transactions/{id}
```
### Get Transaction by User ID
```http
GET /api/transactions/user/{userId}
```
### Get Transaction by Provider ID
```http
GET /api/transactions/provider/{providerId}
```
### Get Transaction by Product ID
```http
GET /api/transactions/product/{productId}
```
### Delete Transaction by ID
```http
DELETE /api/transactions/{id}
```

## Review API Endpoints
### Create a Review
```http
POST /api/reviews
Content-Type: application/json
{
  "user": {"id": 1},
  "product": {"id": 1},
  "rating": 5,
  "buyerText": "example"
}
```
### Respond to a Review
```http
PUT /api/reviews/{id}/respond
Content-Type: application/json
{
  "sellerText": "example"
}
```
### Update a Review
```http
PUT /api/reviews/{id}
Content-Type: application/json
{
  "rating": 5,
  "buyerText": "example"
}
```
### Delete a Review
```http
DELETE /api/reviews/{id}
```
### Get All Reviews of a Product
```http
GET /api/reviews/product/{productId}
```
### Get All Reviews of a User
```http
GET /api/reviews/user/{userId}
```
### Get All Reviews of a Provider
```http
GET /api/reviews/provider/{providerId}
```
### Get Average Rating of a Product
```http
GET /api/reviews/product/{productId}/rating
```

## Messages API Endpoints
### Create Message
```http
POST /api/messages
Content-Type: application/json
{
  "product": {"id": 1},
  "buyerId": 1,
  "sellerId": 1,
  "buyerText": "example"
}
```
### Get Messages by ID
```http
GET /api/messages/{id}
```
### Get Messages by Product ID
```http
GET /api/messages/product/{productId}
```
### Get Messages by Buyer ID
```http
GET /api/messages/buyer/{buyerId}
```
### Get Messages by Seller ID
```http
GET /api/messages/seller/{sellerId}
```
### Get Messages by User ID
```http
GET /api/messages/user/{userId}
```
### Delete Messages by ID
```http
DELETE /api/messages/{id}
```