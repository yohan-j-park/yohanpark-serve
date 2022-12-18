package kr.jobtc.springboot.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jobtc.springboot.mybatis.BoardMapper;

@Service
public class BoardService {
	@Autowired
	BoardMapper mapper;
	
	public List<BoardVo> select(String findStr){
		List<BoardVo> list = mapper.select(findStr);
		return list;
	}
}
