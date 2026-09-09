classDiagram
    %% ===== MODEL LAYER =====
    class Person {
        <<abstract>>
        -name: String
        -identification: String
        -phone: String
        +getName() String
        +setName(name String) void
        +getIdentification() String
        +setIdentification(id String) void
        +getPhone() String
        +setPhone(phone String) void
    }
    class Client {
        -email: String
        +getEmail() String
        +setEmail(email String) void
    }
    class Seller {
        -employeeCode: String
        -shift: String
        +getEmployeeCode() String
        +setEmployeeCode(code String) void
        +getShift() String
        +setShift(shift String) void
    }
    class Product {
        <<abstract>>
        -id: String
        -title: String
        -price: double
        -stock: int
        +getId() String
        +setId(id String) void
        +getTitle() String
        +setTitle(title String) void
        +getPrice() double
        +setPrice(price double) void
        +getStock() int
        +setStock(stock int) void
        +adjustStock(amount int) void
        +getDescription() String*
    }
    class VideoGame {
        -platform: String
        -genre: String
        -ageRating: String
        +getDescription() String
        +getPlatform() String
        +setPlatform(platform String) void
        +getGenre() String
        +setGenre(genre String) void
        +getAgeRating() String
        +setAgeRating(rating String) void
    }
    class Console {
        -brand: String
        -model: String
        -generation: String
        +getDescription() String
        +getBrand() String
        +setBrand(brand String) void
        +getModel() String
        +setModel(model String) void
        +getGeneration() String
        +setGeneration(gen String) void
    }
    class Sale {
        -id: String
        -date: LocalDate
        -seller: Seller
        -customer: Client
        -products: List~Product~
        -total: double
        +getId() String
        +setId(id String) void
        +getDate() LocalDate
        +setDate(date LocalDate) void
        +getSeller() Seller
        +setSeller(seller Seller) void
        +getCustomer() Client
        +setCustomer(customer Client) void
        +getProducts() List~Product~
        +setProducts(products List~Product~) void
        +getTotal() double
        +toString() String
        -calculateTotal() double
    }

    Person <|-- Client
    Person <|-- Seller
    Product <|-- VideoGame
    Product <|-- Console
    Sale "1" --> "1" Client
    Sale "1" --> "1" Seller
    Sale "1" o-- "1..*" Product

    %% ===== PERSISTENCE LAYER =====
    class ProductRepository {
        -filePath: String
        +ProductRepository(filePath String)
        +saveAll(products List~Product~) void
        +loadAll() List~Product~
        -toLine(product Product) String
        -fromLine(line String) Product
    }
    class PersonRepository {
        -CLIENTS_FILE: String
        -SELLERS_FILE: String
        +saveClients(clients List~Client~) void
        +loadClients() List~Client~
        +saveSellers(sellers List~Seller~) void
        +loadSellers() List~Seller~
    }
    class SaleRepository {
        -FILE_PATH: String
        +save(sales List~Sale~) void
        +load() List~Sale~
        -toLine(sale Sale) String
    }

    ProductRepository ..> Product
    PersonRepository ..> Client
    PersonRepository ..> Seller
    SaleRepository ..> Sale
    SaleRepository ..> ProductService
    SaleRepository ..> PersonService

    %% ===== SERVICE LAYER =====
    class ProductService {
        -productRepository: ProductRepository
        -products: List~Product~
        +ProductService(repository ProductRepository)
        +registerVideoGame(id String, title String, price double, stock int, platform String, genre String, ageRating String) void
        +registerConsole(id String, title String, price double, stock int, brand String, model String, generation String) void
        +listProducts() List~Product~
        +findById(id String) Optional~Product~
        +hasSufficientStock(id String, quantity int) boolean
        +updateStock(id String, amount int) void
        -addProduct(product Product) void
    }
    class PersonService {
        -clients: List~Client~
        -sellers: List~Seller~
        -repository: PersonRepository
        +PersonService()
        +registerClient(client Client) void
        +listClients() List~Client~
        +listSellers() List~Seller~
    }
    class SaleService {
        -repository: SaleRepository
        -sales: List~Sale~
        +SaleService(repository SaleRepository)
        +registerSale(customer Client, seller Seller, products List~Product~) Sale
        +viewAllSales() List~Sale~
        +viewSalesByCustomer(customer Client) List~Sale~
        +viewSalesBySeller(seller Seller) List~Sale~
    }

    ProductService "1" --> "1" ProductRepository
    ProductService ..> Product
    PersonService "1" --> "1" PersonRepository
    SaleService "1" --> "1" SaleRepository
    SaleService "1" --> "1" ProductService
    SaleService ..> Sale

    %% ===== UI LAYER =====
    class ConsoleMenu {
        -scanner: Scanner
        -productService: ProductService
        -personService: PersonService
        -saleService: SaleService
        +ConsoleMenu(productService ProductService, personService PersonService, saleService SaleService)
        +start() void
        -printMainMenu() void
        -registerVideoGame() void
        -registerConsole() void
        -listProducts() void
        -registerClient() void
        -listClients() void
        -listSellers() void
        -registerSale() void
        -viewAllSales() void
        -viewSalesByCustomer() void
        -viewSalesBySeller() void
        -readInt() int
    }

    ConsoleMenu "1" --> "1" ProductService
    ConsoleMenu "1" --> "1" PersonService
    ConsoleMenu "1" --> "1" SaleService

    %% ===== ENTRY POINT =====
    class Main {
        +main(args String[]) void$
    }

    Main ..> ConsoleMenu
    Main ..> ProductRepository
    Main ..> PersonRepository
    Main ..> SaleRepository
    Main ..> ProductService
    Main ..> PersonService
    Main ..> SaleService