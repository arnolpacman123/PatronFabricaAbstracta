package abstractfactory.interfaces;

import abstractfactory.services.IEmployeesService;
import abstractfactory.services.IProductsService;

public interface IServiceStackAbstractFactory {
    public IEmployeesService createEmployeesService();
    public IProductsService createProductsService();
}