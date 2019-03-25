package Factory.FactoryMethod;

public class Client {
    public static void main(String[] args){
       Car c1=new BMWFactory().creatCar();
       Car c2=new BenzFactory().creatCar();
       c1.run();
       c2.run();
    }
}
