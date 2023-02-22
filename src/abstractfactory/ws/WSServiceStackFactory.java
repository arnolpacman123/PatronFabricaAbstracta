package abstractfactory.ws;

import abstractfactory.interfaces.IServiceStackAbstractFactory;
import abstractfactory.services.IEmployeesService;
import abstractfactory.services.IProductsService;

public class WSServiceStackFactory implements IServiceStackAbstractFactory {

    @Override
    public IEmployeesService createEmployeesService() {
        return new EmployeesServiceWS();
    }

    @Override
    public IProductsService createProductsService() {
        return new ProductServiceWS();
    }
}