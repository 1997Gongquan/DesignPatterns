package Factory.FactoryMethod;

public class BenzFactory implements CarFactory{
    public Car creatCar() {
        return new Benz();
    }
}
