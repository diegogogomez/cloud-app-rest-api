# Backend 

# Rest API bills:
This web service is developed in Spring boot, its job is generate a billing system where when you want to buy a product, you need to make a request to the main endpoint.

Main endpoint: https://cloud-app-rest-api.herokuapp.com/api/v2/bills

INPUT MAIN REST API

METHOD
<POST>
  when a request is received by the web service, this should receive this properties at its body:
  (INT) productId: Product Id from the list of products.
  (INT) quantity: Quantity to buy.
  (INT) preventId: An unique ID random.
  
  example:
  {
    "productId":121,
    "quantity":50,
    "preventId":1
  }
  
OUTPUT MAIN REST API

the output from this request, should to return four properties:
  (INT) billId: This is the unique bill Id generated the web service.
  (BOOLEAN) billStatus: This property define the status. If the request was success should return true, else return false.
  (DOUBLE) billDesc: This property return the total cost obtained from the transaction.
  (STRING) billDispatch: Return the place to dispatch the order.
  
  example
  {
      "billId": 401,
      "billStatus": true,
      "billDesc": 1725000.0,
      "billDispatch": "pradera"
  }

# REST API Products

If you want create, update or delete a product, you can use this endoint and these are the method to interact with him:
endpoint to crate, update or delete product: https://cloud-app-rest-api.herokuapp.com/api/v1/product

Methods:
<GET> -> https://cloud-app-rest-api.herokuapp.com/api/v1/product
  this method can be used to obtain all products created in the database.
 
<GET> -> https://cloud-app-rest-api.herokuapp.com/api/v1/product/<productId>
  this method and the property in the url <productId> is used to obtain a specific product and its properties.
  
<POST> -> https://cloud-app-rest-api.herokuapp.com/api/v1/product/
    This method should to have and json body to create a new product in the data base, its body request must to have these properties:
    (STRING) productName: This is the name of the new product.
    (DOUBLE) productPrice: Each product must have a price, so this property define the price for that new product.
      Example:
      {
        "productName":"product21",
        "productPrice":33300.0
      }
  
  
<PUT> -> https://cloud-app-rest-api.herokuapp.com/api/v1/product/
    This method update a product created in the data base.
    (INT) productId: This must be the Id which you want to update.
    (STRING) productName: This is the new name of this product.
    (DOUBLE) productPrice: This is th enew price of this product.
      Example:
      {
        "productId": 221,
        "productName": "producto12",
        "productPrice": 11100.15
      }  
  
<DELETE> -> https://cloud-app-rest-api.herokuapp.com/api/v1/product/<productId>
  this method and the property in the url <productId> is used to delete a specific product and its properties.


# Frontend
To watch each product and the quantity sold, use this web page:
https://cloud-app-rest.herokuapp.com/
https://github.com/diegogogomez/cloud-app-rest

  
