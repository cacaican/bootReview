package com.xiaocai.bootreview.ssm.service.impl;

import com.xiaocai.bootreview.ssm.entity.Car;
import com.xiaocai.bootreview.ssm.mapper.CarMapper;
import com.xiaocai.bootreview.ssm.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName CarServiceImpl
 * @Description Isolation 隔离级别，读未提交，读已提交，可重复读 ，和串行化，
 * Propagation required 支持当前事务，如果不存在则创建一个新事务。类似于同名的 EJB 事务属性。
 * PROPAGATION_SUPPORTS 支持当前事务，如果不存在则以非事务方式执行。类似于同名的 EJB 事务属性。
 * PROPAGATION_MANDATORY  支持当前事务，如果不存在则抛出异常。类似于同名的 EJB 事务属性。
 * PROPAGATION_REQUIRES_NEW  创建一个新事务，如果存在则暂停当前事务。类似于同名的 EJB 事务属性。
 * PROPAGATION_NOT_SUPPORTED  以非事务方式执行，如果存在则暂停当前事务。类似于同名的 EJB 事务属性。
 * PROPAGATION_NEVER 以非事务方式执行，如果存在事务则抛出异常。类似于同名的 EJB 事务属性。
 * PROPAGATION_NESTED  如果当前事务存在，则在嵌套事务中执行，否则行为类似于REQUIRED 。 EJB 中没有类似的特性。
 *
REQUIRED（默认的传播机制）：
如果当前没有事务，则新建事务
如果当前存在事务，则加入当前事务，合并成一个事务
REQUIRES_NEW：
新建事务，如果当前存在事务，则把当前事务挂起
NESTED
如果当前没有事务，则新建事务
如果当前存在事务，则创建一个当前事务的子事务（嵌套事务），子事务不能单独提交，只能和父事务一起提交。
REQUIRED
一个类的A方法调用另一个类的B方法。
假设在A方法存在一个当前事务，B方法的事务传播机制为REQUIRED，则B方法会合并到A方法的事务里执行。
A、B任意一个方法异常（默认是RuntimeException和Error）都会导致A、B的操作被回滚。

Spring事务管理器不会吞异常。
B异常后会抛给A，A如果没有catch这个异常，会继续向上抛。如果A catch住了，Spring事务管理器会替A向上抛一个UnexpectedRollbackException。总之，一旦A、B回滚，A的调用方一定能收到一个异常感知到回滚。

REQUIRES_NEW
一个类的A方法调用另一个类的B方法。
假设在A方法存在一个当前事务，B方法的事务传播机制为REQUIRES_NEW，则B方法会新建一个事务并把A所在的事务挂起。A事务等到B事务执行完后，恢复执行。
这种传播机制下，需要小心死锁问题。A事务被挂起了，如果B事务要加的锁被A占用了就会发生死锁。
如果B发生异常，B事务一定回滚，B的异常随后会抛给A，如果A catch住了这个异常，A不会回滚，否则A也会回滚。
如果A发生异常，则只会回滚A，不会回滚B。

NESTED
一个类的A方法调用另一个类的B方法。
假设在A方法存在一个当前事务，B方法的事务传播机制为NESTED，则B方法会作为A方法所在事务的一个子事务执行。
子事务的底层实现：B方法执行前会在A所在事务中创建一个savepoint，B异常后回滚到此savepoint。
如果B异常，B一定回滚，B的异常随后会抛给A，如果A catch住了这个异常，A不会回滚，否则A也会回滚。这种情况和REQUIRES_NEW一样。
如果A发生异常，则A、B都会回滚。

链接：https://www.jianshu.com/p/22b9b22f91e5
 * @Author xiaocai
 * @Date 2022/9/11
 */
@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public Car getById(Integer id) {

        Car car = carMapper.getCarById(id);
        return car;
    }

    @Override
    @Transactional(isolation= Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public List<Car> getCarsByBrand(String brand) {
        List car = carMapper.getCarByBrand("%"+brand+"%");
        return car;
    }

    @Override
    @Transactional(isolation= Isolation.DEFAULT,propagation = Propagation.NESTED)
    public boolean createCar(Car car) {
        boolean car1 = carMapper.createCar(car);
        return car1;
    }

    @Override
    public List<Car> getCarsByDriverId(String driverId) {
        List car =  carMapper.getCarByDriverId(driverId);
        return car;
    }
}
