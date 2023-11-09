package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    /*
    @AfterEach 를 사용하면 각 테스트가 종료될 때 마다 이 기능을 실행한다.
     */
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        // Given
        Member member = new Member();
        member.setName("spring");

        // When
        repository.save(member);

        // Then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName(){
        // Given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // When
        Member result = repository.findByName(member1.getName()).get();

        // Then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        // Given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // When
        List<Member> memberList = repository.findAll();

        // Then
        assertThat(memberList.size()).isEqualTo(2);
    }

}
