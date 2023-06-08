# AMRIT - Inventory API
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)  ![branch parameter](https://github.com/PSMRI/Inventory-API/actions/workflows/sast-and-package.yml/badge.svg)

Inventory service acts as a medicine inventory management and dispensing unit that helps in distributing the medicine to the pateint as per the prescription. Exposes below set of features as REST APIs.

* Item tracking
* Purchase order management
* Inventory reports
* Create, read, update, and delete inventory items.
* Get inventory levels.

## Building From Source
This microservice is built on Java, Spring boot framework and MySQL DB.

### Prerequisites
* JDK 1.8
* Wildfly 11
* MySQL
* Springboot V2

Maven
$ ./mvn clean install

## Installation
To install the inventory module, follow these steps:

1. Clone the repository to your local machine.
2. Install the dependencies.
npm install
3. Run the development server.
npm start

Open the application in your browser. The inventory module will be accessible at http://localhost:3000/inventory.

### Usage
Inventory module can be used to track items, create purchase orders, generate inventory reports, and scan barcodes. To access the inventory module, navigate to http://localhost:3000/inventory in your browser. You will be able to view all of the items in your inventory, create purchase orders and generate inventory reports.

All other features have been exposed as REST endpoints. Refer to the SWAGGER API specification for details.
