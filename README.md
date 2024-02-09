  1.a)Версия Java - 17
  
  .b)postgresql 14
  
  .c)Gradle 7.6
  
2. В проекте используется 2 Контроллера, CustomerController /api/v1/customer, EmployeeController /api/v1/employee
CustomerController methods
First of all CustomerCotnroller have greeting method i created this method for testing in testng, address of it /api/v1/customer/greet
createCustomer() method - this is method for creating new customer, as parameter it takes @RequestBody CustomerRequest with required fields(username, year and etc), it returns CustomerResponse with same fields, it is http post method with /createCustomer address
deleteCustomerById() method - this is method for deleting customer by id, as parameter it takes id of customer as @PathVariable, it returns CustomerResponse with fields of customer that you deleted, it is http delete method with /deleteCustomerById/{customerId}, so you have write id of customer in path
getCustomerById() method - this is method for retrieving customer by id, as parameter it takes id of customer as @PathVariable, it returns CustomerResponse with fields of customer with id that you pasted, it is http get method with /getCustomerById/{id}, so you have to write id in path
updateCustomer() method - this is method for updating customer by id, as parametr it takes RequestBody and id, it returns customer data with modifications, as RequestBody it takes fields that you want to modify, it is http patch method with /updateCustomer/{customerId}, so ypu have to write id in path
getCustomersWithFilter() - this is method for retrieving customers, as parametr it takes Filter class with limit and offset fields, and returns List of customers, it is http get method with /getCustomersWithFilter address

EmployeeController methods work exactly the same as CustomerController, but in Customer id is Integer, in Employee id is ObjectId
createEmployee() method - this is method for creating new employee, as parameter it takes @RequestBody EmployeeRequest with required fields(username, year and etc), it returns EmployeeResponse with same fields, it is http post method with /createEmployee address
deleteEmployeeById() method - this is method for deleting employee by id, as parameter it takes id of employee as @PathVariable, it returns EmployeeResponse with fields of employee that you deleted, it is http delete method with /deleteEmployeeById/{employeeId}, so you have write id of employee in path
getEmployeeById() method - this is method for retrieving employee by id, as parameter it takes id of employee as @PathVariable, it returns EmployeeResponse with fields of employee with id that you pasted, it is http get method with /getEmployeeById/{id}, so you have to write id in path
updateEmployee() method - this is method for updating employee by id, as parametr it takes RequestBody and id, it returns employee data with modifications, as RequestBody it takes fields that you want to modify, it is http patch method with /updateEmployee/{employeeId}, so ypu have to write id in path
getEmployeeWithFilter() - this is method for retrieving employees, as parametr it takes Filter class with limit and offset fields, and returns List of customers, it is http get method with /getEmployeeWithFilter address

3. a) Скачиваем проект при помощи комманды git clone
https://github.com/azimenov/eglbmobfkzgieoqusdjl
b) Устанавливаем Java 17
c) Открываем проект и меняем данные для баз данных в application.properties, меняем данные для postgresql database, и uri for mongodb
d) Импортируем postman file
4. Кроме как поменять application.properties для запуска проекта больше ничего не требуется
5. Насчет проблем с которыми я столкнулся, я не так часто работал с проектами где не используются микросервисы но использует несколько баз данных, так что почитал документацию и прописал конфиги для двух сервисов

    Да прибудет с вами Java
