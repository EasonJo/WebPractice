package cn.eason.service.impl;

import cn.eason.dao.AccountDao;
import cn.eason.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Eason
 * @date Create in 14:29 17/04/2018
 */
@Service("accountService")
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false,
    rollbackFor = Exception.class)
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

//    @Resource(name = "transactionTemplate")
//    private TransactionTemplate tt;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void transfer(Integer from, Integer to, Double money) {
        //编码式使用 Spring事务
//        tt.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                accountDao.decreaseMoney(from, money);
//                accountDao.increaseMoney(to, money);
//            }
//        });

        accountDao.decreaseMoney(from, money);
        accountDao.increaseMoney(to, money);
    }
}
