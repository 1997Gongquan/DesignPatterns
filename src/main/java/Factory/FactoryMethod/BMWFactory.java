package Factory.FactoryMethod;

public class BMWFactory  implements CarFactory{
    public Car creatCar() {
        return new BMW();
    }
}
