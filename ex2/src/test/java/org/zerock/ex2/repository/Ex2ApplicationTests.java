package org.zerock.ex2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.zerock.ex2.dto.SampleDTO;
import org.zerock.ex2.entity.Memo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class MemoRepositoryTests {

	@Autowired
	private MemoRepository memoRepository;


	@Test
	public void testInsertDummies() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Memo memo = Memo.builder().memoText("Sample…" + i).build();
			memoRepository.save(memo);
		});
	}

	@Test
	public void testSelect() {
		Long mno = 100L;
		Optional<Memo> result = memoRepository.findById(mno);
		if(result.isPresent()) {
			Memo memo = result.get();
		}
	}


	public void testSelectAll() {
		// select * from tbl_memo;
		List<Memo> list = memoRepository.findAll();
		list.forEach(memo -> {
			System.out.println("================");
			System.out.println(memo);
		});
	}


	public void testDelete() {
		Long mno = 100L;
		memoRepository.deleteById(mno);

	}


//	testPageDefault
    @Test
	public void testPageDefault() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<Memo> result = memoRepository.findAll(pageable);
		result.stream().forEach(memo -> {
			System.out.println(memo);
		});
		System.out.println("———————————————————");
		System.out.println("Total Pages: " + result.getTotalPages()); //총 몇 페이지
		System.out.println("Total Count: " + result.getTotalElements()); //전체 개수

		System.out.println("Page Number: " + result.getNumber()); //현재 페이지 번호 0부터 시작
		System.out.println("Page Size: " + result.getSize()); //페이지당 데이터 개수
		System.out.println("has next page?: " + result.hasNext()); //다음 페이지 존재 여부
		System.out.println("first page?: " + result.isFirst()); //시작 페이지(0) 여부
	}

	@Test
	public void testSort() {
		Sort sort = Sort.by("mno").descending();
		Pageable pageable = PageRequest.of(0, 10, sort);
		Page<Memo> list = memoRepository.findAll(pageable);
		list.get().forEach(memo -> {
			System.out.println(memo);
		});
	}


	@Test
	public void testQueryMethod1() {
		List<Memo> list = memoRepository.findByMnoBetween(50L, 60L);
		list.stream().forEach(memo ->
				System.out.println(memo)
		);
	}


	@Test
	public void testQueryMethod2() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
		Page<Memo> result = memoRepository.findByMnoBetween(50L, 60L, pageable);
		result.stream().forEach(memo -> System.out.println(memo));
	}

	@Test
	public void testGetListDesc() {
		List<Memo> result = memoRepository.getListDesc();
		result.stream().forEach(memo -> {
			System.out.println(memo);
		});
	}

	@Test
	public void testNative() {
		List<Object[]> result = memoRepository.getNativeResult();
		result.stream().forEach(arr -> {
			System.out.println(Arrays.toString(arr));
		});

	}



}
