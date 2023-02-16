package abstractfactory.rest;

import abstractfactory.impl.IServiceStackAbstractFactory;
import abstractfactory.service.IEmployeeService;
import abstractfactory.service.IProductsService;

public class RestServiceStackFactory implements IServiceStackAbstractFactory {

    @Override
    public IEmployeeService createEmployeeService() {
        return new EmployeeServiceRest();
    }

    @Override
    public IProductsService createProductsService() {
        return new ProductServiceRest();
    }
}
