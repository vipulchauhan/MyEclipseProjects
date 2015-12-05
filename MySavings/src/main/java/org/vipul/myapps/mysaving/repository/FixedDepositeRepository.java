/**
 * 
 */
package org.vipul.myapps.mysaving.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vipul.myapps.mysaving.model.FixedDeposite;


public interface FixedDepositeRepository extends JpaRepository<FixedDeposite, Long> {

	Collection<FixedDeposite> getFixedDepositeByAccountNo(String acntNo);
}
