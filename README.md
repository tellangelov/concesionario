## Diseño funcional

### Descripción

El concesionario virtual es una herramienta para gestionar la información y operaciones de un negocio de compra y alquiler de vehículos.

### Requisitos funcionales

| RF1 | El sistema debe permitir registrar nuevos clientes con su nombre y DNI. |
| --- | --- |
| RF2 | El sistema debe permitir listar, editar o eliminar la información de cada cliente |
| RF3 | El sistema debe permitir registrar un vehículo en el inventario por su modelo, estado, fecha de compra y precio de compra |
| RF4 | El sistema debe permitir listar, editar o eliminar la información de cada vehículo |
| RF5 | El sistema debe permitir registrar el inicio de un alquiler de un vehículo ingresando el cliente, la fecha de inicio y tarifa diaria |
| RF6 | El sistema debe permitir registrar la finalización de un alquiler ingresando la fecha de finalización |
| RF7 | El sistema debe calcular el monto a cancelar de un alquiler en función de los días transcurridos entre la fecha de inicio y la de finalización |
| RF8 | El sistema debe permitir listar, editar o eliminar la información de los alquileres |
| RF9 | Al listar los alquileres, el sistema debe mostrar el estado de un alquiler dependiendo de la presencia o ausencia de una fecha de finalización |

### Requisitos no funcionales

| RNF1 | Se debe usar MySQL como base de datos |
| --- | --- |
| RNF2 | Se debe exponer endpoints mediante una API REST |
| RNF3 | Usar lenguaje de programación JAVA y framework SPRING |
| RNF4 | Despliegue en nube |

### Diagrama de casos de uso

```mermaid
flowchart LR
    admin[Administrador]

    subgraph sistema["Concesionario Virtual"]
        gc([Gestionar clientes])
        gv([Gestionar vehículos])
        ga([Gestionar alquileres])
        ia([Iniciar alquiler])
        fa([Finalizar alquiler])
    end

    admin --> gc
    admin --> gv
    admin --> ga

    ga -. "<<include>>" .-> ia
    ga -. "<<include>>" .-> fa
```

## Diseño de componentes

### Diagrama de clases

```mermaid
classDiagram
direction LR

class Cliente {
    +int id
    +string nombre
    +string dni
    +registrarCliente()
    +actualizarCliente()
    +eliminarCliente()
    +listarClientes()
}

class Vehiculo {
    +int id
    +string marca
    +string modelo
    +string condicion
    +Date fechaCompra
    +decimal precioCompra
    +registrarVehiculo()
    +actualizarVehiculo()
    +eliminarVehiculo()
    +listarVehiculos()
}

class Alquiler {
    +int id
    +int clienteId
    +int vehiculoId
    +Date fechaInicio
    +Date fechaFin
    +decimal precioDia
    +alquilar()
    +finalizarAlquiler()
    +actualizarAlquiler()
    +eliminarAlquiler()
    +listarAlquileres()
    +decimal calcularTotal()
}

Cliente "1" --> "0..*" Alquiler
Vehiculo "1" --> "0..*" Alquiler
```

### Diagrama de arquitectura

Arquitectura en capas - Spring Framework

```mermaid
flowchart TB
    cliente[Cliente]

    proxy[Reverse Proxy Server]

    subgraph backend["Backend"]
        direction TB
        controller[Controller]
        service[Service]
        repository[Repository]

        controller --> service
        service --> repository
    end

    mysql[(MySQL Server)]

    cliente --> proxy
    proxy --> backend
    backend --> mysql

    mysql --> backend
    backend --> proxy
    proxy --> cliente
```

```mermaid
flowchart TB
    clienteHTTP[Cliente HTTP / Frontend]

    subgraph api["API REST (Spring Boot)"]
        direction TB

        subgraph capaControllers["Capa de Controladores"]
            cc["<<component>><br>ClienteController"]
            cv["<<component>><br>VehiculoController"]
            ca["<<component>><br>AlquilerController"]
        end

        subgraph capaServicios["Capa de Servicios"]
            sc["<<component>><br>ClienteService"]
            sv["<<component>><br>VehiculoService"]
            sa["<<component>><br>AlquilerService"]
        end

        subgraph capaRepos["Capa de Repositorios"]
            rc["<<component>><br>ClienteRepository"]
            rv["<<component>><br>VehiculoRepository"]
            ra["<<component>><br>AlquilerRepository"]
        end
    end

    mysql[("MySQL Server")]

    %% Cliente externo
    clienteHTTP --> cc
    clienteHTTP --> cv
    clienteHTTP --> ca

    %% Controllers -> Services
    cc --> sc
    cv --> sv
    ca --> sa

    %% Dependencias cruzadas entre servicios
    sa -.->|valida cliente| sc
    sa -.->|valida vehiculo| sv

    %% Services -> Repositories
    sc --> rc
    sv --> rv
    sa --> ra

    %% Repositories -> BD
    rc --> mysql
    rv --> mysql
    ra --> mysql
```

###