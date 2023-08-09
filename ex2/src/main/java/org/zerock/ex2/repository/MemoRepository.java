package org.zerock.ex2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex2.entity.Memo;

import java.util.List;
import java.util.Objects;

public interface MemoRepository extends JpaRepository<Memo, Long> {


    @Query(value = "select * from tbl_memo where mno > 0 ",nativeQuery = true)
    List<Object[]> getNativeResult();


    @Modifying
    @Transactional
    @Query("update Memo m " + "set m.memoText = :memoText" + " where m.mno = :mno")
    int updateMemoText(long l, String s);
    @Query("select m from Memo m " + " where m.mno = :mno " + " order by m.mno desc")
    List<Memo> getListDesc();








List<Memo> findByMnoBetween(Long from, Long to);

    Page<Memo> findByMnoBetween(long l, long l1, Pageable pageable);
}
