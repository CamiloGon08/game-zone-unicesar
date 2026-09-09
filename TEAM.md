# TEAM.md - GameZone Unicesar

## Members
|---------------------------------------------------------------------------------------------------------------------------|
|            Name             | Student Code  | Github Username |      Role      |      Module     |     Feature Branch     |
|---------------------------------------------------------------------------------------------------------------------------|
|Camilo Andres Gonzalez Garcia|  1067600279   |   CamiloGon08   | Technical Lead |Sale + UI + Main |  feature/sale-module   |
|---------------------------------------------------------------------------------------------------------------------------|
|Jesus David Dominguez Theran |  1067594914   | jdaviddominguez |   Developer 1  |     Product     | feature/product-module |
|---------------------------------------------------------------------------------------------------------------------------|
|Aramis junior torres González|  1082852805   |     juniorg     |   Developer 2  |      Person     |  feature/person-module |
|---------------------------------------------------------------------------------------------------------------------------|

## Class Distribution

## Technical Lead
- Sale
- SaleRepository
- SaleService
- ConsoleMenu
- Main

## Developer 1
- Product (abstract)
- VideoGame
- Console
- ProductRepository
- ProductService 

## Developer 2 
- Person (abstract)
- Customer
- Seller 
- PersonRepository
- PersonService

## Commited Activities 
1. Initial commit
2. chore: configure Maven project structure for four layers
3. feat: implement Sale class with total calculation
4. feat: implement Salepository for persistence
5. feat: add method to convert sale objects into text format
6.  feat: implement save method in SaleRepository
7. feat: implement SaleService class with validation rules
8. fix: correct package and resolve compilation errors in product module
9. fix: correct package structure and resolve Sale class compilation errors
10. feat: add SaleService with registerSale method and stock validation
11. feat: add register and query methods to SaleService
12. feat: create ConsoleMenu class with service dependencies
13. feat: add main menu loop and print method with 10 options
14. feat: add registerVideoGame and registerConsole methods
15. feat: add all remaining console menu operations


# Developer 1 
1. feat: add Product abstract class with common attributes
2. feat: add VideoGame class with description implementation
3. feat: add Console class with description implementation
4. feat: implement ProductRepository for file-based
5. feat: implement ProductService with product registration and listing
5. docs: add JavaDoc to Product class
6. docs: add JavaDoc to VideoGame class
7. docs: add JavaDoc to Console class
8. docs: add JavaDoc to ProductRepository class
9. docs: add JavaDoc to ProductService class
10. refactor: move stock adjustment logic into Product
11. refactor: delegate stock updates to Product.adjustStock in ProductService

# Developer 2
1. feat: add Person abstract class with common attributes
2. chore: remove unused temp file from model package
3. feat: add Client class extending Person
4. feat: add Seller class extending Person
5. fix: complete Person and Seller classes with attributes and JavaDoc
6. fix: complete Seller class with attributes and JavaDoc
7. fix: complete Client class with attributes and JavaDoc
8. feat: add PersonRepository for saving and loading data
9. fix: complete PersonRepository content that was uploaded empty
10. feat: add PersonService with business rules for clients and sellers
11. fix: complete PersonService content that was uploaded empty