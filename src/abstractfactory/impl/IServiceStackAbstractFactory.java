package abstractfactory.impl;

import abstractfactory.service.IEmployeeService;
import abstractfactory.service.IProductsService;

public interface IServiceStackAbstractFactory {
    public IEmployeeService createEmployeeService();
    public IProductsService createProductsService();
}