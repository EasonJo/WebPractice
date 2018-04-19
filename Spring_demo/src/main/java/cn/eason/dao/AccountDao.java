package cn.eason.dao;

/**
 * @author Eason
 * @date Create in 14:21 17/04/2018
 */
public interface AccountDao {

    //加钱
    void increaseMoney(Integer id, Double money);

    //减钱
    void decreaseMoney(Integer id, Double money);
}
