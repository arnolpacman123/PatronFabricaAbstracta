package abstractfactory.db;

import abstractfactory.interfaces.IServiceStackAbstractFactory;
import abstractfactory.services.IEmployeesService;
import abstractfactory.services.IProductsService;

public class DBServiceStackFactory implements IServiceStackAbstractFactory {

    @Override
    public IEmployeesService createEmployeesService() {
        return new EmployeesServiceDB();
    }

    @Override
    public IProductsService createProductsService() {
        return new ProductServiceDB();
    }
}
