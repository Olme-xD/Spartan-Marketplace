# Spartan Marketplace API Documentation

## User API Endpoints
### Create Customer
```
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
```
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
```
GET /api/users
```
### Get Customers
```
GET /api/users/{id}
```
### Delete Customer
```
DELETE /api/users/{id}
```

## Listings API Endpoints
### Create Listing
```
POST /api/listings
Content-Type: application/json
{
  "user": { "id": 1 },
  "category": "example",
  "isActive": true
}
```
### Update Listing
```
PUT /api/listings/{id}
Content-Type: application/json
{
  "category": "example",
  "isActive": false
}
```
### Delete Listing
```
DELETE /api/listings/{id}
```
### Get Listing by ID
```
GET /api/listings/{id}
```
### Get Listings from a User
```
GET /api/listings/user/{userId}
```
### Get Active Listings from a User
```
GET /api/listings/user/{userId}/active
```
### Get All Active Listings
```
GET /api/listings/active
```
### Get All Active Listings by Category
```
GET GET /api/listings/category/{category}
```

## Products API Endpoints
### Create Product
```
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
```
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
```
DELETE /api/products/{id}
```
### Get Products of a User
```
GET /api/products/user/{userId}
```
### Get Products of a Listing
```
GET /api/products/listing/{listingId}
```
### Get All Active Products
```
GET /api/products/active
```
### Get Products with a Query
```
GET /api/products/search?q=example
```

## Transactions API Endpoints
### Create Transaction
```
POST /api/transactions
Content-Type: application/json
{
  "user": {"id": 1},
  "product": {"id": 1}
}
```
### Get Transaction by ID
```
GET /api/transactions/{id}
```
### Get Transaction by User ID
```
GET /api/transactions/user/{userId}
```
### Get Transaction by Provider ID
```
GET /api/transactions/provider/{providerId}
```
### Get Transaction by Product ID
```
GET /api/transactions/product/{productId}
```
### Delete Transaction by ID
```
DELETE /api/transactions/{id}
```

## Review API Endpoints
### Create a Review
```
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
```
PUT /api/reviews/{id}/respond
Content-Type: application/json
{
  "sellerText": "example"
}
```
### Update a Review
```
PUT /api/reviews/{id}
Content-Type: application/json
{
  "rating": 5,
  "buyerText": "example"
}
```
### Delete a Review
```
DELETE /api/reviews/{id}
```
### Get All Reviews of a Product
```
GET /api/reviews/product/{productId}
```
### Get All Reviews of a User
```
GET /api/reviews/user/{userId}
```
### Get All Reviews of a Provider
```
GET /api/reviews/provider/{providerId}
```
### Get Average Rating of a Product
```
GET /api/reviews/product/{productId}/rating
```

## Messages API Endpoints
### Create Message
```
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
```
GET /api/messages/{id}
```
### Get Messages by Product ID
```
GET /api/messages/product/{productId}
```
### Get Messages by Buyer ID
```
GET /api/messages/buyer/{buyerId}
```
### Get Messages by Seller ID
```
GET /api/messages/seller/{sellerId}
```
### Get Messages by User ID
```
GET /api/messages/user/{userId}
```
### Delete Messages by ID
```
DELETE /api/messages/{id}
```