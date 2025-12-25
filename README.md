# Rango

Rango is a food delivery platform that connects users with their favorite restaurants.

## Architecture

The project follows the Hexagonal Architecture (also known as Ports and Adapters). This architecture promotes a clear separation of concerns by dividing the application into three main layers:

*   **Core:** The core of the application, containing the business logic and use cases.
*   **Adapters:** The adapters are responsible for connecting the core to the outside world.
*   **Ports:** The ports are the interfaces that define how the core communicates with the adapters.

## Modules

The project is divided into the following modules:

*   **Costumer:** Manages customer data.
*   **Item:** Manages the items within an order.
*   **Order:** Manages user orders.
*   **Payment:** Handles the payment process.
*   **Product:** Manages the products offered by restaurants.
*   **Restaurant:** Manages restaurant data.
*   **User:** Manages user authentication and data.
*   **Infrastructure:** Provides core functionalities and configurations for the other modules.


Each module is divided into the following directories:

*   **`core`:** Contains the business logic and use cases.
    *   **`domain`:** Contains the business rules and entities.
    *   **`ports/in`:** Contains the input ports, which define how the application is driven by the outside world.
    *   **`ports/out`:** Contains the output ports, which define how the application communicates with the outside world.
    *   **`usecases`:** Contains the implementation of the input ports. Responsible for direct communication with the domain class.
*   **`adapters`:** Contains the implementation of the output ports.
    *   **`Mapper`:** Contains the mapping methods between DTO, domain and entity.
    *   **`API`:** Contains the endpoints that will be used in requests.
    *   **`Controller`:** Link between the requests and the orchestration of the use of the Usecases, performing the mapping.
    *   **`DTO`:** Contains the Response and Request transfer classes.
    *   **`Entity`:** Object that will be saved in the database.
    *   **`Repository`:** Communication with the database.
    *   **`Service`:** Responsible for the interaction with the database, performing the mapping.

The Infrastructure is divided into:

*   **`beans`:** Contains the use cases beans,required for Spring to function.
*   **`exceptions`:** Contains the exceptions and handlers.
*   **`secutiry`:** Contains web security configurations.


## Technologies

*   **Java 21:** The core programming language.
*   **Spring Boot:** The application framework.
*   **Maven:** The dependency management tool.
*   **MySQL:** The database.
*   **Docker:** The containerization platform.

## How to Run

To run the application, you will need to have Docker and Docker Compose installed.

1.  Clone the repository:

```bash
git clone https://github.com/enacreditavel/rango.git
```

2.  Navigate to the project's root directory:

```bash
cd rango
```

3.  Run the following command to start the application:

```bash
docker-compose up
```

The application will be available at `http://localhost:8080`.
