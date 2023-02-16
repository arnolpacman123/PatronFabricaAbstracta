package abstractfactory.db;

import abstractfactory.impl.IServiceStackAbstractFactory;
import abstractfactory.service.IEmployeeService;
import abstractfactory.service.IProductsService;

public class DBServiceStackFactory implements IServiceStackAbstractFactory {

    @Override
    public IEmployeeService createEmployeeService() {
        return new EmployeeServiceDB();
    }

    @Override
    public IProductsService createProductsService() {
        return new ProductServiceDB();
    }
}
