package kr.jobtc.springboot.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.jobtc.springboot.board.BoardVo;

@Repository		//저장기능
@Mapper			//mapper(crud)기능
public interface BoardMapper {
	public List<BoardVo> select(String findStr);	//추상메소드(header만 있고 body가 없음)
}
