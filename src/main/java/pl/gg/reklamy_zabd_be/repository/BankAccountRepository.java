package pl.gg.reklamy_zabd_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.dto.BankAccountDto;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {
//    int save(BankAccount acc);
//    int update(BankAccountDto acc);
//    BankAccount findById(int id);
//    int deleteById(int id);
//    List<BankAccount> findAll();
//    int deleteAll();
}
