package abstractfactory.rest;

import abstractfactory.interfaces.IServiceStackAbstractFactory;
import abstractfactory.services.IEmployeesService;
import abstractfactory.services.IProductsService;

public class RestServiceStackFactory implements IServiceStackAbstractFactory {

    @Override
    public IEmployeesService createEmployeesService() {
        return new EmployeesServiceRest();
    }

    @Override
    public IProductsService createProductsService() {
        return new ProductServiceRest();
    }
}
