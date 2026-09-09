classDiagram
    class Person {
    ...
    }
    class Client {
    <<concrete>>
    }
    class Seller {
    <<concrete>>
    }
    class Product {
    <<abstract>>
    }
    class VideoGame {
    <<concrete>>
    }
    class Console {
    <<concrete>>
    }
    class Sale {
    <<concrete>>
    }
Person <|-- Client
Person <|-- Seller
Product <|-- VideoGame
Product <|-- Console
Person <|-- Seller : s1
Product <|-- Console : s2