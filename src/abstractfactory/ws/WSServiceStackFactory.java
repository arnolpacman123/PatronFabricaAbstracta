package abstractfactory.ws;

import abstractfactory.impl.IServiceStackAbstractFactory;
import abstractfactory.service.IEmployeeService;
import abstractfactory.service.IProductsService;

public class WSServiceStackFactory implements IServiceStackAbstractFactory {

    @Override
    public IEmployeeService createEmployeeService() {
        return new EmployeeServiceWS();
    }

    @Override
    public IProductsService createProductsService() {
        return new ProductServiceWS();
    }
}